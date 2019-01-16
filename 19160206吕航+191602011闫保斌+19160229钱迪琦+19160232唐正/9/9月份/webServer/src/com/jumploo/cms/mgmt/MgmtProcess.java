package com.jumploo.cms.mgmt;

import java.util.List;

import com.jumploo.cms.bean.CmdOperation;
import com.jumploo.cms.conf.SysDefine;
import com.jumploo.cms.thread.SyncProcess;

public class MgmtProcess implements InterationInterface {


	private static List list = null;
	
	@Override
	public List action(CmdOperation cmdOperation, SyncProcess process) {
		// TODO Auto-generated method stub
		
		
		InterationInterface tmp = null;
		switch(cmdOperation.getCmdType())
		{

		default:
			break;
		}
		if(null != tmp)
		{
			list = tmp.action(cmdOperation, process);
		}
		return list;
	}

}
