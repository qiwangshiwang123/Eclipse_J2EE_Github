package com.gzucm.volunteer.service;

import java.util.List;
import java.util.Map;

import com.gzucm.volunteer.domain.Information;
import com.gzucm.volunteer.util.PageInfo;

/**
 * 资讯表
 */
public interface IInformationService {
	public final static String SERVICE_NAME = "com.gzucm.volunteer.service.impl.InformationServiceImpl";

	public void save(Information information);

	public List<Information> findWithPage(Map<String, String> condition, PageInfo pageInfo);

	public Information findById(String infoID);
}
