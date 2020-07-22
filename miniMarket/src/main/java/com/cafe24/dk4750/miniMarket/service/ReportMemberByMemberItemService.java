package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.MemberItemMapper;
import com.cafe24.dk4750.miniMarket.mapper.MemberTempMapper;
import com.cafe24.dk4750.miniMarket.mapper.MemberTempTotalMapper;
import com.cafe24.dk4750.miniMarket.mapper.ReportMemberByMemberItemMapper;
import com.cafe24.dk4750.miniMarket.vo.MemberItem;
import com.cafe24.dk4750.miniMarket.vo.MemberTemp;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByMemberItem;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByMemberItemAndMemberItem;

@Service
@Transactional
public class ReportMemberByMemberItemService {
	@Autowired
	private ReportMemberByMemberItemMapper reportMemberByMemberItemMapper;
	@Autowired private MemberTempMapper memberTempMapper;
	@Autowired private MemberTempTotalMapper memberTempTotalMapper;
	@Autowired private MemberItemMapper memberItemMapper;
	// 신고 total 리스트 (페이징)
	public Map<String, Object> getReportMemberByMemberItemList(int currentPage, String reportState) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("reportState", reportState);
		// lastPage
		int totalRow = reportMemberByMemberItemMapper.getTotalRow(reportState);
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage Map에 담는다
		List<ReportMemberByMemberItem> reportMemberByMemberItemList = reportMemberByMemberItemMapper.selectReportMemberByMemberItemAll(map);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("reportMemberByMemberItemList", reportMemberByMemberItemList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
	// 신고내용 상세보기
	public ReportMemberByMemberItemAndMemberItem getReportMemberByMemberItemOne(int reportNo) {
		return reportMemberByMemberItemMapper.selectReportMemberByMemberItemOne(reportNo);
	}
	// 신고 접수
	public int addReportMemberByMemberItem(ReportMemberByMemberItem reportMemberByMemberItem) {
		reportMemberByMemberItemMapper.insertReportMemberByMemberItem(reportMemberByMemberItem);
		// 가장 최근에 신고 확인으로 된것 가져오기
		reportMemberByMemberItemMapper.selectMemberByMemberItemDesc();
		return 0;
	}
	//상태 수정
	public int modifyMemberByMemberItemState(ReportMemberByMemberItem reportMemberByMemberItem) {
		reportMemberByMemberItemMapper.updateMemberByMemberItemState(reportMemberByMemberItem);
		reportMemberByMemberItemMapper.selectMemberByMemberItemDesc();
		System.out.println(reportMemberByMemberItemMapper.selectMemberByMemberItemDesc()+"<----신고확인으로 된게 있는지 확인");
		// 신고확인이 확인됬을 경우 멤버의 온도를 깍아주고 아이템을 삭제하는 세션
		if(reportMemberByMemberItemMapper.selectMemberByMemberItemDesc() !=null) {
			String memberUniqueNo = reportMemberByMemberItemMapper.selectMemberByMemberItemDesc().getMemberUniqueNo();
			// 해당아이템 번호 가져오기
			int memberItemNo = reportMemberByMemberItemMapper.selectMemberByMemberItemDesc().getMemberItemNo();
			// 해당아이템 비활성화
			String memberItemState = "상품삭제";
			// 멤버아이템 설정
			MemberItem memberItem = new MemberItem();
			memberItem.setMemberItemNo(memberItemNo);;
			memberItem.setMemberItemState(memberItemState);
			// 해당아이템을 비활성화
			memberItemMapper.disabledMemberItem(memberItem);
			
			// 멤버템프에 신고받은 유저의 것을 인서트하기
			MemberTemp memberTemp = new MemberTemp();
			memberTemp.setMemberUniqueNo(memberUniqueNo);
			memberTemp.setTempInsertScore(-1);
			System.out.println(memberUniqueNo+"<========멤버템프의 멤버 유니크 넘버");
			// 멤버템프 테이블에 인서트
			memberTempMapper.insertTemp(memberTemp);
			// 신고받은 멤버의 현재 온도
			double tempTotalNow = memberTempTotalMapper.selectTempTotalNow(memberUniqueNo);
			// 신고받은 멤버의 온도에 감점
			double finalTempTotal = tempTotalNow + memberTemp.getTempInsertScore();
			// 온도차감을 완료한 템프토탈을 템프토탈에 추가 시 값 넣어주기
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("memberUniqueNo", memberUniqueNo);
			map.put("memberTempTotal", finalTempTotal);
			// 템프토탈 인서트 실행
			memberTempTotalMapper.insertTempTotal(map);
		}
		return 0;
	}
}
