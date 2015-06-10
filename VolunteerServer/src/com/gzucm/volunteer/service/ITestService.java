package com.gzucm.volunteer.service;

import com.gzucm.volunteer.domain.UserInfo;
/**
 * 测试
 * @author 万允山
 *
 */
public interface ITestService {
	public final static String SERVICE_NAME = "com.gzucm.volunteer.service.impl.TestServiceImpl";

	/**  
	* @Name: save
	* @Description: 保存对象
	* @Author: 万允山（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2015-1-25 （创建日期）
	* @Parameters:UserInfo 
	* @Return: null
	*/
	public void save(UserInfo userInfo);

}
