package com.gzucm.volunteer.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gzucm.volunteer.dao.IUserDao;
import com.gzucm.volunteer.domain.User;
/**
 * 用户表
 * @author 万允山
 * @version 1.0
 *
 */
@Repository(IUserDao.SERVICE_NAME)
public class UserDaoImpl extends CommonDaoImpl<User> implements IUserDao {

	@Override
	public List<User> findUserByTelephone(String hqlWhere, Object[] params) {
		return findCollectionByConditionNoPage(hqlWhere, params, null);
	}

}
