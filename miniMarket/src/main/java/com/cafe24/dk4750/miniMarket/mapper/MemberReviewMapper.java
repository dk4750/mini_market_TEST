package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.MemberReview;

@Mapper
public interface MemberReviewMapper {
	// 리뷰 리스트
	public List<MemberReview> selectReviewAll(String memberUniqueNo);
	
	// 인설트 리뷰
	public int insertReview(MemberReview memberReview);
	
	// 리뷰 체크
	public int reviewCheck(MemberReview memberReview);
}
