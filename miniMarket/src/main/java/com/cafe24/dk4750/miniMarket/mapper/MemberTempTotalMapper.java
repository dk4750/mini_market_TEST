package com.cafe24.dk4750.miniMarket.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberTempTotalMapper {
	
	// 현재 멤버의 temp total 구하기
	public double selectTempTotalNow(String memberUniqueNo);
	
	// 새로운 템프토탈 인서트하기
	public int insertTempTotal(Map<String, Object> map);
}
