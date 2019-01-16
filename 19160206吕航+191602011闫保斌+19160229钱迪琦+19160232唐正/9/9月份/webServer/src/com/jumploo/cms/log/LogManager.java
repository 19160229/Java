package com.jumploo.cms.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.jumploo.cms.conf.SysDefine;
public class LogManager
{
	 public Logger stLog = Logger.getLogger("stlog");
	  private Logger runLog = Logger.getLogger("runLog");
	  public Logger synLog = Logger.getLogger("synlog");
	  private Logger sercurityLog = Logger.getLogger("securityLog");
	  private static LogManager logManager = null;

	  public static synchronized LogManager getLogManager()
	  {
	    if (logManager == null)
	    {
	      logManager = new LogManager();
	    }
	    return logManager;
	  }
	  

	public void loadConfig()
	{
		PropertyConfigurator.configure(SysDefine.LOG_PATH);
	}

	 public Logger getRunLog()
	  {
	    return this.runLog;
	  }

	  public void setRunLog(Logger runLog)
	  {
	    this.runLog = runLog;
	  }

	  public Logger getSercurityLog()
	  {
	    return this.sercurityLog;
	  }

	  public void setSercurityLog(Logger sercurityLog)
	  {
	    this.sercurityLog = sercurityLog;
	  }
}
