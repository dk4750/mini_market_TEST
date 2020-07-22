package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.QnaBoardCompanyMapper;
import com.cafe24.dk4750.miniMarket.vo.QnaBoardCompany;
import com.cafe24.dk4750.miniMarket.vo.QnaBoardCompanyAndCompany;

@Service
@Transactional
public class QnaBoardCompanyService {
	@Autowired
	private QnaBoardCompanyMapper qnaBoardCompanyMapper;
	
	// QnA 리스트에서 삭제시 비활성화
	public int modifyQnaBoardCompanyActive(int qnaBoardCompanyNo) {
		return qnaBoardCompanyMapper.updateQnaBoardCompanyActive(qnaBoardCompanyNo);
	}
	// QnA 수정
	public int modifyQnaBoardCompany(QnaBoardCompany qnaBoardCompany) {
		return qnaBoardCompanyMapper.updateQnaBoardCompany(qnaBoardCompany);
	}
	// QnA 입력
	public int addQnaBoardCompany(QnaBoardCompany qnaBoardCompany) {
		return qnaBoardCompanyMapper.insertQnaBoardCompany(qnaBoardCompany);
	}
	// QnA리스트 상세보기
	public QnaBoardCompanyAndCompany getQnaBoardCompanyOne(int qnaBoardCompanyNo) {
		return qnaBoardCompanyMapper.selectQnaBoardCompanyOne(qnaBoardCompanyNo);
	}
	// QnA리스트 출력
	public Map<String, Object> getQnaBoardCompanyList(int currentPage, String searchWord) {
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		
		// lastPage
		int totalRow = qnaBoardCompanyMapper.totalQnaBoardCompanyBySearch(searchWord);
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage += 1;
		}
		// list와 lastPage를 Map에 담는다
		List<QnaBoardCompanyAndCompany> qnaBoardCompanyBoardList = qnaBoardCompanyMapper.selectQnaBoardCompanyList(map);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("qnaBoardCompanyBoardList", qnaBoardCompanyBoardList);
		map2.put("lastPage", lastPage);
		
		return map2;
	}
}
