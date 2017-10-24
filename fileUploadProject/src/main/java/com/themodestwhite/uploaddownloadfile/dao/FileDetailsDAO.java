package com.themodestwhite.uploaddownloadfile.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.themodestwhite.uploaddownloadfile.entity.FileDetails;
import com.themodestwhite.uploaddownloadfile.entity.FileDetailsRowMapper;

@Component
public class FileDetailsDAO implements IFileDetailsDAO{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<FileDetails> getAllFileDetails(String username) {
		String sql = "select filename, description,keyName, username, createdate, updatedate, deletedate from filedetails where username = ? ";
       	RowMapper<FileDetails> rowMapper = new FileDetailsRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, username);
	}

	@Override
	public FileDetails getFileDetails(String keyName) {
		try {
			String sql = "select filename, description, keyName, username, createdate, updatedate, deletedate from filedetails where keyname=?";
			RowMapper<FileDetails> rowMapper = new BeanPropertyRowMapper<FileDetails>(FileDetails.class);
			FileDetails fileDetails = jdbcTemplate.queryForObject(sql, rowMapper, keyName);
			return fileDetails;
		}catch(Exception ex) {
			return null;
		}
	}

	@Override
	public void addFileDetails(FileDetails fileDetails) {
		FileDetails fdOld = getFileDetails(fileDetails.getKeyName()) ;
		
		if(fdOld == null){
			//Add FileDetails
			String sql = "insert into filedetails(filename, keyname, description, username, createdate, updatedate, deletedate ) " + 
							"values (?,?,?,?,sysdate(), sysdate(),null)";
			jdbcTemplate.update(sql, fileDetails.getFileName(), fileDetails.getKeyName(), fileDetails.getDescription(), fileDetails.getUserName());
		}else {
			String sql = "update filedetails set updatedate = sysdate() where keyname = ?";
			jdbcTemplate.update(sql,  fileDetails.getKeyName());
		}
				
	}

	@Override
	public void updateFileDetails(FileDetails fileDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFileDetails(String userName, String keyName) {
		// TODO Auto-generated method stub
		String sql = "delete from filedetails where username=? and keyname=?";
		jdbcTemplate.update(sql, userName, keyName);
		
		
	}

}
