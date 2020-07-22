package com.cafe24.dk4750.miniMarket.vo;

public class ReportMemberByMemberAndMember {
	private int reportNo;
	private String reportTitle;
	private String reportContent;
	private String fromMemberId;
	private String memberUniqueNo;
	private String toMemberId;
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
	public String getFromMemberId() {
		return fromMemberId;
	}
	public void setFromMemberId(String fromMemberId) {
		this.fromMemberId = fromMemberId;
	}
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
	}
	public String getToMemberId() {
		return toMemberId;
	}
	public void setToMemberId(String toMemberId) {
		this.toMemberId = toMemberId;
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
		return "ReportMemberByMemberAndMember [reportNo=" + reportNo + ", reportTitle=" + reportTitle
				+ ", reportContent=" + reportContent + ", fromMemberId=" + fromMemberId + ", memberUniqueNo="
				+ memberUniqueNo + ", toMemberId=" + toMemberId + ", reportState=" + reportState + ", reportDate="
				+ reportDate + "]";
	}
}
