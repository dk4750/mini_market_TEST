package com.cafe24.dk4750.miniMarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.CompanyItemPic;

@Mapper
public interface CompanyItemPicMapper {
	
	// 업체아이템 사진 추가하기 
	public void insertCompanyItemPic(CompanyItemPic companyItemPic);
	
	// 업체 아이템 사진 수정을 위한 기존 value값 가져오기
	public CompanyItemPic selectCompanyItemPicName(int companyItemNo);
	
	// 업체아이템 사진 수정
	public void updateCompanyItemPic(CompanyItemPic companyItemPic);

}
