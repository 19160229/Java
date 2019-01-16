package com.jumploo.cms.db.dao.impl;

import com.jumploo.cms.db.dao.AnswerDao;

public final class DaoManager
{
	
private final static AnswerDao AnswerDao=AnswerDaoImpl.getAnswerDao();
	
	
	public final static AnswerDao getAnswerDao() {
		return AnswerDao;
	}
}
