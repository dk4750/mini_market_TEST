package com.cafe24.dk4750.miniMarket.vo;

public class MemberPic {
	private int picNo;
	private String profilePic;
	private String picDate;
	private String memberId;
	
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
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	// toString
	@Override
	public String toString() {
		return "MemberPic [picNo=" + picNo + ", profilePic=" + profilePic + ", picDate=" + picDate + ", memberId="
				+ memberId + "]";
	}
}
