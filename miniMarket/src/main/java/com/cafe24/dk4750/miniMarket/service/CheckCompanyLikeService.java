package com.cafe24.dk4750.miniMarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.CompanyItemLikeMapper;
import com.cafe24.dk4750.miniMarket.vo.CompanyItemLike;

@Service
@Transactional
public class CheckCompanyLikeService {
	@Autowired private CompanyItemLikeMapper companyItemLikeMapper;
	// 좋아요한 업체 상품 등록하기
	// 해당 멤버가 해당 업체아이템을 좋아요 한게 없으면 insert, 좋아요 상태면 좋아요 취소
	public int CheckCompanyLike(CompanyItemLike companyItemLike) {
		// 내가 이 업체에 좋아요 했는지 안했는지 확인
		Integer checkActive = companyItemLikeMapper.CheckCompanyItemLike(companyItemLike);
		if(checkActive == null) {
			companyItemLikeMapper.insertLikeCompanyItem(companyItemLike);
		} else {
			companyItemLikeMapper.updateCompanyItemLikeChange(companyItemLike);
		}
		// 내가 이업체에 라이크한 값을 가져온다
		Integer resultActive = companyItemLikeMapper.CheckCompanyItemLike2(companyItemLike);
		return resultActive;
	}
	// 페이지 들어 갈때 내 라이크 엑티브 구하기
	public Integer defaultLike(CompanyItemLike companyItemLike) {
		Integer resultActive = companyItemLikeMapper.CheckCompanyItemLike2(companyItemLike);
		return resultActive;
	}
}
