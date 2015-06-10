package com.gzucm.volunteer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gzucm.volunteer.dao.IUserDao;
import com.gzucm.volunteer.domain.User;
import com.gzucm.volunteer.service.IUserService;
/**
 * 用户表
 * @author 万允山
 * @version 1.0
 *
 */
@Transactional(readOnly=true)
@Service(IUserService.SERVICE_NAME)
public class UserServiceImpl implements IUserService {

	@Resource(name=IUserDao.SERVICE_NAME)
	private IUserDao userDao;

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void save(User user) {
		userDao.save(user);		
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public User findUserByTelephone(String telephone) {
		String hqlWhere = " and o.telPhone like ?";
		Object[] params = {telephone};
		List<User> userList = userDao.findUserByTelephone(hqlWhere,params);
		if (userList.size()>0) {
			return userList.get(0);
		}
		return null;
	}

	@Override
	public User findUserByAccount(String account) {
		String hqlWhere = " and o.account like ?";
		Object[] params = {account};
		List<User> userList = userDao.findUserByTelephone(hqlWhere,params);
		if (userList.size()>0) {
			return userList.get(0);
		}
		return null;
	}

	@Override
	public User findUserById(String userId) {
		return userDao.findObjectByID(userId);
	}

	
}
