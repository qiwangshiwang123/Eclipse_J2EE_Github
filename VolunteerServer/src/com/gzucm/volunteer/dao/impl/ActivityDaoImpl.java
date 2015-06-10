package com.gzucm.volunteer.dao.impl;



import org.springframework.stereotype.Repository;

import com.gzucm.volunteer.dao.IActivityDao;
import com.gzucm.volunteer.domain.Activity;
/**
 * 志愿活动Dao
 * @author 张泽洲
 * @version 1.0
 *
 */
@Repository(IActivityDao.SERVICE_NAME)
public class ActivityDaoImpl extends CommonDaoImpl<Activity> implements IActivityDao {
	
}
