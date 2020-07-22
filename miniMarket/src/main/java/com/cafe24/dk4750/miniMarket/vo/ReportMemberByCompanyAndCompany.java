package com.cafe24.dk4750.miniMarket.vo;

public class ReportMemberByCompanyAndCompany {
	private int reportNo;
	private String reportTitle;
	private String reportContent;
	private String memberId;
	private String companyUniqueNo;
	private String companyId;
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
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCompanyUniqueNo() {
		return companyUniqueNo;
	}
	public void setCompanyUniqueNo(String companyUniqueNo) {
		this.companyUniqueNo = companyUniqueNo;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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
		return "ReportMemberByCompanyAndCompany [reportNo=" + reportNo + ", reportTitle=" + reportTitle
				+ ", reportContent=" + reportContent + ", memberId=" + memberId + ", companyUniqueNo=" + companyUniqueNo
				+ ", companyId=" + companyId + ", reportState=" + reportState + ", reportDate=" + reportDate + "]";
	}
	
}
