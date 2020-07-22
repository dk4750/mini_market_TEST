package com.cafe24.dk4750.miniMarket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.service.MemberReviewService;
import com.cafe24.dk4750.miniMarket.service.MemberService;
import com.cafe24.dk4750.miniMarket.vo.MemberReview;

@Controller
public class MemberReviewController {
	@Autowired private MemberReviewService memberReviewService;
	@Autowired private MemberService memberService;
	
	//리뷰 인서트  겟 맵핑
	@GetMapping("/addReview")
	public String addReview(HttpSession session, MemberReview memberReview, Model model) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		System.out.println(memberReview +"<== 리뷰 작성 하기 겟맵핑 값확인");
		// 판매자의 유니크넘버 구하기 섭스트링으로 ""부분 잘라주기
		String memberUniqueNo2 = memberReview.getMemberUniqueNoSale();
		String memberUniqueNo = memberUniqueNo2.substring(1, 8);
		// 판매자의 유니크넘버로 닉네임구하기
		String memberNickname = memberService.getMemberNickname(memberUniqueNo);
		
		model.addAttribute("memberNickname", memberNickname);
		model.addAttribute("memberReview", memberReview);
		
		return "addReview";
	}
	
	//리뷰 인서트 포스트 맵핑
	@PostMapping("/addReview")
	public void addReview(HttpSession session, MemberReview memberReview) {

		System.out.println("addReview post매핑 스타트");
		System.out.println(memberReview+"<== 리뷰 작성 하기 포스트맵핑  값확인");
		
		// addReview 서비스
		memberReviewService.addReview(session, memberReview);
	}
}
