package com.cafe24.dk4750.miniMarket.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.NoticeService;
import com.cafe24.dk4750.miniMarket.vo.LoginAdmin;
import com.cafe24.dk4750.miniMarket.vo.Notice;


@Controller
public class NoticeController {
	@Autowired private NoticeService noticeService;
	// 공지사항 목록
	@GetMapping("/getNoticeList")
	public String getNoticeList(HttpSession session, Model model, @RequestParam(value= "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value="searchWord", defaultValue = "") String searchWord) {
		
		LoginAdmin loginAdmin = (LoginAdmin)session.getAttribute("loginAdmin");
		int rowPerPage = 5;
		int beginRow = (currentPage-1)*rowPerPage;
		System.out.println(beginRow +"<-----beginRow");
		
		// 공지사항 리스트
		Map<String , Object> map = noticeService.getNoticeList(beginRow, rowPerPage, searchWord);
		
		// 모델로 리스트 넘겨주기
		model.addAttribute("totalRow", map.get("totalRow"));
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("currentPage", currentPage);
		System.out.println(map.get("lastPage")+"<---라스트페이지 값 확인하기");
		return "getNoticeList";
	}
	
	// 공지사항 자세히 보기
	@GetMapping("getNoticeOne")
	public String getNoticeOne(HttpSession session, Model model, @RequestParam(value="noticeNo", defaultValue = "") int noticeNo) {
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginCompany") == null && session.getAttribute("loginMember") == null && session.getAttribute("loginAdmin") == null) {
			return "index";
		}
		// 공지사항 자세히 보기
		Notice notice = noticeService.getNoticeOne(noticeNo);
		model.addAttribute("session", session);
		model.addAttribute("notice", notice);
		// 공지사항 자세히 보기
		return "getNoticeOne";
	}
	
	// 공지사항 입력하기 겟맵핑 (폼)
	@GetMapping("addNotice")
	public String addNotice(HttpSession session, Model model) {
		 // 관리자 세션이 아니라면 리턴
		 if(session.getAttribute("loginAdmin") == null) {
			 	return "index";
			}
		
		 // 현재 로그인 한 관리자의 네임 
		 LoginAdmin loginAdmin = (LoginAdmin)session.getAttribute("loginAdmin");
		
		String adminName = loginAdmin.getAdminName();
		model.addAttribute("adminName", adminName);
		return "addNotice";
	}
	
	// 공지사항 입력하기 포스트맵핑 (액션)
	@PostMapping("addNotice")
	public String addNotice(HttpSession session, Notice notice) {
		LoginAdmin loginAdmin = (LoginAdmin)session.getAttribute("loginAdmin");
		
		String adminName = loginAdmin.getAdminName();

		System.out.println(adminName+"<========공지사상 입력하기 포스트 맵핑 세션의 어드민 네임값");
		
		// 작성자 설정
		notice.setAdminName(adminName);
		System.out.println(notice+"<----공지사항 작성한 내용 포스트 맵핑");
		noticeService.addNotice(notice);
		
		// 작성 후 공지사항 리스트로
		return "redirect:/getNoticeList";
	}
	
	// 공지사항 수정하기 겟맵핑 (폼)
	@GetMapping("modifyNotice")
	public String modifyNotice(HttpSession session, @RequestParam(value="noticeNo", defaultValue = "0") int noticeNo, Model model) {
		 // 관리자 세션이 아니라면 리턴
		 if(session.getAttribute("loginAdmin") == null) {
			 	return "index";
			}
		 
		LoginAdmin loginAdmin = (LoginAdmin)session.getAttribute("loginAdmin");
		
		// 현재 로그인한 관리자의 네임
		String adminName = loginAdmin.getAdminName();
		
		System.out.println(adminName+"<========공지사상 입력하기 포스트 맵핑 세션의 어드민 네임값");
		Notice notice = noticeService.getNoticeOne(noticeNo);
		
		// 현재 로그한 관리자 네임 설정
		notice.setAdminName(adminName);
		
		model.addAttribute("adminName", adminName);
		model.addAttribute("notice", notice);
		return "modifyNotice";
	}
	
	// 공지사항 수정하기 포스트맵핑 (액션)
	@PostMapping("modifyNotice")
	public String modifyNotice(HttpSession session, Notice notice, @RequestParam(value="noticeNo", defaultValue = "0") int noticeNo ) {
		LoginAdmin loginAdmin = (LoginAdmin)session.getAttribute("loginAdmin");
		
		// 현재 로그인한 관리자의 네임
		String adminName = loginAdmin.getAdminName();
		
		// 관리자의 닉네임을 노티스에 서정
		notice.setAdminName(adminName);
		noticeService.modifyNotice(notice);
		System.out.println(notice+"<---------------수정 후 공지사항 내용");
		// 리스트 목록으로
		return "redirect:/getNoticeList";
	}
}
