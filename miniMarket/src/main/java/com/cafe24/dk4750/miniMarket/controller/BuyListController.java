package com.cafe24.dk4750.miniMarket.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.dk4750.miniMarket.service.MemberItemService;

@RestController
public class BuyListController {
	@Autowired private MemberItemService memberItemService;
	
	// 내가 구매한 아이템 리스트
	@GetMapping("/getBuyListByMember2")
	public Map<String, Object> getBuyListByMember(Model model, HttpSession session, @RequestParam(value= "currentPage", defaultValue = "1") int currentPage) {
		int rowPerPage = 5;
		int beginRow = (currentPage-1)*rowPerPage;
		// 내 구매리스트 출력해주기.
		Map<String , Object> map = memberItemService.getBuyListByMember(session, beginRow, rowPerPage);
		// 모델로 리스트 넘겨주기
		model.addAttribute("totalRow", map.get("totalRow"));
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		System.out.println(map+"<-----내가 구매한 아이템 리스트 레스트컨트롤러 map값");
		return map;
	}
}
