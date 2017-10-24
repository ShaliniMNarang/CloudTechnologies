package com.themodestwhite.uploaddownloadfile.dbStorage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.themodestwhite.uploaddownloadfile.entity.FileDetails;
import com.themodestwhite.uploaddownloadfile.dao.FileDetailsDAO;
import com.themodestwhite.uploaddownloadfile.dao.IFileDetailsDAO;

@Service
public class DBStrorageService {
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("upload-dir");

	@Autowired
	private  IFileDetailsDAO fileDetailDao;
	
	public void addFile(FileDetails fileDetails){
		try {
           fileDetailDao.addFileDetails(fileDetails);
        } catch (Exception e) {
        	throw new RuntimeException("FAIL!" + e.getMessage());
        }
	}
	
	public List<FileDetails> getAllFiles(String userName){
		try {
			//TODO : return as JSON String
			List<FileDetails> fileDetails =  fileDetailDao.getAllFileDetails(userName);
			return fileDetails;
        } catch (Exception e) {
        	throw new RuntimeException("FAIL!" + e.getMessage());
        }
	}
	
	public void deleteFile(String userName, String keyName){
		try {
			fileDetailDao.deleteFileDetails(userName, keyName);
        } catch (Exception e) {
        	throw new RuntimeException("FAIL!" + e.getMessage());
        }
	}

}
