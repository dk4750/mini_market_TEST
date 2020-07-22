package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.ReportMemberByCompany;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByCompanyAndCompany;

@Mapper
public interface ReportMemberByCompanyMapper {
	//업체 네임 불러오기
	public String selectCompanyName(String companyUniqueNo);
	// 멤버가 업체 신고시
	public int insertReportMemberByCompany(ReportMemberByCompany reportMemberByCompany);
	// 신고 total리스트 출력
	public List<ReportMemberByCompany> selectReportMemberByCompanyAll(Map<String, Object> map);
	// 신고 total리스트 페이징
	public int getTotalRow(String reportState);
	// 신고 내용 상세보기
	public ReportMemberByCompanyAndCompany selectReportMemberByCompanyOne(int reportNo);
	// 신고 상태 수정
	public int updateReportMemberByCompanyState(ReportMemberByCompany reportMemberByCompany);
}
