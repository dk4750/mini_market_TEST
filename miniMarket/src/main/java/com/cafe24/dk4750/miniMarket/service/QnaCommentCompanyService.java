package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.QnaCommentCompanyMapper;
import com.cafe24.dk4750.miniMarket.vo.QnaCommentCompany;

@Service
@Transactional
public class QnaCommentCompanyService {
	@Autowired
	private QnaCommentCompanyMapper qnaCommentCompanyMapper;
	
	
	// 댓글 삭제
	public int removeCommentCompany(int qnaCommentCompanyNo) {
		return qnaCommentCompanyMapper.deletQnaCommentCompany(qnaCommentCompanyNo);
	}
	// QnA 댓글 입력
	public int addQnaCommentCompany(QnaCommentCompany qnaCommentCompany) {
		return qnaCommentCompanyMapper.insertQnaCommentCompany(qnaCommentCompany);
	}
	// QnA 댓글 리스트 출력
	public Map<String, Object> getQnaCommentCompanyList(int currentPage, int qnaBoardCompanyNo) {
		int rowPerPage = 5;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("qnaBoardCompanyNo", qnaBoardCompanyNo);
		// lastPage
		int totalRow = qnaCommentCompanyMapper.getTotalRow();
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage를 Map에 담는다
		List<QnaCommentCompany> qnaCommentCompanyList = qnaCommentCompanyMapper.selectQnaCommentCompanyList(map);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("qnaCommentCompanyList", qnaCommentCompanyList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
}
