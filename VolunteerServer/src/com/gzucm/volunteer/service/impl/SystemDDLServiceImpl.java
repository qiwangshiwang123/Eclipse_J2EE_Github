package com.gzucm.volunteer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gzucm.volunteer.dao.ISystemDDLDao;
import com.gzucm.volunteer.domain.SystemDDL;
import com.gzucm.volunteer.service.ISystemDDLService;

@Transactional(readOnly=true)
@Service(ISystemDDLService.SERVICE_NAME)
public class SystemDDLServiceImpl implements ISystemDDLService {

	@Resource(name=ISystemDDLDao.SERVICE_NAME)
	private ISystemDDLDao systemDDLDao;

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void save(SystemDDL systemDDL) {
		systemDDLDao.save(systemDDL);
	}

	@Override
	public List<String> findBykeyword(String keyword) {
		return systemDDLDao.findByKeyword(keyword);
	}

	//@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
}
