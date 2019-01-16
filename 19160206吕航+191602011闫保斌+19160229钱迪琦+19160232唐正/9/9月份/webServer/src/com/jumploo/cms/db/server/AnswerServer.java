package com.jumploo.cms.db.server;

import java.sql.SQLException;
import java.util.List;

import org.bson.Document;

import com.jumploo.cms.bean.Question;

public interface AnswerServer {

	public List<Document> getAnswer(Question qes) throws SQLException;
	
	
}
