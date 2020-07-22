package com.cafe24.dk4750.miniMarket.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.dk4750.miniMarket.service.ChatService;
import com.cafe24.dk4750.miniMarket.service.ChatroomService;
import com.cafe24.dk4750.miniMarket.vo.Chat;
import com.cafe24.dk4750.miniMarket.vo.Chatroom;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;




@Controller
public class ChatController {
	@Autowired
	private ChatroomService chatroomService;
	@Autowired 
	private ChatService chatService;
	
	@GetMapping("/chatList")
	public String getChatList(HttpSession session, Model model, @RequestParam(value = "chatroomNo", defaultValue = "0" ) int chatroomNo) {
		//비로그인시 접근 불가능
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
	         return "redirect:/loginMemberAndCompany";
	    }else if(session.getAttribute("loginCompany") != null || session.getAttribute("loginAdmin") != null) {
			System.out.println("업체 혹은 관리자 로그인 시");
			return "redirect:/index";
		}
		
		String memberId = ((LoginMember)session.getAttribute("loginMember")).getMemberId();
		String memberNickname = ((LoginMember)session.getAttribute("loginMember")).getMemberNickname();
		System.out.println(chatroomNo);
		String memberUniqueNo = ((LoginMember)session.getAttribute("loginMember")).getMemberUniqueNo();
		List<String> list = chatService.getChatMemberId(chatroomNo);
		System.out.println(list + "<--출력");
		Chatroom chatroom = chatroomService.getChatRoomOne(chatroomNo);
		System.out.println(chatroom +"<----세션 확인");
		System.out.println(chatroom.getMemberId() + "<---controller getmemberId");
		System.out.println(memberId);
		System.out.println(memberUniqueNo);
		System.out.println(chatroom.getMemberUniqueNo());
		// 현재 채팅중인 상대가 아닌 사람이 채팅방을 확인하려 할 때 메인페이지로 이동
		if(memberId.equals(chatroom.getMemberId()) ) {
			if(memberUniqueNo.equals(chatroom.getMemberUniqueNo())) {
				System.out.println("실패");
				return "redirect:/index";
			}
		}
		System.out.println("성공");
		model.addAttribute("chatroom", chatroom);
		model.addAttribute("memberNickname", memberNickname);
		model.addAttribute("memberId", memberId);
		model.addAttribute("MymemberId", chatroom.getMemberId());
		model.addAttribute("list", list);
		return "chatList";
		/*채팅중인 상대 혹은 나 와 아이디가 다른 사람이 접근시
		if(((LoginMember)session.getAttribute("loginMember")).getMemberId() != chatroom.getMemberId()) {
			System.out.println("채팅중인 상대 혹은 나 와 아이디가 다른 사람 접근제한");
			return "redirect:/index";
		}*/
	}
	//채팅 페이지 
	@GetMapping("/chatroom")
	public String getChatRoom(HttpSession session, Model model, @RequestParam(value="chatroomNo", defaultValue = "0") int chatroomNo) {
		//비로그인시 접근 불가능
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
	         return "redirect:/loginMemberAndCompany";
	    }else if(session.getAttribute("loginCompany") != null || session.getAttribute("loginAdmin") != null) {
			System.out.println("업체 혹은 관리자 로그인 시");
			return "redirect:/index";
		  }
		
		String memberId = ((LoginMember)session.getAttribute("loginMember")).getMemberId();
		String memberNickname = ((LoginMember)session.getAttribute("loginMember")).getMemberNickname();
		String memberUniqueNo = ((LoginMember)session.getAttribute("loginMember")).getMemberUniqueNo();
		System.out.println(chatroomNo);
		Chatroom chatroom = chatroomService.getChatRoomOne(chatroomNo);
		System.out.println(memberId+"<--memberId");
		System.out.println(chatroom.getMemberId()+"<--chatroom.getMemberId()");
		if(memberId.equals(chatroom.getMemberId()) ) {
			if(memberUniqueNo.equals(chatroom.getMemberUniqueNo())) {
				System.out.println("실패");
				return "redirect:/index";
			}
		}
		/*
		if(((LoginMember)session.getAttribute("loginMember")).getMemberId() != chatroom.getMemberId()) {
			System.out.println("채팅중인 상대 혹은 나 와 아이디가 다른 사람 접근제한");
			return "redirect:/index";
		}*/
		model.addAttribute("chatroom", chatroom);
		model.addAttribute("memberNickname", memberNickname);
		model.addAttribute("memberId", memberId);
		model.addAttribute("MymemberId", chatroom.getMemberId());

		return "chatroom";
	}
	// 채팅 보내기 액션 ajax
	@PostMapping("/addMessage")
	@ResponseBody
	public int addMessage(Chat chat){
		System.out.println(chat);	
		return chatService.addChatList(chat);
	}
	//채팅 리스트 받아오기 ajax
	@RequestMapping("/getAllMessages")
	@ResponseBody
	public List<Chat> getAllMessages(@RequestParam(value= "chatroomNo", defaultValue = "0") int chatroomNo){
		System.out.println(chatroomNo+"<--chatroomNo");
		
		List<Chat> list = chatService.getChatList(chatroomNo);
		System.out.println(list.toString() + "<--list");
		return list;
	}
}
