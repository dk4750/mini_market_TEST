package com.cafe24.dk4750.miniMarket.vo;

public class MemberTemp {
	private int tempNo;
	private String memberUniqueNo;
	private double tempInsertScore;
	private String tempDate;
	
	// 겟터 셋터
	public int getTempNo() {
		return tempNo;
	}
	public void setTempNo(int tempNo) {
		this.tempNo = tempNo;
	}
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
	}
	public double getTempInsertScore() {
		return tempInsertScore;
	}
	public void setTempInsertScore(double tempInsertScore) {
		this.tempInsertScore = tempInsertScore;
	}
	public String getTempDate() {
		return tempDate;
	}
	public void setTempDate(String tempDate) {
		this.tempDate = tempDate;
	}
	
	// toString
	@Override
	public String toString() {
		return "MemberTemp [tempNo=" + tempNo + ", memberUniqueNo=" + memberUniqueNo + ", tempInsertScore="
				+ tempInsertScore + ", tempDate=" + tempDate + "]";
	}
}
