package com.cafe24.dk4750.miniMarket.vo;

public class QnaCommentCompany {
	private int qnaCommentCompanyNo;
	private int qnaBoardCompanyNo;
	private String qnaCommentCompany;
	private String qnaCommentCompanyDate;
	private String adminId;
	public int getQnaCommentCompanyNo() {
		return qnaCommentCompanyNo;
	}
	public void setQnaCommentCompanyNo(int qnaCommentCompanyNo) {
		this.qnaCommentCompanyNo = qnaCommentCompanyNo;
	}
	public int getQnaBoardCompanyNo() {
		return qnaBoardCompanyNo;
	}
	public void setQnaBoardCompanyNo(int qnaBoardCompanyNo) {
		this.qnaBoardCompanyNo = qnaBoardCompanyNo;
	}
	public String getQnaCommentCompany() {
		return qnaCommentCompany;
	}
	public void setQnaCommentCompany(String qnaCommentCompany) {
		this.qnaCommentCompany = qnaCommentCompany;
	}
	public String getQnaCommentCompanyDate() {
		return qnaCommentCompanyDate;
	}
	public void setQnaCommentCompanyDate(String qnaCommentCompanyDate) {
		this.qnaCommentCompanyDate = qnaCommentCompanyDate;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	@Override
	public String toString() {
		return "QnaCommentCompany [qnaCommentCompanyNo=" + qnaCommentCompanyNo + ", qnaBoardCompanyNo="
				+ qnaBoardCompanyNo + ", qnaCommentCompany=" + qnaCommentCompany + ", qnaCommentCompanyDate="
				+ qnaCommentCompanyDate + ", adminId=" + adminId + "]";
	}
	
}
