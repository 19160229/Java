package com.jumploo.cms.db;

import com.jumploo.cms.db.server.AnswerServer;
import com.jumploo.cms.db.server.impl.AnswerServerImpl;

public final class ServerManager
{


	private final static AnswerServer AnswerServer=AnswerServerImpl.getServer();
	
	
	public final static AnswerServer getAnswerServer() {
		return AnswerServer;
	}
	
}
