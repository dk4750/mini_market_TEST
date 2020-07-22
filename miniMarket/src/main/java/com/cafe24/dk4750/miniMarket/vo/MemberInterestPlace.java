package com.cafe24.dk4750.miniMarket.vo;

public class MemberInterestPlace {
	private int interestPlaceNo;
	private String memberId;
	private String sido;
	private String sigungu;
	private String bname;
	private String interestPlaceDate;
	public int getInterestPlaceNo() {
		return interestPlaceNo;
	}
	public void setInterestPlaceNo(int interestPlaceNo) {
		this.interestPlaceNo = interestPlaceNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getSigungu() {
		return sigungu;
	}
	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getInterestPlaceDate() {
		return interestPlaceDate;
	}
	public void setInterestPlaceDate(String interestPlaceDate) {
		this.interestPlaceDate = interestPlaceDate;
	}
	@Override
	public String toString() {
		return "MemberInterestPlace [interestPlaceNo=" + interestPlaceNo + ", memberId=" + memberId + ", sido=" + sido
				+ ", sigungu=" + sigungu + ", bname=" + bname + ", interestPlaceDate=" + interestPlaceDate + "]";
	}
	
	
}
