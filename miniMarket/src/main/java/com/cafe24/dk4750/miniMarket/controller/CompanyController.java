package com.cafe24.dk4750.miniMarket.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.dk4750.miniMarket.service.CompanyService;
import com.cafe24.dk4750.miniMarket.vo.Company;
import com.cafe24.dk4750.miniMarket.vo.CompanyNameAndPic;
import com.cafe24.dk4750.miniMarket.vo.LoginCompany;

@Controller
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	   //업체 탈퇴
	   @GetMapping("/removeCompany")
	   public String removeCompany(HttpSession session) {
	      //로그인 상태가 아니면
	      if(session.getAttribute("loginCompany")== null){ 
	         return "redirect:/loginMemberAndCompany";
	      }            
	      return "removeCompany";
	   }
	   
	   //업체 탈퇴 액션
	   @PostMapping("/removeCompany")
	   public String removeCompany(HttpSession session,@RequestParam(value="companyPw", defaultValue = "") String companyPw, Model model) {
	      //로그인 상태가 아니면
	      if(session.getAttribute("loginCompany")== null){ 
	    	  return "redirect:/loginMemberAndCompany";
	      }
	      
	      LoginCompany loginCompany = (LoginCompany)session.getAttribute("loginCompany");
	      System.out.println(loginCompany.getCompanyId()+"<-----companyId");
	      loginCompany.setCompanyPw(companyPw);
	      
	      String check = companyService.removeCompany(loginCompany);
	      String msg = "";
	      if(check == null) {
	         msg = "비밀번호를 확인해주세요.";
	         model.addAttribute("msg",msg);
	         return "removeCompany";
	      }
	      session.invalidate(); 
	      return "redirect:/index";
	   }
	   
	   //비밀번호 찾기 액션 
	   @PostMapping("/getFindCompanyPw")
	   public String getFindCompanyPw(HttpSession session, Company company, Model model) {
	      //로그인 상태면
	      if(session.getAttribute("loginCompany")!= null){ 
	         return "redirect:/index";
	      }
	      int row = companyService.getFindCompanyPw(company);
	         String msg = "";
	         String msg2 = "";
	         
	         if(row == 1) {
	            msg2 = "해당 이메일로 임시비밀번호를 전송하였습니다. ";
	            model.addAttribute("msg2", msg2);
	         } else {
	            msg = "회원님의 입력정보와 일치하는 정보가 없습니다.";
	         }
	         model.addAttribute("msg", msg);
	         
	      return "getFindCompanyPw"; 
	   }
	   
	   //비밀번호 찾기 폼 
	   @GetMapping("/getFindCompanyPw")
	   public String getFindCompanyPw(HttpSession session) {
	      //로그인 상태면
	      if(session.getAttribute("loginCompany")!= null || session.getAttribute("loginMember") != null){ 
	         return "redirect:/index";
	      }            
	      return "getFindCompanyPw"; 
	   }
	   
	
	// 업체 아이디 찾기 액션
	@PostMapping("/getFindCompanyId")
	public String findCompanyId(HttpSession session, Model model, Company company) {
	    //로그인 상태면
        if(session.getAttribute("loginCompany")!= null || session.getAttribute("loginMember") != null){ 
           return "redirect:/index";
        }   
		String companyIdPart = companyService.getFindCompanyId(company);
		System.out.println(companyIdPart + "<-----companyIdpart");
		model.addAttribute("companyIdPart", companyIdPart);
		return "companyIdView";
	}

	// 업체아이디 찾기 폼
	@GetMapping("/getFindCompanyId")
	public String findCompanyId(HttpSession session) {
		//로그인 상태면
	    if(session.getAttribute("loginCompany")!= null || session.getAttribute("loginMember") != null){ 
	       return "redirect:/index";
	    }   
		return "getFindCompanyId";
	}

	// 업체 정보 수정(비밀번호 수정)폼
	@GetMapping("/modifyCompanyPw")
	public String modifyCompanyPw(HttpSession session) {
		//로그인 상태면
	    if(session.getAttribute("loginCompany")!= null || session.getAttribute("loginMember") != null){ 
	       return "redirect:/index";
	    }   
		return "modifyCompanyPw";
	}

	// 업체 정보 수정(비밀번호 수정)액션
	@PostMapping("/modifyCompanyPw")
	public String modifyCompanyPw(HttpSession session, @RequestParam(value = "companyPw", defaultValue = "") String companyPw) {
		//로그인 상태면
	    if(session.getAttribute("loginCompany")!= null || session.getAttribute("loginMember") != null){ 
	       return "redirect:/index";
	    }   
		// 세션에 담긴 아이디와, 입력받은 패스워드 변수에 담아서 서비스로 넘겨줌
		LoginCompany loginCompany = (LoginCompany) (session.getAttribute("loginCompany"));
		loginCompany.setCompanyPw(companyPw);

		System.out.println(loginCompany.getCompanyId() + "<-- 아이디");
		System.out.println(loginCompany.getCompanyPw() + "<---새비번 확인 ");
		companyService.updateCompanyPw(loginCompany);
		return "redirect:/companyMyPage";
	}

	// 업체 정보 수정(ceo이름,전화번호,내동네,이메일,유니크넘버)폼
	@GetMapping("/modifyCompany")
	public String modifyCompany(HttpSession session, Model model) {
		//로그인 상태면
	    if(session.getAttribute("loginCompany")!= null || session.getAttribute("loginMember") != null){ 
	       return "redirect:/index";
	    }   

		Company company = companyService.selectCompanyOne((LoginCompany) (session.getAttribute("loginCompany")));
		System.out.println("수정확인중" + company);
		model.addAttribute("company", company);

		return "modifyCompany";
	}

	// 업체 정보(ceo이름,전화번호,내동네,이메일,유니크넘버) 수정 액션
	@PostMapping("/modifyCompany")
	public String modifyCompany(HttpSession session, Company company) {
		//로그인 상태면
	    if(session.getAttribute("loginCompany")!= null || session.getAttribute("loginMember") != null){ 
	       return "redirect:/index";
	    }   
		System.out.println(company + "<----수정된 company값");
		companyService.modifyCompanyOne(company);
		return "redirect:/getCompanyOne";
	}

	// 나의 정보보기
	@GetMapping("/getCompanyOne")
	public String getCompanyOne(HttpSession session, Model model) {
		if (session.getAttribute("loginCompany") == null) { // 로그인 상태 아니면 홈
			return "redirect:/index";
		}

		Company company = companyService.selectCompanyOne((LoginCompany) (session.getAttribute("loginCompany")));
		System.out.println(company);
		model.addAttribute("company", company);
		return "getCompanyOne";
	}

	// 마이페이지
	@GetMapping("/companyMyPage")
	public String companyMyPage(HttpSession session, Model model) {
		// 로그인 아닐때
		if (session.getAttribute("loginCompany") == null) {
			return "redirect:/index";
		}
		LoginCompany companyId = (LoginCompany) (session.getAttribute("loginCompany"));
		// 사진 닉네임 불러오기
		Map<String, Object> map = companyService.getCompanyNameAndPic(companyId);

		model.addAttribute("companyPic", map.get("companyPic"));
		model.addAttribute("CompanyName", map.get("companyName"));

		return "companyMyPage";
	}

	   //업체 사진,닉네임 수정 폼
	   @GetMapping("/modifyCompanyNameAndPic")
	   public String modifyCompanyNameAndPic(HttpSession session,Model model) {
	      //로그인 아닐때
	      if(session.getAttribute("loginCompany")== null){
	         return "redirect:/index";
	      }            
	      LoginCompany companyId = (LoginCompany)(session.getAttribute("loginCompany"));
	      //사진 닉네임 불러오기
	      Map<String,Object> map = companyService.getCompanyNameAndPic(companyId);
	      
	      model.addAttribute("companyPic",map.get("companyPic"));
	      model.addAttribute("companyName",map.get("companyName"));
	      
	      return "modifyCompanyNameAndPic";
	   }
	   
	   //업체 사진, 닉네임만 수저폼 수정 액션
	   @PostMapping("/modifyCompanyNameAndPic")
	   public String modifyCompanyNameAndPic(HttpSession session, CompanyNameAndPic companyNameAndPic){
	      //로그인 상태 아니면 인덱스로 
	      if (session.getAttribute("loginCompany") == null) {
	         return "redirect:/index"; 
	      }
	      //세션 아이디 값 companyNameAndPic 넣어주기 
	      LoginCompany f = (LoginCompany)session.getAttribute("loginCompany");
	      String companyId = f.getCompanyId();
	      
	      companyNameAndPic.setCompanyId(companyId);
	            
	      System.out.println(companyNameAndPic + "<----companyNameAndPic 받아온값 확인");
	      MultipartFile mf = companyNameAndPic.getProfilePic(); 
	      String originName= mf.getOriginalFilename();
	      System.out.println(originName+"<----originName 디버깅 ");
	      System.out.println(companyNameAndPic.getProfilePic() + "<--companyNameAndPic.getProfilePic()");
	            
	      // "image/png" 파일로는 사용 가능하나 그게 아니라면
	      if (companyNameAndPic.getProfilePic() != null && !originName.equals("")) {
	         if (!companyNameAndPic.getProfilePic().getContentType().equals("image/png")
	               && !companyNameAndPic.getProfilePic().getContentType().equals("image/jpeg")
	               && !companyNameAndPic.getProfilePic().getContentType().equals("image/gif")) {
	            return "redirect:/modifyCompanyNameAndPic?imgMsg=n";
	         }
	      }

	      // 받아온 사진이 없으면(프로필 사진 변경 x) 원래 저장된 사진 그대로 보여줌
	      if (companyNameAndPic.getProfilePic().getOriginalFilename().equals("")) {         
	         companyService.modifyCompanyName(companyNameAndPic);         
	         return "redirect:/companyMyPage"; 
	      }

	      companyService.modifyCompanyNameAndPic(companyNameAndPic);
	      System.out.println(companyNameAndPic + "업데이트 companyNameAndPic 확인!!");

	      return "redirect:/companyMyPage";
	   }
	   

	// 로그아웃하기
	@GetMapping("/logoutCompany")
	public String logout(HttpSession session) {
		// 로그인 실패시 로그인 폼으로
		if (session.getAttribute("loginCompany") == null) {
			return "redirect:/loginCompany"; // index로 넘겨줌
		}
		session.invalidate(); // 로그아웃
		return "redirect:/index"; // 로그아웃 후 index 넘겨줌
	}

	@GetMapping("/loginCompany")
	public String loginCompany(HttpSession session) {
		// 로그인 중일때
		if (session.getAttribute("loginCompany") != null) {
			return "redirect:/index";
		}
		return "loginCompany";

	}

	// 로그인 액션
	@PostMapping("/loginCompany")
	public String loginCompany(Model model, LoginCompany loginCompany, HttpSession session) {
		// 로그인 중일때
		if (session.getAttribute("loginCompany") != null) {
			return "redirect:/index";
		}
		System.out.println("loginCompany 로그인 확인" + loginCompany);
		LoginCompany returnLoginCompany = companyService.selectLoginCompany(loginCompany);
		System.out.println("리턴 로그인 returnLoginCompany:" + returnLoginCompany); // 리턴 로그인 returnLoginCompany:LoginCompany
																				// [companyId=user1, companyPw=1234]
		if (returnLoginCompany == null) { // 빈값이면 로그인 못함(로그인 실패시)
			model.addAttribute("msg", "아이디와 비밀번호를 확인하세요");
			return "loginCompany";
		} else {// 로그인 성공시 (디비에 결과값 있으면 회원임)
				// 세션에 담기
			session.setAttribute("loginCompany", returnLoginCompany);
			return "redirect:/index"; // 홈으로감
		}
	}

	// 회원가입 폼
	@GetMapping("/addCompany")
	public String addCompany(HttpSession session) {
		if (session.getAttribute("loginCompany") != null && session.getAttribute("loginMember") !=null) {
			return "redirect:/index";
		}
		return "addCompany";

	}

	// 회원가입(이메일 인증 서비스도 포함)
	@PostMapping("/addCompany")
	public String addCompany(Company company, Model model, HttpSession session) {
		// 로그인 중이면 다시 리다이렉트
		if (session.getAttribute("loginCompany") != null) {
			return "redirect:/index";
		}
		System.out.println(company + "<---addCompany company");

		// 이메일 임시 번호 전송 메세지
		int row = companyService.addCompany(company);

		String msg = "메일 정확히 입력해주세요";
		if (row == 1) {
			msg = "인증된 메일로 임시 비밀번호를 전송했습니다  확인 후 로그인 해주세요 ";
		}
		model.addAttribute("msg", msg);

		return "redirect:/index";
	}

}
