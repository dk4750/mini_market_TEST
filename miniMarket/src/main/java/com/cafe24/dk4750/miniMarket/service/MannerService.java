package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.MannerMapper;
import com.cafe24.dk4750.miniMarket.mapper.MemberTempMapper;
import com.cafe24.dk4750.miniMarket.mapper.MemberTempTotalMapper;
import com.cafe24.dk4750.miniMarket.vo.LoginMember;
import com.cafe24.dk4750.miniMarket.vo.Manner;
import com.cafe24.dk4750.miniMarket.vo.MemberTemp;

@Service
@Transactional
public class MannerService {
   @Autowired private MannerMapper mannerMapper;
   @Autowired private MemberTempMapper memberTempMapper;
   @Autowired private MemberTempTotalMapper memberTempTotalMapper;
   
   // good 매너 평가하기
   public int addGoodManner(HttpSession session, Manner manner) {
      // 매너평가하기
	  mannerMapper.insertGoodManner(manner);
	  System.out.println(manner+"<===============매너평가한 목록들");
	  System.out.println(manner.getMemberUniqueNo()+"매너평가한 목록에 멤버유니크 넘버");
	  System.out.println(manner.getMemberId()+"==매너평가한 목록에 멤버아이디");
     
      System.out.println(manner.getMemberItemNo() + " <== memberItemNo..");
      System.out.println(manner+"<--=-=-=-=-=매너평가 관련 값 확인 ;;;;");
      System.out.println(manner.getMemberUniqueNo()+"<=====멤버유니크 넘버 값 1111111");
      System.out.println(manner.getMemberId()+"<-=-=-=-=멤버아이디값 11111111111");
      // 매너평가 결과 템프에 insert하기.. manner에서 값 꺼내서 담아주기
      MemberTemp memberTemp = new MemberTemp();
      memberTemp.setMemberUniqueNo(manner.getMemberUniqueNo());
      memberTemp.setTempInsertScore(manner.getGoodManner());
      // 인서트 temp실행
      memberTempMapper.insertTemp(memberTemp);
      
      // tempTotal 부분.. 현재템프토탈과 해당멤버의 인서트스코어를 계산 후 새로 템프토탈 인서트하기
      String memberUniqueNo = manner.getMemberUniqueNo();
      double tempTotalNow = memberTempTotalMapper.selectTempTotalNow(memberUniqueNo);
      System.out.println(tempTotalNow + " <== 현재 템프토탈");
      
      // 최종 템프토탈 값을 구하고 인서트해주기
      double finalTempTotal = tempTotalNow + manner.getGoodManner();
      System.out.println(finalTempTotal + " <== 최종 tempTotal");
      // 인서트temp에 들어갈 값들을 담을 임시 맵 생성
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("memberUniqueNo", memberUniqueNo);
      map.put("memberTempTotal", finalTempTotal);
      // 인서트 실행
      memberTempTotalMapper.insertTempTotal(map);
      
      return 0;
   }
   
   // bad 매너 평가하기
   public int addBadManner(Manner manner) {
	  // 매너평가하기
      mannerMapper.insertBadManner(manner);
      System.out.println(manner.getMemberItemNo() + " <== memberItemNo..");
      System.out.println(manner+"<========매너 평가 서비스=====");
      // 매너평가 결과 템프에 insert하기.. manner에서 값 꺼내서 담아주기
      MemberTemp memberTemp = new MemberTemp();
      memberTemp.setMemberUniqueNo(manner.getMemberUniqueNo());
      memberTemp.setTempInsertScore(manner.getBadManner());
      // 인서트 temp실행
      memberTempMapper.insertTemp(memberTemp);
      
      // tempTotal 부분.. 현재템프토탈과 해당멤버의 인서트스코어를 계산 후 새로 템프토탈 인서트하기
      String memberUniqueNo = manner.getMemberUniqueNo();
      double tempTotalNow = memberTempTotalMapper.selectTempTotalNow(memberUniqueNo);
      System.out.println(tempTotalNow + " <== 현재 템프토탈");
      
      // 최종 템프토탈 값을 구하고 인서트해주기
      double finalTempTotal = tempTotalNow + manner.getBadManner();
      System.out.println(finalTempTotal + " <== 최종 tempTotal");
      // 인서트temp에 들어갈 값들을 담을 임시 맵 생성
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("memberUniqueNo", memberUniqueNo);
      map.put("memberTempTotal", finalTempTotal);
      // 인서트 실행
      memberTempTotalMapper.insertTempTotal(map);
      
      return 0;
   }
   
   // 해당 아이템에 매너평가를 한 적이 있는지 체크 
   public int mannerCheck(Manner manner) {
	   return mannerMapper.mannerCheck(manner);
   }
}