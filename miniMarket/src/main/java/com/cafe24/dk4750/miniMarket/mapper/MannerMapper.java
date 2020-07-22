package com.cafe24.dk4750.miniMarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.Manner;

@Mapper
public interface MannerMapper {
	
	// 매너평가 1번
	public int selectMannerContentCount1(String memberUniqueNo);

	// 매너평가 1번
	public int selectMannerContentCount2(String memberUniqueNo);
	
	// 매너평가 1번
	public int selectMannerContentCount3(String memberUniqueNo);
	
	// 매너평가 1번
	public int selectMannerContentCount4(String memberUniqueNo);
	
	// 매너평가 1번
	public int selectMannerContentCount5(String memberUniqueNo);
	
	// 매너평가 1번
	public int selectMannerContentCount6(String memberUniqueNo);
	
	// good 매너 평가하기
	public int insertGoodManner(Manner manner);
	
	// bad 매너 평가하기
	public int insertBadManner(Manner manner);
	
	// 해당 아이템에 매너평가를 한 적이 있는지 체크 
	public int mannerCheck(Manner manner);
}
