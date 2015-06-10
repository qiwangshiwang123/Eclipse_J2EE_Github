package com.gzucm.volunteer.domain;

/**
 * 通告表
 * 
 * @author 万允山
 * 
 */
public class Announce {

	public String announceID; // 主键ID
	public String title; // 标题
	public String content; // 内容

	public String getAnnounceID() {
		return announceID;
	}

	public void setAnnounceID(String announceID) {
		this.announceID = announceID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
