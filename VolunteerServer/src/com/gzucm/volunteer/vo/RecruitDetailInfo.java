package com.gzucm.volunteer.vo;

/**
 * 数据传输对象
 * 招募详情值对象
 * 
 * @author 张泽洲
 * 
 */
public class RecruitDetailInfo {

	private String activityID; // 活动ID
	private String title; // 标题
	private String publisher;//发布者姓名
	private String activityType; // 志愿服务类型
	private int recruitPeopleNum; // 招募人数
	private String startTime; // 活动开始时间
	private String endTime; // 活动结束时间
	private String deadline; // 报名截止时间
	private String activityAddress; // 活动地点
	private String activityContactName; // 活动联系人姓名
	private String activityTelPhone; // 活动联系人电话
	private String perks; // 补贴待遇
	private String demand;//工作要求
	private String uploadTime;//发布时间
	public String activityIntroduce; // 活动内容

	public String getActivityID() {
		return activityID;
	}

	public void setActivityID(String activityID) {
		this.activityID = activityID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public int getRecruitPeopleNum() {
		return recruitPeopleNum;
	}

	public void setRecruitPeopleNum(int recruitPeopleNum) {
		this.recruitPeopleNum = recruitPeopleNum;
	}

	public String getActivityAddress() {
		return activityAddress;
	}

	public void setActivityAddress(String activityAddress) {
		this.activityAddress = activityAddress;
	}

	public String getActivityContactName() {
		return activityContactName;
	}

	public void setActivityContactName(String activityContactName) {
		this.activityContactName = activityContactName;
	}

	public String getActivityTelPhone() {
		return activityTelPhone;
	}

	public void setActivityTelPhone(String activityTelPhone) {
		this.activityTelPhone = activityTelPhone;
	}


	public String getPerks() {
		return perks;
	}

	public void setPerks(String perks) {
		this.perks = perks;
	}

	public String getActivityIntroduce() {
		return activityIntroduce;
	}

	public void setActivityIntroduce(String activityIntroduce) {
		this.activityIntroduce = activityIntroduce;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDemand() {
		return demand;
	}

	public void setDemand(String demand) {
		this.demand = demand;
	}
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	
}
