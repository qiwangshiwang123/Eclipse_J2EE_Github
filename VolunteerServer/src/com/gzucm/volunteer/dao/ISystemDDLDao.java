package com.gzucm.volunteer.dao;

import java.util.List;

import com.gzucm.volunteer.domain.SystemDDL;

/**
 * 数据字典表的dao
 * @author 万允山
 *
 */
public interface ISystemDDLDao extends ICommonDao<SystemDDL>{
	public static final String SERVICE_NAME="com.gzucm.volunteer.dao.impl.SystemDDLDaoImpl";

	/**
	 * 根据关键字查询
	 * @return
	 */
	public List<String> findByKeyword(String keyword);
}
