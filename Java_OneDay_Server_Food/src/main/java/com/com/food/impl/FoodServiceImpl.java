package com.com.food.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.com.food.model.FoodDTO;
import com.com.food.persistence.DBContract;
import com.com.food.service.FoodService;

public class FoodServiceImpl implements FoodService{

	protected Connection dbConn;
	public FoodServiceImpl() {
		dbConn = DBContract.getDBConnection();
	}
	
	
	protected List<FoodDTO> select(PreparedStatement pStr) throws SQLException {
		
		List<FoodDTO> fdList = new ArrayList<FoodDTO>();
		
		ResultSet rStr = pStr.executeQuery();
		while(rStr.next()) {
			
			FoodDTO fdDTO = new FoodDTO();
			
			
			
			
		}
		
		
		
		return null;
		
	}
	
	@Override
	public List<FoodDTO> findByfname(String fd_fname) {
		// 식품명으로 검색
		
		String sql = " SELECT * FROM view_식품정보";
			sql += " WHERE 식품명 LIKE = ? || ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	}

	
}
