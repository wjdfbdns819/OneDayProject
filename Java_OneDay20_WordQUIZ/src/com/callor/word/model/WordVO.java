package com.callor.word.model;

public class WordVO {
	
	private String eng;
	private String kor;
	private Integer count;
	
	
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	@Override
	public String toString() {
		return "[영어 =" + eng + ", 뜻 =" + kor + ", count =" + count + "]";
	}
	

	
	
}
