package com.cafe24.dk4750.miniMarket.vo;

public class MemberItemLike {
	private int likeNo;
	private int likeActive;
	private String memberUniqueNo;
	private int memberItemNo;
	private String likeDate;
	// 겟터 셋터
	public int getLikeNo() {
		return likeNo;
	}
	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}
	public int getLikeActive() {
		return likeActive;
	}
	public void setLikeActive(int likeActive) {
		this.likeActive = likeActive;
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
	public String getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(String likeDate) {
		this.likeDate = likeDate;
	}	
	// toString
	@Override
	public String toString() {
		return "MemberItemLike [likeNo=" + likeNo + ", likeActive=" + likeActive + ", memberUniqueNo=" + memberUniqueNo
				+ ", memberItemNo=" + memberItemNo + ", likeDate=" + likeDate + "]";
	}

	
}
