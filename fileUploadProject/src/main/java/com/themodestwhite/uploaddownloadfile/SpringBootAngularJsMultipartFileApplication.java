package com.themodestwhite.uploaddownloadfile;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.themodestwhite.uploaddownloadfile.s3storage.S3StorageService;

@SpringBootApplication
public class SpringBootAngularJsMultipartFileApplication implements CommandLineRunner {

	@Resource
	S3StorageService storageService;
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootAngularJsMultipartFileApplication.class, args);
    }
    
	@Override
	public void run(String... args) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}

}