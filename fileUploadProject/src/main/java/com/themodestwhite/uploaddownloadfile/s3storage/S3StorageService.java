package com.themodestwhite.uploaddownloadfile.s3storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;


@Service
public class S3StorageService {
	
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("upload-dir");
	
	@Autowired
    private AmazonS3Client s3Client;
	
	@Value("${s3.bucket}")
	private String bucketName;
		

	public String store(MultipartFile multipartFile, String userName){
		try {
            //Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
			 	File fileToUpload = convertFromMultiPart(multipartFile);
	            String key = userName + "_" + fileToUpload.getName();

	            /* save file */
	            s3Client.putObject(bucketName, key, fileToUpload);
	            return key;
	            		
	       } catch (Exception e) {
        	throw new RuntimeException("FAIL!");
        }
	}
	
	public void deleteFile(String keyName){
		try {
                s3Client.deleteObject(bucketName, keyName);
	            	            		
	       } catch (Exception e) {
	    	   throw new RuntimeException("FAIL!" + e.getMessage());
        }
	}
	
	
	private File convertFromMultiPart(MultipartFile multipartFile) throws IOException {

		File file = new File(multipartFile.getOriginalFilename());
		file.createNewFile(); 
		FileOutputStream fos = new FileOutputStream(file); 
		fos.write(multipartFile.getBytes());
		fos.close(); 

		return file;
	}
	
	
	public byte[] downloadFile(String keyName) {
		
		try {
			
            S3Object s3object = s3Client.getObject(new GetObjectRequest(bucketName, keyName));
            System.out.println("Content-Type: "  + s3object.getObjectMetadata().getContentType());
            S3ObjectInputStream stream = s3object.getObjectContent();
            byte[] bytes = IOUtils.toByteArray(stream);
            return bytes;
            
        } catch (Exception ex) {
        	throw new  RuntimeException("FAIL!" + ex.getMessage());
        }
       
	}
	
	

//    public Resource loadFile(String filename) {
//        try {
//            Path file = rootLocation.resolve(filename);
//            Resource resource = new UrlResource(file.toUri());
//            if(resource.exists() || resource.isReadable()) {
//                return resource;
//            }else{
//            	throw nc
//            }
//        } catch (MalformedURLException e) {
//        	throw new RuntimeException("FAIL!");
//        }
//    }
    
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
}