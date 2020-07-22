package com.cafe24.dk4750.miniMarket.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.dk4750.miniMarket.service.CompanyItemService;

@RestController
public class CompanyItemCheck {
	@Autowired CompanyItemService companyItemService;
	// 업체 아이템이 이미 추가하였는지 없는지 확인
	@GetMapping("/CompanyItemCheck")
	public int getCompanyItemCheck(@RequestParam(value="companyUniqueNo", defaultValue = "") String companyUniqueNo ) {
		return companyItemService.getCompanyItemCheck(companyUniqueNo);
	}
}
