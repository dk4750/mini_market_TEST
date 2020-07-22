package com.cafe24.dk4750.miniMarket.vo;

public class ReportMemberByCompanyItem {
	private int reportNo;
	private String reportTitle;
	private String reportContent;
	private String memberId;
	private int companyItemNo;
	private String reportState;
	private String reportDate;
	
	// 겟터 셋터
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
	public int getCompanyItemNo() {
		return companyItemNo;
	}
	public void setCompanyItemNo(int companyItemNo) {
		this.companyItemNo = companyItemNo;
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
	// toString
	@Override
	public String toString() {
		return "ReportMByCitem [reportNo=" + reportNo + ", reportTitle=" + reportTitle + ", reportContent="
				+ reportContent + ", memberId=" + memberId + ", companyItemNo=" + companyItemNo + ", reportState="
				+ reportState + ", reportDate=" + reportDate + "]";
	}
}
