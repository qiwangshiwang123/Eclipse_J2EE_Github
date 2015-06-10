package com.gzucm.volunteer.junit;

import org.junit.Test;

import com.gzucm.volunteer.util.DateUtil;



/**
 * 
 * @author       张泽洲
 * @createTime   2014-10-20 
 */
public class TestDateUtil {
	/**  
	* @Name: testTxtToPDF
	* @Description: 测试将text文件转化为pdf文件
	* @Author: 张泽洲（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2014-10-20 （创建日期）
	*/
	@Test
	public void testCalendarUtil(){
		DateUtil calendarUtil=new DateUtil(DateUtil.NEXTWEEK);
		System.out.println(calendarUtil.getTimeBucket_start());
		System.out.println(calendarUtil.getTimeBucket_end());
	}
	
}
