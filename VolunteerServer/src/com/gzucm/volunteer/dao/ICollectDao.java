package com.gzucm.volunteer.dao;

import java.util.List;

import com.gzucm.volunteer.domain.Activity;
import com.gzucm.volunteer.domain.Collect;
import com.gzucm.volunteer.util.PageInfo;

/**
 * 收藏Dao
 * @author 张泽洲
 * @version 1.0
 *
 */
public interface ICollectDao extends ICommonDao<Collect>{
	public static final String SERVICE_NAME="com.gzucm.volunteer.dao.impl.CollectDao";
	public List<Activity> findActivityCollectBySql(String conditionsql,final PageInfo pageInfo);
	public List<Activity> findActivityCollectBySql(String conditionsql);
}
