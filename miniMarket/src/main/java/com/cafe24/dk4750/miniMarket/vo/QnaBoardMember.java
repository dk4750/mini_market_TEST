package com.cafe24.dk4750.miniMarket.vo;

public class QnaBoardMember {
	private int qnaBoardMemberNo;
	private String memberUniqueNo;
	private String qnaBoardMemberTitle;
	private String qnaBoardMemberContent;
	private String qnaBoardMemberDate;
	private int qnaBoardMemberActive;
	private String memberNickname;
	
	// 겟터 셋터
	public int getQnaBoardMemberNo() {
		return qnaBoardMemberNo;
	}
	public void setQnaBoardMemberNo(int qnaBoardMemberNo) {
		this.qnaBoardMemberNo = qnaBoardMemberNo;
	}
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
	}
	public String getQnaBoardMemberTitle() {
		return qnaBoardMemberTitle;
	}
	public void setQnaBoardMemberTitle(String qnaBoardMemberTitle) {
		this.qnaBoardMemberTitle = qnaBoardMemberTitle;
	}
	public String getQnaBoardMemberContent() {
		return qnaBoardMemberContent;
	}
	public void setQnaBoardMemberContent(String qnaBoardMemberContent) {
		this.qnaBoardMemberContent = qnaBoardMemberContent;
	}
	public String getQnaBoardMemberDate() {
		return qnaBoardMemberDate;
	}
	public void setQnaBoardMemberDate(String qnaBoardMemberDate) {
		this.qnaBoardMemberDate = qnaBoardMemberDate;
	}
	
	public int getQnaBoardMemberActive() {
		return qnaBoardMemberActive;
	}
	public void setQnaBoardMemberActive(int qnaBoardMemberActive) {
		this.qnaBoardMemberActive = qnaBoardMemberActive;
	}
	
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	@Override
	public String toString() {
		return "QnaBoardMember [qnaBoardMemberNo=" + qnaBoardMemberNo + ", memberUniqueNo=" + memberUniqueNo
				+ ", qnaBoardMemberTitle=" + qnaBoardMemberTitle + ", qnaBoardMemberContent=" + qnaBoardMemberContent
				+ ", qnaBoardMemberDate=" + qnaBoardMemberDate + ", qnaBoardMemberActive=" + qnaBoardMemberActive
				+ ", memberNickname=" + memberNickname + "]";
	}
	
	
}
