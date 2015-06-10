package com.gzucm.volunteer.dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.gzucm.volunteer.dao.ICollectDao;
import com.gzucm.volunteer.domain.Activity;
import com.gzucm.volunteer.domain.Collect;
import com.gzucm.volunteer.util.PageInfo;
/**
 * 收藏Dao
 * @author 张泽洲
 * @version 1.0
 *
 */
@Repository(ICollectDao.SERVICE_NAME)
public class CollectDaoImpl extends CommonDaoImpl<Collect> implements ICollectDao {
	/**  
	* @Name: findActivityCollectWithPageBySql
	* @Description: 根据sql语句查询对应收藏的招募信息
	* @Author: 张泽洲（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2014-11-21 （创建日期）
	* @Return: List<Collect> 收藏的招募信息
	*/
	public List<Activity> findActivityCollectBySql(String conditionsql,final PageInfo pageInfo) {
		// TODO Auto-generated method stub
		String sql="select * from collect c,activity a where c.activityID=a.activityID ";	
		final String finalSql = sql+conditionsql;	
		/*获得多个实体*/
		List<Object[]> list = (List<Object[]>) this.getHibernateTemplate().execute(new HibernateCallback(){
            public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
            	Query query = session.createSQLQuery(finalSql)
        				.addEntity(Collect.class)
        				.addEntity(Activity.class);	
            	//添加分页功能
				pageInfo.setTotalResult(query.list().size());//通过pageInfo对象设置列表中的总记录数
				query.setFirstResult(pageInfo.getBeginResult());//当前页中的数据从第几条开始查询
				query.setMaxResults(pageInfo.getPageSize());//当前页显示几条记录
				System.out.println(query.getQueryString());
				return query.list();
			}
		});
		List<Activity> ActivityList=new ArrayList<Activity>();
		Activity activity=new Activity();
		//循环得到categoryList和docList
		for(int i=0;i<list.size();i++){
			activity=(Activity)list.get(i)[1];
			ActivityList.add(activity);
		}
		return ActivityList;	
}
	public List<Activity> findActivityCollectBySql(String conditionsql) {
		// TODO Auto-generated method stub
		String sql="select * from collect c,activity a where c.activityID=a.activityID ";	
		final String finalSql = sql+conditionsql;	
		/*获得多个实体*/
		List<Object[]> list = (List<Object[]>) this.getHibernateTemplate().execute(new HibernateCallback(){
            public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
            	Query query = session.createSQLQuery(finalSql)
        				.addEntity(Collect.class)
        				.addEntity(Activity.class);	
				System.out.println(query.getQueryString());
				return query.list();
			}
		});
		List<Activity> ActivityList=new ArrayList<Activity>();
		Activity activity=new Activity();
		//循环得到categoryList和docList
		for(int i=0;i<list.size();i++){
			activity=(Activity)list.get(i)[1];
			ActivityList.add(activity);
		}
		return ActivityList;	
}
}
