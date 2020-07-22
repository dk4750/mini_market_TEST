package com.cafe24.dk4750.miniMarket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.ChatroomService;
import com.cafe24.dk4750.miniMarket.vo.Chatroom;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;



@Controller
public class ChatroomController {
   
   @Autowired
   private ChatroomService chatroomService;
   
   //채팅방 활성화 상태 변경
   @GetMapping("/modifyChatroomActive")
   public String modifyChatroom(HttpSession session , @RequestParam(value="chatroomNo", defaultValue = "0") int chatroomNo) {
	   
	   // 비로그인 상태시 로그인 창으로
	  if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
        return "redirect:/loginMemberAndCompany";
	  }else if(session.getAttribute("loginCompany") != null || session.getAttribute("loginAdmin") != null) {
		System.out.println("업체 혹은 관리자 로그인 시");
		return "redirect:/index";
	  }
      //채팅방 번호 디버깅(매개변수 받아온 값)
      System.out.println(chatroomNo + "<--chatroomNo modifyChatroomActive");
      //변경하려는 값 추가
      String chatroomActive = "connect";
      Chatroom chatroom = new Chatroom();
      //객체에 set으로 넘어온 매개변수를 넣어줌
      chatroom.setChatroomNo(chatroomNo);
      chatroom.setChatroomActive(chatroomActive);
      chatroomService.modifyChatroomDisconnect(chatroom);
      return "redirect:/chatroomList";
   }
   //임시 채팅방 테스트
   @GetMapping("/button")
   public String getButton() {
      return "button";
   }
   //채팅방 리스트 페이지 get
   @GetMapping("/chatroomList")
   public String getChatRoomListByMemberId(HttpSession session, Model model) {
      if(session.getAttribute("loginMember") == null) {
         return "redirect:loginMemberAndCompany";
      }else if(session.getAttribute("loginCompany") != null || session.getAttribute("loginAdmin") != null) {
  		System.out.println("업체 혹은 관리자 로그인 시");
  		return "redirect:/index";
  	  }
      //세션 값을 변수에 저장
      String memberUniqueNo = ((LoginMember)session.getAttribute("loginMember")).getMemberUniqueNo();
      String memberId = ((LoginMember)session.getAttribute("loginMember")).getMemberId();
      String memberNickname = ((LoginMember)session.getAttribute("loginMember")).getMemberNickname();
      String profilePic = ((LoginMember)session.getAttribute("loginMember")).getProfilePic();
      //저장한 세션값을 객채에 넣어줌
      Chatroom chatRoom = new Chatroom();
      chatRoom.setMemberId(memberId);
      chatRoom.setMemberUniqueNo(memberUniqueNo);
      List<Chatroom> list = chatroomService.getChatRoomListBymemberId(chatRoom);
      System.out.println(list + "<--채팅방 리스트");
      model.addAttribute("list", list); // 채팅방 리스트
      model.addAttribute("memberId", memberId);// 세션 id
      model.addAttribute("memberUniqueNo", memberUniqueNo);//세션 uniqueNo
      model.addAttribute("memberNickname", memberNickname);//세션 닉네임
      model.addAttribute("profilePic", profilePic);//세션 사진
      return "chatroomList";
   }
   //채팅방 생성 액션
   @PostMapping("/chatroom")
   public String addChatRoom(/*세션으로 받*/ @RequestParam(value="memberId", defaultValue = "") String memberId/*받는 사람*/, @RequestParam(value="memberItemNo", defaultValue = "0") int memberItemNo , Model model, HttpSession session) {
	  // 비로그인 상태시 로그인 창으로
	  if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
        return "redirect:/loginMemberAndCompany";
	  }else if(session.getAttribute("loginCompany") != null || session.getAttribute("loginAdmin") != null) {
			System.out.println("업체 혹은 관리자 로그인 시");
			return "redirect:/index";
	  }
	  String memberUniqueNo = ((LoginMember)session.getAttribute("loginMember")).getMemberUniqueNo();
      String nickname = ((LoginMember)session.getAttribute("loginMember")).getMemberNickname();
      System.out.println(memberUniqueNo);
      System.out.println(memberId);
      System.out.println(memberItemNo);
      System.out.println(nickname + "-------------내 세션 memberUniqueNo , memberId , memberItemNo ,nickname------------------");
      //임의로 아이템 번호 만들어줌
      
      //채팅방 생성시 초기값을 disconnect로 설정
      String active = "disconnect"; 
      Chatroom chatroom = new Chatroom();
      chatroom.setMemberItemNo(memberItemNo);
      chatroom.setNickname(nickname);
      chatroom.setMemberItemNo(memberItemNo);
      chatroom.setMemberUniqueNo(memberUniqueNo);
      chatroom.setMemberId(memberId);
      chatroom.setChatroomActive(active);
      System.out.println(chatroom);
      //채팅방 유무 체크 후 채팅방이 존재시 msg를 model로 보내줌 존재하지않으면 추가 
      chatroomService.addChatRoom(chatroom);
         return "redirect:/chatroomList";
      
   }
}