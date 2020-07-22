package com.cafe24.dk4750.miniMarket.controller;

import java.nio.channels.SeekableByteChannel;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.QnaBoardCompanyService;
import com.cafe24.dk4750.miniMarket.service.QnaCommentCompanyService;
import com.cafe24.dk4750.miniMarket.vo.LoginCompany;
import com.cafe24.dk4750.miniMarket.vo.QnaBoardCompany;
import com.cafe24.dk4750.miniMarket.vo.QnaBoardCompanyAndCompany;

@Controller
public class QnaBoardCompanyController {
	@Autowired
	private QnaBoardCompanyService qnaBoardCompanyService;
	@Autowired
	private QnaCommentCompanyService qnaCommentCompanyService;
	
	// QnA 리스트 비 활성화
	@GetMapping("modifyQnaBoardCompanyActive")
	public String modifyQnaBoardCompanyActive(HttpSession session, @RequestParam(value="qnaBoardCompanyNo", defaultValue = "0") int qnaBoardCompanyNo) {
		// 내가 쓴글만 접근 허용 및 삭제 버튼 활성화
		if(session.getAttribute("loginCompany") == null) {
			return "redirect:/loginMemberAndCompany";
		} else if(qnaBoardCompanyNo == 0) {
			return "redirect:/";
		}
		qnaBoardCompanyService.modifyQnaBoardCompanyActive(qnaBoardCompanyNo);
		
		return "redirect:/getQnaBoardCompany";
	}
	// QnA 수정 액션
	@PostMapping("modifyQnaBoardCompany")
	public String modifyQnaBoardCompany(HttpSession session, QnaBoardCompany qnaBoardCompany) {
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		// 내가 쓴글만 접근 가능 하게 세션 companyUniqueNo 와 글의 companyUniqueNo의 값을 비교
		qnaBoardCompanyService.modifyQnaBoardCompany(qnaBoardCompany);
		
		return "redirect:/getQnaBoardCompany";
	}
	// QnA 수정 페이지 요청
	@GetMapping("modifyQnaBoardCompany")
	public String modifyQnaBoardCompany(HttpSession session, Model model, @RequestParam(value="qnaBoardCompanyNo", defaultValue = "0") int qnaBoardCompanyNo) {
		if(session.getAttribute("loginCompany") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		QnaBoardCompanyAndCompany qnaBoardCompanyAndCompany = qnaBoardCompanyService.getQnaBoardCompanyOne(qnaBoardCompanyNo);
		model.addAttribute("qnaOne", qnaBoardCompanyAndCompany);
		
		return "modifyQnaBoardCompany";
	}
	// QnA 입력 페이지 액션
	@PostMapping("addQnaBoardCompany")
	public String addQnaBoardCompany(HttpSession session, QnaBoardCompany qnaBoardCompany) {
		if(session.getAttribute("loginCompany") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		// companyUniqueNo는 세션값으로 받는다
		String companyUniqueNo = ((LoginCompany)session.getAttribute("loginCompany")).getCompanyUniqueNo();
		qnaBoardCompany.setCompanyUniqueNo(companyUniqueNo);
		System.out.println(qnaBoardCompany + "<--addQnaBoardCompany: qnaBoardCompany");
		qnaBoardCompanyService.addQnaBoardCompany(qnaBoardCompany);
		
		return "redirect:/getQnaBoardCompany";
	}
	// QnA 입력 페이지 요청
	@GetMapping("addQnaBoardCompany")
	public String addQnaBoardCompany(HttpSession session) {
		if(session.getAttribute("loginCompany") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		return "addQnaBoardCompany";
	}
	// QnA상세보기 페이지 요청, 댓글(페이징) 입력
	@GetMapping("getQnaBoardCompanyOne")
	public String qnaBoardCompanyOne(HttpSession session, Model model, @RequestParam(value="qnaBoardCompanyNo", defaultValue = "0") int qnaBoardCompanyNo, @RequestParam(value="currentPage", defaultValue="1") int currentPage) {
		if(session.getAttribute("loginCompany") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		System.out.println(qnaBoardCompanyNo + "<--getQnaBoardCompanyOne: qnaBoardCompanyNo");
		QnaBoardCompanyAndCompany qnaBoardCompanyAndCompany = qnaBoardCompanyService.getQnaBoardCompanyOne(qnaBoardCompanyNo);
		model.addAttribute("qnaOne", qnaBoardCompanyAndCompany);
		// 댓글 리스트
		Map<String, Object> map = qnaCommentCompanyService.getQnaCommentCompanyList(currentPage, qnaBoardCompanyNo);
		System.out.println(map.get("qnaCommentCompanyList") + "qnaCommentCompanyList List");
		System.out.println(map.get("lastPage") + "qnaBoardCompanyOne: lastPage");
		model.addAttribute("list", map.get("qnaCommentCompanyList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("qnaBoardCompanyNo", qnaBoardCompanyNo);
		
		return "getQnaBoardCompanyOne";
	}
	// QnA 리스트 출력
	@GetMapping("getQnaBoardCompanyList")
	public String qnaBoardCompanyListAll(HttpSession session, Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="searchWord", defaultValue="") String searchWord) {
		if(session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
			return "redirect:/loginMemberAndCompany";
		}else if(session.getAttribute("loginMember") != null) {
			return "redirect:/";
		}
		
		// QnA 리스트 출력 및 페이징
		System.out.println(currentPage + "<--qnaBoardCompanyList currentPage");
		System.out.println(searchWord + "<--qnaBoardCompanyList searchWord");
		Map<String, Object> map = qnaBoardCompanyService.getQnaBoardCompanyList(currentPage, searchWord);
		System.out.println(map.get("qnaBoardCompanyBoardList") + "qnaBoardCompanyList List");
		System.out.println(map.get("lastPage") + "qnaBoardCompanyList: lastPage");
		model.addAttribute("list", map.get("qnaBoardCompanyBoardList"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		// 검색한 화면 페이징하기위해
		model.addAttribute("searchWord", searchWord);
		
		return "getQnaBoardCompanyList";
	}
	// 업체 자주묻는 질문 및 QnA
	@GetMapping("getQnaBoardCompany")
	public String qnaBoardCompanyList(HttpSession session) {
		if(session.getAttribute("loginCompany") == null && session.getAttribute("loginMember") == null && session.getAttribute("loginAdmin") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		
		return "getQnaBoardCompany";
	}
}
