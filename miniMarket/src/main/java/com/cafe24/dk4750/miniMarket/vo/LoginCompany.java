package com.cafe24.dk4750.miniMarket.vo;

public class LoginCompany {
	private String companyId;
	private String companyPw;
	private String companyName;	 
	private String companyUniqueNo; 
	private String companySido;
	private String companySigungu;
	private String companyBname;
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyPw() {
		return companyPw;
	}
	public void setCompanyPw(String companyPw) {
		this.companyPw = companyPw;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyUniqueNo() {
		return companyUniqueNo;
	}
	public void setCompanyUniqueNo(String companyUniqueNo) {
		this.companyUniqueNo = companyUniqueNo;
	}
	public String getCompanySido() {
		return companySido;
	}
	public void setCompanySido(String companySido) {
		this.companySido = companySido;
	}
	public String getCompanySigungu() {
		return companySigungu;
	}
	public void setCompanySigungu(String companySigungu) {
		this.companySigungu = companySigungu;
	}
	public String getCompanyBname() {
		return companyBname;
	}
	public void setCompanyBname(String companyBname) {
		this.companyBname = companyBname;
	}
	
	@Override
	public String toString() {
		return "LoginCompany [companyId=" + companyId + ", companyPw=" + companyPw + ", companyName=" + companyName
				+ ", companyUniqueNo=" + companyUniqueNo + ", companySido=" + companySido + ", companySigungu="
				+ companySigungu + ", companyBname=" + companyBname + "]";
	}
}
