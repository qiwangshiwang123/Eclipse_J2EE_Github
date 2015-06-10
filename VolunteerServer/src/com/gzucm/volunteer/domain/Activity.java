package com.gzucm.volunteer.domain;

import java.util.Date;

/**
 * 志愿活动表
 * 
 * @author 万允山
 * 
 */
public class Activity {

	public String activityID; // 活动ID
	public String title; // 标题
	public String activityType; // 志愿服务类型
	public int recruitPeopleNum; // 招募人数
	public Date startTime; // 活动开始时间
	public Date endTime; // 活动结束时间
	public Date deadline; // 报名截止时间
	public Date uploadTime; // 活动上传时间
	public String activityAddress; // 活动地点
	public String activityContactName; // 活动联系人姓名
	public String activityTelPhone; // 活动联系人电话
	public String activityEmail; // 活动联系邮箱
	public String perks; // 补贴待遇
	public String demand;//工作要求
	public String activityIntroduce; // 活动内容
	public String publisher;//发布者姓名
	public int viewAcount;//浏览量
	private String imgPath;//图片路径
	private String isRecommended;//是否推荐
	public int getViewAcount() {
		return viewAcount;
	}
	public void setViewAcount(int viewAcount) {
		this.viewAcount = viewAcount;
	}
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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
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
	public String getActivityEmail() {
		return activityEmail;
	}
	public void setActivityEmail(String activityEmail) {
		this.activityEmail = activityEmail;
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
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getIsRecommended() {
		return isRecommended;
	}
	public void setIsRecommended(String isRecommended) {
		this.isRecommended = isRecommended;
	}
}
