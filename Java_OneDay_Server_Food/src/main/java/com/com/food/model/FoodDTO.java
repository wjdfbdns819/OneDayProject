package com.com.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {

	private String fd_fname;
	private Integer fd_totalgram;
	private Integer fd_kcal = 0;
	private Integer fd_tan = 0;
	private Integer fd_dan = 0;
	private Integer fd_ge = 0;
	private Integer fd_suger = 0;
	
}
