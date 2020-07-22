package com.cafe24.dk4750.miniMarket.vo;

public class CompanyBackup {
	private String companyId;
	private String companyEmail;
	private String companyDivision;
	private String companyUniqueNo;
	private String companyDate;
	
	// 겟터 셋터
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getCompanyDivision() {
		return companyDivision;
	}
	public void setCompanyDivision(String companyDivision) {
		this.companyDivision = companyDivision;
	}
	public String getCompanyUniqueNo() {
		return companyUniqueNo;
	}
	public void setCompanyUniqueNo(String companyUniqueNo) {
		this.companyUniqueNo = companyUniqueNo;
	}
	public String getCompanyDate() {
		return companyDate;
	}
	public void setCompanyDate(String companyDate) {
		this.companyDate = companyDate;
	}
	
	// toString
	@Override
	public String toString() {
		return "CompanyBackup [companyId=" + companyId + ", companyEmail=" + companyEmail + ", companyDivision="
				+ companyDivision + ", companyUniqueNo=" + companyUniqueNo + ", companyDate=" + companyDate + "]";
	}
}
