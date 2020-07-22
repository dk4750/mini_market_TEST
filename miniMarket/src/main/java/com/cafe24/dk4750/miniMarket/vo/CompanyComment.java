package com.cafe24.dk4750.miniMarket.vo;

public class CompanyComment {
	private int companyCommentNo;
	private String companyCommentContent;
	private int companyItemNo;
	private String memberUniqueNo;
	private String companyUniqueNo;
	private String companyCommentDate;
	
	// 겟터 셋터
	public int getCompanyCommentNo() {
		return companyCommentNo;
	}
	public void setCompanyCommentNo(int companyCommentNo) {
		this.companyCommentNo = companyCommentNo;
	}
	public String getCompanyCommentContent() {
		return companyCommentContent;
	}
	public void setCompanyCommentContent(String companyCommentContent) {
		this.companyCommentContent = companyCommentContent;
	}
	public int getCompanyItemNo() {
		return companyItemNo;
	}
	public void setCompanyItemNo(int companyItemNo) {
		this.companyItemNo = companyItemNo;
	}
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
	}
	public String getCompanyUniqueNo() {
		return companyUniqueNo;
	}
	public void setCompanyUniqueNo(String companyUniqueNo) {
		this.companyUniqueNo = companyUniqueNo;
	}
	public String getCompanyCommentDate() {
		return companyCommentDate;
	}
	public void setCompanyCommentDate(String companyCommentDate) {
		this.companyCommentDate = companyCommentDate;
	}
	
	// toString
	@Override
	public String toString() {
		return "CompanyComment [companyCommentNo=" + companyCommentNo + ", companyCommentContent="
				+ companyCommentContent + ", companyItemNo=" + companyItemNo + ", memberUniqueNo=" + memberUniqueNo
				+ ", companyUniqueNo=" + companyUniqueNo + ", companyCommentDate=" + companyCommentDate + "]";
	}
}
