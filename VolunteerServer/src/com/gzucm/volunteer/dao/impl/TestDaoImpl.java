package com.gzucm.volunteer.dao.impl;

import org.springframework.stereotype.Repository;

import com.gzucm.volunteer.dao.ITestDao;
import com.gzucm.volunteer.domain.UserInfo;
/**
 * 测试
 * @author 万允山
 *
 */
@Repository(ITestDao.SERVICE_NAME)
public class TestDaoImpl extends CommonDaoImpl<UserInfo> implements ITestDao {

}
