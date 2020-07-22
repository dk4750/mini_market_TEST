package com.cafe24.dk4750.miniMarket.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.dk4750.miniMarket.mapper.CompanyItemLikeMapper;
import com.cafe24.dk4750.miniMarket.mapper.CompanyItemMapper;
import com.cafe24.dk4750.miniMarket.mapper.CompanyItemPicMapper;
import com.cafe24.dk4750.miniMarket.mapper.MemberInterestPlaceMapper;
import com.cafe24.dk4750.miniMarket.vo.CompanyItem;
import com.cafe24.dk4750.miniMarket.vo.CompanyItemAndCompanyAndCompanyItemPic;
import com.cafe24.dk4750.miniMarket.vo.CompanyItemAndCompanyAndCompanyItemPicAndCompanyItemLikeAndCompanyPic;
import com.cafe24.dk4750.miniMarket.vo.CompanyItemForm;
import com.cafe24.dk4750.miniMarket.vo.CompanyItemPic;
import com.cafe24.dk4750.miniMarket.vo.LoginCompany;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;

@Service
@Transactional
public class CompanyItemService {
	@Autowired private CompanyItemMapper companyItemMapper;
	@Autowired private CompanyItemPicMapper companyItemPicMapper;
	@Autowired private MemberInterestPlaceMapper memberInterestPlaceMapper;
	@Autowired private CompanyItemLikeMapper companyItemLikeMapper;
	@Value("/dk4750/tomcat/webapps/miniMarket/WEB-INF/classes/static/images/")
	private String path;
	
	// 나의 업체 아이템 상세보기
	public CompanyItemAndCompanyAndCompanyItemPicAndCompanyItemLikeAndCompanyPic getCompanyMyItemOne(HttpSession session, String companyUniqueNo) {
		// 세션값 가져오기
		LoginCompany loginCompany = (LoginCompany)session.getAttribute("loginCompany");
		companyUniqueNo = loginCompany.getCompanyUniqueNo();
		return companyItemMapper.selectCompanyMyItemOne(companyUniqueNo);
	}
	
	// 업체 아이템 상세보기
	public CompanyItemAndCompanyAndCompanyItemPicAndCompanyItemLikeAndCompanyPic getCompanyItemOne(int companyItemNo) {
		return companyItemMapper.selectCompanyItemOne(companyItemNo);
	}
	
	// 수정 폼
	public Map<String, Object> getCompanyItemOneForUpdate(int companyItemNo) {
		
		// 리턴타입 map 생성
		HashMap<String, Object> map = new HashMap<String, Object>();
		// map에 담을 정보들
		CompanyItem companyItem = companyItemMapper.selectCompanyItemOneForUpdate(companyItemNo);
		CompanyItemPic companyItemPic = companyItemPicMapper.selectCompanyItemPicName(companyItemNo);
		// map에 담아주기
		map.put("companyItem", companyItem);
		map.put("companyItemPic", companyItemPic);
		System.out.println(companyItem+"<------컴퍼니 아이템 수정 폼의 아이템 정보");
		System.out.println(companyItemPic+"<====컴퍼니 아이템 사진 수정 폼의 아이템사진정보");
		return map;
	}
	// 끌어올리기
	public int companyItemPullUp(HttpSession session, String companyUniqueNo) {
		LoginCompany loginCompany = (LoginCompany)session.getAttribute("loginCompany");
		companyUniqueNo = loginCompany.getCompanyUniqueNo();
		return companyItemMapper.companyItemPullUp(companyUniqueNo);
	}
	
	// 수정 액션
	public int modifyCompanyItem(CompanyItemForm companyItemForm) {
		// 기존 아이템 사진 이름 가져오기
		int companyItemNo = companyItemForm.getCompanyItemNo();
		CompanyItemPic companyItemPicc = companyItemPicMapper.selectCompanyItemPicName(companyItemNo);
		String originCompanyItemPic1 = companyItemPicc.getCompanyItemPic1();
		String originCompanyItemPic2 = companyItemPicc.getCompanyItemPic2();
		String originCompanyItemPic3 = companyItemPicc.getCompanyItemPic3();
		String originCompanyItemPic4 = companyItemPicc.getCompanyItemPic4();
		String originCompanyItemPic5 = companyItemPicc.getCompanyItemPic5();
		System.out.println(originCompanyItemPic1 +"<====기존 사진 이름 가져오기기기ㅣㄱ기기기기ㅣㅣ기기기ㅣ");
		System.out.println(originCompanyItemPic2);
		System.out.println(originCompanyItemPic3);
		System.out.println(originCompanyItemPic4);
		System.out.println(originCompanyItemPic5);	
		
		// 이미지 파일 저장
		MultipartFile multif1 = companyItemForm.getCompanyItemPic1();
		MultipartFile multif2 = companyItemForm.getCompanyItemPic2();
		MultipartFile multif3 = companyItemForm.getCompanyItemPic3();
		MultipartFile multif4 = companyItemForm.getCompanyItemPic4();
		MultipartFile multif5 = companyItemForm.getCompanyItemPic5();

		String originName1 = multif1.getOriginalFilename();
		String originName2 = multif2.getOriginalFilename();
		String originName3 = multif3.getOriginalFilename();
		String originName4 = multif4.getOriginalFilename();
		String originName5 = multif5.getOriginalFilename();
		
		// 새로 입력될 이름
		String companyItemPic1 = "";
		String companyItemPic2 = "";
		String companyItemPic3 = "";
		String companyItemPic4 = "";
		String companyItemPic5 = "";	
		// 값이 없으면 삭제 X, 있으면 삭제 실행
		if(!originName1.equals("")) {
			// 이미지 삭제
			File originFile = new File(path + originCompanyItemPic1);
			// 초기 설정 이미지 삭제 x
			if(originFile.exists() && !originCompanyItemPic1.equals("default.jpg")) {
				originFile.delete();
			}
			int lastDot = originName1.lastIndexOf(".");
			String extension = originName1.substring(lastDot);
			// 랜덤이름 주기
			UUID uuid = UUID.randomUUID();
			String comPic1 = uuid.toString().substring(0, 6);
			companyItemPic1 = comPic1+"1" + extension;
		} else {
			companyItemPic1 = originCompanyItemPic1;
		}
		
		// 값이 없으면 삭제 X, 있으면 삭제 실행
		if(!originName2.equals("")) {
			// 이미지 삭제
			File originFile = new File(path + originCompanyItemPic2);
			// 초기 설정 이미지 삭제 x
			if(originFile.exists() && !originCompanyItemPic2.equals("default.jpg")) {
				originFile.delete();
			}
			int lastDot = originName2.lastIndexOf(".");
			String extension = originName2.substring(lastDot);
			// 랜덤이름 주기
			UUID uuid = UUID.randomUUID();
			String comPic2 = uuid.toString().substring(0, 6);
			companyItemPic2 = comPic2+"2" + extension;
		} else {
			companyItemPic2 = originCompanyItemPic2;
		}
		// 값이 없으면 삭제 X, 있으면 삭제 실행
		if(!originName3.equals("")) {
			// 이미지 삭제
			File originFile = new File(path + originCompanyItemPic3);
			// 초기 설정 이미지 삭제 x
			if(originFile.exists() && !originCompanyItemPic3.equals("default.jpg")) {
				originFile.delete();
			}
			int lastDot = originName3.lastIndexOf(".");
			String extension = originName3.substring(lastDot);
			// 랜덤이름 주기
			UUID uuid = UUID.randomUUID();
			String comPic3 = uuid.toString().substring(0, 6);
			companyItemPic3 = comPic3+"3" + extension;
		} else {
			companyItemPic3 = originCompanyItemPic3;
		}
		// 값이 없으면 삭제 X, 있으면 삭제 실행
		if(!originName4.equals("")) {
			// 이미지 삭제
			File originFile = new File(path + originCompanyItemPic4);
			// 초기 설정 이미지 삭제 x
			if(originFile.exists() && !originCompanyItemPic4.equals("default.jpg")) {
				originFile.delete();
			}
			int lastDot = originName4.lastIndexOf(".");
			String extension = originName4.substring(lastDot);
			// 랜덤이름 주기
			UUID uuid = UUID.randomUUID();
			String comPic4 = uuid.toString().substring(0, 6);
			companyItemPic4 = comPic4+"4" + extension;
		} else {
			companyItemPic4 = originCompanyItemPic4;
		}
		// 값이 없으면 삭제 X, 있으면 삭제 실행
		if(!originName5.equals("")) {
			// 이미지 삭제
			File originFile = new File(path + originCompanyItemPic5);
			// 초기 설정 이미지 삭제 x
			if(originFile.exists() && !originCompanyItemPic5.equals("default.jpg")) {
				originFile.delete();
			}
			int lastDot = originName5.lastIndexOf(".");
			String extension = originName5.substring(lastDot);
			// 랜덤이름 주기
			UUID uuid = UUID.randomUUID();
			String comPic5 = uuid.toString().substring(0, 6);
			companyItemPic5 = comPic5+"5" + extension;
		} else {
			companyItemPic5 = originCompanyItemPic5;
		}
		// 업체아이템 폼에서 업체아이템 속성 꺼내서 담아주기
		CompanyItem companyItem = new CompanyItem();
		companyItem.setCompanyItemNo(companyItemNo);
		companyItem.setCompanyUniqueNo(companyItemForm.getCompanyUniqueNo());
		companyItem.setCompanyItemTitle(companyItemForm.getCompanyItemTitle());
		companyItem.setCategoryName(companyItemForm.getCategoryName());
		companyItem.setCompanyPhone(companyItemForm.getCompanyPhone());
		companyItem.setCompanyItemPrice(companyItemForm.getCompanyItemPrice());
		companyItem.setCompanyItemContent(companyItemForm.getCompanyItemContent());
		companyItemMapper.updateCompanyItem(companyItem);
		
		// 사진추가하기
		CompanyItemPic companyItemPic = new CompanyItemPic();
		companyItemPic.setCompanyItemNo(companyItemForm.getCompanyItemNo());
		companyItemPic.setCompanyItemPic1(companyItemPic1);
		companyItemPic.setCompanyItemPic2(companyItemPic2);
		companyItemPic.setCompanyItemPic3(companyItemPic3);
		companyItemPic.setCompanyItemPic4(companyItemPic4);
		companyItemPic.setCompanyItemPic5(companyItemPic5);
		companyItemPicMapper.updateCompanyItemPic(companyItemPic);
		
		// 사진 저장
		if(!originName1.equals("")) {
			// 파일 저장
			// 경로 저장
			File file = new File(path + companyItemPic1);
			try {
				multif1.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 예외처리를 코드에 구현하지 않아도 문제 없는 예외
				throw new RuntimeException();
			}
			// 예외처리를 해야만 문법적으로 이상없는 예외
		}
		// 사진 저장
		if(!originName2.equals("")) {
			// 파일 저장
			// 경로 저장
			File file = new File(path + companyItemPic2);
			try {
				multif2.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 예외처리를 코드에 구현하지 않아도 문제 없는 예외
				throw new RuntimeException();
			}
			// 예외처리를 해야만 문법적으로 이상없는 예외
		}
		// 사진 저장
		if(!originName3.equals("")) {
			// 파일 저장
			// 경로 저장
			File file = new File(path + companyItemPic3);
			try {
				multif3.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 예외처리를 코드에 구현하지 않아도 문제 없는 예외
				throw new RuntimeException();
			}
			// 예외처리를 해야만 문법적으로 이상없는 예외
		}
		// 사진 저장
		if(!originName4.equals("")) {
			// 파일 저장
			// 경로 저장
			File file = new File(path + companyItemPic4);
			try {
				multif4.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 예외처리를 코드에 구현하지 않아도 문제 없는 예외
				throw new RuntimeException();
			}
			// 예외처리를 해야만 문법적으로 이상없는 예외
		}
		// 사진 저장
		if(!originName5.equals("")) {
			// 파일 저장
			// 경로 저장
			File file = new File(path + companyItemPic5);
			try {
				multif5.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 예외처리를 코드에 구현하지 않아도 문제 없는 예외
				throw new RuntimeException();
			}
			// 예외처리를 해야만 문법적으로 이상없는 예외
		}
		return 0;
	}
	
	// 업체 아이템이 있는지 없는지 체크 
	public int getCompanyItemCheck(String companyUniqueNo) {
		return companyItemMapper.selectCompanyItemCheck(companyUniqueNo);
	}
	
	// 홍보중인 카테고리별 업체 아이템 리스트 출력
	public Map<String, Object> getCompanyItemListByCategory(HttpSession session, String categoryName, int beginRow, int rowPerPage) {
		// 세션값 가져오기
		LoginCompany loginCompany = (LoginCompany)session.getAttribute("loginCompany");
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		
		// beginRow, rowPerPage, bname, sigungu 등 입력할 데이터 담아서 보내주기.
		Map<String, Object> map = new HashMap<String, Object>();
		// 몇번째부터..
		map.put("beginRow", beginRow);
		// 페이지당 갯수..
		map.put("rowPerPage", rowPerPage);
		// 검색어!
		// 리스트의 토탈 카운트 수 + 조건 검색값이 있으면 검색값 추가하여 글 토탈 수를 구함
		int totalRow = 0;
		totalRow = companyItemMapper.totalCompanyItem();
		System.out.println(totalRow+"<----게시물 총합 수");
		String companyBname;
		String companySigungu;
		// 로그인이 업체일 경우와 멤버일 경우의 주소값 넣기
		if(session.getAttribute("loginCompany") == null) {
			companyBname = loginMember.getMemberBname();
			companySigungu = loginMember.getMemberSigungu();
		} else {
			companyBname = loginCompany.getCompanyBname();
			companySigungu = loginCompany.getCompanySigungu();
		}
		System.out.println(companyBname+"<------getCompanyItemListByCategory service 로그인한 세션의 비네임 주소");
		System.out.println(companySigungu+"<------getCompanyItemListByCategory service 로그인한 세션의 시군구 주소");
		map.put("companyBname", companyBname);
		map.put("companySigungu", companySigungu);
		map.put("categoryName", categoryName);
		//리스트 담기
		List<CompanyItemAndCompanyAndCompanyItemPic> list = companyItemMapper.selectCompanyItemListByCategory(map);
		System.out.println(list+"CompanyItemService list 목록 확인");
		// 마지막 페이지 번호 + 나머지 값이 있을 경우 마지막 페이지 값 +1
		int lastPage = totalRow / rowPerPage;
		if(totalRow % rowPerPage !=0) {
			lastPage += 1;
		}
		Map<String, Object> map2 = new HashMap<>();
		map2.put("list", list);
		map2.put("lastPage", lastPage);
		map2.put("totalRow", totalRow);	
		
		System.out.println(map2.get("list")+"<-----map2에 담긴 리스트값");
		return map2;
	}
	
	// 관심동네 중에 홍보중인 업체 아이템 리스트 출력
	public Map<String, Object> getPlaceByCompanyItemList(HttpSession session, int beginRow, int rowPerPage) {
		// 세션값 가져오기
		LoginCompany loginCompany = (LoginCompany)session.getAttribute("loginCompany");
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		
		Map<String, Object> map = new HashMap<String, Object>();
		// 몇번째부터..
		map.put("beginRow", beginRow);
		// 페이지당 갯수..
		map.put("rowPerPage", rowPerPage);
		// 리스트의 토탈 카운트 수 + 조건 검색값이 있으면 검색값 추가하여 글 토탈 수를 구함
		int totalRow = 0;
			totalRow = companyItemMapper.totalCompanyItem();
		System.out.println(totalRow+"<----게시물 총합 수");
		String companyBname;
		String companySigungu;
		String memberId = loginMember.getMemberId();
		
		//  관심동네 설정한 값 가져오기
		memberInterestPlaceMapper.selectMemberInterestPlace(memberId);
		
		// 로그인이 업체일 경우와 멤버일 경우의 주소값 넣기
		if(session.getAttribute("loginCompany") == null) {
			// 로그인한 멤버가 관심주소를 등록하지 않을 경우와 관심주소를 등록 했을 경우
			if(memberInterestPlaceMapper.selectMemberInterestPlace(memberId)== null ) {
				companyBname = loginMember.getMemberBname();
				companySigungu = loginMember.getMemberSigungu();
			} else {
				companyBname = memberInterestPlaceMapper.selectMemberInterestPlace(memberId).getBname();
				companySigungu = memberInterestPlaceMapper.selectMemberInterestPlace(memberId).getSigungu();
			}
		} else {
			companyBname = loginCompany.getCompanyBname();
			companySigungu = loginCompany.getCompanySigungu();
		}
		map.put("companyBname", companyBname);
		map.put("companySigungu", companySigungu);
		// 리스트 받아오기
		List<CompanyItemAndCompanyAndCompanyItemPic> list = companyItemMapper.selectCompanyItemList(map);
		// 마지막 페이지 번호 + 나머지 값이 있을 경우 마지막 페이지 값 +1
		int lastPage = totalRow / rowPerPage;
		if(totalRow % rowPerPage !=0) {
			lastPage += 1;
		}
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("list", list);
		map2.put("lastPage", lastPage);
		map2.put("totalRow", totalRow);

		// 리스트 리턴
		return map2;
	}
	
	// 홍보중인 업체 아이템 리스트 출력
	public Map<String, Object> getCompanyItemList(HttpSession session, int beginRow, int rowPerPage, String searchWord) {
		// 세션값 가져오기
		LoginCompany loginCompany = (LoginCompany)session.getAttribute("loginCompany");
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		
		Map<String, Object> map = new HashMap<String, Object>();
		// 몇번째부터..
		map.put("beginRow", beginRow);
		// 페이지당 갯수..
		map.put("rowPerPage", rowPerPage);
		// 검색어!
		map.put("searchWord", searchWord);
		// 리스트의 토탈 카운트 수 + 조건 검색값이 있으면 검색값 추가하여 글 토탈 수를 구함
		int totalRow = 0;
		if(searchWord.equals("")) {
			totalRow = companyItemMapper.totalCompanyItem();
		} else {
			totalRow = companyItemMapper.totalCompanyItemBySerach(searchWord);
		}
		String companyBname;
		String companySigungu;
		// 로그인이 업체일 경우와 멤버일 경우의 주소값 넣기
		if(session.getAttribute("loginCompany") == null) {
			companyBname = loginMember.getMemberBname();
			companySigungu = loginMember.getMemberSigungu();
		} else {
			companyBname = loginCompany.getCompanyBname();
			companySigungu = loginCompany.getCompanySigungu();
		}
		map.put("companyBname", companyBname);
		map.put("companySigungu", companySigungu);
		
		// 리스트 받아오기
		List<CompanyItemAndCompanyAndCompanyItemPic> list = companyItemMapper.selectCompanyItemList(map);
		System.out.println(list+"<===맵에 넣기전 리스트정보들");
		// 마지막 페이지 번호 + 나머지 값이 있을 경우 마지막 페이지 값 +1
		int lastPage = totalRow / rowPerPage;
		if(totalRow % rowPerPage !=0) {
			lastPage += 1;
		}
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("list", list);
		map2.put("lastPage", lastPage);
		map2.put("totalRow", totalRow);
		System.out.println(lastPage+"<=====마지막페이지 수");
		System.out.println(map2+"<----맵에 들어간 정보들");
		System.out.println(map2.get("list")+"<------맵에 들어간 리스트");
		// 리스트 리턴
		return map2;
	}
	
	// 내가 좋아요한 업체아이템 리스트 출력
	public Map<String, Object> getMyLikeCompanyItem(HttpSession session, int beginRow, int rowPerPage) {
		// 세션의 로그인한 유저의 유니크넘버 가져오기
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		
		String memberUniqueNo = loginMember.getMemberUniqueNo();
		Map<String, Object> map = new HashMap<String, Object>();
		// 몇번째부터..
		map.put("beginRow", beginRow);
		// 페이지당 갯수..
		map.put("rowPerPage", rowPerPage);
		// 리스트의 토탈 카운트 수 + 조건 검색값이 있으면 검색값 추가하여 글 토탈 수를 구함
		int totalRow = 0;
			totalRow = companyItemMapper.totalCompanyItem();
		map.put("memberUniqueNo", memberUniqueNo);
		// 리스트 받아오기
		List<CompanyItemAndCompanyAndCompanyItemPic> list = companyItemMapper.selectMyLikeCompanyItem(map);
		// 마지막 페이지 번호 + 나머지 값이 있을 경우 마지막 페이지 값 +1
		int lastPage = totalRow / rowPerPage;
		if(totalRow % rowPerPage !=0) {
			lastPage += 1;
		}
		Map<String, Object> map2 = new HashMap<>();
		map2.put("beginRow", beginRow);
		map2.put("list", list);
		map2.put("lastPage", lastPage);
		map2.put("totalRow", totalRow);
		
		// 리스트 리턴
		return map2;
	}
	
	// 업체 아이템 추가
	public void addCompanyItem(HttpSession session, CompanyItemForm companyItemForm) {
		System.out.println(companyItemForm + "<===업체 아이템 서비스 / companyItemForm 디버깅");
		System.out.println(path + "<-- 이미지 파일 저장경로");
		
		// 이미지 파일 저장
		MultipartFile multif1 = companyItemForm.getCompanyItemPic1();
		MultipartFile multif2 = companyItemForm.getCompanyItemPic2();
		MultipartFile multif3 = companyItemForm.getCompanyItemPic3();
		MultipartFile multif4 = companyItemForm.getCompanyItemPic4();
		MultipartFile multif5 = companyItemForm.getCompanyItemPic5();

		String originName1 = multif1.getOriginalFilename();
		String originName2 = multif2.getOriginalFilename();
		String originName3 = multif3.getOriginalFilename();
		String originName4 = multif4.getOriginalFilename();
		String originName5 = multif5.getOriginalFilename();
		
		String companyItemPic1 = null;
		String companyItemPic2 = null;
		String companyItemPic3 = null;
		String companyItemPic4 = null;
		String companyItemPic5 = null;
		
		//사진이 널일시.
		if(originName1.equals("")) {
			companyItemPic1 = "default.jpg";
		} else {
			int lastDot = originName1.lastIndexOf(".");
			System.out.println(lastDot + "<== 마지막 .의 위치... 확장자 앞까지만 나오게 하기 위해");
			String extension = originName1.substring(lastDot);
			companyItemPic1 = "comPic1"+extension;
		}
		//사진이 널일시.
		if(originName2.equals("")) {
			companyItemPic2 = "default.jpg";
		} else {
			int lastDot = originName2.lastIndexOf(".");
			System.out.println(lastDot + "<== 마지막 .의 위치... 확장자 앞까지만 나오게 하기 위해");
			String extension = originName2.substring(lastDot);
			companyItemPic2 = "comPic2"+extension;
		}
		//사진이 널일시.
		if(originName3.equals("")) {
			companyItemPic3 = "default.jpg";
		} else {
			int lastDot = originName3.lastIndexOf(".");
			System.out.println(lastDot + "<== 마지막 .의 위치... 확장자 앞까지만 나오게 하기 위해");
			String extension = originName3.substring(lastDot);
			companyItemPic3 = "comPic3"+extension;
		}
		//사진이 널일시.
		if(originName4.equals("")) {
			companyItemPic4 = "default.jpg";
		} else {
			int lastDot = originName4.lastIndexOf(".");
			System.out.println(lastDot + "<== 마지막 .의 위치... 확장자 앞까지만 나오게 하기 위해");
			String extension = originName4.substring(lastDot);
			companyItemPic4 = "comPic4"+extension;
		}
		//사진이 널일시.
		if(originName5.equals("")) {
			companyItemPic5 = "default.jpg";
		} else {
			int lastDot = originName5.lastIndexOf(".");
			System.out.println(lastDot + "<== 마지막 .의 위치... 확장자 앞까지만 나오게 하기 위해");
			String extension = originName5.substring(lastDot);
			companyItemPic5 = "comPic1"+extension;
		}
		
		// 사진이 널이 아닐시.
		if(!originName1.equals("")) {
			File file = new File(path+companyItemPic1);
			try {
				multif1.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 사진이 널이 아닐시.
		if(!originName2.equals("")) {
			File file = new File(path+companyItemPic2);
			try {
				multif2.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 사진이 널이 아닐시.
		if(!originName3.equals("")) {
			File file = new File(path+companyItemPic3);
			try {
				multif3.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 사진이 널이 아닐시.
		if(!originName4.equals("")) {
			File file = new File(path+companyItemPic4);
			try {
				multif4.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 사진이 널이 아닐시.
		if(!originName5.equals("")) {
			File file = new File(path+companyItemPic5);
			try {
				multif5.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 이름 변경된 값 디버깅
		System.out.println(companyItemPic1 + "<==companyItemPic1");
		System.out.println(companyItemPic2 + "<==companyItemPic2");
		System.out.println(companyItemPic3 + "<==companyItemPic3");
		System.out.println(companyItemPic4 + "<==companyItemPic4");
		System.out.println(companyItemPic5 + "<==companyItemPic5");
		
		
		// 지정해줄 companyItemNo 셀렉트로 구해오기
		int companyItemNo = companyItemMapper.selectMaxPlusCompanyItemNo();
		
		System.out.println(companyItemNo+"<---companyItemNo 값 컴퍼니아이템 서비스 컴퍼니아이템 추가");
		
		// 업체아이템 폼에서 업체아이템 속성 꺼내서 담아주기
		CompanyItem companyItem = new CompanyItem();
		companyItem.setCompanyItemNo(companyItemNo);
		companyItem.setCompanyUniqueNo(companyItemForm.getCompanyUniqueNo());
		companyItem.setCompanyItemTitle(companyItemForm.getCompanyItemTitle());
		companyItem.setCategoryName(companyItemForm.getCategoryName());
		companyItem.setCompanyPhone(companyItemForm.getCompanyPhone());
		companyItem.setCompanyItemPrice(companyItemForm.getCompanyItemPrice());
		companyItem.setCompanyItemContent(companyItemForm.getCompanyItemContent());
		System.out.println(companyItem + "<== 업체 아이템 서비스 / 업체 아이템 추가 / 업체 아이템 디버깅");
		
		// 사진추가하기
		CompanyItemPic companyItemPic = new CompanyItemPic();
		companyItemPic.setCompanyItemNo(companyItemNo);
		companyItemPic.setCompanyItemPic1(companyItemPic1);
		companyItemPic.setCompanyItemPic2(companyItemPic2);
		companyItemPic.setCompanyItemPic3(companyItemPic3);
		companyItemPic.setCompanyItemPic4(companyItemPic4);
		companyItemPic.setCompanyItemPic5(companyItemPic5);
		// 아이템 넘버를 받아와서 아이템 등록하기
		companyItemMapper.insertCompanyItem(companyItem);
		
		// 받아온 아이템 넘버에 해당하는 아이템 사진 등록하기
		companyItemPicMapper.insertCompanyItemPic(companyItemPic);
		
	}
	
	// 업체 아이템 삭제(비활성화)
	public int disabledCompanyItem(CompanyItem companyItem) {
		System.out.println(companyItem + "<== 업체 아이템 서비스 / 업체 아이템 삭제 /업체 아이템 디버깅");
		return companyItemMapper.disabledCompanyItem(companyItem);
	}
}
