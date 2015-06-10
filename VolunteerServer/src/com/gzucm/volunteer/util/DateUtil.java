package com.gzucm.volunteer.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author 张泽洲
 *处理与日期相关的工具类
 */
public class DateUtil {
	public static String TODAY="today";//今天
	public static String TOMORROW="tomorrow";//明天
	public static String NEXTWEEK="nextweek";//最近一周
	public static String NEXTMONTH="nextmonth";//最近一个月
	private Date timeBucket_start;//时间段开始
	
	private Date timeBucket_end;//时间段结束
	private String timeBucket_start_str;//时间段开始(字符串)
	private String timeBucket_end_str;//时间段结束(字符串)
	Calendar cl;

	//根据标志得出时间段的开始时间和结束时间
	public DateUtil(String flag) {
		this.timeBucket_start = new Date();
		//创建基于当前时间的日历对象
		this.cl = Calendar.getInstance();
		setTimeBucket(flag);
		// TODO Auto-generated constructor stub
	}
	
	public DateUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setTimeBucket(String flag){
		cl.setTime(timeBucket_start);
		//距离今天，一个月内数据
		 if(flag.equals("nextmonth")){
		  cl.add(Calendar.MONTH, +1);
		  
		}
		 //距离今天，一周内的数据
		if(flag.equals("nextweek")){
		  cl.add(Calendar.DATE, +7);
		  timeBucket_end = cl.getTime();
		  SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
		  //格式化开始日期和结束日期
		  timeBucket_start_str= dd.format(timeBucket_start);
		  timeBucket_end_str= dd.format(timeBucket_end);
		 }
		//距离今天，一天内的数据
		if(flag.equals("tomorrow")){
		  cl.add(Calendar.DATE, +1);
		}
		//今天內的数据
		if(flag.equals("today")){
			
		  cl.add(Calendar.DATE,0);
		}
		timeBucket_end = cl.getTime();
		SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
		 //格式化开始日期和结束日期(字符串)
		timeBucket_start_str= dd.format(timeBucket_start);
		timeBucket_end_str= dd.format(timeBucket_end);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			timeBucket_start=format.parse(timeBucket_start_str+" 00:00:00");
			timeBucket_end=format.parse(timeBucket_end_str+" 23:59:59");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// 返回时间字符串(yyyy-MM-dd)
	public static String getStringDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd");
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 日期大小比较
	 */
	public static boolean dateCompare(Date date1, Date date2) {
			boolean dateComPareFlag = true;
			if (date2.compareTo(date1) != 1) {
				dateComPareFlag = false;
			}
			return dateComPareFlag;
		}
	public Date getTimeBucket_start() {
		return timeBucket_start;
	}

	public void setTimeBucket_start(Date timeBucket_start) {
		this.timeBucket_start = timeBucket_start;
	}

	public Date getTimeBucket_end() {
		return timeBucket_end;
	}

	public void setTimeBucket_end(Date timeBucket_end) {
		this.timeBucket_end = timeBucket_end;
	}

	public String getTimeBucket_start_str() {
		return timeBucket_start_str;
	}

	public void setTimeBucket_start_str(String timeBucket_start_str) {
		this.timeBucket_start_str = timeBucket_start_str;
	}

	public String getTimeBucket_end_str() {
		return timeBucket_end_str;
	}

	public void setTimeBucket_end_str(String timeBucket_end_str) {
		this.timeBucket_end_str = timeBucket_end_str;
	}
	
	public static Date  StringToDate(String time){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
