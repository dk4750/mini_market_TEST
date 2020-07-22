package com.cafe24.dk4750.miniMarket.controller;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.dk4750.miniMarket.service.CategoryService;
import com.cafe24.dk4750.miniMarket.service.ChatroomService;
import com.cafe24.dk4750.miniMarket.service.CheckLikeService;
import com.cafe24.dk4750.miniMarket.service.MemberItemService;
import com.cafe24.dk4750.miniMarket.vo.Category;
import com.cafe24.dk4750.miniMarket.vo.Chatroom;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.MemberItem;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMemberAndMemberItemPic;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMemberAndMemberPicAndMemberItemPicAndMemberTempTotalAndMemberItemLike;
import com.cafe24.dk4750.miniMarket.vo.MemberItemForm;
import com.cafe24.dk4750.miniMarket.vo.MemberItemLike;
import com.cafe24.dk4750.miniMarket.vo.MemberItemPic;

@Controller
public class MemberItemController {
	@Autowired private MemberItemService memberItemService;
	@Autowired private CheckLikeService checkLikeService;
	@Autowired private CategoryService categoryService;
	@Autowired private ChatroomService chatroomService;
	
	// 내가 좋아요한 리스트 보기
	@GetMapping("/getMyLikeItem")
	public String getMyLikeItem(HttpSession session, Model model, @RequestParam(value= "currentPage", defaultValue = "1") int currentPage) {
		System.out.println("getMyLikeItem 겟매핑 시작");
		
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginMember") == null) {
			return "index";
		}
		int rowPerPage = 5;
		int beginRow = (currentPage-1)*rowPerPage;
		System.out.println(beginRow +"<-----beginRow");
		// 리스트 받아오기
		Map<String , Object> map = memberItemService.getMyLikeItem(session, beginRow, rowPerPage);
		System.out.println(map + " <== 내 좋아요 목록 리스트");
		
		// 모델에 리스트 담아주기
		model.addAttribute("totalRow", map.get("totalRow"));
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		// 페이지요청
		return "getMyLikeItem";
	}
	
	// 관심동네 아이템 리스트 보기
	@GetMapping("/getItemListByPlace")
	public String getItemListByPlace(HttpSession session, Model model, @RequestParam(value= "currentPage", defaultValue = "1") int currentPage) {
		System.out.println("getItemListByPlace 컨트롤러 시작");
		
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		// rowPerPage, beginRow 설정
		int rowPerPage = 5;
		int beginRow = (currentPage-1)*rowPerPage;
		// 리스트 가져오기
		Map<String , Object> map = memberItemService.getItemListByPlace(session, beginRow, rowPerPage);
		System.out.println(map+"값이 제대로 오는 확인하는 것");
		
		// 모델로 리스트 넘겨주기
		model.addAttribute("totalRow", map.get("totalRow"));
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		
		// 페이지요청
		return "getItemListByPlace";
	}
	
	// 카테고리별 동네 아이템 보기
	@GetMapping("/getItemListByCategory")
	public String getItemListByCategory(HttpSession session, Model model, String categoryName, @RequestParam(value= "currentPage", defaultValue = "1") int currentPage) {
		System.out.println("getItemListByCategory 겟매핑 시작");
		System.out.println(categoryName + " <== 카테고리 네임 디버깅");
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		// row
		int rowPerPage = 5;
		int beginRow = (currentPage-1)*rowPerPage;
		// 리스트 받아오기
		Map<String , Object> map = memberItemService.getItemListByCategory(session, categoryName, beginRow, rowPerPage);
		System.out.println(map + " <== 컨트롤러로 돌아온 카테고리별 리스트 디버깅");
		
		// 모델로 리스트 넘겨주기
		model.addAttribute("totalRow", map.get("totalRow"));
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		System.out.println(map.get("totalRow")+"<----토탈로우 값 카테고리별 아이템 컨트롤러");
		System.out.println(map.get("list"));
		return "getItemListByCategory";
	}
	
	// 아이템 상세보기 겟매핑
	@GetMapping("/getItemOne")
	public String getItemOne(HttpSession session ,Model model, @RequestParam(value="memberItemNo", defaultValue = "0") int memberItemNo, @RequestParam(value="pageCheck", defaultValue = "0") int pageCheck) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		
		// 세션에서 내 유니크넘버 받아오기
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		String memberUniqueNo = loginMember.getMemberUniqueNo();
		System.out.println(memberItemNo + " <== memberItemController 측에서 멤버 아이템 넘버 디버깅");
		System.out.println(memberUniqueNo + " <== memberItemController 측에서 멤버 유니크넘버 디버깅");
		//페이지에 넘겨줄 세션 아이디 값
		String memberId = ((LoginMember)session.getAttribute("loginMember")).getMemberId();
		System.out.println(memberId);
		//채팅방 존재 유무
		Chatroom chatroom = new Chatroom();
		chatroom.setMemberItemNo(memberItemNo);
		chatroom.setMemberUniqueNo(memberUniqueNo);
		int chatRoomCheck = chatroomService.getChatroomCheck(chatroom);
		System.out.println(chatRoomCheck+"<---chatroomCheck 채팅방 유무 체크");
		
		// 내가 좋아요 한 적이 있는지 체크
		MemberItemLike memberItemLike = new MemberItemLike();
		memberItemLike.setMemberItemNo(memberItemNo);
		memberItemLike.setMemberUniqueNo(memberUniqueNo);
		
		Integer check = checkLikeService.defaultLike(memberItemLike);
		System.out.println(check + " <== check");
		
		// 아이템 상세보기 불러오기
		MemberItemAndMemberAndMemberPicAndMemberItemPicAndMemberTempTotalAndMemberItemLike getItemOne = memberItemService.getMemberItemOne(memberItemNo);
		
		System.out.println(getItemOne.getMemberUniqueNo());
		String memberUniqueNoSale = getItemOne.getMemberUniqueNo();
		System.out.println(getItemOne.getMemberId());
		
		// 아이템 상세보기창에서 해당 회원의 판매상품 몇개 출력하기
		List<MemberItemAndMemberAndMemberItemPic> limitList = memberItemService.getItemListMyItemLimit(memberUniqueNoSale);
		
		// 모델에 담아주기
		model.addAttribute("chatRoomCheck", chatRoomCheck);
		model.addAttribute("getItemOne", getItemOne);
		model.addAttribute("check", check);
		model.addAttribute("LoginMemberId", memberId);
		model.addAttribute("limitList", limitList);
		System.out.println(getItemOne + " <== getItemOne");
		
		// 거래완료, 리스트에서는 수정이 안나오게끔... 이유는 판매하고 정보를 바꿔버릴수도 있기 때문에
		// 나의 판매중인 아이템리스트에만 수정버튼이 나오게끔
		model.addAttribute("pageCheck", pageCheck);
		
		return "getItemOne";
	}
	
	// 판매완료 
    @PostMapping("/soldOutComplete")
    public String soldOutComplete(HttpSession session, @RequestParam(value="memberItemNo", defaultValue = "0") int memberItemNo , @RequestParam(value="memberUniqueNo", defaultValue = "") String memberUniqueNo) {
    	// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		} else if(memberItemNo == 0) {
			return "redirect:/";
		}
    	System.out.println(memberItemNo + "<--soldOutComplete itemNo");
		System.out.println(memberUniqueNo + "<--soldOutComplete memberUniqueNo");
		memberItemService.itemSalesComplete(memberItemNo, memberUniqueNo);
		  
		return "redirect:/index";
    }
	
	// 구매자의 구매완료 아이템 리스트
	@GetMapping("/getBuyListByMember") 
	public String getBuyListByMember(HttpSession session, Model model, @RequestParam(value= "currentPage", defaultValue = "1") int currentPage) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		int rowPerPage = 5;
		int beginRow = (currentPage-1)*rowPerPage;
		// 내 구매리스트 출력해주기.
		Map<String , Object> map = memberItemService.getBuyListByMember(session, beginRow, rowPerPage);
		// 모델로 리스트 넘겨주기
		model.addAttribute("totalRow", map.get("totalRow"));
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		System.out.println(map.get("list")+"<=====리스트 값 확인");
		return "getBuyListByMember"; 
	}
	 
	
	// 나의 판매완료 아이템 리스트
	@GetMapping("/getItemListBySaleMyItem")
	public String getItemListBySaleMyItem(HttpSession session, Model model, @RequestParam(value= "currentPage", defaultValue = "1") int currentPage) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		
		int rowPerPage = 5;
		int beginRow = (currentPage-1)*rowPerPage;
		// 내 판매완료 아이템 리스트 받아오기
		Map<String , Object> map = memberItemService.getItemListBySaleMyItem(session, beginRow, rowPerPage);
		
		// 모델로 리스트 넘겨주기
		model.addAttribute("totalRow", map.get("totalRow"));
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		return "getItemListBySaleMyItem";
	}
	
	// 나의 판매중인 아이템 리스트
	@GetMapping("/getItemListMyItem")
	public String getItemListMyItem(HttpSession session, Model model, @RequestParam(value= "currentPage", defaultValue = "1") int currentPage) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		int rowPerPage = 5;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = memberItemService.getItemListMyItem(session, beginRow, rowPerPage);
		// 모델로 리스트 넘겨주기
		model.addAttribute("totalRow", map.get("totalRow"));
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		
		return "getItemListMyItem";
	}
	
	// 멤버 추가하기 겟매핑. 페이지요청. 폼
	@GetMapping("/addMemberItem")
	public String addMemberItem(HttpSession session, Model model) {
		System.out.println("addMemberItem 겟매핑 시작");
		
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		
		// 카테고리 목록 모델에담아서 포워딩 시켜주기
		List<Category> list = categoryService.getMemberCategory();
		System.out.println(list + " <== 중고물품등록 카테고리 이름");
		model.addAttribute("list", list);
		
		// 페이지요청
		return "addMemberItem";
	}
	
	// 멤버 추가하기 포스트매핑. 액션
	@PostMapping("/addMemberItem")
	public String addMemberItem(HttpSession session, MemberItemForm memberItemForm) {
		System.out.println("addMemberItem 포스트매핑 시작");
		
		// 가격 들어온거 디버깅
		int price = Integer.parseInt(memberItemForm.getMemberItemPrice());
		System.out.println(price);
		DecimalFormat formatter = new DecimalFormat("###,###");
		String memberItemPrice = formatter.format(price);
		System.out.println(memberItemPrice + " <== 아이템 가격 컴마 찍힌거");
		memberItemForm.setMemberItemPrice(memberItemPrice);
		
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		
		// 세션에서 유니크넘버 받기
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		String memberUniqueNo = loginMember.getMemberUniqueNo();
		System.out.println(memberUniqueNo + " <== memberUniqueNo");
		// form에 세션값 uniqueNo 넣어주기
		memberItemForm.setMemberUniqueNo(memberUniqueNo);
		
		System.out.println(memberItemForm + " <== 멤어 아이템 추가 memberItemForm");
		System.out.println(memberItemForm.getMemberItemPic1().getOriginalFilename() + " <== pic1");
		System.out.println(memberItemForm.getMemberItemPic2().getOriginalFilename() + " <== pic2");
		System.out.println(memberItemForm.getMemberItemPic3().getOriginalFilename() + " <== pic3");
		System.out.println(memberItemForm.getMemberItemPic4().getOriginalFilename() + " <== pic4");
		System.out.println(memberItemForm.getMemberItemPic5().getOriginalFilename() + " <== pic5");
		
		
		// 아이템 등록 실행
		memberItemService.addMemberItem(memberItemForm);
		
		// 리턴.. 나중에 수정
		return "index";
	}
	
	// 멤버 아이템 수정하기 겟매핑. 페이지요청. 폼
	@GetMapping("/modifyMemberItem")
	public String modifyMemberItem(HttpSession session ,Model model, @RequestParam(value="memberItemNo", defaultValue = "0") int memberItemNo) {
		System.out.println("modifyMemberItem 겟매핑 시작");
		System.out.println(memberItemNo);
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}else if(memberItemNo == 0) {
			return "redirect:/";
		}
		
		// 기존 정보 불러오기
		Map<String, Object> map = memberItemService.getMemberItemOneForUpdate(memberItemNo);
		MemberItemPic memberItemPic = (MemberItemPic)map.get("memberItemPic");
		MemberItem memberItem = (MemberItem)map.get("memberItem");
		System.out.println(memberItemPic + " <== Controller memberItemPic");
		System.out.println(memberItem + " <== Controller memberItem");
		System.out.println(memberItemPic.getMemberItemPic1() + " <== Controller memberItemPic1");
		
		// 모델에 값 담아서 페이지에 보내주기
		model.addAttribute("memberItem", memberItem);
		model.addAttribute("memberItemPic", memberItemPic);
		
		// 페이지요청
		return "modifyMemberItem";
	}
	
	// 멤버 아이템 수정하기 포스트맵핑. 액션
	@PostMapping("/modifyMemberItem")
	public String modifyMemberItem(HttpSession session, MemberItemForm memberItemForm) {
		System.out.println("modifyMemberItem 포스트매핑 시작");
		System.out.println(memberItemForm + " <== 멤버 아이템 수정하기 / memberItemForm 디버깅");
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		// 넘어온 값으로 memberItemNo 값 담아주기
		int memberItemNo = memberItemForm.getMemberItemNo();
		
	    memberItemForm.setMemberItemNo(memberItemNo);
	  
	    // 업데이트 실행 
	    memberItemService.modifyMemberItem(memberItemForm);
		 
		// 페이지 요청
		return "index";
	}
	
	// 판매중인 동네 아이템 리스트 출력하기
	@GetMapping("/getMemberItemList")
	public String getMemberItemList(HttpSession session, Model model, @RequestParam(value= "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value="searchWord", defaultValue = "") String searchWord) {
		System.out.println("getMemberItemList 겟매핑 시작");
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		
		int rowPerPage = 5;
		int beginRow = (currentPage-1)*rowPerPage;
		// 리스트 받아오기
		Map<String , Object> map = memberItemService.getMemberItemList(session, beginRow, rowPerPage, searchWord);
		int interestCheck = (int)map.get("interestCheck");
		List<Category> categoryList = categoryService.getMemberCategory();
		System.out.println(categoryList);
		
		// 모델로 리스트 넘겨주기
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("totalRow", map.get("totalRow"));
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("interestCheck", interestCheck);
		
		// 페이지 요청
		return "getMemberItemList";
	}
	
	// 아이템 삭제(비활성화)
	@GetMapping("/disabledMemberItem")
	public String disabledMemberItem(HttpSession session, MemberItem memberItem) {
		// 로그인 안할시 로그인 창으로
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		System.out.println("disabledMemberItem 겟매핑 시작");
		System.out.println(memberItem + " <== 아이템 삭제 / 멤버 아이템 넘버 디버깅");
		
		String memberItemState = "상품삭제";
		memberItem.setMemberItemState(memberItemState);
		
		memberItemService.disabledMemberItem(memberItem);
		
		return "redirect:/getMemberItemList";
	}
}
