package com.cafe24.dk4750.miniMarket.vo;

public class ReportMemberByMember {
	private int reportNo;
	private String reportTitle;
	private String reportContent;
	private String memberId;
	private String memberUniqueNo;
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
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
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
		return "ReportMByM [reportNo=" + reportNo + ", reportTitle=" + reportTitle + ", reportContent=" + reportContent
				+ ", memberId=" + memberId + ", memberUniqueNo=" + memberUniqueNo + ", reportState=" + reportState
				+ ", reportDate=" + reportDate + "]";
	}
}
