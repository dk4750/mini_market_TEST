package com.cafe24.dk4750.miniMarket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.ChatroomMapper;
import com.cafe24.dk4750.miniMarket.vo.Chatroom;


@Service
@Transactional
public class ChatroomService {
   @Autowired
   private ChatroomMapper chatroomMapper;
   //구매자 리스트
   public List<Chatroom> getCustomerList(int memberItemNo) {
      return chatroomMapper.selectCustomerList(memberItemNo);
   }
   //상대방 닉네임 리스트 
   public List<Chatroom> getChatRoomListByMemberUniqueNo(String memberId){
      return chatroomMapper.selectChatRoomByMemberUniqueNo(memberId);
   }
   //채팅방 활성화 상태 변경
   public int modifyChatroomDisconnect(Chatroom chatroom) {
         return chatroomMapper.updateChatroomDisconnect(chatroom);
      }
   //채팅방 상세보기
   public Chatroom getChatRoomOne(int chatroomNo) {
         return chatroomMapper.selectChatroomOne(chatroomNo);
      }
   //채팅방 리스트
   public List<Chatroom> getChatRoomListBymemberId(Chatroom chatroom) {
      List<Chatroom> list = new ArrayList<>();
      list = chatroomMapper.selectChatRoomByMemberId(chatroom);
      return list;
   }
   //채팅방 체크
   public int getChatroomCheck(Chatroom chatroom) {
	   int checkroom = chatroomMapper.selectChatRoomCheck(chatroom);
	   return checkroom;
   }
   //채팅방 추가
   public int addChatRoom(Chatroom chatroom) {
      System.out.println(chatroom);
      return chatroomMapper.insertChatRoom(chatroom);
       
   }
}