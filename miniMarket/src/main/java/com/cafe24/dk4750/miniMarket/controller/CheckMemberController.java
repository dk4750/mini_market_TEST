package com.cafe24.dk4750.miniMarket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.dk4750.miniMarket.mapper.MemberMapper;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;

@RestController
public class CheckMemberController {
	@Autowired
	private MemberMapper memberMapper;
	
	//비밀번호 중복체크 
	@PostMapping("/checkMemberPw")
	public String checkMemberPw(@RequestParam(value="checkMemberPw", defaultValue = "") String checkMemberPw, HttpSession session ) {
		
		//세션에 담긴 아이디 빼기 		
		LoginMember checkIdPw = (LoginMember)(session.getAttribute("loginMember"));
		checkIdPw.setMemberPw(checkMemberPw);
		
		System.out.println(checkIdPw.getMemberId()+"<-아이디 ");
				
		String resultPw ="비밀번호 불일치";
		
		if(memberMapper.selectMemberPwId(checkIdPw)!=null) {
			resultPw="현재 비밀번호가 확인되었습니다";
		}		
		
		return resultPw;
	}
	
	
	
	//아이디 중복 체크 
	@GetMapping("/checkId")
	public String checkMemberId (@RequestParam(value="checkMemberId", defaultValue = "") String checkMemberId) {
		System.out.println(checkMemberId+"<-checkMemberId");
		String resultId="사용불가";
		
		if(memberMapper.selectMemberId(checkMemberId)==null) {
		  resultId="사용가능";	
		}
				
		return resultId;		
	}
	
	//전화번호 중복 체크 
	@GetMapping("/checkPhone")
	public String checkMemberPhone (@RequestParam(value="checkMemberPhone", defaultValue = "") String checkMemberPhone) {
		System.out.println(checkMemberPhone+"<-checkMemberPhone");
		String resultPhone="사용불가";
		
		if(memberMapper.selectMemberPhone(checkMemberPhone)==null) {
			resultPhone="사용가능";	
		}				
		return resultPhone;		
	}
	
	//이메일 중복 체크 
	@GetMapping("/checkEmail")
	public String checkMemberEmail (@RequestParam(value="checkMemberEmail", defaultValue = "") String checkMemberEmail) {
		System.out.println(checkMemberEmail+"<-checkMemberEmail");
		String resultEmail="사용불가";
		
		if(memberMapper.selectMemberEmail(checkMemberEmail)==null) {
			resultEmail="사용가능";	
		}				
		return resultEmail;		
	}
	
	
}
