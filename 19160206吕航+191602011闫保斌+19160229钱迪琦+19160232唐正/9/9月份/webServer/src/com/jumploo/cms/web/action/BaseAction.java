package com.jumploo.cms.web.action;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.jessma.mvc.ActionSupport;


import com.jumploo.cms.log.LogManager;
import com.jumploo.cms.mgmt.BasicProcess;
import com.jumploo.cms.mgmt.QA.GetAnswerMgmt;


public class BaseAction extends ActionSupport
{
	protected static ObjectMapper objectMapper = new ObjectMapper();
	protected int index = 1;
	protected int totalPage;
	protected static Logger runLog = LogManager.getLogManager().getRunLog();
	protected BasicProcess getAnswerMgmt = new GetAnswerMgmt();

	


	public int getIndex()
	{
		return index;
	}

	public void setIndex(int index)
	{
		this.index = index;
	}

	public int getTotalPage()
	{
		return totalPage;
	}

	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}

	protected String id;
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
}
