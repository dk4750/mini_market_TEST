package com.cafe24.dk4750.miniMarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.MemberItemPic;


@Mapper
public interface MemberItemPicMapper {
	
	// 멤버 아이템 사진 추가
	public void insertMemberItemPic(MemberItemPic memberItemPic);
	
	// 멤버 아이템 사진 수정을 위한 기존 value값 가져오기
	public MemberItemPic selectMemberItemPicName(int memberItemNo);
	
	// 멤버 아이템 사진 수정
	public void updateMemberItemPic(MemberItemPic memberItemPic);
}
