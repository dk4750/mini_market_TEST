package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.MemberItem;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMemberAndMemberInterestPlaceAndMemberItemPic;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMemberAndMemberItemPic;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMemberAndMemberItemPicAndMemberItemLike;
import com.cafe24.dk4750.miniMarket.vo.MemberItemAndMemberAndMemberPicAndMemberItemPicAndMemberTempTotalAndMemberItemLike;

@Mapper
public interface MemberItemMapper {
	
	// 아이템 상세보기에서 해당 회원의 아이템 몇개만 상세보기
	public List<MemberItemAndMemberAndMemberItemPic> selectItemListMyItemLimit(String memberUniqueNo);
	
	// 인덱스에서 아이템 리스트 몇개 보기
	public List<MemberItemAndMemberAndMemberItemPic> selectIndexItemList(Map<String, Object> map);
	
	// 검색한 멤버아이템의 갯수
	public int totalSoldMemberItemBySearch(String searchWord);
	
	// 판매된 멤버 아이템의 총 갯수
	public int totalSoldMemberItem();
	// 멤버아이템의 총 갯수
	public int totalMemberItem();
	
	// 검색한 멤버아이템의 갯수
	public int totalMemberItemBySearch(String searchWord);
	
	// 게시글 상세보기
	public MemberItemAndMemberAndMemberPicAndMemberItemPicAndMemberTempTotalAndMemberItemLike selectMemberItemOne(int memberItemNo);
	
	// 수정을위해 멤버 아이템 상세보기 가져오기
	public MemberItem selectMemberItemOneForUpdate(int memberItemNo);
	
	// 판매자의 판매중인 아이템 판매완료로 수정
	public int itemSalesComplete(MemberItem memberItem);
	
	// 멤버 아이템 추가
	public int insertMemberItem(MemberItem memberItem);
	
	// 멤버 아이템 수정 액션
	public int updateMemberItem(MemberItem memberItem);
	
	// 판매중인 동네 아이템 리스트 출력
	public List<MemberItemAndMemberAndMemberItemPic> selectItemList(Map<String, Object> map);
	
	// 카테고리별 판매중인 동네 아이템 리스트 출력
	public List<MemberItemAndMemberAndMemberItemPic> selectItemListByCategory(Map<String, Object> map);
	
	// 판매중인 관심동네 아이템 리스트 출력
	public List<MemberItemAndMemberAndMemberInterestPlaceAndMemberItemPic> selectItemListByPlace(Map<String, Object> map);
	
	// 판매중인 나의 아이템 리스트 출력
	public List<MemberItemAndMemberAndMemberItemPic> selectItemListMyItem(Map<String, Object> map);
	
	// 나의 판매완료 아이템 리스트 출력
	public List<MemberItemAndMemberAndMemberItemPic> selectItemListBySaleMyItem(Map<String, Object> map);
	
	// 아이템 삭제(비활성화)
	public int disabledMemberItem(MemberItem memberItem);
	
	// 다음 멤버 아이템의 넘버를 알기위해서 현재 멤버 아이템넘버 max+1 값 구해오기
	public int selectMaxPlusMemberItemNo();
	
	// 내가 좋아요 한 멤버 아이템 리스트 출력
	public List<MemberItemAndMemberAndMemberItemPicAndMemberItemLike> selectMyLikeItem(Map<String, Object> map);
}
