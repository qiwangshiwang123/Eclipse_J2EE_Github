package com.gzucm.volunteer.vo;

import java.util.List;

/**
 * 我的资料vo类
 */

public class Data {

	private List<String> zylx; //志愿类型   ,json请求操作获取志愿类型
	
	/**  保存操作   **/
	private String userID;// 用户主键
	private String name;
	private String sex;
	private String phone;
	private String email;
	private String address;
	private String volunteerType;
	private String content;
	private String imageUri;
	
	public Data() {
		super();
	}

	public Data(String userID, String name, String sex, String phone, String email,
			String address, String volunteerType, String content,
			String imageUri) {
		super();
		this.userID = userID;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.volunteerType = volunteerType;
		this.content = content;
		this.imageUri = imageUri;
	}

	public List<String> getZylx() {
		return zylx;
	}

	public void setZylx(List<String> zylx) {
		this.zylx = zylx;
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVolunteerType() {
		return volunteerType;
	}

	public void setVolunteerType(String volunteerType) {
		this.volunteerType = volunteerType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	
	
	
}
