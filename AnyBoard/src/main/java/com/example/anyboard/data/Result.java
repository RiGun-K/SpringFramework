package com.example.anyboard.data;

// @Entity 정의 하지 않음 , Repository 또한 생성하지 않았음 ! 
public class Result {
	
	private String result;
	
	public Result() { }
	public Result(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}

