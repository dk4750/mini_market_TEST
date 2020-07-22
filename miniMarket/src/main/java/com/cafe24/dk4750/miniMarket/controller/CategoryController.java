package com.cafe24.dk4750.miniMarket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.dk4750.miniMarket.service.CategoryService;
import com.cafe24.dk4750.miniMarket.vo.Category;

@Controller
public class CategoryController {
	@Autowired CategoryService categoryService;
	
	// 카테고리 추가 폼 겟맵핑 
	@GetMapping("/addCategory")
	public String addCategory(HttpSession session) {
		if(session.getAttribute("loginAdmin") == null) {
			return "index";
		}
		return "addCategory";
	}
	
	// 카테고리 추가 액션 겟맵핑
	@PostMapping("/addCategory")
	public String addCaString(HttpSession session, Category category) {
		if(session.getAttribute("loginAdmin") == null) {
			return "index";
		}
		// 카테고리 추가
		categoryService.addCategory(category);
		return "redirect:/index";
	}
}
