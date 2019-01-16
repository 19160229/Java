package com.jumploo.cms.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.jumploo.cms.conf.SysDefine;


public class ReqestCheckFilter implements Filter 
{
	final static Logger logger = Logger.getLogger(ReqestCheckFilter.class.getName());
	public void init(FilterConfig config) throws ServletException 
	{

	}

	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException
	{
		chain.doFilter(request, response);
//		if(checkVaildaty(request, response))
//		{
//			chain.doFilter(request, response);
//		}
	}
	private boolean checkVaildaty(ServletRequest request, 
			ServletResponse response)
	{
		HttpServletRequest req =(HttpServletRequest) request;
		String ip = req.getHeader("X-Real-IP");
		Object obj = SysDefine.ipFilter.get(ip);
		if (null == obj)
		{
			return false;
		}
		return true;
	}

	public void destroy() 
	{

	}
}
