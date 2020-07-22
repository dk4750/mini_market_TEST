package com.cafe24.dk4750.miniMarket.vo;

import org.springframework.web.multipart.MultipartFile;

public class MemberNickAndPic {
	private MultipartFile profilePic;
	private String picDate;
	private String memberId;
	private String memberNickname;
	public MultipartFile getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(MultipartFile profilePic) {
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
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	
	@Override
	public String toString() {
		return "MemberNickAndPic [profilePic=" + profilePic + ", picDate=" + picDate + ", memberId=" + memberId
				+ ", memberNickname=" + memberNickname + "]";
	}

}
