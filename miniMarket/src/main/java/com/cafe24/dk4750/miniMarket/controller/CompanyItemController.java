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
import com.cafe24.dk4750.miniMarket.service.CheckCompanyLikeService;
import com.cafe24.dk4750.miniMarket.service.CompanyItemService;
import com.cafe24.dk4750.miniMarket.vo.Category;
import com.cafe24.dk4750.miniMarket.vo.CompanyItem;
import com.cafe24.dk4750.miniMarket.vo.CompanyItemAndCompanyAndCompanyItemPicAndCompanyItemLikeAndCompanyPic;
import com.cafe24.dk4750.miniMarket.vo.CompanyItemForm;
import com.cafe24.dk4750.miniMarket.vo.CompanyItemLike;
import com.cafe24.dk4750.miniMarket.vo.CompanyItemPic;
import com.cafe24.dk4750.miniMarket.vo.LoginCompany;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;

@Controller
public class CompanyItemController {
	@Autowired private CompanyItemService companyItemService;
	@Autowired private CategoryService categoryService;
	@Autowired private CheckCompanyLikeService checkCompanyLikeService; 
	// 나의 업체 아이템 수정
	@GetMapping("/modifyCompanyItem")
	public String modifyCompanyItem(HttpSession session, Model model, @RequestParam(value="companyItemNo", defaultValue="0") int companyItemNo) {
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginCompany") == null) {
			 return "redirect:/loginMemberAndCompany";
		}

		//카테고리 목록
		List<Category> categoryList = categoryService.getCompanyCategory();
		
		// 기존 정보 불러오기
		Map<String, Object> map = companyItemService.getCompanyItemOneForUpdate(companyItemNo);
		CompanyItem companyItem = (CompanyItem)map.get("companyItem");
		CompanyItemPic companyItemPic = (CompanyItemPic)map.get("companyItemPic");
		System.out.println(companyItem + "<-----컴퍼니 아이템 컨트롤러 수정 폼 겟멥핑 아이템 값 확인");
		System.out.println(companyItemPic + "<--컴퍼니 아이템 컨트롤러 수정 폼 겟멥핑 아이템사진 값 확인");
		
		model.addAttribute("companyItem", companyItem);
		model.addAttribute("companyItemPic", companyItemPic);
		model.addAttribute("categoryList", categoryList);
		return "modifyCompanyItem";
	}
	
	// 업체 아이템 수정 액션
	@PostMapping("/modifyCompanyItem") 
	public String modifyCompanyItem(CompanyItemForm companyItemForm) {
		// 넘어온 값으로 companyItemNo 값 담아주기
		int companyItemNo = companyItemForm.getCompanyItemNo();
		
		companyItemForm.setCompanyItemNo(companyItemNo);
		System.out.println(companyItemNo+"<============컴퍼니 아이템 넘버 포스트 맵핑 수정");
		// 업데이트 실행
		companyItemService.modifyCompanyItem(companyItemForm);
		
		// 페이지 요청
		return "redirect:/getCompanyItemList";
	}
	// 끌어 올리기
	@GetMapping("/companyItemPullUp")
	public String companyItemPullUp(HttpSession session, String companyUniqueNo) {
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginCompany") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		companyItemService.companyItemPullUp(session, companyUniqueNo);
		return "redirect:/getCompanyItemList";
	}
	
	// 나의 업체 아이템 상세보기
	@GetMapping("/getCompanyMyItemOne")
	public String getMyCompanyItemOne(HttpSession session, Model model, String companyUniqueNo) {
		// 세션이 없다면 index로 리턴
		System.out.println(companyUniqueNo+"<---상세보기 유니크 넘버");
		if(session.getAttribute("loginCompany") == null) {
			return "redirect:/loginMemberAndCompany";
		}
		CompanyItemAndCompanyAndCompanyItemPicAndCompanyItemLikeAndCompanyPic myCompanyItemOne = companyItemService.getCompanyMyItemOne(session, companyUniqueNo);
		model.addAttribute("myCompanyItemOne", myCompanyItemOne);
		System.out.println(companyUniqueNo+"<-==컴퍼니 유니크 넘버 번호");
		System.out.println(myCompanyItemOne+"<====해당업체의 정보들");
		if(companyUniqueNo == null ) {
			return "getCompanyItemList";
		}
		return "getCompanyMyItemOne";
	}
	
	// 업체 아이템 상세보기
	@GetMapping("/getCompanyItemOne")
	public String getCompanyItemOne(HttpSession session, Model model, @RequestParam(value="companyItemNo", defaultValue="0") int companyItemNo) {
		System.out.println("업체 아이템 상세보기 get매핑 시작");
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
	         return "redirect:/loginMemberAndCompany";
	    }else if(companyItemNo == 0) {
	    	return "redirect:/index";
	    }
		
		CompanyItemAndCompanyAndCompanyItemPicAndCompanyItemLikeAndCompanyPic companyItemOne = new CompanyItemAndCompanyAndCompanyItemPicAndCompanyItemLikeAndCompanyPic();
		companyItemOne.setCompanyItemNo(companyItemNo);
		companyItemOne = companyItemService.getCompanyItemOne(companyItemNo);
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		
		// 현재 로그인한 유저의 유니크넘버값을 넘겨준다
		CompanyItemLike companyItemLike = new CompanyItemLike();
		String memberUniqueNo = loginMember.getMemberUniqueNo();
		companyItemLike.setMemberUniqueNo(memberUniqueNo);
		companyItemLike.setCompanyItemNo(companyItemNo);
		// 내 현재 라이크 상태
		Integer check = checkCompanyLikeService.defaultLike(companyItemLike);
		System.out.println(check+"<======== 내 현재 라이크 상태값값값");
		model.addAttribute("check", check);
		model.addAttribute("companyItemOne", companyItemOne);
		System.out.println(companyItemNo+"<-=-0-=0-=0=-0=-0=-0-=0=-0-=0=");
		System.out.println(companyItemOne+"<====해당업체의 정보들");
		return "getCompanyItemOne";
	}
	
	// 홍보중인 업체 아이템 카테고리별 출력하기
	@GetMapping("/getCompanyItemListByCategory")
	public String getCompanyItemListByCategory(HttpSession session, Model model, @RequestParam(value="categoryName", defaultValue="") String categoryName, @RequestParam(value= "currentPage", defaultValue = "1") int currentPage){
		System.out.println("getCompanyItemListByCategory<==겟메핑 시작");
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
	         return "redirect:/loginMemberAndCompany";
	    }else if(categoryName.equals("")) {
	    	return "redirect:/";
	    }
		// 업체로그인 웹으로
		LoginCompany loginCompany = (LoginCompany)session.getAttribute("loginCompany");
		int rowPerPage = 5;
		int beginRow = (currentPage-1)*rowPerPage;
		
		//카테고리 목록
		List<Category> categoryList = categoryService.getCompanyCategory();
		
		//아이템 리스트
		Map<String , Object> map2 = companyItemService.getCompanyItemListByCategory(session, categoryName, beginRow, rowPerPage);
		System.out.println(map2+"키테고리별 아이템 서비스 맵");
		System.out.println(categoryName+"<-----카테고리 네임값 컨트롤러러러러");
		//모델에 값넘기기
		model.addAttribute("loginCompany", loginCompany);
		model.addAttribute("list", map2.get("list"));
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("lastPage", map2.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		System.out.println(map2.get("list")+"<===카테고리별 아이템 리스트 목록 컨트롤러");
		System.out.println(map2.get("lastPage")+"<---라스트페이지 값 확인하기");
		return "getCompanyItemListByCategory";
	}
	
	// 홍보중인 업체 아이템 리스트 출력하기
	@GetMapping("/getCompanyItemList")
	public String getCompanyItemList(HttpSession session, Model model, @RequestParam(value= "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value="searchWord", defaultValue = "") String searchWord) {
		System.out.println("getCompanyItemList<== 겟메핑 시작");
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
	         return "redirect:/loginMemberAndCompany";
	     }
		int rowPerPage = 5;
		int beginRow = (currentPage-1)*rowPerPage;
		// 세션값 모델로 넘기기 위해서
		LoginCompany loginCompany = (LoginCompany)session.getAttribute("loginCompany");
		// 리스트 받아오기
		Map<String , Object> map2 = companyItemService.getCompanyItemList(session, beginRow, rowPerPage, searchWord);
		
		//카테고리 목록
		List<Category> categoryList = categoryService.getCompanyCategory();

		
		// 리스트 모델에 담아서 페이지로 보내주기
		model.addAttribute("totalRow", map2.get("totalRow"));
		model.addAttribute("list", map2.get("list"));
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("loginCompany", loginCompany);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", map2.get("lastPage"));
		System.out.println(map2.get("list")+"<---리스트 정보");
		
		//페이지 요청
		return "getCompanyItemList";
	}
	
	// 관심동네중에 홍보중인 업체 아이템 리스트 출력하기
	@GetMapping("/getPlaceByCompanyItemList")
	public String getPlaceByCompanyItemList(HttpSession session, Model model, @RequestParam(value= "currentPage", defaultValue = "1") int currentPage) {
		System.out.println("getPlaceByCompanyItemList<==겟맵핑 시작");
		// 세션이 없다면 인덱스로 
		if(session.getAttribute("loginMember") == null && session.getAttribute("loginCompany") == null && session.getAttribute("loginAdmin") == null) {
	         return "redirect:/loginMemberAndCompany";
	     }
		int rowPerPage = 5;
		int beginRow = (currentPage-1)*rowPerPage;
		// 관심동네중에 홍보중인 업체 아이템 리스트 출력
		Map<String , Object> map  =  companyItemService.getPlaceByCompanyItemList(session, beginRow, rowPerPage);
		model.addAttribute("totalRow", map.get("totalRow"));
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		return "getPlaceByCompanyItemList";
	}
	
	// 내가 좋아요한 업체 아이템 리스트 출력하기
	@GetMapping("/getMyLikeCompanyItem")
	public String getMyLikeCompanyItem(HttpSession session, Model model, @RequestParam(value= "currentPage", defaultValue = "1") int currentPage) {
		System.out.println("getMyLikeCompanyItem<==겟메핑 시작");
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginMember") == null ) {
	         return "redirect:/loginMemberAndCompany";
	    }
		int rowPerPage = 5;
		int beginRow = (currentPage-1)*rowPerPage;
		// 좋아요한 아이템 리스트 출력하기
		Map<String , Object> map2 = companyItemService.getMyLikeCompanyItem(session, beginRow, rowPerPage);
		
		// 모델로 리스트 넘겨주기
		model.addAttribute("totalRow", map2.get("totalRow"));
		model.addAttribute("list", map2.get("list"));
		model.addAttribute("lastPage", map2.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		System.out.println(map2.get("lastPage")+"<---라스트페이지 값 확인하기");
		
		return "getMyLikeCompanyItem";
	}
	
	// 업체 추가하기 겟매핑. 페이지요청. 폼
	@GetMapping("/addCompanyItem")
	public String addCompanyItem(HttpSession session, Model model) {
		System.out.println("addCompanyItem 겟매핑 시작");
		// 세션이 없다면 로그인창으로 리턴
		if(session.getAttribute("loginCompany") == null) {
			 return "redirect:/loginMemberAndCompany";
		}
		// 세션값의 유니크넘버 가져오기
		LoginCompany loginCompany = (LoginCompany)session.getAttribute("loginCompany");
		String companyUniqueNo = loginCompany.getCompanyUniqueNo();
		
		//모델로 업체의 카테고리 리스트 넘겨주기
		List<Category> list = categoryService.getCompanyCategory();
		model.addAttribute("list", list);
		model.addAttribute("companyUniqueNo", companyUniqueNo);
		// 페이지 요청
		return "addCompanyItem";
	}
	
	// 업체 아이템 추가하기 포스트 매핑. 액션
	@PostMapping("/addCompanyItem")
	public String addCompanyItem(HttpSession session, CompanyItemForm companyItemForm) {
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginCompany") == null) {
			 return "redirect:/loginMemberAndCompany";
		}
		
		// 아이템 가격 컴마찍기
		int price = Integer.parseInt(companyItemForm.getCompanyItemPrice());
		System.out.println(price);
		DecimalFormat formatter = new DecimalFormat("###,###");
		String companyItemPrice = formatter.format(price);
		System.out.println(companyItemPrice + " <== 아이템 가격 컴마 찍힌거");
		companyItemForm.setCompanyItemPrice(companyItemPrice);
		
		System.out.println("addCompanyItem <== 포스트매핑 시작");
		System.out.println(companyItemForm +"<--- 업체 아이템 추가 companyItemForm");
		System.out.println(companyItemForm.getCompanyItemPic1().getOriginalFilename() + "<==pic1");
		System.out.println(companyItemForm.getCompanyItemPic1().getOriginalFilename() + "<==pic2");
		System.out.println(companyItemForm.getCompanyItemPic1().getOriginalFilename() + "<==pic3");
		System.out.println(companyItemForm.getCompanyItemPic1().getOriginalFilename() + "<==pic4");
		System.out.println(companyItemForm.getCompanyItemPic1().getOriginalFilename() + "<==pic5");
		// 업체 유니크넘버를 세션값을 받아오기
		LoginCompany loginCompany = (LoginCompany)session.getAttribute("loginCompany");
		companyItemForm.setCompanyUniqueNo(loginCompany.getCompanyUniqueNo()); 
		System.out.println(companyItemForm.getCompanyUniqueNo()+"<---컴퍼니 아이템 포스트맵핑 컴퍼니 유니크 넘버가 제대로 넘어 오는지 확인");
		companyItemService.addCompanyItem(session, companyItemForm);
		// 리턴
		return "index";
	}
	
	// 업체 아이템 삭제(비활성화)
	@GetMapping("/disabledCompanyItem")
	public String disabledCompanyItem(HttpSession session, CompanyItem companyItem) {
		// 세션이 없다면 index로 리턴
		if(session.getAttribute("loginCompany") == null) {
			 return "redirect:/loginMemberAndCompany";
		}

		System.out.println("disabledCompanyItem 겟매핑 시작");
		System.out.println(companyItem + "<==업체 아이템 삭제 / 업체 아이템 넘버 디버깅");
		
		String companyItemState = "삭제";
		companyItem.setCompanyItemState(companyItemState);
		
		companyItemService.disabledCompanyItem(companyItem);
		
		return "redirect:/getCompanyItemList";
	}
	
}
