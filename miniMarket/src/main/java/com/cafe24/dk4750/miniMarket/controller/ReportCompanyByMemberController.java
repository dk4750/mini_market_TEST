package com.cafe24.dk4750.miniMarket.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.ReportCompanyByMemberService;
import com.cafe24.dk4750.miniMarket.vo.ReportCompanyByMember;
import com.cafe24.dk4750.miniMarket.vo.ReportCompanyByMemberAndMember;



@Controller
public class ReportCompanyByMemberController {
	@Autowired
	private ReportCompanyByMemberService reportCompanyByMemberService;
	// 관리자만 접근가능
	// 신고 상태 수정
	@PostMapping("modifyReportStateCompanyByMember")
	public String modifyReportStateCompanyByMember(HttpSession session , ReportCompanyByMember reportCompanyByMember, @RequestParam(value="reportNo", defaultValue = "0") int reportNo) {
		//멤버 or 업체 로그인 상태시 메인화면으로 이동
		if(session.getAttribute("loginMember") != null || session.getAttribute("loginCompany") != null) {
			return "redirect:index";
		// 관리자 비로그인 상태시 관리자 로그인 화면으로
	    }else if(session.getAttribute("loginAdmin") == null){
	    	return "redirect:loginAdmin";
	    }
		
		reportCompanyByMemberService.modifyCompanyByMemberState(reportCompanyByMember);
		
		return "redirect:/getReportCompanyByMemberListOne?reportNo="+reportNo;
	}
	// 신고내용 상세보기
	@GetMapping("getReportCompanyByMemberListOne")
	public String getReportCompanyByMemberListOne(HttpSession session , Model model, @RequestParam(value="reportNo", defaultValue = "0") int reportNo) {
		//멤버 or 업체 로그인 상태시 메인화면으로 이동
		if(session.getAttribute("loginMember") != null || session.getAttribute("loginCompany") != null) {
			return "redirect:index";
		// 비로그인 상태시 관리자 로그인 화면으로
	    }else if(session.getAttribute("loginAdmin") == null){
	    	return "redirect:loginAdmin";
	    }
		ReportCompanyByMemberAndMember reportCompanyByMemberAndMember = reportCompanyByMemberService.getReportCompanyByMemberOne(reportNo);
		model.addAttribute("reportOne", reportCompanyByMemberAndMember);
		
		return "getReportCompanyByMemberListOne";
	}
	// CompanyByMember 신고리스트
	@GetMapping("getReportCompanyByMemberList")
	public String getReportCompanyByMemberList(HttpSession session , Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="reportState", defaultValue="") String reportState) {
		System.out.println(session.getAttribute("loginAdmin")+"<---관리자 세션");
		//멤버 or 업체 로그인 상태시 메인화면으로 이동
		if(session.getAttribute("loginMember") != null || session.getAttribute("loginCompany") != null) {
			System.out.println("멤버 or 업체 로그인 상태로 관리자 페이지 접근");
			return "redirect:index";
		// 비로그인 상태시 관리자 로그인 화면으로
	    }else if(session.getAttribute("loginAdmin") == null ){
	    	System.out.println("비로그인 상태로 관리자 페이지 접근");
	    	return "redirect:loginAdmin";
	    }
		
		System.out.println(currentPage + "<--getReportCompanyByMemberList currentPage");
		System.out.println(reportState + "<--getReportCompanyByMemberList reportState");
		Map<String, Object> map = reportCompanyByMemberService.getReportCompanyByMemberList(currentPage, reportState);
		System.out.println(map.get("reportCompanyByMemberList") + "<--getReportCompanyByMemberList reportCompanyByMemberList");
		System.out.println(map.get("lastPage") + "<-- lastPage");
		model.addAttribute("list", map.get("reportCompanyByMemberList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("reportState", reportState);
		
		return "getReportCompanyByMeberList";
	}
	@GetMapping("/companyByMemberReport")
	public String addReport(HttpSession session) {
		// 비로그인 상태시 로그인 창으로
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
	         return "redirect:/loginMemberAndCompany";
	    //업체 신고 페이지여서 멤버 로그인 상태로 접근 불가능
	      }else if(session.getAttribute("loginMember") != null) {
			System.out.println("업체 -> 멤버 신고 페이지 멤버 접근 x");
			return "redirect:index";
	      }
		
		return "companyByMemberReport";
	}
	@PostMapping("/companyByMemberReport")
	public String addReport(HttpSession session , ReportCompanyByMember reportCompanyByMember) {
		// 비로그인 상태시 로그인 창으로
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
			System.out.println("비로그인 상태 ");
			return "redirect:/loginMemberAndCompany";
			//업체 신고 페이지여서 멤버 로그인 상태로 접근 불가능
	    }else if(session.getAttribute("loginMember") != null) {
			System.out.println("업체 -> 멤버 신고 페이지 멤버 접근 x");
			return "redirect:index";
	    }
		
		System.out.println(reportCompanyByMember);
		return "redirect:/companyByMemberReport";
	}
	
}
