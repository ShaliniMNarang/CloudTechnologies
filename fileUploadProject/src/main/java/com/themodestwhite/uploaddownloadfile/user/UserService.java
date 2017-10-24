package com.themodestwhite.uploaddownloadfile.user;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.themodestwhite.uploaddownloadfile.dao.IUserDAO;
import com.themodestwhite.uploaddownloadfile.entity.User;

@Service
public class UserService {
	
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("upload-dir");
	
	@Autowired
    private IUserDAO userDao;
	
	public String login(String userName, String password){
		try {
				
            User user = userDao.getUserDetails(userName, password);
            if(user == null)
            	return null;
            StringBuffer sb = new StringBuffer();
            sb.append(user.getUserName());
            sb.append(":");
            sb.append(user.getFirstName());
            sb.append(":");
            sb.append(user.getLastName());
            
            return sb.toString();
	            		
	       }catch(org.springframework.dao.EmptyResultDataAccessException ex) {
	    	   return null;
	       }
		  catch (Exception e) {
        	throw new RuntimeException("FAIL in login!");
        }
	}

}
