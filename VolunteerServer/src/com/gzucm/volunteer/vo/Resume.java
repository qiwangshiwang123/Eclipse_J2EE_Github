package com.gzucm.volunteer.vo;

import java.util.List;

public class Resume {

	private int type = 0;
	private List<String> yx; //服务意向
	
	private String userID;// 用户主键
	private String name;
	private String sex;
	private String cantonese;
	private String experience;
	private String intention;
	private String telephone;
	private String email;
	private String college;
	private String province;
	private String city;
	private String area;
	private String imageUri;
	
	public Resume() {
		super();
	}
	
	

	public Resume(String userID, String name, String sex, String cantonese,
			String experience, String intention, String telephone,
			String email, String college, String province, String city,
			String area) {
		super();
		this.userID = userID;
		this.name = name;
		this.sex = sex;
		this.cantonese = cantonese;
		this.experience = experience;
		this.intention = intention;
		this.telephone = telephone;
		this.email = email;
		this.college = college;
		this.province = province;
		this.city = city;
		this.area = area;
	}



	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<String> getYx() {
		return yx;
	}
	public void setYx(List<String> yx) {
		this.yx = yx;
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
	public String getCantonese() {
		return cantonese;
	}
	public void setCantonese(String cantonese) {
		this.cantonese = cantonese;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getIntention() {
		return intention;
	}
	public void setIntention(String intention) {
		this.intention = intention;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getImageUri() {
		return imageUri;
	}
	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	
	
}
