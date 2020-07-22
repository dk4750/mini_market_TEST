package com.cafe24.dk4750.miniMarket.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.AdminService;
import com.cafe24.dk4750.miniMarket.vo.Admin;
import com.cafe24.dk4750.miniMarket.vo.Company;
import com.cafe24.dk4750.miniMarket.vo.LoginAdmin;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.Member;

@Controller
public class AdminController {
	@Autowired private AdminService adminService;
	
	// 업체 목록 상세
	@GetMapping("getAdminCompanyListOne")
	public String getAdminCompanyListOne(HttpSession session, Model model, @RequestParam(value="companyId" , defaultValue = "") String companyId) {
		if(session.getAttribute("loginAdmin") == null){
			return "redirect:/";
		}
		Company company = adminService.getAdminCompanyListOne(companyId);
		model.addAttribute("list", company);
		
		return "getAdminCompanyListOne";
	}
	// 회원 목록 상세
	@GetMapping("getAdminMemberListOne")
	public String getAdminMemberListOne(HttpSession session, Model model, @RequestParam(value="memberId", defaultValue = "") String memberId) {
		if(session.getAttribute("loginAdmin")== null){
			return "redirect:/";
		}
		Member member = adminService.getAdminMemberListOne(memberId);
		model.addAttribute("list", member);
		
		return "getAdminMemberListOne";
	}
	// 관리자용 업체 목록
	@GetMapping("getAdminCompanyList")
	public String getAdminCompanyList(HttpSession session, Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="searchWord", defaultValue="") String searchWord) {
		if(session.getAttribute("loginAdmin")== null){
			return "redirect:/";
		}
		System.out.println(currentPage + "<--getAdminCompanyList currentPage");
		System.out.println(searchWord + "<--getAdminCompanyList searchWord");
		Map<String, Object> map = adminService.getAdminCompanyList(currentPage, searchWord);
		System.out.println(map.get("companyList") + "<--getAdminCompanyList companyList");
		System.out.println(map.get("lastPage") + "<-- lastPage");
		model.addAttribute("companyList", map.get("companyList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchWord", searchWord);
		
		return "getAdminCompanyList";
	}
	// 관리자용 회원 목록
	@GetMapping("getAdminMemberList")
	public String getAdminMemberList(HttpSession session, Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="searchWord", defaultValue="") String searchWord) {
		// 관리자만 접근 가능
		if(session.getAttribute("loginAdmin")== null){
			return "redirect:/";
		}
		System.out.println(currentPage + "<--getAdminMemberList currentPage");
		System.out.println(searchWord + "<--getAdminMemberList searchWord");
		Map<String, Object> map = adminService.getAdminMemberList(currentPage, searchWord);
		System.out.println(map.get("memberList") + "<--getAdminMemberList memberList");
		System.out.println(map.get("lastPage") + "<-- lastPage");
		model.addAttribute("memberList", map.get("memberList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchWord", searchWord);
		
		return "getAdminMemberList";
	}
	// 로그인 폼 겟맵핑
	@GetMapping("loginAdmin")
	public String loginAdmin(HttpSession session) {
		//로그인 중일때 
		if(session.getAttribute("loginAdmin")!= null){
			return "redirect:/";
		}				
		return "loginAdmin";
	}
	
	// 로그인 액션 포스트맵핑
	@PostMapping("loginAdmin")
	public String loginAdmin(Model model, Admin admin, HttpSession session) {
		//로그인 중일때 
		if(session.getAttribute("loginAdmin")!= null){
			return "redirect:/index";
		}
		LoginAdmin returnLoginAdmin = adminService.getLoginAdmin(admin);
		System.out.println(returnLoginAdmin+"<====관리자 로그인 포스트 맵핑 로그인 확인");
		// 일치하지 않으면 로그인 실패
		if(returnLoginAdmin == null) {
			model.addAttribute("msg","아이디와 비밀번호를 확인하세요");
			return "loginAdmin"; 
		} else { // 로그인 성공
			session.setAttribute("loginAdmin", returnLoginAdmin);
			return "redirect:/index"; 
		}
	}
	// 로그아웃하기
	@GetMapping("/logoutAdmin")
	public String logout(HttpSession session) {
		// 로그인 실패시 로그인 폼으로
		if (session.getAttribute("loginAdmin") == null) {
			return "redirect:/index"; // index로 넘겨줌
		}
		session.invalidate(); // 로그아웃
		return "redirect:/index"; // 로그아웃 후 index 넘겨줌
	}
	
}
