package com.cafe24.dk4750.miniMarket.vo;

public class Manner {
	private int mannerNo;
	private double goodManner;
	private double badManner;
	private String mannerDate;
	private String mannerContent1;
	private String mannerContent2;
	private String mannerContent3;
	private String mannerContent4;
	private String mannerContent5;
	private String mannerContent6;
	private String memberId;
	private String memberUniqueNo;
	private int memberItemNo;
	
	// 겟터 셋터
	public int getMannerNo() {
		return mannerNo;
	}
	public void setMannerNo(int mannerNo) {
		this.mannerNo = mannerNo;
	}
	public double getGoodManner() {
		return goodManner;
	}
	public void setGoodManner(double goodManner) {
		this.goodManner = goodManner;
	}
	public double getBadManner() {
		return badManner;
	}
	public void setBadManner(double badManner) {
		this.badManner = badManner;
	}
	public String getMannerDate() {
		return mannerDate;
	}
	public void setMannerDate(String mannerDate) {
		this.mannerDate = mannerDate;
	}
	public String getMannerContent1() {
		return mannerContent1;
	}
	public void setMannerContent1(String mannerContent1) {
		this.mannerContent1 = mannerContent1;
	}
	public String getMannerContent2() {
		return mannerContent2;
	}
	public void setMannerContent2(String mannerContent2) {
		this.mannerContent2 = mannerContent2;
	}
	public String getMannerContent3() {
		return mannerContent3;
	}
	public void setMannerContent3(String mannerContent3) {
		this.mannerContent3 = mannerContent3;
	}
	public String getMannerContent4() {
		return mannerContent4;
	}
	public void setMannerContent4(String mannerContent4) {
		this.mannerContent4 = mannerContent4;
	}
	public String getMannerContent5() {
		return mannerContent5;
	}
	public void setMannerContent5(String mannerContent5) {
		this.mannerContent5 = mannerContent5;
	}
	public String getMannerContent6() {
		return mannerContent6;
	}
	public void setMannerContent6(String mannerContent6) {
		this.mannerContent6 = mannerContent6;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
	}
	public int getMemberItemNo() {
		return memberItemNo;
	}
	public void setMemberItemNo(int memberItemNo) {
		this.memberItemNo = memberItemNo;
	}
	
	// toString
	@Override
	public String toString() {
		return "Manner [mannerNo=" + mannerNo + ", goodManner=" + goodManner + ", badManner=" + badManner
				+ ", mannerDate=" + mannerDate + ", mannerContent1=" + mannerContent1 + ", mannerContent2="
				+ mannerContent2 + ", mannerContent3=" + mannerContent3 + ", mannerContent4=" + mannerContent4
				+ ", mannerContent5=" + mannerContent5 + ", mannerContent6=" + mannerContent6 + ", memberId=" + memberId
				+ ", memberUniqueNo=" + memberUniqueNo + ", memberItemNo=" + memberItemNo + "]";
	}
}