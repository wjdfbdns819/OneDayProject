package com.callor.word;

import com.callor.word.impl.WordServiceImplV1;
import com.callor.word.service.WordService;

public class WordEx_01 {

	public static void main(String[] args) {
		
		WordService wSerivce = new WordServiceImplV1();
		wSerivce.menuWord();
		
	}
}
