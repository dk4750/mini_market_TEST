package com.cafe24.dk4750.miniMarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.MemberTemp;

@Mapper
public interface MemberTempMapper {
	
	// 매너평가 이후 매너온도 인서트
	public int insertTemp(MemberTemp memberTemp);
}
