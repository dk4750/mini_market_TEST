package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.ReportMemberByMemberItem;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByMemberItemAndMemberItem;

@Mapper
public interface ReportMemberByMemberItemMapper {
	// 신고중에 가장 최근에 신고 확인으로 된거 가져오기
	public ReportMemberByMemberItem selectMemberByMemberItemDesc();
	// 멤버가 멤버아이템 신고시
	public int insertReportMemberByMemberItem(ReportMemberByMemberItem reportMemberByMemberItem);
	// 신고 total리스트 출력
	public List<ReportMemberByMemberItem> selectReportMemberByMemberItemAll(Map<String, Object> map);
	// 신고 total리스트 페이징
	public int getTotalRow(String reportState);
	// 신고 내용 상세보기
	public ReportMemberByMemberItemAndMemberItem selectReportMemberByMemberItemOne(int reportNo);
	// 신고 상태 업데이트
	public int updateMemberByMemberItemState(ReportMemberByMemberItem reportMemberByMemberItem);
}
