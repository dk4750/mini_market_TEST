package com.cafe24.dk4750.miniMarket.vo;

import org.springframework.web.multipart.MultipartFile;

public class CompanyItemForm {
	// 업체 아이템 속성
	private int companyItemNo;
	private String companyUniqueNo;
	private String companyItemTitle;
	private String categoryName;
	private String companyPhone;
	private String companyItemPrice;
	private String companyItemContent;
	private String companyItemState;
	private String companyItemDate;
	
	// 업체 아이템 사진 속성
	private int picNo;
	private MultipartFile companyItemPic1;
	private MultipartFile companyItemPic2;
	private MultipartFile companyItemPic3;
	private MultipartFile companyItemPic4;
	private MultipartFile companyItemPic5;
	
	// 게터 세터
	public int getCompanyItemNo() {
		return companyItemNo;
	}
	public void setCompanyItemNo(int companyItemNo) {
		this.companyItemNo = companyItemNo;
	}
	public String getCompanyUniqueNo() {
		return companyUniqueNo;
	}
	public void setCompanyUniqueNo(String companyUniqueNo) {
		this.companyUniqueNo = companyUniqueNo;
	}
	public String getCompanyItemTitle() {
		return companyItemTitle;
	}
	public void setCompanyItemTitle(String companyItemTitle) {
		this.companyItemTitle = companyItemTitle;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getCompanyItemPrice() {
		return companyItemPrice;
	}
	public void setCompanyItemPrice(String companyItemPrice) {
		this.companyItemPrice = companyItemPrice;
	}
	public String getCompanyItemContent() {
		return companyItemContent;
	}
	public void setCompanyItemContent(String companyItemContent) {
		this.companyItemContent = companyItemContent;
	}
	public String getCompanyItemState() {
		return companyItemState;
	}
	public void setCompanyItemState(String companyItemState) {
		this.companyItemState = companyItemState;
	}
	public String getCompanyItemDate() {
		return companyItemDate;
	}
	public void setCompanyItemDate(String companyItemDate) {
		this.companyItemDate = companyItemDate;
	}
	public int getPicNo() {
		return picNo;
	}
	public void setPicNo(int picNo) {
		this.picNo = picNo;
	}
	public MultipartFile getCompanyItemPic1() {
		return companyItemPic1;
	}
	public void setCompanyItemPic1(MultipartFile companyItemPic1) {
		this.companyItemPic1 = companyItemPic1;
	}
	public MultipartFile getCompanyItemPic2() {
		return companyItemPic2;
	}
	public void setCompanyItemPic2(MultipartFile companyItemPic2) {
		this.companyItemPic2 = companyItemPic2;
	}
	public MultipartFile getCompanyItemPic3() {
		return companyItemPic3;
	}
	public void setCompanyItemPic3(MultipartFile companyItemPic3) {
		this.companyItemPic3 = companyItemPic3;
	}
	public MultipartFile getCompanyItemPic4() {
		return companyItemPic4;
	}
	public void setCompanyItemPic4(MultipartFile companyItemPic4) {
		this.companyItemPic4 = companyItemPic4;
	}
	public MultipartFile getCompanyItemPic5() {
		return companyItemPic5;
	}
	public void setCompanyItemPic5(MultipartFile companyItemPic5) {
		this.companyItemPic5 = companyItemPic5;
	}
	
	// toString
	@Override
	public String toString() {
		return "CompanyItemForm [companyItemNo=" + companyItemNo + ", companyUniqueNo=" + companyUniqueNo
				+ ", companyItemTitle=" + companyItemTitle + ", categoryName=" + categoryName + ", companyPhone="
				+ companyPhone + ", companyItemPrice=" + companyItemPrice + ", companyItemContent=" + companyItemContent
				+ ", companyItemState=" + companyItemState + ", companyItemDate=" + companyItemDate + ", picNo=" + picNo
				+ ", companyItemPic1=" + companyItemPic1 + ", companyItemPic2=" + companyItemPic2 + ", companyItemPic3="
				+ companyItemPic3 + ", companyItemPic4=" + companyItemPic4 + ", companyItemPic5=" + companyItemPic5
				+ "]";
	}
	
}
