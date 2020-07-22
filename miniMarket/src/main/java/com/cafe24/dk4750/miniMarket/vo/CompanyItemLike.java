package com.cafe24.dk4750.miniMarket.vo;

public class CompanyItemLike {
	private int likeNo;
	private int likeActive;
	private String memberUniqueNo;
	private int companyItemNo;
	private String lakeDate;
	
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
	public int getCompanyItemNo() {
		return companyItemNo;
	}
	public void setCompanyItemNo(int companyItemNo) {
		this.companyItemNo = companyItemNo;
	}
	public String getLakeDate() {
		return lakeDate;
	}
	public void setLakeDate(String lakeDate) {
		this.lakeDate = lakeDate;
	}
	
	@Override
	public String toString() {
		return "CompanyItemLike [likeNo=" + likeNo + ", likeActive=" + likeActive + ", memberUniqueNo=" + memberUniqueNo
				+ ", companyItemNo=" + companyItemNo + ", lakeDate=" + lakeDate + "]";
	}

}
