package com.gzucm.volunteer.domain;

import java.util.Date;

/**
 * 资讯表
 * 
 * @author 万允山
 * 
 */
public class Information {

	public String informationID; // 主键ID
	public String title; // 标题
	public String digest; // 摘要
	public String imgPath; // 图片路径
	public int num;  //阅读量
	public Date uploadTime;  //上传时间

	public String getInformationID() {
		return informationID;
	}

	public void setInformationID(String informationID) {
		this.informationID = informationID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	
	
}
