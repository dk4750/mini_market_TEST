package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.ReportCompanyByMember;
import com.cafe24.dk4750.miniMarket.vo.ReportCompanyByMemberAndMember;


@Mapper
public interface ReportCompanyByMemberMapper {
	
	// 신고완료인것중에 가장 최근에거 가져오기
	public ReportCompanyByMember selectReportCompanyByMemberDesc();
	// 업체가 멤버 댓글 신고시
	public int insertReportCompanyByMember(ReportCompanyByMember reportCompanyByMember);
	// 신고 total리스트 출력
	public List<ReportCompanyByMember> selectReportCompanyByMemberAll(Map<String, Object> map);
	// 신고 total리스트 페이징
	public int getTotalRow(String reportState);
	// 신고 내용 상세보기
	public ReportCompanyByMemberAndMember selectReportCompanyByMemberOne(int reportNo);
	// 신고 상태 변경
	public int updateReportCompanyByMemberState(ReportCompanyByMember reportCompanyByMember);
}
