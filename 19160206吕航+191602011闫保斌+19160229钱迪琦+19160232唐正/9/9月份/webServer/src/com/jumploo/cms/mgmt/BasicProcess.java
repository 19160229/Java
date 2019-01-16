package com.jumploo.cms.mgmt;

import java.util.List;

import org.apache.log4j.Logger;

import com.jumploo.cms.db.DBManager;
import com.jumploo.cms.db.server.AnswerServer;
import com.jumploo.cms.log.LogManager;
import com.jumploo.cms.thread.SyncProcess;
import com.jumploo.cms.util.TimeTools;

public abstract class BasicProcess
{
	protected static Logger logger = LogManager.getLogManager().getRunLog();

	protected static TimeTools timeTools = new TimeTools();
	protected static AnswerServer answerServer=DBManager.getAnswerServer();
	protected static SyncProcess syncProcess = null;
	public abstract int process(Object[] obj, List list) throws Exception;
	
}
