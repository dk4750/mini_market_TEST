package com.cafe24.dk4750.miniMarket.vo;

public class ReportMemberByCompanyItemAndCompanyItem {
	private int reportNo;
	private String reportTitle;
	private String reportContent;
	private String memberId;
	private String companyItemNo;
	private String companyItemTitle;
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
	public String getCompanyItemNo() {
		return companyItemNo;
	}
	public void setCompanyItemNo(String companyItemNo) {
		this.companyItemNo = companyItemNo;
	}
	public String getCompanyItemTitle() {
		return companyItemTitle;
	}
	public void setCompanyItemTitle(String companyItemTitle) {
		this.companyItemTitle = companyItemTitle;
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
		return "ReportMemberByCompanyItemAndCompanyItem [reportNo=" + reportNo + ", reportTitle=" + reportTitle
				+ ", reportContent=" + reportContent + ", memberId=" + memberId + ", companyItemNo=" + companyItemNo
				+ ", companyItemTitle=" + companyItemTitle + ", reportState=" + reportState + ", reportDate="
				+ reportDate + "]";
	}
	
}
