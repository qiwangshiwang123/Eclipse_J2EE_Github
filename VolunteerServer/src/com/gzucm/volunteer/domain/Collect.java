package com.gzucm.volunteer.domain;

import java.util.Date;

/**
 * 我的收藏表
 * 
 * @author 张泽洲
 * 
 */
public class Collect {
	private String collectID;//收藏ID
	private String activityID; // 活动ID
	private String userID; // 用户ID
	private Activity activity;//活动
	public String getActivityID() {
		return activityID;
	}
	public void setActivityID(String activityID) {
		this.activityID = activityID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getCollectID() {
		return collectID;
	}
	public void setCollectID(String collectID) {
		this.collectID = collectID;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
}
