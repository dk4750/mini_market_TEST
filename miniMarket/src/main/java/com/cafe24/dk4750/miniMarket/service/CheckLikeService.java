package com.cafe24.dk4750.miniMarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.dk4750.miniMarket.mapper.MemberItemLikeMapper;
import com.cafe24.dk4750.miniMarket.vo.MemberItemLike;

@Service
public class CheckLikeService {
	@Autowired private MemberItemLikeMapper memberItemLikeMapper;
	
	// 좋아요 한 상품 등록하기
	// 해당 멤버가 해당 아이템에 좋아요 한게 없으면 insert, 좋아요 상태면 좋아요 취소
	public int likeCheck(MemberItemLike memberItemLike) {
		// start 디버깅
		System.out.println("CheckLikeService / likeCheck / start");
		
		// 해당멤버가 해당아이템을 좋아요 한 적이 있는지 체크.. 없다면 인서트
		Integer checkActive = memberItemLikeMapper.CheckLike(memberItemLike);
		System.out.println(memberItemLike.getLikeActive() + " <== Service likeCheck");
		if(checkActive == null) {
			memberItemLikeMapper.insertLikeItem(memberItemLike);
		} else {
			memberItemLikeMapper.updateLikeChange(memberItemLike);
		}
		
		Integer resultActive = memberItemLikeMapper.CheckLike2(memberItemLike);
		System.out.println(resultActive + "<== CheckListService 내 액티브 가져오기");
		return resultActive;
	}
	
	// 페이지 들어갈때 내 like active 구하기
	public Integer defaultLike(MemberItemLike memberItemLike) {
		Integer resultActive = memberItemLikeMapper.CheckLike2(memberItemLike);
		System.out.println(resultActive + "<== CheckListService 내 액티브 가져오기");
		return resultActive;
	}
}
