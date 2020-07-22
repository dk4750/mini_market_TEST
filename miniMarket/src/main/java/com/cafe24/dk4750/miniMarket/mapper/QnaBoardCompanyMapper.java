package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.QnaBoardCompany;
import com.cafe24.dk4750.miniMarket.vo.QnaBoardCompanyAndCompany;

@Mapper
public interface QnaBoardCompanyMapper {
	// 검색시 글 토탈 수
	public int totalQnaBoardCompanyBySearch(String searchWord);
	// 삭제시 active가 1로 수정하여 비활성화
	public int updateQnaBoardCompanyActive(int qnaBoardCompanyNo);
	// QnA 수정
	public int updateQnaBoardCompany(QnaBoardCompany qnaBoardCompany);
	// QnA 입력
	public int insertQnaBoardCompany(QnaBoardCompany qnaBoardCompany);
	// 상세보기 페이지
	public QnaBoardCompanyAndCompany selectQnaBoardCompanyOne(int qnaBoardCompanyNo);
	// 총 페이지 (lastPage)
	public int getTotalRow();
	// QnA리스트 출력 (페이징, 검색)
	public List<QnaBoardCompanyAndCompany> selectQnaBoardCompanyList(Map<String, Object> map);
}
