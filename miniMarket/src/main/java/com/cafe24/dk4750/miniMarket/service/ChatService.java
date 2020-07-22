package com.cafe24.dk4750.miniMarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.ChatMapper;
import com.cafe24.dk4750.miniMarket.mapper.ChatroomMapper;
import com.cafe24.dk4750.miniMarket.vo.Chat;


@Service
@Transactional
public class ChatService {
	@Autowired
	private ChatMapper chatMapper;
	@Autowired
	private ChatroomMapper chatroomMapper;
	
	//판매자 아이디 값
	public String getChatroomMemberIdOne(int chatroomNo) {
		return chatroomMapper.selectChatroomMemberIdOne(chatroomNo);
	}
	//멤버 아이디 리스트
	public List<String> getChatMemberId(int chatroomNo) {
		return chatMapper.selectChatMemberId(chatroomNo);
	}
	// 채팅 메세지 리스트
	public List<Chat> getChatList(int chatroomNo){
		System.out.println(chatroomNo);
		List<Chat> list = chatMapper.selectChatList(chatroomNo);
		
		return list;
	}
	//채팅 메세지 추가
	public int addChatList(Chat chat) {
		System.out.println(chat);
		
		return chatMapper.insertChatList(chat);
	}
}
