package com.cafe24.dk4750.miniMarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.Company;
import com.cafe24.dk4750.miniMarket.vo.CompanyNameAndPic2;
import com.cafe24.dk4750.miniMarket.vo.LoginCompany;

@Mapper
public interface CompanyMapper {
   
   //고유번호 가져오기(카운트후  m+1)
   public String selectCompanyUniqueNo();
   
   //업체 이름 수정
   public int updateCompanyName(CompanyNameAndPic2 companyNameAndPic2);
   
   //업체 사진 수정
   public int updateCompanyPic(CompanyNameAndPic2 companyNameAndPic2);
   
   //업체 사진보기
   public String selectCompanyPic(LoginCompany companyId); 
   
   //업체명 보기
   public String selectCompanyName(LoginCompany companyId);
   
   //업체 정보보기 
   public Company selectCompanyOne(LoginCompany companyId); 
   
   //업체 정보수정(이름,전화번호,주소(동네))
   public int updateCompanyOne(Company company);
   
   //업체 탈퇴(회원탈퇴하면 멤버 정보 업데이트됨)
   public int deleteCompany(LoginCompany companyId);
      
   //업체 탈퇴시 비밀번호 확인
   public String selectCompanyPw(LoginCompany loginCompany);
   
   //업체 탈퇴시 백업 
   public int insertCompanyBackUp(LoginCompany loginCompany);
   
   //업체 탈퇴시 업체 프로필 사진 삭제 
   public int deleteCompanyPic(LoginCompany loginCompany);
      
   //아이디 찾기  
   public String selectFindCompanyId(Company company); 
   
   //비번찾기
   public int updateCompanyFindPw(Company company); 
   
   //비밀번호 변경하기(새 비밀번호 입력)
   public int updateCompanyPw(LoginCompany loginCompany);
   
   //비밀번호변경(현재 입력된 비밀번호 값 비교)
   public String selectCompanyPwId(LoginCompany checkCompanyPw);
   
   
   //로그인하기 아이디 비번 일치하는지 확인 
   public LoginCompany selectLoginCompany(LoginCompany loginCompany);   
      
   //핸드폰 중복확인 
   public String selectCompanyPhone(String checkCompanyrPhone); 
   
   //이메일 중복확인 
   public String selectCompanyEmail(String checkCompanyEmail); 
   
   //업체 아이디 중복확인
   public String selectCompanyId(String checkCompanyId); 
      
   //회원가입시 업체 사진 디폴트값 추가 
   public int insertCompanyPic(String CompanyId);   
   
   //업체 정보 입력, 회원가입  
   public int insertCompany(Company company);   
   }