package com.gzucm.volunteer.domain;

import java.util.Date;

/**
 * 机构审核表
 * 
 * @author 万允山
 * 
 */
public class CheckOrg {
	
	public String checkOrgID; // 审核ID
	public String orgID; // 机构ID
	public String state; // 审核状态（0审核中，1审核成功，2审核失败）
	public String failedReason; // 审核失败原因
	public Date checkTime; // 审核时间
	public Date uploadTime; // 提交时间

	public String getCheckOrgID() {
		return checkOrgID;
	}

	public void setCheckOrgID(String checkOrgID) {
		this.checkOrgID = checkOrgID;
	}

	public String getOrgID() {
		return orgID;
	}

	public void setOrgID(String orgID) {
		this.orgID = orgID;
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
