package com.cafe24.dk4750.miniMarket.vo;

public class LoginMember {
	private String memberId;
	private String memberPw; 
	private String memberUniqueNo;
	private String memberNickname;
	private String memberSido;
	private String memberSigungu;
	private String memberBname;
	private String profilePic;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public String getMemberSido() {
		return memberSido;
	}
	public void setMemberSido(String memberSido) {
		this.memberSido = memberSido;
	}
	public String getMemberSigungu() {
		return memberSigungu;
	}
	public void setMemberSigungu(String memberSigungu) {
		this.memberSigungu = memberSigungu;
	}
	public String getMemberBname() {
		return memberBname;
	}
	public void setMemberBname(String memberBname) {
		this.memberBname = memberBname;
	}
	
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	@Override
	public String toString() {
		return "LoginMember [memberId=" + memberId + ", memberPw=" + memberPw + ", memberUniqueNo=" + memberUniqueNo
				+ ", memberNickname=" + memberNickname + ", memberSido=" + memberSido + ", memberSigungu="
				+ memberSigungu + ", memberBname=" + memberBname + ", profilePic=" + profilePic + "]";
	}
	
	
}
