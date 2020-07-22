package com.cafe24.dk4750.miniMarket.vo;

public class CompanyItemAndCompanyAndCompanyItemPicAndCompanyItemLike {
	
	//업체 아이템 속성
	private int companyItemNo;
	private String companyUniqueNo;
	private String companyItemTitle;
	private String categoryName;
	private String companyPhone;
	private String companyItemPrice;
	private String companyItemContent;
	private String companyItemState;
	private String companyItemDate;
	
	// 업체 속성
	private String companyId;
	private String companySido;
	private String companySigungu;
	private String companyBname;
	private String companyPw;
	private String companyName;
	private String companyCeoName;
	private String companyEmail;
	private String compnayDate;
	
	//업체 사진 속성
	private int picNo;
	private String companyItemPic1;
	private String companyItemPic2;
	private String companyItemPic3;
	private String companyItemPic4;
	private String companyItemPic5;
	private String picDate;
	
	//업체 좋아요 속성
	private int likeNo;
	private String likeActive;
	private String memberUniqueNo;
	
	// 게터 세터
	public int getCompanyItemNo() {
		return companyItemNo;
	}
	public void setCompanyItemNo(int companyItemNo) {
		this.companyItemNo = companyItemNo;
	}
	public String getCompanyUniqueNo() {
		return companyUniqueNo;
	}
	public void setCompanyUniqueNo(String companyUniqueNo) {
		this.companyUniqueNo = companyUniqueNo;
	}
	public String getCompanyItemTitle() {
		return companyItemTitle;
	}
	public void setCompanyItemTitle(String companyItemTitle) {
		this.companyItemTitle = companyItemTitle;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getCompanyItemPrice() {
		return companyItemPrice;
	}
	public void setCompanyItemPrice(String companyItemPrice) {
		this.companyItemPrice = companyItemPrice;
	}
	public String getCompanyItemContent() {
		return companyItemContent;
	}
	public void setCompanyItemContent(String companyItemContent) {
		this.companyItemContent = companyItemContent;
	}
	public String getCompanyItemState() {
		return companyItemState;
	}
	public void setCompanyItemState(String companyItemState) {
		this.companyItemState = companyItemState;
	}
	public String getCompanyItemDate() {
		return companyItemDate;
	}
	public void setCompanyItemDate(String companyItemDate) {
		this.companyItemDate = companyItemDate;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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
	public String getCompanyCeoName() {
		return companyCeoName;
	}
	public void setCompanyCeoName(String companyCeoName) {
		this.companyCeoName = companyCeoName;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getCompnayDate() {
		return compnayDate;
	}
	public void setCompnayDate(String compnayDate) {
		this.compnayDate = compnayDate;
	}
	public int getPicNo() {
		return picNo;
	}
	public void setPicNo(int picNo) {
		this.picNo = picNo;
	}
	public String getCompanyItemPic1() {
		return companyItemPic1;
	}
	public void setCompanyItemPic1(String companyItemPic1) {
		this.companyItemPic1 = companyItemPic1;
	}
	public String getCompanyItemPic2() {
		return companyItemPic2;
	}
	public void setCompanyItemPic2(String companyItemPic2) {
		this.companyItemPic2 = companyItemPic2;
	}
	public String getCompanyItemPic3() {
		return companyItemPic3;
	}
	public void setCompanyItemPic3(String companyItemPic3) {
		this.companyItemPic3 = companyItemPic3;
	}
	public String getCompanyItemPic4() {
		return companyItemPic4;
	}
	public void setCompanyItemPic4(String companyItemPic4) {
		this.companyItemPic4 = companyItemPic4;
	}
	public String getCompanyItemPic5() {
		return companyItemPic5;
	}
	public void setCompanyItemPic5(String companyItemPic5) {
		this.companyItemPic5 = companyItemPic5;
	}
	public String getPicDate() {
		return picDate;
	}
	public void setPicDate(String picDate) {
		this.picDate = picDate;
	}
	public int getLikeNo() {
		return likeNo;
	}
	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}
	public String getLikeActive() {
		return likeActive;
	}
	public void setLikeActive(String likeActive) {
		this.likeActive = likeActive;
	}
	public String getMemberUniqueNo() {
		return memberUniqueNo;
	}
	public void setMemberUniqueNo(String memberUniqueNo) {
		this.memberUniqueNo = memberUniqueNo;
	}
	
	// toString
	@Override
	public String toString() {
		return "CompanyItemAndCompanyAndCompanyItemPicAndCompanyItemLike [companyItemNo=" + companyItemNo
				+ ", companyUniqueNo=" + companyUniqueNo + ", companyItemTitle=" + companyItemTitle + ", categoryName="
				+ categoryName + ", companyPhone=" + companyPhone + ", companyItemPrice=" + companyItemPrice
				+ ", companyItemContent=" + companyItemContent + ", companyItemState=" + companyItemState
				+ ", companyItemDate=" + companyItemDate + ", companyId=" + companyId + ", companySido=" + companySido
				+ ", companySigungu=" + companySigungu + ", companyBname=" + companyBname + ", companyPw=" + companyPw
				+ ", companyName=" + companyName + ", companyCeoName=" + companyCeoName + ", companyEmail="
				+ companyEmail + ", compnayDate=" + compnayDate + ", picNo=" + picNo + ", companyItemPic1="
				+ companyItemPic1 + ", companyItemPic2=" + companyItemPic2 + ", companyItemPic3=" + companyItemPic3
				+ ", companyItemPic4=" + companyItemPic4 + ", companyItemPic5=" + companyItemPic5 + ", picDate="
				+ picDate + ", likeNo=" + likeNo + ", likeActive=" + likeActive + ", memberUniqueNo=" + memberUniqueNo
				+ "]";
	}
	
}
