package com.cafe24.dk4750.miniMarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.MemberItemLike;

@Mapper
public interface MemberItemLikeMapper {
	
	// 내가 이 상품을 좋아요 했는지 확인하기
	public Integer CheckLike(MemberItemLike memberItemLike);
	
	// 내 like active 가져오기
	public Integer CheckLike2(MemberItemLike memberItemLike);
	
	// 멤버가 처음으로 관심등록 할 때 인서트
	public int insertLikeItem(MemberItemLike memberItemLike);
	
	// 멤버 관심등록 active 업데이트
	public int updateLikeChange(MemberItemLike memberItemLike);
}
