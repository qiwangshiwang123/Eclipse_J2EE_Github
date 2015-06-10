package com.gzucm.volunteer.vo;


/**
 * 资讯
 * 
 * @author 万允山
 * 
 */
public class Info {

	public String informationID; // 主键ID
	public String title; // 标题
	public String digest; // 摘要
	public String imgPath; // 图片路径
	public int num;  //阅读量
	public String uploadTime;  //上传时间

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

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

}
