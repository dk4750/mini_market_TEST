package com.cafe24.dk4750.miniMarket.vo;

public class CompanyPic {
	private int picNo;
	private String profilePic;
	private String picDate;
	private String companyId;
	
	// 겟터 셋터
	public int getPicNo() {
		return picNo;
	}
	public void setPicNo(int picNo) {
		this.picNo = picNo;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getPicDate() {
		return picDate;
	}
	public void setPicDate(String picDate) {
		this.picDate = picDate;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	// toString
	@Override
	public String toString() {
		return "CompanyPic [picNo=" + picNo + ", profilePic=" + profilePic + ", picDate=" + picDate + ", companyId="
				+ companyId + "]";
	}
}
