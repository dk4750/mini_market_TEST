package com.cafe24.dk4750.miniMarket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.dk4750.miniMarket.service.CheckCompanyLikeService;
import com.cafe24.dk4750.miniMarket.vo.CompanyItemLike;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;

@RestController
public class CheckCompanyLikeController {
	@Autowired private CheckCompanyLikeService checkCompanyLikeService; 
	// 업체아이템라이크를 체크하는 레스트 컨트롤러
	@GetMapping("/CheckCompanyLike")
	public int CheckCompanyLike(HttpSession session, int count, int companyItemNo) {
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		String memberUniqueNo = loginMember.getMemberUniqueNo();
		
		if(count%2 == 1) {
			count = 1;
		} else {
			count = 0;
		}
		
		CompanyItemLike companyItemLike = new CompanyItemLike();
		companyItemLike.setMemberUniqueNo(memberUniqueNo);
		companyItemLike.setCompanyItemNo(companyItemNo);
		companyItemLike.setLikeActive(count);
		
		int resultActive = checkCompanyLikeService.CheckCompanyLike(companyItemLike);
		return resultActive;
	}
}
