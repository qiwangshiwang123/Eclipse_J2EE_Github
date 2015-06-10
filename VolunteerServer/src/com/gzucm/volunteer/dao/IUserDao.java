package com.gzucm.volunteer.dao;

import java.util.List;

import com.gzucm.volunteer.domain.User;

/**
 * 用户表
 * @author 万允山
 * @version 1.0
 *
 */
public interface IUserDao extends ICommonDao<User>{
	public static final String SERVICE_NAME="com.gzucm.volunteer.dao.impl.UserDaoImpl";

	public List<User> findUserByTelephone(String hqlWhere, Object[] params);

}
