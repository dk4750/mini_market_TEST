package com.cafe24.dk4750.miniMarket.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.MemberReviewMapper;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.MemberReview;

@Service
@Transactional
public class MemberReviewService {
	@Autowired private MemberReviewMapper memberReviewMapper;
	
	//리뷰가 있는지 없는 지 체크 서비스
	public int reviewCheck(MemberReview memberReview) {
		return memberReviewMapper.reviewCheck(memberReview);
	}
	
	// 리뷰 작성하기 서비스 
	public int addReview(HttpSession session, MemberReview memberReview) {
		
		// 세션에서 내 아이디 넣기
		LoginMember loginMember = (LoginMember)session.getAttribute("loginMember");
		String memberId = loginMember.getMemberId();
		memberReview.setMemberId(memberId);
		
		// 판매자의 정보에서 ""를 제외한 정보를 가져오기 위해 섭스트링 한다
		String memberUniqueNo2 = memberReview.getMemberUniqueNoSale();
		String memberUniqueNo = memberUniqueNo2.substring(1, 8);
		memberReview.setMemberUniqueNo(memberUniqueNo);
		System.out.println(memberReview + "<== 인설트 리뷰 서비스");
		
		System.out.println(memberReview + " <== memberReview / 리뷰 서비스");
		
		return memberReviewMapper.insertReview(memberReview);
	}
}
