package com.cafe24.dk4750.miniMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.NoticeMapper;
import com.cafe24.dk4750.miniMarket.vo.Notice;

@Service
@Transactional
public class NoticeService {
	@Autowired private NoticeMapper noticeMapper;
	
	// 공지사항 목록
	public Map<String, Object> getNoticeList(int beginRow, int rowPerPage, String searchWord) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 몇번째부터..
		map.put("beginRow", beginRow);
		// 페이지당 갯수..
		map.put("rowPerPage", rowPerPage);
		// 검색어!
		map.put("searchWord", searchWord);
		// 리스트의 토탈 카운트 수 + 조건 검색값이 있으면 검색값 추가하여 글 토탈 수를 구함
		int totalRow = 0;
		if(searchWord.equals("")) {
			totalRow = noticeMapper.totalNotice();
		} else {
			totalRow = noticeMapper.totalNoticeBySearch(searchWord);
		}
		
		System.out.println(totalRow+"<----게시물 총합 수");
		List<Notice> list = noticeMapper.selectNoticeList(map);
		// 마지막 페이지 번호 + 나머지 값이 있을 경우 마지막 페이지 값 +1
		int lastPage = totalRow / rowPerPage;
		if(totalRow % rowPerPage !=0) {
			lastPage += 1;
		}
		Map<String, Object> map2 = new HashMap<>();
		map2.put("list", list);
		map2.put("lastPage", lastPage);
		map2.put("totalRow", totalRow);
		System.out.println(map2+"<-------공지사항 서비스에 맵2값!!");
		return map2;
	}
	
	// 공지사항 자세히 보기
	public Notice getNoticeOne(int noticeNo) {
		return noticeMapper.selectNoticeOne(noticeNo);
	}
	
	// 공지사항 입력하기
	public int addNotice(Notice notice) {
		return noticeMapper.insertNotice(notice);
	}
	
	// 공지사항 수정하기
	public int modifyNotice(Notice notice) {
		return noticeMapper.updateNotice(notice);
	}
	
	
}
