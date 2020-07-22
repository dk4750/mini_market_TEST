package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.QnaBoardMember;

@Mapper
public interface QnaBoardMapper {
	//검색시 글 토탈 수
	public int totalQnaBoardBySearch(String qnaBoardMemberTitle);
	//자주 묻는 질문 수정
	public int updateQnaBoardMember(QnaBoardMember qnaBoardMember);
	//게시글 비활성화
	public int updateQnaBoardMemberByActive(int qnaBoardMemberNo);
	//자주 묻는 질문 추가
	public int insertQnaBoardMember(QnaBoardMember qnaBoardMember);
	//멤버 qna 상세보기
	public QnaBoardMember selectQnaBoardMemberOne(int qnaBoardMemberNo);
	//멤버 qna 기타 게시글 리스트
	public List<QnaBoardMember> selectQnaBoardMember(int beginRow, int rowPerPage, String qnaBoardMemberTitle);
	//자주 묻는 질문(사용자) 글 토탈 수
	public int totalQnaBoard();
}