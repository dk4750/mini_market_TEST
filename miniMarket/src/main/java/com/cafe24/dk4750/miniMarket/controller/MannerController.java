package com.cafe24.dk4750.miniMarket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.service.MannerService;
import com.cafe24.dk4750.miniMarket.service.MemberService;
import com.cafe24.dk4750.miniMarket.vo.ItemSoldoutAndMemberItemAndMemberItemPic;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.Manner;

@Controller
public class MannerController {
	@Autowired private MannerService mannerService;
	@Autowired private MemberService memberService;
	
	//매너 평가 하기 겟맵핑 (폼)
	@GetMapping("/addManner")
	public String addManner(HttpSession session, Model model, ItemSoldoutAndMemberItemAndMemberItemPic itemSoldoutAndMemberItemAndMemberItemPic) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		if(itemSoldoutAndMemberItemAndMemberItemPic.getMemberItemNo() == 0) {
			return "redirect:/index";
		}
		System.out.println("addManner Controller start..");
		System.out.println(itemSoldoutAndMemberItemAndMemberItemPic + " <== 들어온 값 디버깅");
			
		int memberItemNo = itemSoldoutAndMemberItemAndMemberItemPic.getMemberItemNo();
		String memberUniqueNo = itemSoldoutAndMemberItemAndMemberItemPic.getMemberUniqueNo();
		// 문자열로 들어오기에 불필요한 부분은 잘라주기 위해 섭스트링
		String memberUniqueNoSale2 = itemSoldoutAndMemberItemAndMemberItemPic.getMemberUniqueNoSale();
		String memberUniqueNoSale = memberUniqueNoSale2.substring(1, 8);
		System.out.println(memberUniqueNo + " <== subUnique 디버깅");
		System.out.println(memberUniqueNoSale + " <== subUniqueSale 디버깅");
		System.out.println(memberItemNo + " <== memberItemNo 디버깅");
		
		// 세션에서 구매자인 내 닉네임 가져오기
		String memberNickname = (String)((LoginMember)session.getAttribute("loginMember")).getMemberNickname();
		// String memberNickname = memberService.getMemberNickname(memberUniqueNo);
		// 판매자 유니크넘버로 닉네임 가져오기 
		String memberNicknameSale = memberService.getMemberNickname(memberUniqueNoSale);
		System.out.println(memberNicknameSale+"========판매자의 멤버유니크닉네임");
		model.addAttribute("memberItemNo", memberItemNo);
		model.addAttribute("memberNickname", memberNickname);
		model.addAttribute("memberNicknameSale", memberNicknameSale);
		model.addAttribute("memberUniqueNo", memberUniqueNo);
		model.addAttribute("memberUniqueNoSale", memberUniqueNoSale);
		System.out.println(memberItemNo);
		System.out.println(memberNickname);
		System.out.println(memberUniqueNo);
		System.out.println(memberUniqueNoSale+"<===============================판매자 닉네임 정보");
		return "addManner"; // 리뷰 작성한다고 했을 때
	}
	
	//매너 평가하기  goodAddManner 포스트 맵핑 (액션)
	@PostMapping("/goodAddManner")
	public void goodAddManner(HttpSession session ,Manner manner) {
		System.out.println();
		
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		String memberId = loginMember.getMemberId();
		manner.setMemberId(memberId);
		System.out.println(manner + " <== good manner");
		mannerService.addGoodManner(session, manner);
	}
	
	//매너 평가하기  badAddManner 포스트 맵핑 (액션)
	@PostMapping("/badAddManner")
	public void badAddManner(HttpSession session, Manner manner) {
		System.out.println(manner + " <== bad manner");
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		String memberId = loginMember.getMemberId();
		manner.setMemberId(memberId);
		
		mannerService.addBadManner(manner);
	}
}
