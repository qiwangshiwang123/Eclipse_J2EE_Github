package com.gzucm.volunteer.junit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.gzucm.volunteer.container.ServiceProvider;
import com.gzucm.volunteer.dao.IActivityDao;
import com.gzucm.volunteer.dao.ICollectDao;
import com.gzucm.volunteer.domain.Activity;
import com.gzucm.volunteer.domain.Collect;
import com.gzucm.volunteer.service.IRecruitService;
import com.gzucm.volunteer.util.DateUtil;
import com.gzucm.volunteer.util.PageInfo;
import com.gzucm.volunteer.vo.Enlist;
import com.gzucm.volunteer.vo.RecruitDetailInfo;



/**
 * 
 * @author       张泽洲
 * @createTime   2014-10-20 
 */
public class TestDao {
	
	@Test
	public void testCollectDao(){
		ICollectDao CollectDao = (ICollectDao)ServiceProvider.getService(ICollectDao.SERVICE_NAME);
		Collect collect=new Collect();
		collect.setActivityID("1");
		collect.setUserID("1");
		CollectDao.save(collect);
		
	}
	@Test
	public void testActivityDao(){
		IActivityDao ActivityDao = (IActivityDao)ServiceProvider.getService(IActivityDao.SERVICE_NAME);
		Activity activity=new Activity();
		activity.setActivityID("1");
		activity.setTitle("1");
		ActivityDao.save(activity);
		
	}
	@Test
	public void testCollectDao_findActivityCollectWithPageBySql(){
		ICollectDao CollectDao = (ICollectDao)ServiceProvider.getService(ICollectDao.SERVICE_NAME);
		PageInfo pageInfo=new PageInfo();
		pageInfo.setBeginResult(0);
		pageInfo.setPageSize(3);
		List<Activity> collectList=CollectDao.findActivityCollectBySql("", pageInfo);
		System.out.println(collectList.get(0).getTitle());
	}
}
