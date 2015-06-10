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
import com.gzucm.volunteer.service.IRecommendedService;
import com.gzucm.volunteer.service.IRecruitService;
import com.gzucm.volunteer.util.DateUtil;
import com.gzucm.volunteer.util.PageInfo;
import com.gzucm.volunteer.util.StringHelp;
import com.gzucm.volunteer.vo.Enlist;
import com.gzucm.volunteer.vo.RecruitDetailInfo;
/**
 * 招募Service
 * @author 张泽洲
 * @version 1.0
 *
 */
@Transactional(readOnly=true)
@Service(IRecommendedService.SERVICE_NAME)
public class RecommendedServiceImpl implements IRecommendedService {

	@Resource(name=IActivityDao.SERVICE_NAME)
	private IActivityDao activityDao;
	@Resource(name=IUserDao.SERVICE_NAME)
	private IUserDao userDao;
	@Resource(name=IApplyActivityDao.SERVICE_NAME)
	private IApplyActivityDao applyActivityDao;
	@Resource(name=ICollectDao.SERVICE_NAME)
	private ICollectDao collectDao;
	@Override
	public List<Activity> recommended(PageInfo pageInfo,String userID) {
		String hqlWhere=" ";
		if(userID!=null){
			hqlWhere=concatCondition(userID);	
		}
		LinkedHashMap<String, String> orderby=new LinkedHashMap<String,String>();
		orderby.put("o.uploadTime","desc");
		List<Activity> activityList=activityDao.findCollectionByConditionWithPage(hqlWhere, null, orderby, pageInfo);
		return  activityList;
	}
	//拼接推荐条件hql;
	public String concatCondition(String userID){
		Map<String,String> condition=new HashMap<String, String>();
		//按用户活动偏好类型拼接条件sql语句
		String hqlWhere=" ";
		User user=null;
		user=userDao.findObjectByID(userID);
		String[] volunteerType;
		if(user!=null){
			if(user.getVolunteerType()!=null){
			volunteerType=user.getVolunteerType().split("\\,");
			for(int i=0;i<volunteerType.length;i++){
				if(!volunteerType[i].equals("")){
					System.out.println("用户偏好活动类型："+volunteerType[i]);
					hqlWhere+=" or o.activityType='"+volunteerType[i]+"' ";
				}			
			}
			}
		}
		/*按活动的isRecommended字段拼接条件sql语句*/
		condition.put(" and o.isRecommended ","1");
		//condition.put(" and o.imgPath！", "");
		return StringHelp.concatConditionSql(condition)+hqlWhere;
	}
	
	
	
}
