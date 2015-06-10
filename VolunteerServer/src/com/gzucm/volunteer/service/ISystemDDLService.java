package com.gzucm.volunteer.service;

import java.util.List;

import com.gzucm.volunteer.domain.SystemDDL;


public interface ISystemDDLService {
	public final static String SERVICE_NAME = "com.gzucm.volunteer.service.impl.SystemDDLServiceImpl";

	/**  
	* @Name: save
	* @Description: 保存对象
	* @Author: 万允山（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2015-3-15 （创建日期）
	* @Parameters:SystemDDL
	* @Return: null
	*/
	public void save(SystemDDL systemDDL);
	
	/**
	 * @Name findBykeyword
	 * @Description: 查询数据字典
	 * @Author: 万允山（作者）
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2015-3-15 （创建日期）
	 * @param ddlName
	 * @return
	 */
	public List<String> findBykeyword(String keyword);
}
