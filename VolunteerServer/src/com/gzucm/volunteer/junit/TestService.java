package com.gzucm.volunteer.junit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.gzucm.volunteer.container.ServiceProvider;
import com.gzucm.volunteer.domain.Activity;
import com.gzucm.volunteer.service.IRecommendedService;
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
public class TestService {
	
	@Test
	public void testfindWithPage(){
		IRecruitService RecruitService = (IRecruitService)ServiceProvider.getService(IRecruitService.SERVICE_NAME);
		Map<String,String> condition=new HashMap<String,String>();
		//参数值
		String activityType = "1";
		String timeBucket = DateUtil.NEXTMONTH;
		condition.put("o.activityType", activityType);
		PageInfo pageInfo=new PageInfo();
		pageInfo.setCurrentPageNo(1);
		pageInfo.setBeginResult(2);
		List<Enlist> recruitInfoList=new ArrayList<Enlist>();
		recruitInfoList=RecruitService.findWithPage(condition, timeBucket, pageInfo);
		System.out.println("pageSize:"+pageInfo.getPageSize());
		for(Enlist r:recruitInfoList){
			System.out.println("ActivityType:"+r.getActivityType());
		}
	}
	//拼接条件sql语句
	@Test
	public void testSqlConcat(){
		Map<String,String> condition=new HashMap<String,String>();
		//参数值
		String activityType = "2";
		String timeBucket = "7";
		condition.put("o.activityType", activityType);
		condition.put("o.timeBucket", timeBucket);
		String str="  and o.startTime between ? and ? ";
		String hql=" ";
		for( Map.Entry<String, String> entry:condition.entrySet()){
			hql+=" and "+entry.getKey()+"='"+entry.getValue()+"'";
		}
		System.out.println(hql);
	}
	@Test
	public void testApply(){
		IRecruitService RecruitService = (IRecruitService)ServiceProvider.getService(IRecruitService.SERVICE_NAME);
		String activityID="1";
		String userID="1";
		String applystate="";
		applystate=RecruitService.apply(userID, activityID);
		System.out.println(applystate);
	}
	@Test
	public void testMyCollection(){
		IRecruitService RecruitService = (IRecruitService)ServiceProvider.getService(IRecruitService.SERVICE_NAME);
		PageInfo pageInfo=new PageInfo();
		pageInfo.setBeginResult(0);
		pageInfo.setPageSize(3);
		Map<String, String> condition=new HashMap<String, String>();
		String userID="1";
		condition.put("c.userID", userID);
		List<Enlist> enlistList=new ArrayList<Enlist>();
		enlistList = RecruitService
				.findMyCollection(condition, pageInfo);
		System.out.println("title:"+enlistList.get(0).getTitle());
	}
	@Test
	public void testRecommended(){
		IRecommendedService RecommendedService = (IRecommendedService)ServiceProvider.getService(IRecommendedService.SERVICE_NAME);
		PageInfo pageInfo=new PageInfo();
		pageInfo.setBeginResult(0);
		pageInfo.setPageSize(6);
		Map<String, String> condition=new HashMap<String, String>();
		String userID="1";
		condition.put("c.userID", userID);
		List<Activity> enlistList=new ArrayList<Activity>();
		enlistList = RecommendedService
				.recommended(pageInfo, userID);
		for(Activity enlist:enlistList){
			System.out.println("ActivityID:"+enlist.getActivityID());
			System.out.println("ImgPath:"+enlist.getImgPath());
		}
		
	}
}
