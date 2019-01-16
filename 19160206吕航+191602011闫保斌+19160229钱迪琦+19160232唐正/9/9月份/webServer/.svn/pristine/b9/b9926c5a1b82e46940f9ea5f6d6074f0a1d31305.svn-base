package com.jumploo.cms.log;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Layout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;
public class RBAppender extends RollingFileAppender
{
  private String extName;
  private String logPath;

  public RBAppender()
  {
    this.logPath = "..\\logs\\";
  }

  public RBAppender(Layout layout, String filename) throws IOException
  {
    super(layout, filename);
    this.logPath = "..\\logs\\";
  }

  public RBAppender(Layout layout, String filename, boolean append)
    throws IOException
  {
    super(layout, filename, append);
    this.logPath = "..\\logs\\";
  }

  public void rollOver()
  {
    this.fileName = createFileName();
    File file = new File(this.fileName);
    if (file.exists())
    {
      file.delete();
    }
    try
    {
      setFile(this.fileName, false, this.bufferedIO, this.bufferSize);
    }
    catch (IOException e)
    {
      LogLog.error("setFile(" + this.fileName + ", false) call failed.", e);
    }
  }

  public String createFileName()
  {
    File dir = new File(this.logPath);
    if (!(dir.exists()))
    {
      dir.mkdirs();
    }
    SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");
    String time = date.format(new Date());
    StringBuffer tmpSb = new StringBuffer();
    tmpSb.append(this.logPath).append(this.extName).append("_").append(time).append(
      ".log");
    return tmpSb.toString();
  }

  public void setFile(String file)
  {
    String tempFileName = file.trim();
    if (file.indexOf("/") > -1)
    {
      this.logPath = file.substring(0, file.lastIndexOf("/"));
      tempFileName = file.substring(file.lastIndexOf("/"));
    }
    this.extName = tempFileName;
    this.fileName = createFileName();
  }

  protected void subAppend(LoggingEvent event)
  {
    if ((this.fileName != null) && (!(compareFileNameWithSysDate(this.fileName))))
    {
      rollOver();
    }
    super.subAppend(event);
  }

  private boolean compareFileNameWithSysDate(String fileName)
  {
    SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
    String sDate = date.format(new Date());
    StringBuffer tmpSb = new StringBuffer();
    tmpSb.append(sDate);
    String sysDate = tmpSb.toString();
    int index = fileName.lastIndexOf("/");
    String dateOfFileName = fileName.substring(index + 6, index + 14);
    return dateOfFileName.equals(sysDate);
  }
}