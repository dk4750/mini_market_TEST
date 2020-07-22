package com.cafe24.dk4750.miniMarket.vo;

public class ItemSoldoutAndMemberItemAndMemberItemPic {
	// soldout 속성
	private int soldoutNo;
	private int memberItemNo;
	private String memberUniqueNo;
	private String soldoutDate;
	// memberItem 속성
	private String memberItemTitle;
	private String categoryName;
	private String memberItemPrice;
	private String memberItemContent;
	private String memberItemDate;
	private String memberItemState;
	private String memberUniqueNoSale;
	// memberItemPic 속성
	private int picNo;
	private String memberItemPic1;
	private String memberItemPic2;
	private String memberItemPic3;
	private String memberItemPic4;
	private String memberItemPic5;
	private String picDate;
	
	// 겟터 셋터
	public String getMemberUniqueNoSale() {
		return memberUniqueNoSale;
	}
	public void setMemberUniqueNoSale(String memberUniqueNoSale) {
		this.memberUniqueNoSale = memberUniqueNoSale;
	}
	public int getSoldoutNo() {
		return soldoutNo;
	}
	public void setSoldoutNo(int soldoutNo) {
		this.soldoutNo = soldoutNo;
	}
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
	public String getSoldoutDate() {
		return soldoutDate;
	}
	public void setSoldoutDate(String soldoutDate) {
		this.soldoutDate = soldoutDate;
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
	public int getPicNo() {
		return picNo;
	}
	public void setPicNo(int picNo) {
		this.picNo = picNo;
	}
	public String getMemberItemPic1() {
		return memberItemPic1;
	}
	public void setMemberItemPic1(String memberItemPic1) {
		this.memberItemPic1 = memberItemPic1;
	}
	public String getMemberItemPic2() {
		return memberItemPic2;
	}
	public void setMemberItemPic2(String memberItemPic2) {
		this.memberItemPic2 = memberItemPic2;
	}
	public String getMemberItemPic3() {
		return memberItemPic3;
	}
	public void setMemberItemPic3(String memberItemPic3) {
		this.memberItemPic3 = memberItemPic3;
	}
	public String getMemberItemPic4() {
		return memberItemPic4;
	}
	public void setMemberItemPic4(String memberItemPic4) {
		this.memberItemPic4 = memberItemPic4;
	}
	public String getMemberItemPic5() {
		return memberItemPic5;
	}
	public void setMemberItemPic5(String memberItemPic5) {
		this.memberItemPic5 = memberItemPic5;
	}
	public String getPicDate() {
		return picDate;
	}
	public void setPicDate(String picDate) {
		this.picDate = picDate;
	}
	//toString
	@Override
	public String toString() {
		return "ItemSoldoutAndMemberItemAndMemberItemPic [soldoutNo=" + soldoutNo + ", memberItemNo=" + memberItemNo
				+ ", memberUniqueNo=" + memberUniqueNo + ", soldoutDate=" + soldoutDate + ", memberItemTitle="
				+ memberItemTitle + ", categoryName=" + categoryName + ", memberItemPrice=" + memberItemPrice
				+ ", memberItemContent=" + memberItemContent + ", memberItemDate=" + memberItemDate
				+ ", memberItemState=" + memberItemState + ", memberUniqueNoSale=" + memberUniqueNoSale + ", picNo="
				+ picNo + ", memberItemPic1=" + memberItemPic1 + ", memberItemPic2=" + memberItemPic2
				+ ", memberItemPic3=" + memberItemPic3 + ", memberItemPic4=" + memberItemPic4 + ", memberItemPic5="
				+ memberItemPic5 + ", picDate=" + picDate + "]";
	}
}
