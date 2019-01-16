package com.jumploo.cms.mgmt;

import java.util.List;

import com.jumploo.cms.bean.CmdOperation;
import com.jumploo.cms.thread.SyncProcess;

public interface InterationInterface {
	public List action(CmdOperation cmdOperation, SyncProcess process);
}
