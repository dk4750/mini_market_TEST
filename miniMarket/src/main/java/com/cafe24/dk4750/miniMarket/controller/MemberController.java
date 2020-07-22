package com.cafe24.dk4750.miniMarket.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.dk4750.miniMarket.service.MemberItemService;
import com.cafe24.dk4750.miniMarket.service.MemberService;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.Member;
import com.cafe24.dk4750.miniMarket.vo.MemberInterestPlace;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMemberAndMemberItemPic;
import com.cafe24.dk4750.miniMarket.vo.MemberNickAndPic;
import com.cafe24.dk4750.miniMarket.vo.MemberReview;



@Controller
public class MemberController {
	@Autowired private MemberService memberService;
	@Autowired private MemberItemService memberItemService;
	
	// 회원의 프로필 보기
	@GetMapping("/getProfile")
	public String getProfile(Model model, @RequestParam(value="memberUniqueNo", defaultValue = "") String memberUniqueNo, @RequestParam(value="memberId", defaultValue = "") String memberId, HttpSession session) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		System.out.println("getProfile 시작");
		 // 세션이 널일경우
	     if(session.getAttribute("loginMember") == null){ 
	    	 return "redirect:/index";
	     }
	     if(memberUniqueNo.equals("") || memberId.equals("")) {
	    	 return "redirect:/index";
	     }
		System.out.println(memberUniqueNo + " <== 멤버 유니크넘버 넘어온 값");
		System.out.println(memberId + " <== 멤버 아이디 넘어온 값");
		
		// 닉네임 불러오기
		String memberNickname = memberService.getMemberNickname(memberUniqueNo);
		System.out.println(memberNickname + " <== 멤버 닉네임 디버깅");
		// 멤버 프로필사진 가져오기
		String profilePic = memberService.getMemberProfile(memberId);
		System.out.println(profilePic + " <== 멤버 프로필사진");
		// 멤버의 현재 매너온도 가져오기
		double tempTotal = memberService.getTempTotalNow(memberUniqueNo);
		System.out.println(tempTotal + " <== 매너온도");
		// 매너 카운트 구해오기
		Map<String, Object> map = memberService.getMannerContentCount(memberUniqueNo);
		
		List<MemberReview> list = memberService.getReviewAll(memberUniqueNo);
		
		// 모델에 담기
		model.addAttribute("tempTotal", tempTotal);
		model.addAttribute("memberNickname", memberNickname);
		model.addAttribute("profilePic", profilePic);
		model.addAttribute("map", map);
		model.addAttribute("list", list);
		
		return "getProfile";
	}
	
	//어바웃
	@GetMapping("/about")
	public String about() {
		
		return "about";
	}
	
	
	//관심동네 수정하기 폼
	@GetMapping("/modifyMemberInterestPlace")
	public String modifyMemberInterestPlace(HttpSession session,Model model) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}           
      
      LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
      String memberId= loginMember.getMemberId();
      System.out.println(memberId+"<-----modifyMemberInterestPlace memberId");
      MemberInterestPlace member = memberService.getMemberInterestPlace(memberId);
      
      System.out.println(member+"<-----modifyMemberInterestPlace member");
      model.addAttribute("member",member);
      return "modifyMemberInterestPlace";
   }
	   
	//관심동네 수정하기 액션
	   @PostMapping("/modifyMemberInterestPlace")
	   public String modifyMemberInterestPlace(HttpSession session,MemberInterestPlace memberInterestPlace) {
			// 로그인 안할시 로그인 창으로
			if(session.getAttribute("loginMember") == null) {
				return "redirect:/loginMemberAndCompany";
			}      
	      
	      LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
	      String memberId= loginMember.getMemberId();
	      memberInterestPlace.setMemberId(memberId);
	      
	      //서비스
	      memberService.modifyMemberInterestPlace(memberInterestPlace);
	      return "redirect:/memberMyPage";
	   }
	   
	
	//관심동네 설정하기 폼 
	   @GetMapping("/addMemberInterestPlace")
	   public String addMemberInterestPlace(HttpSession session) {
			// 로그인 안할시 로그인 창으로
			if(session.getAttribute("loginMember") == null) {
				return "redirect:/loginMemberAndCompany";
			}          
	      return "addMemberInterestPlace";
	   }
	
	//관심동네 추가하기 
	@PostMapping("/addMemberInterestPlace")   
	public String addMemberInterestPlace(HttpSession session, MemberInterestPlace memberInterestPlace) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}
	     LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
	     String memberId= loginMember.getMemberId();
	     memberInterestPlace.setMemberId(memberId);
	      //받아온값 확인하기 
	      System.out.println(memberInterestPlace + "<----memberInterestPlace");	      
	      memberService.addMemberInterestPlace(memberInterestPlace);
	      
	      return "redirect:/index";
	   }   
	   
	//회원탈퇴
	@GetMapping("/removeMember")
	public String removeMember(HttpSession session) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}			
		return "removeMember";
	}
	//회원탈퇴 액션
	@PostMapping("/removeMember")
	public String removeMember(HttpSession session,@RequestParam(value="memberPw", defaultValue = "") String memberPw,Model model) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		loginMember.setMemberPw(memberPw);
		
		String check = memberService.removeMember(loginMember);
		String msg = "";
		if(check == null) {
			msg = "비밀번호를 확인해주세요.";
			model.addAttribute("msg",msg);
			return "removeMember";
		}
		session.invalidate(); 
		return "redirect:/index";
	}
	
	//비밀번호 찾기 액션 
	@PostMapping("/getFindMemberPw")
	public String getFindMemberPw(HttpSession session, Member member, Model model) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		int row = memberService.getFindMemberPw(member);
	      String msg = "";
	      String msg2 = "";
	      
	      if(row == 1) {
	         msg2 = "해당 이메일로 임시비밀번호를 전송하였습니다. ";
	         model.addAttribute("msg2", msg2);
	      } else {
	         msg = "회원님의 입력정보와 일치하는 정보가 없습니다.";
	      }
	      model.addAttribute("msg", msg);
	      
		return "getFindMemberPw"; 
	}
	
	
	
	//비밀번호 찾기 폼 
	@GetMapping("/getFindMemberPw")
	public String getFindMemberPw(HttpSession session) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") != null) {
			return "redirect:/loginMemberAndCompany";
		}			
		return "getFindMemberPw"; 
	}
	
	//아이디 찾기 액션
	@PostMapping("/getFindMemberId")
	public String findMemberId(HttpSession session,Model model ,Member member) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}		
		String memberIdPart= memberService.getFindMemberId(member);
		System.out.println(memberIdPart+"<-----memberIdpart");
		model.addAttribute("memberIdPart", memberIdPart);		
		return "memberIdView";
	}
	
	
	//아이디 찾기 폼 
	@GetMapping("/getFindMemberId")
	public String findMemberId(HttpSession session) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") != null) {
			return "redirect:/loginMemberAndCompany";
		}					
		return "getFindMemberId"; 
	}
	

	
	//멤버 정보 수정(비밀번호 수정)폼  
	@GetMapping("/modifyMemberPw")
	public String modifyMemberPw(HttpSession session) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}				
		return "modifyMemberPw";		
	}
	
	//멤버 정보 수정(비밀번호 수정)액션  
	@PostMapping("/modifyMemberPw")
	public String modifyMemberPw(HttpSession session, @RequestParam(value="memberPw", defaultValue = "") String memberPw) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}	
		//세션에 담긴 아이디와, 입력받은 패스워드  변수에 담아서 서비스로 넘겨줌 
		LoginMember loginMember = (LoginMember)(session.getAttribute("loginMember"));
		loginMember.setMemberPw(memberPw);
		
		System.out.println(loginMember.getMemberId()+"<-- 아이디");
		System.out.println(loginMember.getMemberPw()+"<---새비번 확인 ");
		memberService.updateMemberPw(loginMember);
		return "redirect:/memberMyPage";		
	}
	
	
	//멤버 정보 수정(이름,전화번호,내동네 )폼
	@GetMapping("/modifyMember")
	public String modifyMember(HttpSession session,Model model ) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}	
		
		Member member= memberService.selectMemberOne((LoginMember)(session.getAttribute("loginMember")));
		System.out.println("수정확인중"+member);
		model.addAttribute("member", member);
				
		return "modifyMember";		
	}		
	//멤버 정보(이름,전화번호,내동네 ) 수정 액션
	@PostMapping("/modifyMember")
	public String modifyMember(HttpSession session, Member member) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}	
		System.out.println(member+"<----수정된 member값");
		memberService.modifyMemberOne(member);
		return "redirect:/getMemberOne";
	}
	
	//마이페이지 
	@GetMapping("/memberMyPage")
	public String memberMyPage(HttpSession session,Model model) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}					
		LoginMember memberId = (LoginMember)(session.getAttribute("loginMember"));
		String interest = memberId.getMemberId();
		
		//사진 닉네임 불러오기
		Map<String,Object> map = memberService.getMemberNickAndPic(memberId);
		
		//관심지역 설정 구분
		MemberInterestPlace a = memberService.getMemberInterestPlace(interest);
		//만약 관심지역 설정이 안되어있으면
		if(a == null) {
		String interest1 = "no";
		//model에 interest1 값을 넣어 보낼거임 그러면 interest1값이 있으면 설정 안되어있음. 없으면 설정 되어있음.
		model.addAttribute("interest1",interest1);
		}
		
		model.addAttribute("memberPic",map.get("memberPic"));
		model.addAttribute("memberNick",map.get("memberNick"));
		
		return "memberMyPage";
	}
	
	//멤버 사진,닉네임 수정 폼
	@GetMapping("/modifyMemberNickAndPic")
	public String modifyMemberNickAndPic(HttpSession session,Model model) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}				
		LoginMember memberId = (LoginMember)(session.getAttribute("loginMember"));
		//사진 닉네임 불러오기
		Map<String,Object> map = memberService.getMemberNickAndPic(memberId);
		
		model.addAttribute("memberPic",map.get("memberPic"));
		model.addAttribute("memberNick",map.get("memberNick"));
		
		return "modifyMemberNickAndPic";
	}
	
	//멤버 사진, 닉네임만 수저폼 수정 액션
	@PostMapping("/modifyMemberNickAndPic")
	public String modifyMemberNickAndPic(HttpSession session,MemberNickAndPic memberNickAndPic){
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}	
		//세셩 아이디 값 memberNickAndPic 넣어주기 
		LoginMember f = (LoginMember)session.getAttribute("loginMember");
		String memberId = f.getMemberId();
		
		memberNickAndPic.setMemberId(memberId);
				
		System.out.println(memberNickAndPic + "<----memberNickAndPic 받아온값 확인");
		MultipartFile mf = memberNickAndPic.getProfilePic(); 
		String originName= mf.getOriginalFilename();
		System.out.println(originName+"<----originName 디버깅 ");
		System.out.println(memberNickAndPic.getProfilePic() + "<--memberNickAndPic.getProfilePic()");
				
		// "image/png" 파일로는 사용 가능하나 그게 아니라면
		if (memberNickAndPic.getProfilePic() != null && !originName.equals("")) {
			if (!memberNickAndPic.getProfilePic().getContentType().equals("image/png")
					&& !memberNickAndPic.getProfilePic().getContentType().equals("image/jpeg")
					&& !memberNickAndPic.getProfilePic().getContentType().equals("image/gif")) {
				return "redirect:/modifyMemberNickAndPic?imgMsg=n";
			}
		}

		// 받아온 사진이 없으면(프로필 사진 변경 x) 원래 저장된 사진 그대로 보여줌
		if (memberNickAndPic.getProfilePic().getOriginalFilename().equals("")) {			
			memberService.modifyMemberNick(memberNickAndPic);			
			return "redirect:/memberMyPage"; 
		}

		memberService.modifyMemberNickAndPic(memberNickAndPic);
		System.out.println(memberNickAndPic + "업데이트 memberNickAndPic 확인!!");

		return "redirect:/memberMyPage";
	}
	
	// 로그아웃하기
	@GetMapping("/logoutMember")
	public String logout(HttpSession session) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}	
		session.invalidate(); // 로그아웃
		return "redirect:/index"; // 로그아웃 후 index 넘겨줌
	}
	
	//로그인 폼 
	@GetMapping("/loginMember")
	public String loginMember(HttpSession session) {
		//로그인 중일때 
		if(session.getAttribute("loginMember")!= null){
			return "redirect:/";
		}				
		return "loginMember";
		
	}
	
	//로그인 액션 
	@PostMapping("/loginMember")
	public String loginMember(Model model ,LoginMember loginMember, HttpSession session) {
		//로그인 중일때 
		if(session.getAttribute("loginMember")!= null){
			return "redirect:/index";
		}
		System.out.println("loginMember 로그인 확인" +loginMember); 
		LoginMember returnLoginMember= memberService.selectLoginMember(loginMember);
		System.out.println("리턴 로그인 returnLoginMember:"+returnLoginMember); //리턴 로그인 returnLoginMember:LoginMember [memberId=user1, memberPw=1234]
		if(returnLoginMember ==null) { //빈값이면 로그인 못함(로그인 실패시)
			model.addAttribute("msg","아이디와 비밀번호를 확인하세요");
			return "loginMember"; 
		}else{//로그인 성공시 (디비에 결과값 있으면 회원임)
			//세션에 담기
			session.setAttribute("loginMember", returnLoginMember);
			return "redirect:/index"; // 홈으로감  
		}	
	}

	
	//회원가입  폼
	@GetMapping("/addMember")
	public String addMember(HttpSession session) {
		if(session.getAttribute("loginMember")!= null){
			return "redirect:/index";
		}		
		return "addMember";
		
	}
	
	//회원가입(이메일 인증 서비스도 포함)
	@PostMapping("/addMember")
	public String addMember(Member member,Model model, HttpSession session){
		//로그인 중이면 다시 리다이렉트 
		if(session.getAttribute("loginMember")!= null){
			return "redirect:/index";
		}		
		System.out.println(member +"<---addMember member");
		
		//이메일 임시 번호 전송 메세지 
	
		int row= memberService.addMember(member);
		
		String msg = "메일 정확히 입력해주세요";
		if(row == 1) {
			msg="인증된 메일로 임시 비밀번호를 전송했습니다  확인 후 로그인 해주세요 "; 			
		}
		model.addAttribute("msg",msg);
		
		return "redirect:/index";				
	}
	
	//나의 정보보기
	@GetMapping("/getMemberOne")
	public String getMemberOne(HttpSession session, Model model) {
		if(session.getAttribute("loginMember")== null){ //로그인 상태 아니면 홈
			return "redirect:/index";
		}
		
		Member member = memberService.selectMemberOne((LoginMember)(session.getAttribute("loginMember")));
		System.out.println(member);
		model.addAttribute("member",member);
		return "getMemberOne";		
	}
	
	//index 홈 
	@GetMapping({"/","/index"})
	public String index(Model model, @RequestParam(value="currentPage", defaultValue = "1") int currentPage, @RequestParam(value="searchWord", defaultValue = "") String searchWord) {
		System.out.println("index start");
		System.out.println(currentPage + " <== currentPage 들어온 값 디버깅");
		System.out.println(searchWord + " <== searchWord 들어온 값 디버깅");
		int rowPerPage = 5;
		int beginRow = (currentPage-1)*rowPerPage;
		System.out.println(beginRow + " <== beginRow 디버깅");
		
		List<MemberItemAndMemberAndMemberItemPic> list = memberItemService.getIndexItemList(beginRow, rowPerPage, searchWord);
		model.addAttribute("list", list);
		
		return "index";
	}
	
	//전체(업체,회원) 회원가입 폼 
	@GetMapping("/addMemberAndCompany")
	public String addMemberAndCompany(HttpSession session) {
		if(session.getAttribute("loginMember")!= null || session.getAttribute("loginCompany")!= null){
			return "redirect:/index";
		}		
		return "addMemberAndCompany";
		
	}
	
	//전체(업체,회원) 로그인 폼
		@GetMapping("/loginMemberAndCompany")
		public String loginMemberAndCompany(HttpSession session) {
			if(session.getAttribute("loginMember")!= null || session.getAttribute("loginCompany")!= null){
				return "redirect:/index";
			}		
			return "loginMemberAndCompany";
			
		}
	
}
