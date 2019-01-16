package com.jumploo.cms.mgmt.QA;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.jumploo.cms.bean.CmdOperation;
import com.jumploo.cms.bean.Question;
import com.jumploo.cms.mgmt.BasicProcess;
import com.jumploo.cms.mgmt.InterationInterface;
import com.jumploo.cms.thread.SyncProcess;

public class GetAnswerMgmt extends BasicProcess implements InterationInterface{

	@Override
	public List<Document> action(CmdOperation cmdOperation, SyncProcess process) {
		// TODO 自动生成的方法存根
		Question qes=(Question)cmdOperation;
		List<Document>list=new ArrayList<>();
		try {
			list=answerServer.getAnswer(qes);
			return list;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			logger.debug(e);
		}
		return list;
	}

	@Override
	public int process(Object[] obj, List list) throws Exception {
		// TODO 自动生成的方法存根
		return 0;
	}

}


