package com.cafe24.dk4750.miniMarket.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.dk4750.miniMarket.mapper.CompanyMapper;
import com.cafe24.dk4750.miniMarket.vo.Company;
import com.cafe24.dk4750.miniMarket.vo.CompanyNameAndPic;
import com.cafe24.dk4750.miniMarket.vo.CompanyNameAndPic2;
import com.cafe24.dk4750.miniMarket.vo.LoginCompany;


@Service
@Transactional
public class CompanyService {
	@Autowired private CompanyMapper companyMapper;
	@Autowired private JavaMailSender javaMailSender;//@Conponent	
	@Value("/dk4750/tomcat/webapps/miniMarket/WEB-INF/classes/static/images/")
	private String path;
	
	
	//업체탈퇴 
	public String removeCompany(LoginCompany loginCompany) {
		String check = companyMapper.selectCompanyPw(loginCompany);
		if(check!=null) {
			companyMapper.insertCompanyBackUp(loginCompany);
			companyMapper.deleteCompanyPic(loginCompany);
			companyMapper.deleteCompany(loginCompany);
			check="탈퇴성공";
		}
		System.out.println(check+"<--check값 2면 탈퇴성공");
		return check;
	}
	
	
	//업체사진과 회사명 (사진 수정) 
	public int modifyCompanyNameAndPic(CompanyNameAndPic companyNameAndPic) {		
		MultipartFile mf = companyNameAndPic.getProfilePic();
		//확장자 필요		
		String originName= mf.getOriginalFilename();	
		 
		 System.out.println(originName+ "<--originName" ); //user.jpg<--originName
			int lastDot= originName.lastIndexOf("."); // 마지막글자의 . (좌석표.png)
			String extension =originName.substring(lastDot); 
			
			//새로운 이름을 생성: UUID
			String profilePic= companyNameAndPic.getCompanyId()+extension; 
			
			//1.디비에서 저장 
			CompanyNameAndPic2 companyNameAndPic2 = new CompanyNameAndPic2(); 
			companyNameAndPic2.setCompanyId(companyNameAndPic.getCompanyId());
			companyNameAndPic2.setCompanyName(companyNameAndPic.getCompanyName());
			companyNameAndPic2.setProfilePic(profilePic);
			
			System.out.println(companyNameAndPic2+"<-----CompanyService.companyNameAndPic1 출력확인");
			System.out.println(profilePic+"<-----profilePic출력확인");
			int row = companyMapper.updateCompanyName(companyNameAndPic2);
			int row2= companyMapper.updateCompanyPic(companyNameAndPic2);
			
			//2.파일저장
			
			File file = new File(this.path+profilePic);
			 
			try {
				mf.transferTo(file);
			} catch (Exception e) {			
				e.printStackTrace();
			}		
		         // Exception 
		         //1.예외처리를 해야만 문법적으로 이상없는 예외 
		         //2.예외처리를 토드에서 구현하지 않아도 아무문제 없는 예외 RuntimeException
		 
		      return row;
		      
	}	
	
	
	// 업체 수정  이름만 수정 
	public int modifyCompanyName(CompanyNameAndPic companyNameAndPic) {
		CompanyNameAndPic2 companyName = new CompanyNameAndPic2();
		companyName.setCompanyId(companyNameAndPic.getCompanyId());
		companyName.setCompanyName(companyNameAndPic.getCompanyName());
		
		int row =companyMapper.updateCompanyName(companyName);
		return row;		
	}
	
	
	//업체사진과 업체명을 불러오기
		public Map<String, Object> getCompanyNameAndPic(LoginCompany companyId) {		
			Map<String,Object> map = new HashMap<>(); 
			String companyPic = companyMapper.selectCompanyPic(companyId);
			String companyName = companyMapper.selectCompanyName(companyId);
			
			map.put("companyPic",companyPic);
			map.put("companyName", companyName);
			return map;
		}	

	//아이디 찾기  
	public String getFindCompanyId (Company company) {
		return companyMapper.selectFindCompanyId(company);		
	}
	
	//비번찾기
	public int getFindCompanyPw(Company company) {
		// 업체 비밀번호 찾기, 랜덤 비밀번호 만들어줌 
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
		
		//랜덤 비번 8글자로 자름 
		String companyPw = uuid.toString().substring(0, 8); 
		company.setCompanyPw(companyPw);
		int row = companyMapper.updateCompanyFindPw(company);
		if (row == 1) {	
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(company.getCompanyEmail()); // 누구에게 보내는지 
			simpleMailMessage.setFrom("hya7835@gmail.com"); // 누가 보내는지
			simpleMailMessage.setSubject("Minimarket 임시 비밀번호 메일");//내용
			simpleMailMessage.setText("변경된 비밀번호는 " + companyPw + " 입니다.");
			javaMailSender.send(simpleMailMessage);
		}
		return row;

	}
	

	//업체 비밀번호 수정 
	public int updateCompanyPw(LoginCompany loginCompany) {
		int row = companyMapper.updateCompanyPw(loginCompany);
		return row;
	}
	
	//로그인하기 아이디 비번 일치하는지 확인 
	public LoginCompany selectLoginCompany(LoginCompany loginCompany) {
		return companyMapper.selectLoginCompany(loginCompany);		
	}
	
	//업체의 정보보기 
	public Company selectCompanyOne(LoginCompany companyId) {
		return companyMapper.selectCompanyOne(companyId);		
	}
	
	//업체의 정보 수정(CEO,전화번호,주소(동네))
	public int modifyCompanyOne(Company company) {		
		return companyMapper.updateCompanyOne(company);		
	}
	
	//업체 정보 입력, 회원가입  
	public int addCompany(Company company) {
		//랜덤 비번 만들기 
		UUID uuid = UUID.randomUUID();
		String companyPw= uuid.toString().substring(0,4);//0번째부터 4번쨰까지 
		company.setCompanyPw(companyPw);
		System.out.println(companyPw +"<--랜덤companyPw  확인");
		System.out.println(company.getCompanyPw()+"<-랜덤 비번getCompanyPw 잘 들어갔나 확인");
		// 유니크 넘버 만들어 줘야됨 	
		String companyUniqueNo = companyMapper.selectCompanyUniqueNo();
		System.out.println(companyUniqueNo+"<--유니크넘버임");
		company.setCompanyUniqueNo(companyUniqueNo);
		
		int row = companyMapper.insertCompany(company);
	
		if(row==1) {
			//회원가입 완료되면 사진 넣기 
			companyMapper.insertCompanyPic(company.getCompanyId());				
			System.out.println(companyPw+"<--임시 비밀번호 들어갔는지 확인 companyPw");
			
			//회원가입 완료되면 생성된 임시 비번 메일로 보내주기 
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(company.getCompanyEmail()); // 누구에게 보내는지 
			simpleMailMessage.setFrom("hya7835@gmail.com"); // 누가 보내는지
			simpleMailMessage.setSubject("Minimarket 임시 비밀번호 메일");//내용
			simpleMailMessage.setText("지정된 임시 비밀번호:"+ companyPw+"입니다" +"로그인 후 비밀번호를 변경해주세요");
			javaMailSender.send(simpleMailMessage);
		}
		return row;		
	}
}
