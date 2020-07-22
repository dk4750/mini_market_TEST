package com.cafe24.dk4750.miniMarket.vo;

public class LoginAdmin {
	private String adminId;
	private String adminName;
	
	// 게터 세터
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	// toString
	@Override
	public String toString() {
		return "LoginAdmin [adminId=" + adminId + ", adminName=" + adminName + "]";
	}
	
}
