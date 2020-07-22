package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.Chat;

@Mapper
public interface ChatMapper {
	//채팅 메세지 리스트
	public List<Chat> selectChatList(int chatroomNo);
	//채팅 메세지 추가
	public int insertChatList(Chat chat);
	//채팅 상대 아이디 리스트
	public List<String> selectChatMemberId(int chatroomNo);
}
