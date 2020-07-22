package com.cafe24.dk4750.miniMarket.vo;

public class QnaCommentMember {
	private int qnaCommentMemberNo;
	private int qnaBoardMemberNo;
	private String qnaCommentMember;
	private String qnaCommentMemberDate;
	private String adminId;
	public int getQnaCommentMemberNo() {
		return qnaCommentMemberNo;
	}
	public void setQnaCommentMemberNo(int qnaCommentMemberNo) {
		this.qnaCommentMemberNo = qnaCommentMemberNo;
	}
	public int getQnaBoardMemberNo() {
		return qnaBoardMemberNo;
	}
	public void setQnaBoardMemberNo(int qnaBoardMemberNo) {
		this.qnaBoardMemberNo = qnaBoardMemberNo;
	}
	public String getQnaCommentMember() {
		return qnaCommentMember;
	}
	public void setQnaCommentMember(String qnaCommentMember) {
		this.qnaCommentMember = qnaCommentMember;
	}
	public String getQnaCommentMemberDate() {
		return qnaCommentMemberDate;
	}
	public void setQnaCommentMemberDate(String qnaCommentMemberDate) {
		this.qnaCommentMemberDate = qnaCommentMemberDate;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	@Override
	public String toString() {
		return "QnaCommentMember [qnaCommentMemberNo=" + qnaCommentMemberNo + ", qnaBoardMemberNo=" + qnaBoardMemberNo
				+ ", qnaCommentMember=" + qnaCommentMember + ", qnaCommentMemberDate=" + qnaCommentMemberDate
				+ ", adminId=" + adminId + "]";
	}
	
	
}