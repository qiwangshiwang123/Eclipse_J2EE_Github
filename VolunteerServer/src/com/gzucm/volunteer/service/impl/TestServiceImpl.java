package com.gzucm.volunteer.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gzucm.volunteer.dao.ITestDao;
import com.gzucm.volunteer.domain.UserInfo;
import com.gzucm.volunteer.service.ITestService;
/**
 * 测试
 * @author 万允山
 *
 */
@Transactional(readOnly=true)
@Service(ITestService.SERVICE_NAME)
public class TestServiceImpl implements ITestService {

	@Resource(name=ITestDao.SERVICE_NAME)
	private ITestDao testDao;

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void save(UserInfo userInfo) {
		testDao.save(userInfo);		
	}
	
	//@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
}
