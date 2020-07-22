package com.cafe24.dk4750.miniMarket.vo;

public class CompanyItem {
	private int companyItemNo;
	private String companyUniqueNo;
	private String companyItemTitle;
	private String categoryName;
	private String companyPhone;
	private String companyItemPrice;
	private String companyItemContent;
	private String companyItemState;
	private String companyItemDate;
	
	// 겟터 셋터
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
	
	// toString
	@Override
	public String toString() {
		return "CompanyItem [companyItemNo=" + companyItemNo + ", companyUniqueNo=" + companyUniqueNo
				+ ", companyItemTitle=" + companyItemTitle + ", categoryName=" + categoryName + ", companyPhone="
				+ companyPhone + ", companyItemPrice=" + companyItemPrice + ", companyItemContent=" + companyItemContent
				+ ", companyItemState=" + companyItemState + ", companyItemDate=" + companyItemDate + "]";
	}
}
