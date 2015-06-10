package com.gzucm.volunteer.domain;


/**
 * 数据字典表
 * 
 * @author 万允山
 * 
 */
public class SystemDDL {

	public String seqID; // 主键ID
	public String keyword; // 数据字典所属类型
	public String ddlCode; // 数据字典的code
	public String ddlName; // 数据字典的value

	public String getSeqID() {
		return seqID;
	}

	public void setSeqID(String seqID) {
		this.seqID = seqID;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDdlCode() {
		return ddlCode;
	}

	public void setDdlCode(String ddlCode) {
		this.ddlCode = ddlCode;
	}

	public String getDdlName() {
		return ddlName;
	}

	public void setDdlName(String ddlName) {
		this.ddlName = ddlName;
	}

}
