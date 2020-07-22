package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.Admin;
import com.cafe24.dk4750.miniMarket.vo.Company;
import com.cafe24.dk4750.miniMarket.vo.LoginAdmin;
import com.cafe24.dk4750.miniMarket.vo.Member;

@Mapper
public interface AdminMapper {
	// 업체 페이징
	public int getCompanyTotalRow(String searchWord);
	// Member 페이징
	public int getMemberTotalRow(String searchWord);
	// 업체 상세보기
	public Company selectCompanyListOne(String companyId);
	// 관리자 전용 Company리스트
	public List<Company> selectCompanyList(Map<String, Object> map);
	// 일반회원 상세보기
	public Member selectMemberListOne(String MemberId);
	// 관리자 전용 Member리스트
	public List<Member> selectMemberList(Map<String, Object> map);
	// 관리자 로그인 
	public LoginAdmin selectLoginAdmin(Admin admin);
}
