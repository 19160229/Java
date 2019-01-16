package com.jumploo.cms.db;

import com.jumploo.cms.db.server.AnswerServer;

public final class DBManager
{
	public final static AnswerServer getAnswerServer() {
		return ServerManager.getAnswerServer();
	}

}
