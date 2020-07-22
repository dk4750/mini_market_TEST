package com.cafe24.dk4750.miniMarket.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.dk4750.miniMarket.vo.Notice;

@Mapper
public interface NoticeMapper {
	
	// 글의 총갯수
	public int totalNotice();
	
	// 검색어의 총갯수
	public int totalNoticeBySearch(String searchWord);
	
	// 공지사항 리스트
	public List<Notice> selectNoticeList(Map<String, Object> map);

	// 공지사항 상세히 보기
	public Notice selectNoticeOne(int noticeNo);
	
	// 공지사항 작성하기
	public int insertNotice(Notice notice);
	
	// 공지사항 수정
	public int updateNotice(Notice notice);
}
