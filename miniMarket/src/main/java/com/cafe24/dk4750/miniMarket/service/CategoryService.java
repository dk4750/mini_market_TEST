package com.cafe24.dk4750.miniMarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.dk4750.miniMarket.mapper.CategoryMapper;
import com.cafe24.dk4750.miniMarket.vo.Category;

@Service
@Transactional
public class CategoryService {
	@Autowired private CategoryMapper categoryMapper;
	
	// 카테고리 목록 가져오기
	public List<Category> getMemberCategory() {
		return categoryMapper.selectCategoryListByMember();
	}
	
	// 업체 카테고리 목록 가져오기
	public List<Category> getCompanyCategory() {
		return categoryMapper.selectCategoryListByCompany();
	}
	
	// 카테고리 추가하기 (관리자)
	public int addCategory(Category category) {
		return categoryMapper.insertCategory(category);
	}
}
