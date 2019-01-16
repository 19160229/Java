package com.jumploo.cms.db.dao.impl;



import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.jumploo.cms.bean.Question;
import com.jumploo.cms.db.dao.AnswerDao;
import com.jumploo.cms.log.LogManager;
import com.jumploo.cms.util.keyword.KeyWordFilter;


public class AnswerDaoImpl implements AnswerDao{
	private static AnswerDao AnswerDao = new AnswerDaoImpl();

	static AnswerDao getAnswerDao() {
		return AnswerDao;
	}
	protected static Logger runLog = LogManager.getLogManager().getRunLog();

	@Override
	public List<Document> getAnswer(Question qes)  {
		// TODO 自动生成的方法存根
		List<Document>list=new ArrayList<>();    //返回list（使用自定义bean为元素类型）
		try {
		String question=qes.getQuestion();
		KeyWordFilter get=new KeyWordFilter();
		list=get.setwords(question);
		if(list.size()==0) {
			list.add(new Document("error","无信息"));
		}
		return list;
		}
		catch(Exception e) {
			runLog.debug(e);
		}
		return list;
	}
}







