package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.dk4750.miniMarket.mapper.AdminMapper;
import com.cafe24.dk4750.miniMarket.vo.Admin;
import com.cafe24.dk4750.miniMarket.vo.Company;
import com.cafe24.dk4750.miniMarket.vo.LoginAdmin;
import com.cafe24.dk4750.miniMarket.vo.Member;

@Service
public class AdminService {
	@Autowired private AdminMapper adminMapper;
	
	// 업체 상세보기
	public Company getAdminCompanyListOne(String companyId) {
		return adminMapper.selectCompanyListOne(companyId);
	}
	// 멤버 상세보기
	public Member getAdminMemberListOne(String memberId) {
		return adminMapper.selectMemberListOne(memberId);
	}
	// 업체 정보 리스트
	public Map<String, Object> getAdminCompanyList(int currentPage, String searchWord) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		// lastPage
		int totalRow = adminMapper.getCompanyTotalRow(searchWord);
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage Map에 담는다
		List<Company> companyList = adminMapper.selectCompanyList(map);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("companyList", companyList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
	// 회원정보 리스트
	public Map<String, Object> getAdminMemberList(int currentPage, String searchWord) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		// lastPage
		int totalRow = adminMapper.getMemberTotalRow(searchWord);
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage Map에 담는다
		List<Member> memberList = adminMapper.selectMemberList(map);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("memberList", memberList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
	// 관리자 로그인
	public LoginAdmin getLoginAdmin(Admin admin) {
		return adminMapper.selectLoginAdmin(admin);
	}
}
