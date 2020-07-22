package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.QnaBoardMapper;
import com.cafe24.dk4750.miniMarket.mapper.QnaCommentMapper;
import com.cafe24.dk4750.miniMarket.vo.QnaBoardMember;
import com.cafe24.dk4750.miniMarket.vo.QnaCommentMember;

@Service
@Transactional
public class QnaBoardService {
	
	@Autowired
	private QnaBoardMapper qnaBoardMapper;
	@Autowired
	private QnaCommentMapper qnaCommentMapper;
	
	//게시글 비활성화
	public int modifyQnaBoardMemberByActive(int qnaBoardMemberNo) {
		return qnaBoardMapper.updateQnaBoardMemberByActive(qnaBoardMemberNo);
	}
	//게시글 수정
	public int modifyQnaBoardMember(QnaBoardMember qnaBoardMember) {
		return qnaBoardMapper.updateQnaBoardMember(qnaBoardMember);
	}
	//게시글 추가
	public int addQnaBoardMember(QnaBoardMember qnaBoardMember) {
		return qnaBoardMapper.insertQnaBoardMember(qnaBoardMember);
	}
	
	//멤버 qna 상세보기 + 댓글 페이징
	public Map<String, Object> getQnaBoardMemberOne(int qnaBoardMemberNo , int beginRow, int rowPerPage) {
		Map<String, Object> map1 = new HashMap<>();
		map1.put("beginRow", beginRow);
		map1.put("rowPerPage", rowPerPage);
		map1.put("qnaBoardMemberNo", qnaBoardMemberNo);
		Map<String, Object> map2 = new HashMap<>();
		List<QnaCommentMember> list = qnaCommentMapper.selectQnaCommentList(map1);
		System.out.println(list + "<---service One LIST");
		QnaBoardMember qnaBoardMember = qnaBoardMapper.selectQnaBoardMemberOne(qnaBoardMemberNo);
		System.out.println(qnaBoardMember +"<---service qnaBOardMember");
		int totalRow = qnaCommentMapper.totalCountQnaCommentMember(qnaBoardMemberNo);
		System.out.println(totalRow +"<-- 게시글 총합 수");
		int lastPage = totalRow / rowPerPage;
		if(totalRow % rowPerPage != 0) {
			lastPage += 1;
		}
		System.out.println(lastPage);
		map2.put("list", list);
		map2.put("qnaBoardMember", qnaBoardMember);
		map2.put("lastPage", lastPage);
		return map2;
	}
	//게시글 리스트  + 페이징 + 검색
	public Map<String, Object> getQnaBoardMemberList(int beginRow , int rowPerPage, String qnaBoardMemberTitle){
		Map<String, Object> map1 = new HashMap<>();
		//현재 페이지
		map1.put("beginRow", beginRow);
		//페이지 당 몇개의 리스트
		map1.put("rowPerPage", rowPerPage);
		//페이징 + 리스트
		map1.put("qnaBoardMemberTitle", qnaBoardMemberTitle);
		//리스트의 토탈 카운트 수 + 조건 검색값이 있으면 검색값 추가하여 글 토탈 수를 구함
		int totalRow = 0;
		if(qnaBoardMemberTitle.equals("")) {
			totalRow = qnaBoardMapper.totalQnaBoard();
		}else {
			totalRow = qnaBoardMapper.totalQnaBoardBySearch(qnaBoardMemberTitle);
		}
		System.out.println(totalRow+"<---게시물 총합 수");
		List<QnaBoardMember> list = qnaBoardMapper.selectQnaBoardMember(beginRow, rowPerPage, qnaBoardMemberTitle);
		System.out.println(list.size() + "<---qnaBoardService list.size");
		
		System.out.println(totalRow+"<---service totalRow");
		//마지막 페이지 번호 + 나머지 값이 있을경우 마지막 페이지 값 +1
		int lastPage = totalRow / rowPerPage;
		if(totalRow % rowPerPage != 0) {
			lastPage += 1;
		}
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("list", list);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
}
