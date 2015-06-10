package com.gzucm.volunteer.domain;

import java.util.Date;

/**
 * 活动报名表
 * 
 * @author zzz
 * 
 */
public class ApplyActivity {

	private String applyActivityID; // 审核ID
	public String activityID; // 活动ID
	private Activity activity;
	private String userID;//用户ID
	public Date uploadTime; // 提交时间

	

	public String getActivityID() {
		return activityID;
	}

	public void setActivityID(String activityID) {
		this.activityID = activityID;
	}

	
	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getApplyActivityID() {
		return applyActivityID;
	}

	public void setApplyActivityID(String applyActivityID) {
		this.applyActivityID = applyActivityID;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

}
