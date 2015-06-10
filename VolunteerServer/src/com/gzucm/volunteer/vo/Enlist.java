package com.gzucm.volunteer.vo;

import java.io.Serializable;



/**
 * 招募导航listview里的每个item的数据类型
 * @author zzz
 *
 */
public class Enlist {
	
	public String activityID; // 活动ID
	public String activityType; // 志愿服务类型
	public String title; // 标题
	public String releaseTime; //发布时间
	public int viewAcount; //浏览次数
	public String area; //区域，番禺
	private String returnType;//返回类型
	private String imgPath;//图片
	private String isRecommended;//是否推荐
	public Enlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Enlist(String activityID, String activityType, String title,
			String releaseTime, int viewAcount, String area) {
		super();
		this.activityID = activityID;
		this.activityType = activityType;
		this.title = title;
		this.releaseTime = releaseTime;
		this.viewAcount = viewAcount;
		this.area = area;
	}
	public Enlist(String title, String activityType,
			String releaseTime, int viewAcount, String area) {
		super();
		this.title = title;
		this.activityType = activityType;
		this.releaseTime = releaseTime;
		this.viewAcount = viewAcount;
		this.area = area;
	}
	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
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
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	public int getViewAcount() {
		return viewAcount;
	}
	public void setViewAcount(int viewAcount) {
		this.viewAcount = viewAcount;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
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
