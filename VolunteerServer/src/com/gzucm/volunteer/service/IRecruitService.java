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
public interface IRecruitService {
	public final static String SERVICE_NAME = "com.gzucm.volunteer.service.impl.RecruitServiceImpl";

	/**  
	* @Name: findWithPage
	* @Description: 根据条件查询招募信息
	* @Author: 张泽洲（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2015-2-3 （创建日期）
	* @Parameters:	Map<String, String> condition 筛选条件
	* 				String timeBucket	时间段
	* 				PageInfo pageInfo 分页参数
	* @Return: List<Enlist> 招募信息列表
	*/
	public List<Enlist> findWithPage(Map<String, String> condition,String timeBucket,PageInfo pageInfo);

	public List<Enlist> findWithPage(Map<String, String> condition,PageInfo pageInfo);
	
	public List<Enlist> findNoPage(Map<String, String> condition,
			String timeBucket);
	/**  
	* @Name: findRecruitDetailInfoByID
	* @Description: 根据活动ID查询招募详情
	* @Author: 张泽洲（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2015-2-3 （创建日期）
	* @Parameters:	String activityID
	* @Return: RecruitDetailInfo 招募详情
	*/
	public RecruitDetailInfo findRecruitDetailInfoByID(String activityID);
	/**  
	* @Name: apply
	* @Description: 报名
	* @Return: String 报名状态   （0代表报名审核中；1代表报名成功；2代表简历未完善;3代表有报名记录）
	* @Author: 张泽洲（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2015-3-22（创建日期）
	* @Parameters:	String userID,String activityID
	*/
	public String apply(String userID,String activityID);
	/**
	 * @Name:findMyCollection
	 * @Description:查询我的收藏
	 * @return:List<Enlist> 我的收藏招募信息列表
	 * @author 张泽洲
	 * @param Map<String, String> condition 筛选条件
	 * 		  PageInfo pageInfo 分页参数
	 */
	public List<Enlist> findMyCollection(Map<String, String> condition,
			PageInfo pageInfo);
	/**
	 * @Name:insertCollect
	 * @Description:收藏招募信息
	 * @return:String 返回是否收藏成功的信息
	 * @author 张泽洲
	 * @param String userID 用户ID, String activityID 活动ID
	 */
	public String insertCollect(String userID, String activityID);

	public String cancelCollect(String userID, String activityID);

	List<Enlist> findMyApply(Map<String, String> condition, PageInfo pageInfo);

	public void publish(Activity activity);
	
}
