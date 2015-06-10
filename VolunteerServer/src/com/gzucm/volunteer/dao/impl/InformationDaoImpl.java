package com.gzucm.volunteer.dao.impl;

import org.springframework.stereotype.Repository;

import com.gzucm.volunteer.dao.IInformationDao;
import com.gzucm.volunteer.domain.Information;
@Repository(IInformationDao.SERVICE_NAME)
public class InformationDaoImpl extends CommonDaoImpl<Information> implements IInformationDao {

}
