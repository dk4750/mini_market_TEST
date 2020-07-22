package com.cafe24.dk4750.miniMarket.vo;

import org.springframework.web.multipart.MultipartFile;

// 멤버 아이템과 사진을 같이 인서트하기위한 VO타입 생성
public class MemberItemForm {
	// 멤버 아이템 속성
	private int memberItemNo;
	private String memberUniqueNo;
	private String memberItemTitle;
	private String categoryName;
	private String memberItemPrice;
	private String memberItemContent;
	private String memberItemDate;
	private String memberItemState;
	// 멤버 아이템 사진 속성
	private MultipartFile memberItemPic1;
	private MultipartFile memberItemPic2;
	private MultipartFile memberItemPic3;
	private MultipartFile memberItemPic4;
	private MultipartFile memberItemPic5;
	
	// 겟터 셋터
	public int getMemberItemNo() {
		return memberItemNo;
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
	public MultipartFile getMemberItemPic1() {
		return memberItemPic1;
	}
	public void setMemberItemPic1(MultipartFile memberItemPic1) {
		this.memberItemPic1 = memberItemPic1;
	}
	public MultipartFile getMemberItemPic2() {
		return memberItemPic2;
	}
	public void setMemberItemPic2(MultipartFile memberItemPic2) {
		this.memberItemPic2 = memberItemPic2;
	}
	public MultipartFile getMemberItemPic3() {
		return memberItemPic3;
	}
	public void setMemberItemPic3(MultipartFile memberItemPic3) {
		this.memberItemPic3 = memberItemPic3;
	}
	public MultipartFile getMemberItemPic4() {
		return memberItemPic4;
	}
	public void setMemberItemPic4(MultipartFile memberItemPic4) {
		this.memberItemPic4 = memberItemPic4;
	}
	public MultipartFile getMemberItemPic5() {
		return memberItemPic5;
	}
	public void setMemberItemPic5(MultipartFile memberItemPic5) {
		this.memberItemPic5 = memberItemPic5;
	}
	
	// toString
	@Override
	public String toString() {
		return "MemberItemForm [memberItemNo=" + memberItemNo + ", memberUniqueNo=" + memberUniqueNo
				+ ", memberItemTitle=" + memberItemTitle + ", categoryName=" + categoryName + ", memberItemPrice="
				+ memberItemPrice + ", memberItemContent=" + memberItemContent + ", memberItemDate=" + memberItemDate
				+ ", memberItemState=" + memberItemState + ", memberItemPic1=" + memberItemPic1 + ", memberItemPic2="
				+ memberItemPic2 + ", memberItemPic3=" + memberItemPic3 + ", memberItemPic4=" + memberItemPic4
				+ ", memberItemPic5=" + memberItemPic5 + "]";
	}
}
