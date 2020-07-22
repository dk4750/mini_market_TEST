package com.cafe24.dk4750.miniMarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.QnaCommentMapper;
import com.cafe24.dk4750.miniMarket.vo.QnaCommentMember;

@Service
@Transactional
public class QnaCommentService {
	@Autowired QnaCommentMapper qnaCommentMapper;
	//댓글 삭제
	public int removeQnaCommentMember(int qnaCommentMemberNo) {
		System.out.println(qnaCommentMemberNo+"<----삭제 qnaCommentMemberNo 값");
		return qnaCommentMapper.deleteQnaCommentMember(qnaCommentMemberNo);
	}
	//댓글 추가
	public int addQnaCommentMember(QnaCommentMember qnaCommentMember) {
		String adminId = "admin";
		qnaCommentMember.setAdminId(adminId);
		System.out.println(qnaCommentMember +"<--service");
		return qnaCommentMapper.insertQnaCommentMember(qnaCommentMember);
	}
}
