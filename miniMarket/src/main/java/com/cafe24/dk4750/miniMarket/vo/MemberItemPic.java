package com.cafe24.dk4750.miniMarket.vo;

public class MemberItemPic {
	private int picNo;
	private int memberItemNo;
	private String memberItemPic1;
	private String memberItemPic2;
	private String memberItemPic3;
	private String memberItemPic4;
	private String memberItemPic5;
	private String picDate;
	
	// 겟터 셋터
	public int getPicNo() {
		return picNo;
	}
	public void setPicNo(int picNo) {
		this.picNo = picNo;
	}
	public int getMemberItemNo() {
		return memberItemNo;
	}
	public void setMemberItemNo(int memberItemNo) {
		this.memberItemNo = memberItemNo;
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
	
	// toString
	@Override
	public String toString() {
		return "MemberItemPic [picNo=" + picNo + ", memberItemNo=" + memberItemNo + ", memberItemPic1=" + memberItemPic1
				+ ", memberItemPic2=" + memberItemPic2 + ", memberItemPic3=" + memberItemPic3 + ", memberItemPic4="
				+ memberItemPic4 + ", memberItemPic5=" + memberItemPic5 + ", picDate=" + picDate + "]";
	}
}
