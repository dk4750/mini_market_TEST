package com.cafe24.dk4750.miniMarket.vo;

public class MemberItemAndMemberAndMemberItemPic {
	// 멤버 아이템 속성
	private int memberItemNo;
	private String memberUniqueNo;
	private String memberItemTitle;
	private String categoryName;
	private String memberItemPrice;
	private String memberItemContent;
	private String memberItemDate;
	private String memberItemState;
	// 멤버 속성
	private String memberId;
	private String memberSido;
	private String memberSigungu;
	private String memberBname;
	private String memberPw;
	private String memberNickname;
	private String memberName;
	private String memberEmail;
	private String memberPhone;
	private String memberDate;
	// 멤버 아이템 사진 속성
	private String memberItemPic1;
	// 겟터 셋터
	public int getMemberItemNo() {
		return memberItemNo;
	}
	public String getMemberItemPic1() {
		return memberItemPic1;
	}
	public void setMemberItemPic1(String memberItemPic1) {
		this.memberItemPic1 = memberItemPic1;
	}
	public void setMemberItemNo(int memberItemNo) {
		this.memberItemNo = memberItemNo;
	}
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
	}
	public String getMemberItemTitle() {
		return memberItemTitle;
	}
	public void setMemberItemTitle(String memberItemTitle) {
		this.memberItemTitle = memberItemTitle;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getMemberItemPrice() {
		return memberItemPrice;
	}
	public void setMemberItemPrice(String memberItemPrice) {
		this.memberItemPrice = memberItemPrice;
	}
	public String getMemberItemContent() {
		return memberItemContent;
	}
	public void setMemberItemContent(String memberItemContent) {
		this.memberItemContent = memberItemContent;
	}
	public String getMemberItemDate() {
		return memberItemDate;
	}
	public void setMemberItemDate(String memberItemDate) {
		this.memberItemDate = memberItemDate;
	}
	public String getMemberItemState() {
		return memberItemState;
	}
	public void setMemberItemState(String memberItemState) {
		this.memberItemState = memberItemState;
	}
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
		return "MemberItemAndMemberAndMemberItemPic [memberItemNo=" + memberItemNo + ", memberUniqueNo="
				+ memberUniqueNo + ", memberItemTitle=" + memberItemTitle + ", categoryName=" + categoryName
				+ ", memberItemPrice=" + memberItemPrice + ", memberItemContent=" + memberItemContent
				+ ", memberItemDate=" + memberItemDate + ", memberItemState=" + memberItemState + ", memberId="
				+ memberId + ", memberSido=" + memberSido + ", memberSigungu=" + memberSigungu + ", memberBname="
				+ memberBname + ", memberPw=" + memberPw + ", memberNickname=" + memberNickname + ", memberName="
				+ memberName + ", memberEmail=" + memberEmail + ", memberPhone=" + memberPhone + ", memberDate="
				+ memberDate + ", memberItemPic1=" + memberItemPic1 + "]";
	}
}
