package com.themodestwhite.uploaddownloadfile.entity;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.themodestwhite.uploaddownloadfile.utils.*;

public class FileDetails {
	private String fileName;
	private String keyName;
	

	private String description;
	private String userName;
	
	
	private Timestamp createDate;
	
	
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public Timestamp getDeleteDate() {
		return deleteDate;
	}

	private Timestamp updateDate;
	
	
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public void setDeleteDate(Timestamp deleteDate) {
		this.deleteDate = deleteDate;
	}

	private Timestamp deleteDate;
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

//	@JsonSerialize(using=JsonDateSerializer.class)
//	public Date getCreateDate() {
//		return createDate;
//	}
//
//	public void setCreateDate(Date createDate) {
//		this.createDate = createDate;
//	}

	
	
	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	@Override
	public String toString() {
		return "FileDetails [fileName=" + fileName + ", keyName=" + keyName + ", description=" + description
				+ ", userName=" + userName + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", deleteDate=" + deleteDate + "]";
	}

	
	
}
