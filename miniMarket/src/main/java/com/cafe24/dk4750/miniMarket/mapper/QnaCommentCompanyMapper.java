package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.QnaCommentCompany;

@Mapper
public interface QnaCommentCompanyMapper {
	// 댓글 삭제
	public int deletQnaCommentCompany(int qnaCommentCompanyNo);
	// 댓글 입력
	public int insertQnaCommentCompany(QnaCommentCompany qnaCommentCompany);
	// 댓글 페이지
	public int getTotalRow();
	// 댓글 리스트(업체)
	public List<QnaCommentCompany> selectQnaCommentCompanyList(Map<String, Object> map);
}
