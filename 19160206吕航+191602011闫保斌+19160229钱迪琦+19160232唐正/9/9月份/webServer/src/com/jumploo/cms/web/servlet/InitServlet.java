package com.jumploo.cms.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.jumploo.cms.conf.Init;
public class InitServlet extends HttpServlet
{
  private static final long serialVersionUID = -6787376758156567678L;
  Logger runLog = Logger.getLogger(InitServlet.class.getName());
  private String path;

  public void destroy()
  {
    super.destroy();
  }

  public void init()throws ServletException
  {
    runLog.info("init InitServlet start ... ");
    try
    {
    	this.path = getServletContext().getRealPath("");
    	Init tool = new Init();
    	tool.init(this.path);
    	runLog.info("init InitServlet end ... ");
    }
    catch(Exception ee)
    {
    	runLog.error("",ee);
    	System.gc();
    	System.exit(-1);
    }
    runLog.info("init finash ... ");
  }

  protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
    throws ServletException, IOException
  {
  }
}
