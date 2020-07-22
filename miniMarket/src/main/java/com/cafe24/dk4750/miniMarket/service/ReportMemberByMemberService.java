package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.MemberTempMapper;
import com.cafe24.dk4750.miniMarket.mapper.MemberTempTotalMapper;
import com.cafe24.dk4750.miniMarket.mapper.ReportMemberByMemberMapper;
import com.cafe24.dk4750.miniMarket.vo.MemberTemp;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByMember;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByMemberAndMember;

@Service
@Transactional
public class ReportMemberByMemberService {
	@Autowired
	private ReportMemberByMemberMapper reportMemberByMemberMapper;
	@Autowired private MemberTempMapper memberTempMapper;
	@Autowired private MemberTempTotalMapper memberTempTotalMapper;
	//멤버 이름 불러오기
	public String getMemberName(String memberUniqueNo) {
		String memberNickname = reportMemberByMemberMapper.selectMemberName(memberUniqueNo);
		System.out.println(memberNickname);
		return memberNickname;
	}
	// 신고 total 리스트 (페이징)
	public Map<String, Object> getReportMemberByMemberList(int currentPage, String reportState) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("reportState", reportState);
		// lastPage
		int totalRow = reportMemberByMemberMapper.getTotalRow(reportState);
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage Map에 담는다
		List<ReportMemberByMember> reportMemberByMemberList = reportMemberByMemberMapper.selectReportMemberByMemberAll(map);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("reportMemberByMemberList", reportMemberByMemberList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
	// 신고내용 상세보기
	public ReportMemberByMemberAndMember getReportMemberByMemberOne(int reportNo) {
		return reportMemberByMemberMapper.selectReportMemberByMemberOne(reportNo);
	}
	// 신고 접수
	public int addReportMemberByMember(ReportMemberByMember reportMemberByMember) {
		return reportMemberByMemberMapper.insertReportMemberByMember(reportMemberByMember);
	}
	//상태 수정
	public int modifyMemberByMemberState(ReportMemberByMember reportMemberByMember) {
		// 신고 상태 수정
		reportMemberByMemberMapper.updateReportMemberByMemberState(reportMemberByMember);
		// 가장 최근에 신고확인 된것 가져오기
		reportMemberByMemberMapper.selectMemberByMemberDesc();
		// 멤버가 멤버를 신고중인게 신고 확인으로 되었을 경우 멤버의 온도를 깍아주는 세션
		if(reportMemberByMemberMapper.selectMemberByMemberDesc() !=null) {
			// 신고 확인으로 될 시 그해당 멤버의 아이디값을 가져오기 위해서
			String memberUniqueNo = reportMemberByMemberMapper.selectMemberByMemberDesc().getMemberUniqueNo();
			System.out.println(memberUniqueNo+"<----멤버 유니크 넘버가 맞게 왔는지 확인 ");
			// 멤버템프에 신고받은 유저의 것을 인서트하기
			MemberTemp memberTemp = new MemberTemp();
			memberTemp.setMemberUniqueNo(memberUniqueNo);
			memberTemp.setTempInsertScore(-1);
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
