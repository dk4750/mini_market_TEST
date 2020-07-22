package com.cafe24.dk4750.miniMarket.vo;



public class CompanyNameAndPic2 {
	private String profilePic;
	private String picDate;
	private String companyId; 
	private String companyName;
	
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Override
	public String toString() {
		return "CompanyNameAndPic2 [profilePic=" + profilePic + ", picDate=" + picDate + ", companyId=" + companyId
				+ ", companyName=" + companyName + "]";
	}
	
}
