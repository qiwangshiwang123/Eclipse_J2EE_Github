package com.gzucm.volunteer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gzucm.volunteer.dao.IActivityDao;
import com.gzucm.volunteer.dao.IApplyActivityDao;
import com.gzucm.volunteer.dao.ICollectDao;
import com.gzucm.volunteer.dao.IUserDao;
import com.gzucm.volunteer.domain.Activity;
import com.gzucm.volunteer.domain.ApplyActivity;
import com.gzucm.volunteer.domain.CheckActivity;
import com.gzucm.volunteer.domain.Collect;
import com.gzucm.volunteer.domain.User;
import com.gzucm.volunteer.service.IRecruitService;
import com.gzucm.volunteer.util.AddressUtil;
import com.gzucm.volunteer.util.DateUtil;
import com.gzucm.volunteer.util.PageInfo;
import com.gzucm.volunteer.vo.Enlist;
import com.gzucm.volunteer.vo.RecruitDetailInfo;
/**
 * 招募Service
 * @author 张泽洲
 * @version 1.0
 *
 */
@Transactional(readOnly=true)
@Service(IRecruitService.SERVICE_NAME)
public class RecruitServiceImpl implements IRecruitService {

	@Resource(name=IActivityDao.SERVICE_NAME)
	private IActivityDao activityDao;
	@Resource(name=IUserDao.SERVICE_NAME)
	private IUserDao userDao;
	@Resource(name=IApplyActivityDao.SERVICE_NAME)
	private IApplyActivityDao applyActivityDao;
	@Resource(name=ICollectDao.SERVICE_NAME)
	private ICollectDao collectDao;
	@Override
	public List<Enlist> findWithPage(Map<String, String> condition,String timeBucket, PageInfo pageInfo) {
		String str="  and o.startTime between ? and ? ";
		String hqlWhere=" ";
		for( Map.Entry<String, String> entry:condition.entrySet()){
			if(!entry.getValue().equals("")){
				hqlWhere+=" and "+entry.getKey()+"='"+entry.getValue()+"'";
			}
		}
		hqlWhere+=str;
		System.out.println("hqlWhere:"+hqlWhere);
		LinkedHashMap<String, String> orderby=new LinkedHashMap<String,String>();
		orderby.put("o.uploadTime","desc");
		DateUtil calendarUtil=new DateUtil(timeBucket);
		System.out.println("timeBucket:"+calendarUtil.getTimeBucket_start());
		Object[] params={calendarUtil.getTimeBucket_start(),calendarUtil.getTimeBucket_end()};
		// TODO Auto-generated method stub
		List<Activity> activityList=activityDao.findCollectionByConditionWithPage(hqlWhere, params, orderby, pageInfo);
		return  convertToEnlist(activityList);
	}
	@Override
	public List<Enlist> findWithPage(Map<String, String> condition,
			PageInfo pageInfo) {
		String str="";
		String hqlWhere=" ";
		if(condition!=null){
			for( Map.Entry<String, String> entry:condition.entrySet()){
				if(!entry.getValue().equals(""))
				hqlWhere+=" and "+entry.getKey()+"='"+entry.getValue()+"'";
			}
		}
		hqlWhere+=str;
		System.out.println(hqlWhere);
		LinkedHashMap<String, String> orderby=new LinkedHashMap<String,String>();
		orderby.put("o.uploadTime","desc");
		// TODO Auto-generated method stub
		List<Activity> activityList=activityDao.findCollectionByConditionWithPage(hqlWhere, null, orderby, pageInfo);
		return  convertToEnlist(activityList);
	}
	private List<Enlist> convertToEnlist(List<Activity> activityList){
		Enlist enlist=null;
		List<Enlist> enlistList=new ArrayList<Enlist>();
		if(activityList.size()==0){return null;}
		for(Activity activity:activityList){
			enlist=new Enlist();
			enlist.setActivityID(activity.getActivityID());
			enlist.setTitle(activity.getTitle());
			enlist.setActivityType(activity.getActivityType());
			enlist.setArea(AddressUtil.UnpackString(activity.getActivityAddress())[2]);
			enlist.setReleaseTime(DateUtil.getStringDate(activity.getStartTime()));
			enlist.setViewAcount(activity.getViewAcount());
			enlistList.add(enlist);
		}
		return enlistList;		
	}
	@Override
	public List<Enlist> findNoPage(Map<String, String> condition,
			String timeBucket) {
		String str="  and o.startTime between ? and ? ";
		String hqlWhere=" ";
		for( Map.Entry<String, String> entry:condition.entrySet()){
			hqlWhere+=" and "+entry.getKey()+"='"+entry.getValue()+"'";
		}
		hqlWhere+=str;
		System.out.println(hqlWhere);
		LinkedHashMap<String, String> orderby=new LinkedHashMap<String,String>();
		orderby.put("o.uploadTime","desc");
		DateUtil calendarUtil=new DateUtil(timeBucket);
		Object[] params={calendarUtil.getTimeBucket_start(),calendarUtil.getTimeBucket_end()};
		// TODO Auto-generated method stub
		List<Activity> activityList=activityDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		return  convertToEnlist(activityList);
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public RecruitDetailInfo findRecruitDetailInfoByID(String activityID) {
		// TODO Auto-generated method stub
		Activity activity=new Activity();
		activity=activityDao.findObjectByID(activityID);
		activity.setViewAcount(activity.getViewAcount()+1);
		activityDao.update(activity);
		return convertToRecruitDetailInfo(activity);
	}
	private RecruitDetailInfo convertToRecruitDetailInfo(Activity activity){
		RecruitDetailInfo rdi=new RecruitDetailInfo();
		rdi.setActivityID(activity.getActivityID());
		rdi.setTitle(activity.getTitle());
		rdi.setActivityType(activity.getActivityType());
		rdi.setRecruitPeopleNum(activity.getRecruitPeopleNum());
		rdi.setStartTime(DateUtil.getStringDate(activity.getStartTime()));
		rdi.setEndTime(DateUtil.getStringDate(activity.getEndTime()));
		rdi.setDeadline(DateUtil.getStringDate(activity.getDeadline()));
		rdi.setUploadTime(DateUtil.getStringDate(activity.getUploadTime()));
		rdi.setActivityAddress(activity.getActivityAddress());
		rdi.setActivityContactName(activity.getActivityContactName());
		rdi.setActivityTelPhone(activity.getActivityTelPhone());
		rdi.setPerks(activity.getPerks());
		rdi.setDemand(activity.getDemand());
		rdi.setPublisher(activity.getPublisher());
		rdi.setActivityIntroduce(activity.getActivityIntroduce());
		rdi.setActivityType(activity.getActivityType());
		return rdi;
		
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public String apply(String userID,String activityID) {
		// TODO Auto-generated method stub
		if(!checkResume(userID)){
			return "2";//2代表简历未完善
		}		
		if(checkIsApply(userID,activityID)){
			return "3";//3代表有报名记录
		}
		ApplyActivity applyActivity=new ApplyActivity();
		applyActivity.setActivityID(activityID);
		applyActivity.setUserID(userID);
		Date now=new Date();
		applyActivity.setUploadTime(now);
		applyActivityDao.save(applyActivity);
		return "1";
	}
	private boolean checkIsApply(String userID, String activityID) {
		// TODO Auto-generated method stub
		String hql=" and o.userID=? and o.activityID=? ";
		Object[] params={userID,activityID};
		List<ApplyActivity> applyActivity=null;
		applyActivity=applyActivityDao.findCollectionByConditionNoPage(hql, params, null);
		if(applyActivity.size()==0){
			return false;
		}
		return true;
	}
	private boolean checkResume(String userID){
		User user=null;
		user=userDao.findObjectByID(userID);
		if (user != null) {
			if(user.getPortrait()==null){
				return false;//0代表简历未完善
			}
			if(user.getUserName()==null){
				return false;//0代表简历未完善
			}
			if(user.getSex()==null){
				return false;//0代表简历未完善
			}
			if(user.getIsCantonese()==null){
				return false;//0代表简历未完善
			}
			if(user.getExperience()==null){
				return false;//0代表简历未完善
			}
			if(user.getVolunteerType()==null){
				return false;//0代表简历未完善
			}
			if(user.getTelPhone()==null){
				return false;//0代表简历未完善
			}
			if(user.getEmail()==null){
				return false;//0代表简历未完善
			}
			if(user.getAddress()==null){
				return false;//0代表简历未完善
			}
			
			return true;
		}
		return false;
		
	}
	@Override
	public List<Enlist> findMyCollection(Map<String, String> condition,
			PageInfo pageInfo) {
		// TODO Auto-generated method stub
		String str="";
		String hqlWhere=" ";
		if(condition!=null){
			for( Map.Entry<String, String> entry:condition.entrySet()){
				hqlWhere+=" and "+entry.getKey()+"='"+entry.getValue()+"'";
			}
		}
		hqlWhere+=str;
		System.out.println(hqlWhere);
		// TODO Auto-generated method stub
		List<Activity> activityList=collectDao.findActivityCollectBySql(hqlWhere, pageInfo);
		return  convertToEnlist(activityList);
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public String insertCollect(String userID, String activityID) {
		// TODO Auto-generated method stub
		Collect collect=new Collect();
		collect.setUserID(userID);
		collect.setActivityID(activityID);
		try {
			collectDao.save(collect);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "收藏失败";
		}
		return "收藏成功";
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public String cancelCollect(String userID, String activityID) {
		// TODO Auto-generated method stub
		List<Collect> collectList=new ArrayList<Collect>();
		String hqlWhere=" and o.userID=? and o.activityID=? ";
		Object[] params={userID,activityID};
		try {
			collectList=collectDao.findCollectionByConditionNoPage(hqlWhere, params, null);
			collectDao.deleteObjectByCollection(collectList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "取消收藏失败";
		}
		return "取消收藏成功";
	}
	@Override
	public List<Enlist> findMyApply(Map<String, String> condition,
			PageInfo pageInfo) {
		// TODO Auto-generated method stub
		String str="";
		String hqlWhere=" ";
		if(condition!=null){
			for( Map.Entry<String, String> entry:condition.entrySet()){
				hqlWhere+=" and "+entry.getKey()+"='"+entry.getValue()+"'";
			}
		}
		hqlWhere+=str;
		// TODO Auto-generated method stub
		List<Activity> activityList=applyActivityDao.findActivityApplyBySql(hqlWhere,pageInfo);
		return  convertToEnlist(activityList);
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void publish(Activity activity) {
		// TODO Auto-generated method stub
		activityDao.save(activity);
	}
}
