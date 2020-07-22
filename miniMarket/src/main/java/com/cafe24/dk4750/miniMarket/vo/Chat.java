package com.cafe24.dk4750.miniMarket.vo;

public class Chat {
	private int chatNo;
	private String memberId;
	private String chatMessage;
	private String chatDate;
	private int chatroomNo;
	public int getChatNo() {
		return chatNo;
	}
	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getChatMessage() {
		return chatMessage;
	}
	public void setChatMessage(String chatMessage) {
		this.chatMessage = chatMessage;
	}
	public String getChatDate() {
		return chatDate;
	}
	public void setChatDate(String chatDate) {
		this.chatDate = chatDate;
	}
	public int getChatroomNo() {
		return chatroomNo;
	}
	public void setChatroomNo(int chatroomNo) {
		this.chatroomNo = chatroomNo;
	}
	@Override
	public String toString() {
		return "Chat [chatNo=" + chatNo + ", memberId=" + memberId + ", chatMessage=" + chatMessage + ", chatDate="
				+ chatDate + ", chatroomNo=" + chatroomNo + "]";
	}
	
	
}
