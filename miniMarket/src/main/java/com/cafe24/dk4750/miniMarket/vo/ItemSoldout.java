package com.cafe24.dk4750.miniMarket.vo;

public class ItemSoldout {
	private int soldoutNo;
	private int memberItemNo;
	private String memberUniqueNo;
	private String soldoutDate;
	
	// 겟터 셋터
	public int getSoldoutNo() {
		return soldoutNo;
	}
	public void setSoldoutNo(int soldoutNo) {
		this.soldoutNo = soldoutNo;
	}
	public int getMemberItemNo() {
		return memberItemNo;
	}
	public void setMemberItemNo(int memberItemNo) {
		this.memberItemNo = memberItemNo;
	}
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
	}
	public String getSoldoutDate() {
		return soldoutDate;
	}
	public void setSoldoutDate(String soldoutDate) {
		this.soldoutDate = soldoutDate;
	}
	
	// toString
	@Override
	public String toString() {
		return "ItemSoldout [soldoutNo=" + soldoutNo + ", memberItemNo=" + memberItemNo + ", memberUniqueNo="
				+ memberUniqueNo + ", soldoutDate=" + soldoutDate + "]";
	}
}
