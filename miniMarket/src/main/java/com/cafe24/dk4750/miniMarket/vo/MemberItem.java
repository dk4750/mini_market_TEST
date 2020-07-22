package com.cafe24.dk4750.miniMarket.vo;

public class MemberItem {
	private int memberItemNo;
	private String memberUniqueNo;
	private String memberItemTitle;
	private String categoryName;
	private String memberItemPrice;
	private String memberItemContent;
	private String memberItemDate;
	private String memberItemState;
	
	// 겟터셋터
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
	
	// toString
	@Override
	public String toString() {
		return "MemberItem [memberItemNo=" + memberItemNo + ", memberUniqueNo=" + memberUniqueNo + ", memberItemTitle="
				+ memberItemTitle + ", categoryName=" + categoryName + ", memberItemPrice=" + memberItemPrice
				+ ", memberItemContent=" + memberItemContent + ", memberItemDate=" + memberItemDate
				+ ", memberItemState=" + memberItemState + "]";
	}
	
}
