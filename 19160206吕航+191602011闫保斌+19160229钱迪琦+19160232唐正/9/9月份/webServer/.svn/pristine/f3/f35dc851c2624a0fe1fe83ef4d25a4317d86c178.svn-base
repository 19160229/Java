package com.jumploo.cms.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class ConvertUtil
{
	private static int TRANID = 0;
	private final static AtomicLong integ = new AtomicLong(1);
	private static String ymd = "yyyyMMdd";
	private static String ymdhms = "yyyyMMddHHmmss";
	private static String hms = "yyyy-MM-dd HH:mm:ss";
	private static SimpleDateFormat formatYMD;
	private static SimpleDateFormat formatYMDhms;
	private static SimpleDateFormat formathms;
	static
	{
		formatYMD = new SimpleDateFormat(ymd);
		formatYMDhms = new SimpleDateFormat(ymdhms);
		formathms = new SimpleDateFormat(hms);
	}

	public static Date string2DateYMDHMS(String str)
	{
		try
		{
			return formatYMDhms.parse(str);
		}
		catch(Exception ee)
		{
			try
			{
				return formatYMDhms.parse("20120501000000");
			}
			catch(ParseException e)
			{
				return null;
			}
		}

	}

	public static String date2StringYMD(Date date)
	{
		try
		{

			return formatYMD.format(date);
		}
		catch(Exception ee)
		{

		}
		return null;
	}
	public static String date2StringYMDHMS(Date date)
	{
		try
		{

			return formatYMDhms.format(date);
		}
		catch(Exception ee)
		{

		}
		return null;
	}
	public static String date2StringHms(Date date)
	{
		try
		{

			return formathms.format(date);
		}
		catch(Exception ee)
		{

		}
		return null;
	}

	public static int parseInt(String str)
	{
		return parseInt(str, 0);
	}

	public static int parseInt(String str, int defaultValue)
	{
		int num;
		if (null == str)
		{
			return defaultValue;
		}
		try
		{
			num = Integer.parseInt(str);
		}
		catch(Exception e)
		{
			num = defaultValue;
		}

		return num;
	}

	public static long parseLong(String str)
	{
		return parseLong(str, 0L);
	}
	public static String toString(Object str)
	{
		try
		{
			if (null != str)
			{
				return String.valueOf(str);
			}
			
		}
		catch (Exception ee)
		{
			return "";
		}
		
		return "";
	}

	public static long parseLong(String str, long defaultValue)
	{
		long num;
		try
		{
			num = Long.parseLong(str);
		}
		catch(Exception e)
		{
			num = defaultValue;
		}

		return num;
	}

	/**
	 * yyyy-mm-dd hh:MM:SS
	 * 
	 * @param str
	 * @return
	 */
	public static String getLocatTime(String str)
	{
		DateFormat df = new SimpleDateFormat(str);
		return df.format(new Date());
	}

	/**
	 * 
	 * @return
	 */
	public synchronized static String getTransID(String times)
	{
		StringBuffer transTime = new StringBuffer();
		transTime.append(times);

		TRANID++;
		if (TRANID > 999)
		{
			TRANID = 1;
		}

		if (TRANID < 10)
		{
			transTime.append("00").append(TRANID);
		}
		else if (TRANID > 9 && TRANID < 100)
		{
			transTime.append("0").append(TRANID);
		}
		else
		{
			transTime.append(TRANID);
		}
		return transTime.toString();
	}

	public static String strinTOparseStr(String str)
	{
		if (null == str)
		{
			return "";
		}
		str = str.replace("-", "");
		str = str.replace(":", "");
		str = str.replace(" ", "");
		StringBuffer rep = new StringBuffer(str);
		for (int i = rep.length(); i < 14; i++)
		{
			rep.append("0");
		}
		return rep.toString();
	}
	public static long getKey()
	{
		return integ.getAndIncrement();
	}
	public static void setKey(long max)
	{
		integ.set(max);
		//return integ.getAndIncrement();
	}
	
	public static boolean isPhoneId(String tmp)
	{
		int len = tmp.length();
		for(int i=0;i<len;i++)
		{
			if (tmp.charAt(i)<'0' || tmp.charAt(i)>'9')
			{
				return false;
			}
		}
		if (len == 11)
		{
			return true;
		}
		return false;
	}

	public static void main(String[] args)
	{
		//System.out.println(strinTOparseStr("2012-06-01 10:28"));
		System.out.println(isPhoneId("17768100406"));
	}
}
