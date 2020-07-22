package com.cafe24.dk4750.miniMarket.vo;

public class ReportMemberByMemberItemAndMemberItem {
	private int reportNo;
	private String reportTitle;
	private String reportContent;
	private String reportMemo;
	private String memberId;
	private String memberItemNo;
	private String memberItemTitle;
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
	public String getReportMemo() {
		return reportMemo;
	}
	public void setReportMemo(String reportMemo) {
		this.reportMemo = reportMemo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberItemNo() {
		return memberItemNo;
	}
	public void setMemberItemNo(String memberItemNo) {
		this.memberItemNo = memberItemNo;
	}
	public String getMemberItemTitle() {
		return memberItemTitle;
	}
	public void setMemberItemTitle(String memberItemTitle) {
		this.memberItemTitle = memberItemTitle;
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
		return "ReportMemberByMemberItemAndMemberItem [reportNo=" + reportNo + ", reportTitle=" + reportTitle
				+ ", reportContent=" + reportContent + ", reportMemo=" + reportMemo + ", memberId=" + memberId
				+ ", memberItemNo=" + memberItemNo + ", memberItemTitle=" + memberItemTitle + ", reportState="
				+ reportState + ", reportDate=" + reportDate + "]";
	}
}
