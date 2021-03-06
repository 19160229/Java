package com.jumploo.cms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.jumploo.cms.conf.SysDefine;

public class TimeTools {
	private Date d = null;
	private SimpleDateFormat ymdhm = null;
	private SimpleDateFormat ymdhm_show = null;
	
	public TimeTools() {
		new SimpleDateFormat(SysDefine.TIME_YMDHMS);
		ymdhm = new SimpleDateFormat(SysDefine.TIME_YMDHM);
		new SimpleDateFormat(SysDefine.TIME_YMD);
		ymdhm_show = new SimpleDateFormat(SysDefine.TIME_YMDHM_SHOW);
		d = new Date();
	}

	//获得当前的毫秒数
	public long getCurrentSeconds() throws ParseException {
		Date dTmp = new Date();
		long millionSeconds = ymdhm.parse(ymdhm.format(dTmp)).getTime();// 毫秒
		dTmp = null;
		return millionSeconds;
	}
	
	//获得当前时间的 年，月，日，时，分，秒
	public int[] getCurrentTimeFactors() throws Exception
	{
		return getTimeFactors(getCurrentSeconds());
	}
	
	//获得某个时间的 年，月，日，时，分，秒
	public int[] getTimeFactors(long millionSeconds)
	{
		d.setTime(millionSeconds);
		int[] tmp = new int[6];
		tmp[0] = d.getYear();
		tmp[1] = d.getMonth();
		tmp[2] = d.getDate();
		tmp[3] = d.getHours();
		tmp[4] = d.getMinutes();
		tmp[5] = d.getSeconds();
		return tmp;
	}

	//将毫秒数转化为默认的时间字符串显示
	public String praseSecondsToStr(long millionSeconds) {
		d.setTime(millionSeconds);
		try {
			return ymdhm_show.format(d);
		} finally {
			d.setTime(0);
		}
	}
	
	public String getCurrentYear(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return sdf.format(date);
    }
	

}
