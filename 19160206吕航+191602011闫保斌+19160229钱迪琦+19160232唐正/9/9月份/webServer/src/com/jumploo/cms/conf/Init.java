package com.jumploo.cms.conf;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import org.apache.log4j.Logger;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.jumploo.cms.bean.KeyWord;
import com.jumploo.cms.mgmt.InterationInterface;
import com.jumploo.cms.mgmt.MgmtProcess;
import com.jumploo.cms.thread.MsgRcvThread;
import com.jumploo.cms.thread.TaskCleanThread;
import com.jumploo.cms.util.ConvertUtil;
import com.jumploo.cms.util.TimeTools;
import com.jumploo.cms.util.SQLPool.ConnectionPoolUtils;




public class Init 
{
	Logger runLog = Logger.getLogger(Init.class.getName());
	public void init(String path) throws Exception
	{
		initConf(path);
		initDB();
		initThread();
		initTools();
		initkW();
	}
	
	private void initkW() throws SQLException {
		runLog.debug("初始化keyword");

		Connection conn=SysDefine.connPool.getConnection();
		Statement stmt=conn.createStatement();
		String sql="select * from keyword";
		SysDefine.rsKW=stmt.executeQuery(sql);
		int count=0;
			while(SysDefine.rsKW.next()){
				count++;
			}
			
		SysDefine.keywords=new KeyWord[count];
		SysDefine.rsKW.absolute(0);
		int i=0;
		SysDefine.wordSet = new HashSet<String>();
		while(SysDefine.rsKW.next()){
			int id=SysDefine.rsKW.getInt("ID");
				String type=SysDefine.rsKW.getString("TYPE");
				int sequence=SysDefine.rsKW.getInt("SEQUENCE");
			String keyword=SysDefine.rsKW.getString("KEYWORD");
			SysDefine.wordSet.add(keyword);
			SysDefine.keywords[i]=new KeyWord(id,keyword,type,sequence);
	 		i++;
	    }
		runLog.debug("end");
	}
	
	
	private void initTools()
	{
		SysDefine.timeTools = new TimeTools();
	}
	

	private void initThread() throws Exception
	{
		//初始化信息接收
		InterationInterface tmp = new MgmtProcess();
		SysDefine.msgRcvThread = new MsgRcvThread(tmp);
		SysDefine.taskCleanThread = new TaskCleanThread(tmp);
	}
	
	private void initConf(String path) throws Exception
	{
		SAXReader reader = new SAXReader();
		File file = new File(path + SysDefine.LOCAL_CONF);
		Document doc = reader.read(file);
		Element root = doc.getRootElement();
		
		Element ele = root.element("db");
		List list = ele.elements("address");
		int len = list.size();
		SysDefine.dbIp = new String[len];
		SysDefine.dbPort = new int[len];
		SysDefine.SERVER_PORT = 8899;
		for(int i =0;i<len;i++)
		{
			Element arr = (Element)list.get(i);
			String[] aa = arr.getText().split(":");
			SysDefine.dbIp[i] = aa[0];
			SysDefine.dbPort[i] = ConvertUtil.parseInt(aa[1]);
		}
	}
	
	private void initDB() throws Exception
	{

	    SysDefine.connPool=ConnectionPoolUtils.GetPoolInstance();//单例模式创建连接池对象  

	}
}
