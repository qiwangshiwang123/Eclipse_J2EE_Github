package com.gzucm.volunteer.dao;



import com.gzucm.volunteer.domain.Activity;

/**
 * 志愿活动Dao
 * @author 张泽洲
 * @version 1.0
 *
 */
public interface IActivityDao extends ICommonDao<Activity>{
	public static final String SERVICE_NAME="com.gzucm.volunteer.dao.impl.ActivityDaoImpl";
}
