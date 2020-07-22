package com.cafe24.dk4750.miniMarket.vo;

public class ReportCompanyByMemberAndMember {
	private int reportNo;
	private String reportTitle;
	private String reportContent;
	private String companyId;
	private String memberUniqueNo;
	private String memberId;
	private String reportState;
	private String reportDate;
	
	public int getReportNo() {
		return reportNo;
	}
	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}
	public String getReportTitle() {
		return reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public String getReportContent() {
		return reportContent;
	}
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getReportState() {
		return reportState;
	}
	public void setReportState(String reportState) {
		this.reportState = reportState;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	@Override
	public String toString() {
		return "ReportCompanyByMemberAndMember [reportNo=" + reportNo + ", reportTitle=" + reportTitle
				+ ", reportContent=" + reportContent + ", companyId=" + companyId + ", memberUniqueNo=" + memberUniqueNo
				+ ", memberId=" + memberId + ", reportState=" + reportState + ", reportDate=" + reportDate + "]";
	}
	
}
