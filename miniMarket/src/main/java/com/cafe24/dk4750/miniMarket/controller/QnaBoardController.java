package com.cafe24.dk4750.miniMarket.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.QnaBoardService;
import com.cafe24.dk4750.miniMarket.service.QnaCommentService;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.QnaBoardMember;
import com.cafe24.dk4750.miniMarket.vo.QnaCommentMember;

@Controller
public class QnaBoardController {
	@Autowired
	private QnaBoardService qnaBoardService;
	@Autowired QnaCommentService qnaCommentService;
	@GetMapping("/getQnaBoardMemberHtml")
	public String getQnaBoardMemberHtml(HttpSession session) {
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		return "getQnaBoardMemberHtml";
	}
   //댓글 삭제
    @GetMapping("/removeQnaCommentMember")
    public String removeQnaCommentMember(HttpSession session, QnaCommentMember qnaCommentMember) {
       if( session.getAttribute("loginAdmin") == null) {
          return "redirect:/loginMemberAndCompany";
       }
       if(qnaCommentMember.getQnaBoardMemberNo() == 0) {
          return "redirect:/index";
       }
       System.out.println(qnaCommentMember+"<---삭제 컨트롤러");
       qnaCommentService.removeQnaCommentMember(qnaCommentMember.getQnaCommentMemberNo());
       return "redirect:/getQnaBoardMemberOne?qnaBoardMemberNo="+qnaCommentMember.getQnaBoardMemberNo();
    }
	@PostMapping("/modifyQnaBoardMemberByActive")
	//질문 비활성화
	public String modifyQnaBoardMemberByActive(HttpSession session, @RequestParam(value="qnaBoardMemberNo", defaultValue = "") int qnaBoardMemberNo) {
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		System.out.println(qnaBoardMemberNo);
		qnaBoardService.modifyQnaBoardMemberByActive(qnaBoardMemberNo);
		return "redirect:/getQnaBoardMemberList";
	}
	//질문 수정
	@PostMapping("/modifyQnaBoardMember")
	public String modifyQnaBoardMember(HttpSession session, QnaBoardMember qnaBoardMember) {
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		System.out.println(qnaBoardMember);
		qnaBoardService.modifyQnaBoardMember(qnaBoardMember);
		return "redirect:/getQnaBoardMemberOne?qnaBoardMemberNo="+qnaBoardMember.getQnaBoardMemberNo();
	}
	//댓글 추가
	@PostMapping("/addQnaBoardCommentMember")
	public String addQnaCommentMember(HttpSession session ,QnaCommentMember qnaCommentMember) {
		
		System.out.println(qnaCommentMember + "<---controller qnaCommentMember");
		qnaCommentService.addQnaCommentMember(qnaCommentMember);
		System.out.println(qnaCommentMember.getQnaBoardMemberNo());
		return "redirect:/getQnaBoardMemberOne?qnaBoardMemberNo="+qnaCommentMember.getQnaBoardMemberNo();
	}
	//자주 묻는 질문 리스트 + 페이징 + 검색
	@GetMapping("/getQnaBoardMemberList")
	public String getQnaBoardMemberList(HttpSession session , Model model , @RequestParam(value= "currentPage", defaultValue = "1") int currentPage, @RequestParam(value= "qnaBoardMemberTitle", defaultValue = "") String qnaBoardMemberTitle){
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginAdmin") == null) {
			return "redirect:/loginMemberAndCompany";
		}else if(session.getAttribute("loginCompany") != null) {
			return "redirect:/";
		}
		System.out.println(currentPage + "<---페이지 초기 번호");
		System.out.println(qnaBoardMemberTitle+"<---검색어");
		int rowPerPage = 5;
		int beginRow = (currentPage-1)*rowPerPage;
		System.out.println(beginRow+"<---beginRow");
		
		Map<String , Object> map = qnaBoardService.getQnaBoardMemberList(beginRow, rowPerPage, qnaBoardMemberTitle);
		
		//페이지 초기 번호
		model.addAttribute("currentPage", currentPage);
		//자주 묻는 질문 리스트 + 페이징
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("qnaBoardMemberTitle", qnaBoardMemberTitle);
		return "getQnaBoardMemberList";
	}
	// 상세보기
	@GetMapping("/getQnaBoardMemberOne")
	public String getQnaBoardMemberOne(HttpSession session , Model model , @RequestParam(value= "currentPage", defaultValue = "1") int currentPage ,@RequestParam("qnaBoardMemberNo") int qnaBoardMemberNo) {
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		System.out.println(qnaBoardMemberNo+"<---qnaBoardMemberNo controller");
		String memberUniqueNo = ((LoginMember)session.getAttribute("loginMember")).getMemberUniqueNo();
		System.out.println(memberUniqueNo+"<--세션 유니크넘버 controller");
		int rowPerPage = 5;
		int beginRow = (currentPage - 1)*rowPerPage;
		System.out.println(beginRow);
		
		Map<String, Object> map = qnaBoardService.getQnaBoardMemberOne(qnaBoardMemberNo, beginRow, rowPerPage);
		model.addAttribute("CommentList", map.get("list"));
		model.addAttribute("qnaBoardMember", map.get("qnaBoardMember"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("memberUniqueNo", memberUniqueNo);
		
		return "getQnaBoardMemberOne";
	}
	// 자주 묻는 질문 추가
	@GetMapping("/addQnaBoardMember")
	public String addQnaBoardMember(HttpSession session, Model model) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		String memberUniqueNo = ((LoginMember)session.getAttribute("loginMember")).getMemberUniqueNo();
		model.addAttribute("memberUniqueNo", memberUniqueNo);
		return "addQnaBoardMember";
	}
	// 자주 묻는 질문 추가 액션
	@PostMapping("/addQnaBoardMember")
	public String addQnaBoardMember(HttpSession session, QnaBoardMember qnaBoardMember) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		System.out.println(qnaBoardMember);
		qnaBoardService.addQnaBoardMember(qnaBoardMember);
		
		return "redirect:/getQnaBoardMemberList";
	}
}
