package com.jumploo.cms.bean;

public class ProblemKey {
	public int ID;
	public String KEYWORD;
	public String ANSWER;
	public ProblemKey(){
		ID=0;
		KEYWORD="KEYWORD";
		ANSWER="ANSWER";
	}
	public ProblemKey(int id,String keyword,String answer){
		this.ID =id;
		this.KEYWORD =keyword;
		this.ANSWER =answer;
	}
}
