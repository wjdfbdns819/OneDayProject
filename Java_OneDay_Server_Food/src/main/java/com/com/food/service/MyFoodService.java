package com.com.food.service;

import java.util.List;

import com.com.food.model.MyFoodDTO;
import com.com.food.model.MyFoodVO;

public interface MyFoodService {

	// 섭취한 전체 식품 리스트 조회
	public List<MyFoodDTO> listAll();
	
	// 섭취한 식품 입력
	public String insert(MyFoodVO myfoodVO);
	
}
