package com.jumploo.cms.bean;

public class ScoreKey {
	public int ID;
	public int YEAR;
	public String PROVINCE;
	public String MAJOR;
	public String DISCIPLINE;
	public String BANCH;
	public int MAX;
	public int MIN;
	public double AVERAGE;
	public ScoreKey(){
		ID=0;
		YEAR=0;
		PROVINCE="PROVINCE";
		MAJOR="MAJOR";
		DISCIPLINE="DISCIPLINE";
		BANCH="BANCE";
		MAX=0;
		MIN=0;
		AVERAGE=0;
	}
	public ScoreKey(int id,int year,String province,String major,String discipline,String banch,int max,int min,double average){
		this.ID =id;
		this.YEAR =year;
		this.PROVINCE =province;
		this.MAJOR =major;
		this.DISCIPLINE =discipline;
		this.BANCH =banch;
		this.MAX =max;
		this.MIN =min;
		this.AVERAGE =average;
	}
	
}
