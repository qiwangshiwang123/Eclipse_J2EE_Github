package com.gzucm.volunteer.dao;



import java.util.List;

import com.gzucm.volunteer.domain.Activity;
import com.gzucm.volunteer.domain.ApplyActivity;
import com.gzucm.volunteer.util.PageInfo;


/**
 * 审核志愿活动Dao
 * @author 张泽洲
 * @version 1.0
 *
 */
public interface IApplyActivityDao extends ICommonDao<ApplyActivity>{
	public static final String SERVICE_NAME="com.gzucm.volunteer.dao.impl.ApplyActivityDaoImpl";
	/**
	 * @decription 查询我的活动申请列表（分页显示）
	 * @param hqlWhere sql语句
	 * @param pageInfo 分页参数
	 * @return 我的活动申请
	 */
	List<Activity> findActivityApplyBySql(String hqlWhere, PageInfo pageInfo);
	List<Activity> findActivityApplyBySql(String hqlWhere);
}
