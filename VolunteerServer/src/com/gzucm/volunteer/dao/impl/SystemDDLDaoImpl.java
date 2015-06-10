package com.gzucm.volunteer.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.gzucm.volunteer.dao.ISystemDDLDao;
import com.gzucm.volunteer.domain.SystemDDL;
/**
 * 数据字典表
 * @author 万允山
 *
 */
@Repository(ISystemDDLDao.SERVICE_NAME)
public class SystemDDLDaoImpl extends CommonDaoImpl<SystemDDL> implements ISystemDDLDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findByKeyword(final String keyword) {
		final String hql = "select o.ddlName from SystemDDL o where o.keyword=?"; 
		return (List<String>) this.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);
				query.setParameter(0, keyword);
				return query.list();
			}
		});
	}

}
