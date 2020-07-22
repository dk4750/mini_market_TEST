package com.cafe24.dk4750.miniMarket.vo;

public class Member {
	private String memberId;
	private String memberSido;
	private String memberSigungu;
	private String memberBname;
	private String memberPw;
	private String memberNickname;
	private String memberName;
	private String memberEmail;
	private String memberUniqueNo;
	private String memberPhone;
	private String memberDate;
	
	// 겟터 셋터
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberSido() {
		return memberSido;
	}
	public void setMemberSido(String memberSido) {
		this.memberSido = memberSido;
	}
	public String getMemberSigungu() {
		return memberSigungu;
	}
	public void setMemberSigungu(String memberSigungu) {
		this.memberSigungu = memberSigungu;
	}
	public String getMemberBname() {
		return memberBname;
	}
	public void setMemberBname(String memberBname) {
		this.memberBname = memberBname;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
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
		return "Member [memberId=" + memberId + ", memberSido=" + memberSido + ", memberSigungu=" + memberSigungu
				+ ", memberBname=" + memberBname + ", memberPw=" + memberPw + ", memberNickname=" + memberNickname
				+ ", memberName=" + memberName + ", memberEmail=" + memberEmail + ", memberUniqueNo=" + memberUniqueNo
				+ ", memberPhone=" + memberPhone + ", memberDate=" + memberDate + "]";
	}
}
