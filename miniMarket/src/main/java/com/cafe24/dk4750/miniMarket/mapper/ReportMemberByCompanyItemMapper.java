package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.ReportMemberByCompanyItem;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByCompanyItemAndCompanyItem;

@Mapper
public interface ReportMemberByCompanyItemMapper {
	// 멤버가 업체아이템 신고시
	public int insertReportMemberByCompanyItem(ReportMemberByCompanyItem reportMemberByCompanyItem);
	// 신고 total리스트 출력
	public List<ReportMemberByCompanyItem> selectReportMemberByCompanyItemAll(Map<String, Object> map);
	// 신고 total리스트 페이징
	public int getTotalRow(String reportState);
	// 신고 내용 상세보기
	public ReportMemberByCompanyItemAndCompanyItem selectReportMemberByCompanyItemOne(int reportNo);
	// 신고 상태 수정
	public int updateReportMemberByCompanyItemState(ReportMemberByCompanyItem reportMemberByCompanyItem);
}
