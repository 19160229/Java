package com.jumploo.cms.util.keyword;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.jumploo.cms.bean.KeyWord;
import com.jumploo.cms.bean.ProblemKey;
import com.jumploo.cms.bean.ScoreKey;
import com.jumploo.cms.conf.SysDefine;
import com.jumploo.cms.log.LogManager;
import com.jumploo.cms.util.TimeTools;


public class KeyInterface {

	protected static final Logger runLog = LogManager.getLogManager().getRunLog();
	private static Connection conn=null;

	public List<Document> ConnectKeyword(String[] strArray,KeyWord[] keywords){
		List<Document>list=new ArrayList<>();
		try{
			int thisyear=Integer.parseInt( new TimeTools().getCurrentYear()); 				//add
			String[] strYear={""+thisyear,"今年",""+(thisyear-1),"去年",""+(thisyear-2),"前年",""+(thisyear-3),"大前年",""+(thisyear-4)};		//add
			conn=SysDefine.connPool.getConnection();
			boolean gradeKey=false;
			boolean disciplineKey=false;
			boolean provinceKey=false;
			boolean majorKey=false;
			boolean problemKey=false;
			boolean yearKey=false;		//add
			PreparedStatement pstmt=null;
			int problemNum=0;
			int disciplineNum=0;
			int majorNum=0;
			int provinceNum=0;
			int yearNum=0;			//add
			String strgrade="grade";
			String strproblem="problem";
			String strmajor="major";
			String strdiscipline="discipline";
			String strprocince="province";
			String stryear="year";  		//add
			int i=0;
			for(i=0;i<strArray.length ;i++){

				int j=0;
				for(j=0;j<keywords.length ;j++){


					if(strArray[i].equals(keywords[j].KEYWORD )){

						if(keywords[j].TYPE.equals(strgrade)){

							gradeKey=true;
						}else if(keywords[j].TYPE.equals(strproblem)){
							problemKey=true;
							problemNum=j;
						}else if(keywords[j].TYPE.equals(strmajor)){
							majorKey=true;
							majorNum=j;
						}else if(keywords[j].TYPE.equals(strdiscipline)){
							disciplineKey=true;
							disciplineNum=j;
						}else if(keywords[j].TYPE.equals(strprocince)){
							provinceKey=true;
							provinceNum=j;	
						}else if(keywords[j].TYPE.equals(stryear)){		//add
							yearKey=true;
							yearNum=j;
						}


					}

				}
			}

			if(gradeKey==true){

				ScoreKey scorekey=new ScoreKey();
				ScoreKey scoreResult=new ScoreKey();
				if(yearKey==true){
					if(keywords[yearNum].KEYWORD.equals(strYear[0])||keywords[yearNum].KEYWORD.equals(strYear[1])){
						scorekey.YEAR=thisyear;
					}else if(keywords[yearNum].KEYWORD.equals(strYear[2])||keywords[yearNum].KEYWORD.equals(strYear[3])){
						scorekey.YEAR=thisyear-1;
					}else if(keywords[yearNum].KEYWORD.equals(strYear[4])||keywords[yearNum].KEYWORD.equals(strYear[5])){
						scorekey.YEAR=thisyear-2;
					}else if(keywords[yearNum].KEYWORD.equals(strYear[6])||keywords[yearNum].KEYWORD.equals(strYear[7])){
						scorekey.YEAR=thisyear-3;
					}else if(keywords[yearNum].KEYWORD.equals(strYear[8])){
						scorekey.YEAR=thisyear-4;
					}
				}
				if(majorKey==true){
					scorekey.MAJOR =keywords[majorNum].KEYWORD ;
				}
				if(disciplineKey==true){
					scorekey.DISCIPLINE =keywords[disciplineNum].KEYWORD ;
				}
				if(provinceKey==true){
					scorekey.PROVINCE =keywords[provinceNum].KEYWORD ;
				}

				if(majorKey==true && disciplineKey==true && provinceKey==true){
					if(yearKey==true){
						String strSql="select * from score where MAJOR=? and DISCIPLINE=? and PROVINCE=? and YEAR=?";
						pstmt=conn.prepareStatement(strSql) ;
						pstmt.setString(1, scorekey.MAJOR);
						pstmt.setString(2, scorekey.DISCIPLINE);
						pstmt.setString(3, scorekey.PROVINCE);
						pstmt.setLong(4, scorekey.YEAR);

						ResultSet rsScore=pstmt.executeQuery();

						while(rsScore.next()){
							scoreResult.ID =rsScore.getInt("ID");
							scoreResult.YEAR =rsScore.getInt("YEAR");
							scoreResult.PROVINCE =rsScore.getString("PROVINCE");
							scoreResult.MAJOR =rsScore.getString("MAJOR");
							scoreResult.DISCIPLINE =rsScore.getString("DISCIPLINE");
							scoreResult.BANCH =rsScore.getString("BANCH");
							scoreResult.MAX =rsScore.getInt("MAX");
							scoreResult.MIN =rsScore.getInt("MIN");
							scoreResult.AVERAGE =rsScore.getDouble("AVERAGE");

							Document doc=new Document();
							doc.put("年份",scoreResult.YEAR);
							doc.put("省份",scoreResult.PROVINCE);
							doc.put("专业",scoreResult.MAJOR);
							doc.put("分科",scoreResult.DISCIPLINE);
							doc.put("类型",scoreResult.BANCH );
							doc.put("最高分",scoreResult.MAX);
							doc.put("最低分",scoreResult.MIN);
							doc.put("平均分",scoreResult.AVERAGE);
							list.add(doc);
							runLog.debug(" 年份: "+scoreResult.YEAR +" 省份: "+scoreResult.PROVINCE +" 专业: "+scoreResult.MAJOR +" 分科: "+scoreResult.DISCIPLINE +" 类型: "+scoreResult.BANCH +" 最高分: "+scoreResult.MAX +" 最低分: "+scoreResult.MIN +" 平均分: "+scoreResult.AVERAGE );
						}
					}else{					

						String strSql="select * from score where MAJOR=? and DISCIPLINE=? and PROVINCE=?";
						pstmt=conn.prepareStatement(strSql) ;
						pstmt.setString(1, scorekey.MAJOR);
						pstmt.setString(2, scorekey.DISCIPLINE);
						pstmt.setString(3, scorekey.PROVINCE);
						ResultSet rsScore=pstmt.executeQuery();

						while(rsScore.next()){
							scoreResult.ID =rsScore.getInt("ID");
							scoreResult.YEAR =rsScore.getInt("YEAR");
							scoreResult.PROVINCE =rsScore.getString("PROVINCE");
							scoreResult.MAJOR =rsScore.getString("MAJOR");
							scoreResult.DISCIPLINE =rsScore.getString("DISCIPLINE");
							scoreResult.BANCH =rsScore.getString("BANCH");
							scoreResult.MAX =rsScore.getInt("MAX");
							scoreResult.MIN =rsScore.getInt("MIN");
							scoreResult.AVERAGE =rsScore.getDouble("AVERAGE");

							Document doc=new Document();
							doc.put("年份",scoreResult.YEAR);
							doc.put("省份",scoreResult.PROVINCE);
							doc.put("专业",scoreResult.MAJOR);
							doc.put("分科",scoreResult.DISCIPLINE);
							doc.put("类型",scoreResult.BANCH );
							doc.put("最高分",scoreResult.MAX);
							doc.put("最低分",scoreResult.MIN);
							doc.put("平均分",scoreResult.AVERAGE);
							list.add(doc);
							runLog.debug(" 年份: "+scoreResult.YEAR +" 省份: "+scoreResult.PROVINCE +" 专业: "+scoreResult.MAJOR +" 分科: "+scoreResult.DISCIPLINE +" 类型: "+scoreResult.BANCH +" 最高分: "+scoreResult.MAX +" 最低分: "+scoreResult.MIN +" 平均分: "+scoreResult.AVERAGE );
						}
						
					}
					pstmt.close();
				}else if(majorKey==true && disciplineKey==true && provinceKey==false){
					if(yearKey==true){
						String strSql="select * from score where MAJOR=? and DISCIPLINE=? and YEAR=?";
						pstmt=conn.prepareStatement(strSql) ;
						pstmt.setString(1, scorekey.MAJOR);
						pstmt.setString(2, scorekey.DISCIPLINE);
						pstmt.setLong(3, scorekey.YEAR);
						ResultSet rsScore=pstmt.executeQuery();
						while(rsScore.next()){
							scoreResult.ID =rsScore.getInt("ID");
							scoreResult.YEAR =rsScore.getInt("YEAR");
							scoreResult.PROVINCE =rsScore.getString("PROVINCE");
							scoreResult.MAJOR =rsScore.getString("MAJOR");
							scoreResult.DISCIPLINE =rsScore.getString("DISCIPLINE");
							scoreResult.BANCH =rsScore.getString("BANCH");
							scoreResult.MAX =rsScore.getInt("MAX");
							scoreResult.MIN =rsScore.getInt("MIN");
							scoreResult.AVERAGE =rsScore.getDouble("AVERAGE");
							Document doc=new Document();
							doc.put("年份",scoreResult.YEAR);
							doc.put("省份",scoreResult.PROVINCE);
							doc.put("专业",scoreResult.MAJOR);
							doc.put("分科",scoreResult.DISCIPLINE);
							doc.put("类型",scoreResult.BANCH );
							doc.put("最高分",scoreResult.MAX);
							doc.put("最低分",scoreResult.MIN);
							doc.put("平均分",scoreResult.AVERAGE);
							list.add(doc);
							runLog.debug(" 年份: "+scoreResult.YEAR +" 省份: "+scoreResult.PROVINCE +" 专业: "+scoreResult.MAJOR +" 分科: "+scoreResult.DISCIPLINE +" 类型: "+scoreResult.BANCH +" 最高分: "+scoreResult.MAX +" 最低分: "+scoreResult.MIN +" 平均分: "+scoreResult.AVERAGE );
						}
					}else{
						String strSql="select * from score where MAJOR=? and DISCIPLINE=? ";
						pstmt=conn.prepareStatement(strSql) ;
						pstmt.setString(1, scorekey.MAJOR);
						pstmt.setString(2, scorekey.DISCIPLINE);

						ResultSet rsScore=pstmt.executeQuery();
						while(rsScore.next()){
							scoreResult.ID =rsScore.getInt("ID");
							scoreResult.YEAR =rsScore.getInt("YEAR");
							scoreResult.PROVINCE =rsScore.getString("PROVINCE");
							scoreResult.MAJOR =rsScore.getString("MAJOR");
							scoreResult.DISCIPLINE =rsScore.getString("DISCIPLINE");
							scoreResult.BANCH =rsScore.getString("BANCH");
							scoreResult.MAX =rsScore.getInt("MAX");
							scoreResult.MIN =rsScore.getInt("MIN");
							scoreResult.AVERAGE =rsScore.getDouble("AVERAGE");
							Document doc=new Document();
							doc.put("年份",scoreResult.YEAR);
							doc.put("省份",scoreResult.PROVINCE);
							doc.put("专业",scoreResult.MAJOR);
							doc.put("分科",scoreResult.DISCIPLINE);
							doc.put("类型",scoreResult.BANCH );
							doc.put("最高分",scoreResult.MAX);
							doc.put("最低分",scoreResult.MIN);
							doc.put("平均分",scoreResult.AVERAGE);
							list.add(doc);
							runLog.debug(" 年份: "+scoreResult.YEAR +" 省份: "+scoreResult.PROVINCE +" 专业: "+scoreResult.MAJOR +" 分科: "+scoreResult.DISCIPLINE +" 类型: "+scoreResult.BANCH +" 最高分: "+scoreResult.MAX +" 最低分: "+scoreResult.MIN +" 平均分: "+scoreResult.AVERAGE );
						}
						pstmt.close();
					}
					
				}else if(majorKey==true && disciplineKey==false && provinceKey==true){
					if(yearKey==true){
						String strSql="select * from score where MAJOR=?  and PROVINCE=? and YEAR=?";
						pstmt=conn.prepareStatement(strSql) ;
						pstmt.setString(1, scorekey.MAJOR);
						pstmt.setString(2, scorekey.PROVINCE);
						pstmt.setLong(3, scorekey.YEAR);
						ResultSet rsScore=pstmt.executeQuery();
						while(rsScore.next()){
							scoreResult.ID =rsScore.getInt("ID");
							scoreResult.YEAR =rsScore.getInt("YEAR");
							scoreResult.PROVINCE =rsScore.getString("PROVINCE");
							scoreResult.MAJOR =rsScore.getString("MAJOR");
							scoreResult.DISCIPLINE =rsScore.getString("DISCIPLINE");
							scoreResult.BANCH =rsScore.getString("BANCH");
							scoreResult.MAX =rsScore.getInt("MAX");
							scoreResult.MIN =rsScore.getInt("MIN");
							scoreResult.AVERAGE =rsScore.getDouble("AVERAGE");
							Document doc=new Document();
							doc.put("年份",scoreResult.YEAR);
							doc.put("省份",scoreResult.PROVINCE);
							doc.put("专业",scoreResult.MAJOR);
							doc.put("分科",scoreResult.DISCIPLINE);
							doc.put("类型",scoreResult.BANCH );
							doc.put("最高分",scoreResult.MAX);
							doc.put("最低分",scoreResult.MIN);
							doc.put("平均分",scoreResult.AVERAGE);
							list.add(doc);
							runLog.debug(" 年份: "+scoreResult.YEAR +" 省份: "+scoreResult.PROVINCE +" 专业: "+scoreResult.MAJOR +" 分科: "+scoreResult.DISCIPLINE +" 类型: "+scoreResult.BANCH +" 最高分: "+scoreResult.MAX +" 最低分: "+scoreResult.MIN +" 平均分: "+scoreResult.AVERAGE );
						}
					}else{
						String strSql="select * from score where MAJOR=?  and PROVINCE=?";
						pstmt=conn.prepareStatement(strSql) ;
						pstmt.setString(1, scorekey.MAJOR);

						pstmt.setString(2, scorekey.PROVINCE);
						ResultSet rsScore=pstmt.executeQuery();
						while(rsScore.next()){
							scoreResult.ID =rsScore.getInt("ID");
							scoreResult.YEAR =rsScore.getInt("YEAR");
							scoreResult.PROVINCE =rsScore.getString("PROVINCE");
							scoreResult.MAJOR =rsScore.getString("MAJOR");
							scoreResult.DISCIPLINE =rsScore.getString("DISCIPLINE");
							scoreResult.BANCH =rsScore.getString("BANCH");
							scoreResult.MAX =rsScore.getInt("MAX");
							scoreResult.MIN =rsScore.getInt("MIN");
							scoreResult.AVERAGE =rsScore.getDouble("AVERAGE");
							Document doc=new Document();
							doc.put("年份",scoreResult.YEAR);
							doc.put("省份",scoreResult.PROVINCE);
							doc.put("专业",scoreResult.MAJOR);
							doc.put("分科",scoreResult.DISCIPLINE);
							doc.put("类型",scoreResult.BANCH );
							doc.put("最高分",scoreResult.MAX);
							doc.put("最低分",scoreResult.MIN);
							doc.put("平均分",scoreResult.AVERAGE);
							list.add(doc);
							runLog.debug(" 年份: "+scoreResult.YEAR +" 省份: "+scoreResult.PROVINCE +" 专业: "+scoreResult.MAJOR +" 分科: "+scoreResult.DISCIPLINE +" 类型: "+scoreResult.BANCH +" 最高分: "+scoreResult.MAX +" 最低分: "+scoreResult.MIN +" 平均分: "+scoreResult.AVERAGE );
						}
					}
					pstmt.close();
				}else if(majorKey==false && disciplineKey==true && provinceKey==true){
					if(yearKey==true){
						String strSql="select * from score where  DISCIPLINE=? and PROVINCE=? and YEAR=?";
						pstmt=conn.prepareStatement(strSql) ;

						pstmt.setString(1, scorekey.DISCIPLINE);
						pstmt.setString(2, scorekey.PROVINCE);
						pstmt.setLong(3, scorekey.YEAR);
						ResultSet rsScore=pstmt.executeQuery();
						while(rsScore.next()){
							scoreResult.ID =rsScore.getInt("ID");
							scoreResult.YEAR =rsScore.getInt("YEAR");
							scoreResult.PROVINCE =rsScore.getString("PROVINCE");
							scoreResult.MAJOR =rsScore.getString("MAJOR");
							scoreResult.DISCIPLINE =rsScore.getString("DISCIPLINE");
							scoreResult.BANCH =rsScore.getString("BANCH");
							scoreResult.MAX =rsScore.getInt("MAX");
							scoreResult.MIN =rsScore.getInt("MIN");
							scoreResult.AVERAGE =rsScore.getDouble("AVERAGE");
							Document doc=new Document();
							doc.put("年份",scoreResult.YEAR);
							doc.put("省份",scoreResult.PROVINCE);
							doc.put("专业",scoreResult.MAJOR);
							doc.put("分科",scoreResult.DISCIPLINE);
							doc.put("类型",scoreResult.BANCH );
							doc.put("最高分",scoreResult.MAX);
							doc.put("最低分",scoreResult.MIN);
							doc.put("平均分",scoreResult.AVERAGE);
							list.add(doc);
							runLog.debug(" 年份: "+scoreResult.YEAR +" 省份: "+scoreResult.PROVINCE +" 专业: "+scoreResult.MAJOR +" 分科: "+scoreResult.DISCIPLINE +" 类型: "+scoreResult.BANCH +" 最高分: "+scoreResult.MAX +" 最低分: "+scoreResult.MIN +" 平均分: "+scoreResult.AVERAGE );
						}
					}else{
						String strSql="select * from score where  DISCIPLINE=? and PROVINCE=?";
						pstmt=conn.prepareStatement(strSql) ;

						pstmt.setString(1, scorekey.DISCIPLINE);
						pstmt.setString(2, scorekey.PROVINCE);
						ResultSet rsScore=pstmt.executeQuery();
						while(rsScore.next()){
							scoreResult.ID =rsScore.getInt("ID");
							scoreResult.YEAR =rsScore.getInt("YEAR");
							scoreResult.PROVINCE =rsScore.getString("PROVINCE");
							scoreResult.MAJOR =rsScore.getString("MAJOR");
							scoreResult.DISCIPLINE =rsScore.getString("DISCIPLINE");
							scoreResult.BANCH =rsScore.getString("BANCH");
							scoreResult.MAX =rsScore.getInt("MAX");
							scoreResult.MIN =rsScore.getInt("MIN");
							scoreResult.AVERAGE =rsScore.getDouble("AVERAGE");
							Document doc=new Document();
							doc.put("年份",scoreResult.YEAR);
							doc.put("省份",scoreResult.PROVINCE);
							doc.put("专业",scoreResult.MAJOR);
							doc.put("分科",scoreResult.DISCIPLINE);
							doc.put("类型",scoreResult.BANCH );
							doc.put("最高分",scoreResult.MAX);
							doc.put("最低分",scoreResult.MIN);
							doc.put("平均分",scoreResult.AVERAGE);
							list.add(doc);
							runLog.debug(" 年份: "+scoreResult.YEAR +" 省份: "+scoreResult.PROVINCE +" 专业: "+scoreResult.MAJOR +" 分科: "+scoreResult.DISCIPLINE +" 类型: "+scoreResult.BANCH +" 最高分: "+scoreResult.MAX +" 最低分: "+scoreResult.MIN +" 平均分: "+scoreResult.AVERAGE );
						}
					}
					pstmt.close();
				}else if(majorKey==true && disciplineKey==false && provinceKey==false){
					if(yearKey==true){
						String strSql="select * from score where MAJOR=? and YEAR=?";
						pstmt=conn.prepareStatement(strSql) ;
						pstmt.setString(1, scorekey.MAJOR);
						pstmt.setLong(2, scorekey.YEAR);
						ResultSet rsScore=pstmt.executeQuery();
						while(rsScore.next()){
							scoreResult.ID =rsScore.getInt("ID");
							scoreResult.YEAR =rsScore.getInt("YEAR");
							scoreResult.PROVINCE =rsScore.getString("PROVINCE");
							scoreResult.MAJOR =rsScore.getString("MAJOR");
							scoreResult.DISCIPLINE =rsScore.getString("DISCIPLINE");
							scoreResult.BANCH =rsScore.getString("BANCH");
							scoreResult.MAX =rsScore.getInt("MAX");
							scoreResult.MIN =rsScore.getInt("MIN");
							scoreResult.AVERAGE =rsScore.getDouble("AVERAGE");
							Document doc=new Document();
							doc.put("年份",scoreResult.YEAR);
							doc.put("省份",scoreResult.PROVINCE);
							doc.put("专业",scoreResult.MAJOR);
							doc.put("分科",scoreResult.DISCIPLINE);
							doc.put("类型",scoreResult.BANCH );
							doc.put("最高分",scoreResult.MAX);
							doc.put("最低分",scoreResult.MIN);
							doc.put("平均分",scoreResult.AVERAGE);
							list.add(doc);
							runLog.debug(" 年份: "+scoreResult.YEAR +" 省份: "+scoreResult.PROVINCE +" 专业: "+scoreResult.MAJOR +" 分科: "+scoreResult.DISCIPLINE +" 类型: "+scoreResult.BANCH +" 最高分: "+scoreResult.MAX +" 最低分: "+scoreResult.MIN +" 平均分: "+scoreResult.AVERAGE );
						}
					}else{
						String strSql="select * from score where MAJOR=? ";
						pstmt=conn.prepareStatement(strSql) ;
						pstmt.setString(1, scorekey.MAJOR);

						ResultSet rsScore=pstmt.executeQuery();
						while(rsScore.next()){
							scoreResult.ID =rsScore.getInt("ID");
							scoreResult.YEAR =rsScore.getInt("YEAR");
							scoreResult.PROVINCE =rsScore.getString("PROVINCE");
							scoreResult.MAJOR =rsScore.getString("MAJOR");
							scoreResult.DISCIPLINE =rsScore.getString("DISCIPLINE");
							scoreResult.BANCH =rsScore.getString("BANCH");
							scoreResult.MAX =rsScore.getInt("MAX");
							scoreResult.MIN =rsScore.getInt("MIN");
							scoreResult.AVERAGE =rsScore.getDouble("AVERAGE");
							Document doc=new Document();
							doc.put("年份",scoreResult.YEAR);
							doc.put("省份",scoreResult.PROVINCE);
							doc.put("专业",scoreResult.MAJOR);
							doc.put("分科",scoreResult.DISCIPLINE);
							doc.put("类型",scoreResult.BANCH );
							doc.put("最高分",scoreResult.MAX);
							doc.put("最低分",scoreResult.MIN);
							doc.put("平均分",scoreResult.AVERAGE);
							list.add(doc);
							runLog.debug(" 年份: "+scoreResult.YEAR +" 省份: "+scoreResult.PROVINCE +" 专业: "+scoreResult.MAJOR +" 分科: "+scoreResult.DISCIPLINE +" 类型: "+scoreResult.BANCH +" 最高分: "+scoreResult.MAX +" 最低分: "+scoreResult.MIN +" 平均分: "+scoreResult.AVERAGE );
						}
					}
					pstmt.close();
				}else if(majorKey==false && disciplineKey==true && provinceKey==false){
					if(yearKey==true){
						String strSql="select * from score where DISCIPLINE=? and YEAR=?";
						pstmt=conn.prepareStatement(strSql) ;

						pstmt.setString(1, scorekey.DISCIPLINE);
						pstmt.setLong(2, scorekey.YEAR);
						ResultSet rsScore=pstmt.executeQuery();
						while(rsScore.next()){
							scoreResult.ID =rsScore.getInt("ID");
							scoreResult.YEAR =rsScore.getInt("YEAR");
							scoreResult.PROVINCE =rsScore.getString("PROVINCE");
							scoreResult.MAJOR =rsScore.getString("MAJOR");
							scoreResult.DISCIPLINE =rsScore.getString("DISCIPLINE");
							scoreResult.BANCH =rsScore.getString("BANCH");
							scoreResult.MAX =rsScore.getInt("MAX");
							scoreResult.MIN =rsScore.getInt("MIN");
							scoreResult.AVERAGE =rsScore.getDouble("AVERAGE");
							Document doc=new Document();
							doc.put("年份",scoreResult.YEAR);
							doc.put("省份",scoreResult.PROVINCE);
							doc.put("专业",scoreResult.MAJOR);
							doc.put("分科",scoreResult.DISCIPLINE);
							doc.put("类型",scoreResult.BANCH );
							doc.put("最高分",scoreResult.MAX);
							doc.put("最低分",scoreResult.MIN);
							doc.put("平均分",scoreResult.AVERAGE);
							list.add(doc);
							runLog.debug(" 年份: "+scoreResult.YEAR +" 省份: "+scoreResult.PROVINCE +" 专业: "+scoreResult.MAJOR +" 分科: "+scoreResult.DISCIPLINE +" 类型: "+scoreResult.BANCH +" 最高分: "+scoreResult.MAX +" 最低分: "+scoreResult.MIN +" 平均分: "+scoreResult.AVERAGE );
						}
					}else{
						String strSql="select * from score where DISCIPLINE=? ";
						pstmt=conn.prepareStatement(strSql) ;

						pstmt.setString(1, scorekey.DISCIPLINE);

						ResultSet rsScore=pstmt.executeQuery();
						while(rsScore.next()){
							scoreResult.ID =rsScore.getInt("ID");
							scoreResult.YEAR =rsScore.getInt("YEAR");
							scoreResult.PROVINCE =rsScore.getString("PROVINCE");
							scoreResult.MAJOR =rsScore.getString("MAJOR");
							scoreResult.DISCIPLINE =rsScore.getString("DISCIPLINE");
							scoreResult.BANCH =rsScore.getString("BANCH");
							scoreResult.MAX =rsScore.getInt("MAX");
							scoreResult.MIN =rsScore.getInt("MIN");
							scoreResult.AVERAGE =rsScore.getDouble("AVERAGE");
							Document doc=new Document();
							doc.put("年份",scoreResult.YEAR);
							doc.put("省份",scoreResult.PROVINCE);
							doc.put("专业",scoreResult.MAJOR);
							doc.put("分科",scoreResult.DISCIPLINE);
							doc.put("类型",scoreResult.BANCH );
							doc.put("最高分",scoreResult.MAX);
							doc.put("最低分",scoreResult.MIN);
							doc.put("平均分",scoreResult.AVERAGE);
							list.add(doc);
							runLog.debug(" 年份: "+scoreResult.YEAR +" 省份: "+scoreResult.PROVINCE +" 专业: "+scoreResult.MAJOR +" 分科: "+scoreResult.DISCIPLINE +" 类型: "+scoreResult.BANCH +" 最高分: "+scoreResult.MAX +" 最低分: "+scoreResult.MIN +" 平均分: "+scoreResult.AVERAGE );
						}
					}
					pstmt.close();
				}else if(majorKey==false && disciplineKey==false && provinceKey==true){
					if(yearKey==true){
						String strSql="select * from score where PROVINCE=? and YEAR=?";
						pstmt=conn.prepareStatement(strSql) ;

						pstmt.setString(1, scorekey.PROVINCE);
						pstmt.setLong(2, scorekey.YEAR);
						ResultSet rsScore=pstmt.executeQuery();
						while(rsScore.next()){
							scoreResult.ID =rsScore.getInt("ID");
							scoreResult.YEAR =rsScore.getInt("YEAR");
							scoreResult.PROVINCE =rsScore.getString("PROVINCE");
							scoreResult.MAJOR =rsScore.getString("MAJOR");
							scoreResult.DISCIPLINE =rsScore.getString("DISCIPLINE");
							scoreResult.BANCH =rsScore.getString("BANCH");
							scoreResult.MAX =rsScore.getInt("MAX");
							scoreResult.MIN =rsScore.getInt("MIN");
							scoreResult.AVERAGE =rsScore.getDouble("AVERAGE");
							Document doc=new Document();
							doc.put("年份",scoreResult.YEAR);
							doc.put("省份",scoreResult.PROVINCE);
							doc.put("专业",scoreResult.MAJOR);
							doc.put("分科",scoreResult.DISCIPLINE);
							doc.put("类型",scoreResult.BANCH );
							doc.put("最高分",scoreResult.MAX);
							doc.put("最低分",scoreResult.MIN);
							doc.put("平均分",scoreResult.AVERAGE);
							list.add(doc);
							runLog.debug(" 年份: "+scoreResult.YEAR +" 省份: "+scoreResult.PROVINCE +" 专业: "+scoreResult.MAJOR +" 分科: "+scoreResult.DISCIPLINE +" 类型: "+scoreResult.BANCH +" 最高分: "+scoreResult.MAX +" 最低分: "+scoreResult.MIN +" 平均分: "+scoreResult.AVERAGE );
						}
					}else{
						String strSql="select * from score where PROVINCE=?";
						pstmt=conn.prepareStatement(strSql) ;

						pstmt.setString(1, scorekey.PROVINCE);
						ResultSet rsScore=pstmt.executeQuery();
						while(rsScore.next()){
							scoreResult.ID =rsScore.getInt("ID");
							scoreResult.YEAR =rsScore.getInt("YEAR");
							scoreResult.PROVINCE =rsScore.getString("PROVINCE");
							scoreResult.MAJOR =rsScore.getString("MAJOR");
							scoreResult.DISCIPLINE =rsScore.getString("DISCIPLINE");
							scoreResult.BANCH =rsScore.getString("BANCH");
							scoreResult.MAX =rsScore.getInt("MAX");
							scoreResult.MIN =rsScore.getInt("MIN");
							scoreResult.AVERAGE =rsScore.getDouble("AVERAGE");
							Document doc=new Document();
							doc.put("年份",scoreResult.YEAR);
							doc.put("省份",scoreResult.PROVINCE);
							doc.put("专业",scoreResult.MAJOR);
							doc.put("分科",scoreResult.DISCIPLINE);
							doc.put("类型",scoreResult.BANCH );
							doc.put("最高分",scoreResult.MAX);
							doc.put("最低分",scoreResult.MIN);
							doc.put("平均分",scoreResult.AVERAGE);
							list.add(doc);
							runLog.debug(" 年份: "+scoreResult.YEAR +" 省份: "+scoreResult.PROVINCE +" 专业: "+scoreResult.MAJOR +" 分科: "+scoreResult.DISCIPLINE +" 类型: "+scoreResult.BANCH +" 最高分: "+scoreResult.MAX +" 最低分: "+scoreResult.MIN +" 平均分: "+scoreResult.AVERAGE );
						}
					}
					pstmt.close();
				}else if(majorKey==false && disciplineKey==false && provinceKey==false){
					list.add(new Document("error","信息过少"));
					runLog.debug("信息太少！" );
				}

			}else if(problemKey==true){
				ProblemKey prokey=new ProblemKey();
				ProblemKey proResult=new ProblemKey();
				prokey.KEYWORD =keywords[problemNum].KEYWORD ;
				String strSql="select * from problem where KEYWORD=?";
				pstmt=conn.prepareStatement(strSql) ;
				pstmt.setString(1, prokey.KEYWORD );
				ResultSet rsProblem=pstmt.executeQuery();
				while(rsProblem.next()){
					proResult.ID =rsProblem.getInt("ID");
					proResult.KEYWORD =rsProblem.getString("KEYWORD");
					proResult.ANSWER =rsProblem.getString("ANSWER");
					list.add(new Document("answer",proResult.ANSWER));
					runLog.debug(proResult.ANSWER );
				}
				pstmt.close();
			}else if(problemKey==false&&gradeKey==false){
				ProblemKey proResult=new ProblemKey();
				String strSql="select * from problem where KEYWORD=?";
				pstmt=conn.prepareStatement(strSql) ;
				pstmt.setString(1, "零关键词" );
				ResultSet rsProblem=pstmt.executeQuery();
				while(rsProblem.next()){
					proResult.ID =rsProblem.getInt("ID");
					proResult.KEYWORD =rsProblem.getString("KEYWORD");
					proResult.ANSWER =rsProblem.getString("ANSWER");
					list.add(new Document("answer",proResult.ANSWER));
					runLog.debug(proResult.ANSWER );
				}
			}
			SysDefine.connPool.returnConnection(conn);
		}catch(Exception ex){
			runLog.debug(ex.getStackTrace());
		}
		return list;
		
	}

}
