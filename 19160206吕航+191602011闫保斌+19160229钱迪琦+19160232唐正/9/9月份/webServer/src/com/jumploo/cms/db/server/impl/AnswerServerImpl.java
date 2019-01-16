package com.jumploo.cms.db.server.impl;

import java.sql.SQLException;
import java.util.List;

import org.bson.Document;

import com.jumploo.cms.bean.Question;
import com.jumploo.cms.db.dao.AnswerDao;
import com.jumploo.cms.db.dao.impl.DaoManager;
import com.jumploo.cms.db.server.AnswerServer;

public class AnswerServerImpl implements AnswerServer{

	private static AnswerServerImpl us = new AnswerServerImpl();
	private AnswerDao dao = null;
	public AnswerServerImpl() {
		dao = DaoManager.getAnswerDao();
	}
	public static AnswerServer getServer() {
		return us;
	}
	@Override
	public List<Document> getAnswer(Question qes) throws SQLException {
		// TODO 自动生成的方法存根
		return dao.getAnswer(qes);
	}


}



