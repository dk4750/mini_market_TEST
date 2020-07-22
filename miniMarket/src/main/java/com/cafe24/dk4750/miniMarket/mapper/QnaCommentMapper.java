package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.QnaCommentMember;

@Mapper
public interface QnaCommentMapper {
	//댓글 삭제
	public int deleteQnaCommentMember(int qnaCommentMemberNo);
	//댓글 추가
	public int insertQnaCommentMember(QnaCommentMember qnaCommentMember);
	//댓글 리스트
	public List<QnaCommentMember> selectQnaCommentList(Map<String, Object> map);
	//댓글 총합수
	public int totalCountQnaCommentMember(int qnaBoardMemberNo);
	
}