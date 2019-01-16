package com.jumploo.cms.thread;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.log4j.Logger;

import com.jumploo.cms.bean.CmdOperation;
import com.jumploo.cms.conf.SysDefine;
import com.jumploo.cms.log.LogManager;
import com.jumploo.cms.mgmt.InterationInterface;

public class TaskCleanThread extends SyncProcess{

	protected static final Logger runLog = LogManager.getLogManager().getRunLog();
	private ConcurrentLinkedQueue<Object> queue;
	private InterationInterface interation = null;
	private List list = null;
	private Object obj = null;
	private CmdOperation cmdOperation = null;
	int len = 0;

	public TaskCleanThread(InterationInterface _interation) {
		queue = new ConcurrentLinkedQueue<Object>();
		interation = _interation;
	}

	@Override
	public void run() {
		while (true) {
			try {
				obj = getTask();
				
				cmdOperation = (CmdOperation)obj;
				cmdOperation.setCmdType(SysDefine.CLEAN_TIMEOUTTASK);
				interation.action(cmdOperation, this);
				
				cmdOperation = null;
				obj = null;
			} catch (Exception ee) {
				runLog.debug(ee);
			}
		}
	}

	public synchronized void addTask(Object ioMessage) {
		queue.offer(ioMessage);
		++len;
		notifyAll();
	}

	public synchronized Object getTask() {
		while (queue.isEmpty()) {
			try {
				runLog.debug(this.getName() + " wait");
				wait();
			} catch (Exception e) {

			}
		}
		--len;
		return queue.poll();
	}

	public int getCurrentLen() {
		return len;
	}
}
