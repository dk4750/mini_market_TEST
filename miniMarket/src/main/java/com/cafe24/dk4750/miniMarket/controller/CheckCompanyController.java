package com.cafe24.dk4750.miniMarket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.dk4750.miniMarket.mapper.CompanyMapper;
import com.cafe24.dk4750.miniMarket.vo.LoginCompany;

@RestController
public class CheckCompanyController {
	@Autowired
	private CompanyMapper companyMapper;
	
	//비밀번호 중복체크 
	@PostMapping("/checkCompanyPw")
	public String checkCompanyPw(@RequestParam(value="checkCompanyPw", defaultValue = "") String checkCompanyPw, HttpSession session ) {
		
		//세션에 담긴 아이디 빼기 		
		LoginCompany checkIdPw = (LoginCompany)(session.getAttribute("loginCompany"));
		checkIdPw.setCompanyPw(checkCompanyPw);
		
		System.out.println(checkIdPw.getCompanyId()+"<-아이디 ");
				
		String resultPw ="비밀번호 불일치";
		
		if(companyMapper.selectCompanyPwId(checkIdPw)!=null) {
			resultPw="현재 비밀번호가 확인되었습니다";
		}		
		
		return resultPw;
	}
	
	
	
	//아이디 중복 체크 
	@GetMapping("/checkCompanyId")
	public String checkCompanyId (@RequestParam(value="checkCompanyId", defaultValue = "") String checkCompanyId) {
		System.out.println(checkCompanyId+"<-checkCompanyId");
		String resultId="사용불가";
		
		if(companyMapper.selectCompanyId(checkCompanyId)==null) {
		  resultId="사용가능";	
		}
				
		return resultId;		
	}
	
	//전화번호 중복 체크 
	@GetMapping("/checkCompanyPhone")
	public String checkCompanyPhone (@RequestParam(value="checkCompanyPhone", defaultValue = "") String checkCompanyPhone) {
		System.out.println(checkCompanyPhone+"<-checkCompanyPhone");
		String resultPhone="사용불가";
		
		if(companyMapper.selectCompanyPhone(checkCompanyPhone)==null) {
			resultPhone="사용가능";	
		}				
		return resultPhone;		
	}
	
	//이메일 중복 체크 
	@GetMapping("/checkCompanyEmail")
	public String checkCompanyEmail (@RequestParam(value="checkCompanyEmail", defaultValue = "") String checkCompanyEmail) {
		System.out.println(checkCompanyEmail+"<-checkCompanyEmail");
		String resultEmail="사용불가";
		
		if(companyMapper.selectCompanyEmail(checkCompanyEmail)==null) {
			resultEmail="사용가능";	
		}				
		return resultEmail;		
	}
	
	
}
