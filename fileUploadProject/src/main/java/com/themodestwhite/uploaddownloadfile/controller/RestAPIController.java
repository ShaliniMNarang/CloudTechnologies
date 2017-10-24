package com.themodestwhite.uploaddownloadfile.controller;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.themodestwhite.uploaddownloadfile.dbStorage.DBStrorageService;
import com.themodestwhite.uploaddownloadfile.entity.FileDetails;
import com.themodestwhite.uploaddownloadfile.s3storage.S3StorageService;
import com.themodestwhite.uploaddownloadfile.user.UserService;

@RestController
@RequestMapping("/api")
public class RestAPIController {

	@Autowired
	S3StorageService storageService;
	
	@Autowired
	DBStrorageService dbStorageService;
	
	@Autowired
	UserService userService;
	

    // Multiple file upload
    @PostMapping("/uploadfile")
    public String uploadFileMulti(
            @RequestParam("uploadfile") MultipartFile file,
            @RequestParam("username") String userName,
            @RequestParam("description") String description) throws Exception {

    	try {
			String key = storageService.store(file, userName);
			
			FileDetails fileDetails = new FileDetails();
			fileDetails.setFileName(file.getOriginalFilename());
			fileDetails.setKeyName(key);
			fileDetails.setDescription(description);
			fileDetails.setUserName(userName);
			
			dbStorageService.addFile(fileDetails);
			return "You successfully uploaded - " + file.getOriginalFilename();
		} catch (Exception e) {
			throw new Exception("FAIL! Maybe You had uploaded the file before or the file's size > 500KB");
		}
    }
    
    @GetMapping("/getallfiles")
	public ResponseEntity<List<FileDetails>> getAllFiles(@RequestParam("username") String userName) {
     		return new ResponseEntity<List<FileDetails>>(dbStorageService.getAllFiles(userName), HttpStatus.OK);
	}
    
    @GetMapping("/downloadFile")
   	public ResponseEntity<Resource> getAllFiles(
   			@RequestParam("username") String userName,
   			@RequestParam("filename") String fileName,
   			@RequestParam("keyname") String keyName
   			) {

   		byte[] bytes = storageService.downloadFile(keyName);
   		
   		InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(bytes));
   		
   		HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

   	    return ResponseEntity.ok()
   	            .headers(headers)
   	            .contentLength(bytes.length)
   	            .contentType(MediaType.parseMediaType("application/octet-stream"))
   	            .header("Content-Disposition", "attachment;filename=" + "\"" + fileName + "\"" )
   	            .body(resource);
        
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        httpHeaders.setContentLength(bytes.length);
//        httpHeaders.setContentDispositionFormData("attachment", keyName);
//
//        return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
   	}
    

    @PostMapping("/deletefile")
	public void deleteFile(
			@RequestParam("username") String userName,		
			@RequestParam("filekeyname") String fileKeyName
			) {
    	try {
    		//delete from DB
    		dbStorageService.deleteFile(userName, fileKeyName);
    		
    		//delete from s3 storage
    		storageService.deleteFile(fileKeyName);
			
		} catch (Exception e) {
			try {
				throw new Exception("FAIL! delete file is unsuccessful ");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

    

	//User Login
    @PostMapping("/loginUser")
    public String loginUser(
            @RequestParam("username") String userName,
            @RequestParam("password") String password) throws Exception {

    	try {
    			String userName1 = userService.login(userName, password);
    			System.out.println("Login " + userName1);
    			return userName1;
		} catch (Exception e) {
			throw new Exception("FAIL! Maybe You had uploaded the file before or the file's size > 500KB");
		}
    }
    
}
