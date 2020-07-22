package com.cafe24.dk4750.miniMarket.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.ReportMemberByCompanyItemService;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByCompanyItem;
import com.cafe24.dk4750.miniMarket.vo.ReportMemberByCompanyItemAndCompanyItem;


@Controller
public class ReportMemberByCompanyitemController {
	@Autowired
	private ReportMemberByCompanyItemService reportMemberByCompanyItemService;
	// 관리자 세션 전부 다
	// 신고 상태 수정
	@PostMapping("modifyReportStateMemberByCompanyItem")
	public String modifyReportStateMemberByCompanyItem(HttpSession session ,ReportMemberByCompanyItem reportMemberByCompanyItem, @RequestParam(value="reportNo", defaultValue = "0") int reportNo) {
		//멤버 or 업체 로그인 상태시 메인화면으로 이동
		if(session.getAttribute("loginMember") != null || session.getAttribute("loginCompany") != null) {
			return "redirect:index";
		// 관리자 비로그인 상태시 관리자 로그인 화면으로
	    }else if(session.getAttribute("loginAdmin") == null){
	    	return "redirect:loginAdmin";
	    }
		reportMemberByCompanyItemService.modifyMemberByCompanyItemState(reportMemberByCompanyItem);
		
		return "redirect:/getReportMemberByCompanyItemListOne?reportNo="+reportNo;
	}
	// 신고내용 상세보기
	@GetMapping("getReportMemberByCompanyItemListOne")
	public String getReportMemberByCompanyItemListOne(HttpSession session ,Model model, @RequestParam(value="reportNo", defaultValue = "0") int reportNo) {
		//멤버 or 업체 로그인 상태시 메인화면으로 이동
		if(session.getAttribute("loginMember") != null || session.getAttribute("loginCompany") != null) {
			return "redirect:index";
		// 비로그인 상태시 관리자 로그인 화면으로
	    }else if(session.getAttribute("loginAdmin") == null){
	    	return "redirect:loginAdmin";
	    }
		
		ReportMemberByCompanyItemAndCompanyItem reportMemberByCompanyItemAndCompanyItem = reportMemberByCompanyItemService.getReportMemberByCompanyItemOne(reportNo);
		model.addAttribute("reportOne", reportMemberByCompanyItemAndCompanyItem);
		
		return "getReportMemberByCompanyItemListOne";
	}
	// 신고내역 리스트 (페이징)
	@GetMapping("getReportMemberByCompanyItemList")
	public String getReportMemberByCompanyItemList(HttpSession session , Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="reportState", defaultValue="") String reportState) {
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
		
		System.out.println(currentPage + "<--getReportMemberByCompanyItemList currentPage");
		System.out.println(reportState + "<--getReportMemberByCompanyItemList reportState");
		Map<String, Object> map = reportMemberByCompanyItemService.getReportMemberByCompanyItemList(currentPage, reportState);
		System.out.println(map.get("reportMemberByCompanyItemList") + "<--getReportMemberByCompanyItemList reportMemberByCompanyItemList");
		System.out.println(map.get("lastPage") + "<-- lastPage");
		model.addAttribute("list", map.get("reportMemberByCompanyItemList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("reportState", reportState);
		
		return "getReportMemberByCompanyItemList";
	}
	@GetMapping("/memberByCompanyItemReport")
	public String addReport(HttpSession session ,@RequestParam(value="companyItemNo", defaultValue = "0") int companyItemNo, Model model) {
		// 비로그인 상태시 로그인 창으로
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
	         return "redirect:/loginMemberAndCompany";
	    //업체 신고 페이지여서 멤버 로그인 상태로 접근 불가능
	      }else if(session.getAttribute("loginCompany") != null) {
			System.out.println("멤버 -> 업체게시물 신고 페이지 업체 접근 x");
			return "redirect:index";
	      }
		System.out.println(companyItemNo+"<---no 값 확인");
		model.addAttribute("companyItemNo", companyItemNo);
		return "memberByCompanyReport";
	}
	@PostMapping("/memberByCompanyItemReport")
	public String addReport(HttpSession session , ReportMemberByCompanyItem reportMemberByCompanyItem) {
		// 비로그인 상태시 로그인 창으로
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
	         return "redirect:/loginMemberAndCompany";
	    //업체게시물 신고 페이지여서 업체 로그인 상태로 접근 불가능
	      }else if(session.getAttribute("loginCompany") != null) {
			System.out.println("멤버 -> 업체게시물 신고 페이지 업체 접근 x");
			return "redirect:index";
	     }
		
		System.out.println(reportMemberByCompanyItem);
		String memberId = ((LoginMember)session.getAttribute("loginMember")).getMemberId();
		reportMemberByCompanyItem.setMemberId(memberId);
		reportMemberByCompanyItemService.addReportMemberByCompanyItem(reportMemberByCompanyItem);
		
		return "redirect:/getCompanyItemList";
	}
}
