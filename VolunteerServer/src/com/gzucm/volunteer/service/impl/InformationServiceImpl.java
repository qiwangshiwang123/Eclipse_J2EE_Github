package com.gzucm.volunteer.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gzucm.volunteer.dao.IInformationDao;
import com.gzucm.volunteer.domain.Information;
import com.gzucm.volunteer.service.IInformationService;
import com.gzucm.volunteer.util.PageInfo;

@Transactional(readOnly=true)
@Service(IInformationService.SERVICE_NAME)
public class InformationServiceImpl implements IInformationService {

	@Resource(name=IInformationDao.SERVICE_NAME)
	private IInformationDao informationDao;

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void save(Information information) {
		informationDao.save(information);		
	}

	@Override
	public List<Information> findWithPage(Map<String, String> condition,
			PageInfo pageInfo) {
		String hqlWhere = " ";
		LinkedHashMap<String, String> orderby=new LinkedHashMap<String,String>();
		orderby.put("o.uploadTime","desc");
		// TODO Auto-generated method stub
		List<Information> list = informationDao.findCollectionByConditionWithPage(hqlWhere, null, orderby, pageInfo);
		return list;
	}

	@Override
	public Information findById(String infoID) {
		return informationDao.findObjectByID(infoID);
	}
}
