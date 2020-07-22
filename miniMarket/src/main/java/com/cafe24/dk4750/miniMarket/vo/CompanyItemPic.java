package com.cafe24.dk4750.miniMarket.vo;

public class CompanyItemPic {
	private int picNo;
	private int companyItemNo;
	private String companyItemPic1;
	private String companyItemPic2;
	private String companyItemPic3;
	private String companyItemPic4;
	private String companyItemPic5;
	private String picDate;
	
	// 게터 세터
	public int getPicNo() {
		return picNo;
	}
	public void setPicNo(int picNo) {
		this.picNo = picNo;
	}
	public int getCompanyItemNo() {
		return companyItemNo;
	}
	public void setCompanyItemNo(int companyItemNo) {
		this.companyItemNo = companyItemNo;
	}
	public String getCompanyItemPic1() {
		return companyItemPic1;
	}
	public void setCompanyItemPic1(String companyItemPic1) {
		this.companyItemPic1 = companyItemPic1;
	}
	public String getCompanyItemPic2() {
		return companyItemPic2;
	}
	public void setCompanyItemPic2(String companyItemPic2) {
		this.companyItemPic2 = companyItemPic2;
	}
	public String getCompanyItemPic3() {
		return companyItemPic3;
	}
	public void setCompanyItemPic3(String companyItemPic3) {
		this.companyItemPic3 = companyItemPic3;
	}
	public String getCompanyItemPic4() {
		return companyItemPic4;
	}
	public void setCompanyItemPic4(String companyItemPic4) {
		this.companyItemPic4 = companyItemPic4;
	}
	public String getCompanyItemPic5() {
		return companyItemPic5;
	}
	public void setCompanyItemPic5(String companyItemPic5) {
		this.companyItemPic5 = companyItemPic5;
	}
	public String getPicDate() {
		return picDate;
	}
	public void setPicDate(String picDate) {
		this.picDate = picDate;
	}
	
	// toString
	@Override
	public String toString() {
		return "CompanyItemPic [picNo=" + picNo + ", companyItemNo=" + companyItemNo + ", companyItemPic1="
				+ companyItemPic1 + ", companyItemPic2=" + companyItemPic2 + ", companyItemPic3=" + companyItemPic3
				+ ", companyItemPic4=" + companyItemPic4 + ", companyItemPic5=" + companyItemPic5 + ", picDate="
				+ picDate + "]";
	}
	
	
}
