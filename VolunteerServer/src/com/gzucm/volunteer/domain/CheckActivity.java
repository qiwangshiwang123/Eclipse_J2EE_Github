package com.gzucm.volunteer.domain;

import java.util.Date;

/**
 * 活动审核表
 * 
 * @author 万允山
 * 
 */
public class CheckActivity {

	public String checkActivityID; // 审核ID
	public String orgID; // 机构ID
	public String activityID; // 活动ID
	public String state; // 审核状态（0审核中，1招募中，2已下架，3已结束）
	public String failedReason; // 审核失败原因
	public Date checkTime; // 审核时间（也为发布时间）
	public Date uploadTime; // 提交时间

	public String getCheckActivityID() {
		return checkActivityID;
	}

	public void setCheckActivityID(String checkActivityID) {
		this.checkActivityID = checkActivityID;
	}

	public String getOrgID() {
		return orgID;
	}

	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}

	public String getActivityID() {
		return activityID;
	}

	public void setActivityID(String activityID) {
		this.activityID = activityID;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFailedReason() {
		return failedReason;
	}

	public void setFailedReason(String failedReason) {
		this.failedReason = failedReason;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

}
