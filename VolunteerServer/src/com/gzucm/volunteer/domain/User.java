package com.gzucm.volunteer.domain;

import java.util.Date;

public class User {
	private String userID;// 用户主键
	private String account;// 用户账号
	private String password;// 密码
	private String userName;// 真实姓名
	private String nickName;// 昵称
	private String sex;// 性别，数据字典设置
	private String address;// 地址
	private String portrait;// 头像
	private String telPhone;// 手机号
	private String email;// 邮箱
	private String introduce;// 个人简介
	private String volunteerType;// 志愿类型
	private String experience;// 志愿经历及特长
	private int applyCount;// 申请次数
	private String isCantonese;// 是否会粤语，数字字典设置
	private Date registerTime;// 注册时间
	private long volunteerLastTime;// 志愿时长

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getVolunteerType() {
		return volunteerType;
	}

	public void setVolunteerType(String volunteerType) {
		this.volunteerType = volunteerType;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public int getApplyCount() {
		return applyCount;
	}

	public void setApplyCount(int applyCount) {
		this.applyCount = applyCount;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public long getVolunteerLastTime() {
		return volunteerLastTime;
	}

	public void setVolunteerLastTime(long volunteerLastTime) {
		this.volunteerLastTime = volunteerLastTime;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIsCantonese() {
		return isCantonese;
	}

	public void setIsCantonese(String isCantonese) {
		this.isCantonese = isCantonese;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
