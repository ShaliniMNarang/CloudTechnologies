package com.themodestwhite.uploaddownloadfile.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;


public class FileDetailsRowMapper implements RowMapper<FileDetails> {
	@Override
	public FileDetails mapRow(ResultSet row, int rowNum) throws SQLException {
		FileDetails fileDetail = new FileDetails();
		//Date d = new Date(row.getDate("createDate").getTime());
		fileDetail.setCreateDate(row.getTimestamp("createdate"));
		fileDetail.setDeleteDate(row.getTimestamp("deleteDate"));
		fileDetail.setDescription(row.getString("description"));
		fileDetail.setFileName(row.getString("fileName"));
		fileDetail.setUpdateDate(row.getTimestamp("updateDate"));
		fileDetail.setUserName(row.getString("userName"));
		fileDetail.setKeyName(row.getString("keyName"));
		return fileDetail;
	}

}
