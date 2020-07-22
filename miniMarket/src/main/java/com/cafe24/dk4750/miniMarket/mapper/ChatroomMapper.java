package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.Chatroom;


@Mapper
public interface ChatroomMapper {
	//채팅창 판매자 아이디 불러오기
	public String selectChatroomMemberIdOne(int chatroomNo);
	//아이템 판매완료 
   public int updateSoldOutItem(int memberItemNo);
   // 구매자 리스트 
   public List<Chatroom> selectCustomerList(int memberItemNo);
   // 채팅방 유무 체크
   public int selectChatRoomCheck(Chatroom chatroom);
   //채팅방 리스트
   public List<Chatroom> selectChatRoomByMemberId(Chatroom chatroom);
   //채팅방 추가
   public int insertChatRoom(Chatroom chatroom);
   /*채팅방 최고 넘버 구하기
   public int selectMaxNum();
   */
   //채팅방 상세 정보
   public Chatroom selectChatroomOne(int chatroomNo);
   //채팅방 활성화 상태 변경
   public int updateChatroomDisconnect(Chatroom chatroom);
   //상대방 유니크 넘버 구하기
   public List<Chatroom> selectChatRoomByMemberUniqueNo(String memberId);
   
}