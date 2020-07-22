package com.cafe24.dk4750.miniMarket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.dk4750.miniMarket.service.CheckLikeService;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.MemberItemLike;

@RestController
public class CheckLikeController {
	@Autowired private CheckLikeService checkLikeService;
	
	@GetMapping("/likeCheck")
	public int likeCheck(HttpSession session ,int count, int memberItemNo) {
		// 폼에서 입력받아야할 값
		System.out.println(count + " <== count");
		System.out.println(memberItemNo + " <== memberItemNo");
		
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		String memberUniqueNo = loginMember.getMemberUniqueNo();
		
		System.out.println(memberUniqueNo + " <==memberUniqueNo");
		if(count%2 == 1) {
			count = 1;
		} else {
			count = 0;
		}
		System.out.println(count + " <== 변경된 count");
		
		MemberItemLike memberItemLike = new MemberItemLike();
		memberItemLike.setMemberUniqueNo(memberUniqueNo);
		memberItemLike.setMemberItemNo(memberItemNo);
		memberItemLike.setLikeActive(count);
		System.out.println(memberItemLike + " <== RestController. likeCount check");
		
		int resultActive = checkLikeService.likeCheck(memberItemLike);
		return resultActive;
	}
}
