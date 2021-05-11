package com.com.food.service;

import java.util.List;

import com.com.food.model.FoodDTO;

public interface FoodService {
	
	// 식품명으로 검색
	public List<FoodDTO> findByfname(String fd_fname);
	
}