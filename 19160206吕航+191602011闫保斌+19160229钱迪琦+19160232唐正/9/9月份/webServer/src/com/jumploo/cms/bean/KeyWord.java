package com.jumploo.cms.bean;

public class KeyWord {
	public int ID;
	public String KEYWORD;
	public String TYPE;
	public int SEQUENCE;
	
	
	public KeyWord(){
		ID=0;
		KEYWORD="KEYWORD";
		TYPE="TYPE";
		SEQUENCE=0;
	}
	
	public KeyWord(int id,String keyword,String type,int sequence){
		this.ID =id;
		this.KEYWORD =keyword;
		this.TYPE =type;
		this.SEQUENCE =sequence;
	}
}
