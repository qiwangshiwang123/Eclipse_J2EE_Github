package com.gzucm.volunteer.service;
import java.util.List;
import java.util.Map;

import com.gzucm.volunteer.domain.Activity;
import com.gzucm.volunteer.util.PageInfo;
import com.gzucm.volunteer.vo.Enlist;
import com.gzucm.volunteer.vo.RecruitDetailInfo;
/**
 * 招募service
 * @author 张泽洲
 * @version 1.0
 *
 */
public interface IRecommendedService {
	public final static String SERVICE_NAME = "com.gzucm.volunteer.service.impl.RecommendedServiceImpl";

	/**  
	* @Name: recommended
	* @Description: 推荐招募信息
	* @Author: 张泽洲（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2015-2-3 （创建日期）
	* @Parameters:	
	* 				PageInfo pageInfo 分页参数
	* @Return: List<Enlist> 招募信息列表
	*/
	public List<Activity> recommended(PageInfo pageInfo,String userID);

	
	
}
