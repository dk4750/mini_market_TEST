package com.cafe24.dk4750.miniMarket.vo;

public class MemberBackup {
	private String memberId;
	private String memberEmail;
	private String memberDivision;
	private String memberUniqueNo;
	private String memberDate;
	
	// 겟터 셋터
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberDivision() {
		return memberDivision;
	}
	public void setMemberDivision(String memberDivision) {
		this.memberDivision = memberDivision;
	}
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
	}
	public String getMemberDate() {
		return memberDate;
	}
	public void setMemberDate(String memberDate) {
		this.memberDate = memberDate;
	}
	
	// toString
	@Override
	public String toString() {
		return "MemberBackup [memberId=" + memberId + ", memberEmail=" + memberEmail + ", memberDivision="
				+ memberDivision + ", memberUniqueNo=" + memberUniqueNo + ", memberDate=" + memberDate + "]";
	}
}
