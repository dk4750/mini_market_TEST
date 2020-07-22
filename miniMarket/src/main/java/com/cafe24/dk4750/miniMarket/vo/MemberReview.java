package com.cafe24.dk4750.miniMarket.vo;

public class MemberReview {
	private int memberReviewNo;
	private String memberReviewContent;
	private String memberId;
	private String memberUniqueNo;
	private String memberUniqueNoSale;
	private String memberReviewDate;
	private int memberItemNo;
	
	// 게터 세터
	public int getMemberReviewNo() {
		return memberReviewNo;
	}
	public void setMemberReviewNo(int memberReviewNo) {
		this.memberReviewNo = memberReviewNo;
	}
	public String getMemberReviewContent() {
		return memberReviewContent;
	}
	public void setMemberReviewContent(String memberReviewContent) {
		this.memberReviewContent = memberReviewContent;
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
	public String getMemberUniqueNoSale() {
		return memberUniqueNoSale;
	}
	public void setMemberUniqueNoSale(String memberUniqueNoSale) {
		this.memberUniqueNoSale = memberUniqueNoSale;
	}
	public String getMemberReviewDate() {
		return memberReviewDate;
	}
	public void setMemberReviewDate(String memberReviewDate) {
		this.memberReviewDate = memberReviewDate;
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
		return "MemberReview [memberReviewNo=" + memberReviewNo + ", memberReviewContent=" + memberReviewContent
				+ ", memberId=" + memberId + ", memberUniqueNo=" + memberUniqueNo + ", memberUniqueNoSale="
				+ memberUniqueNoSale + ", memberReviewDate=" + memberReviewDate + ", memberItemNo=" + memberItemNo
				+ "]";
	}

}
