package com.jumploo.cms.db.dao;



import java.sql.SQLException;
import java.util.List;

import org.bson.Document;

import com.jumploo.cms.bean.Question;

public interface AnswerDao {

	/**
	 * String问答
	 * @param qes
	 * @return
	 * @throws SQLException 
	 */
	public List<Document> getAnswer(Question qes) throws SQLException;
	
}
