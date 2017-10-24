package com.themodestwhite.uploaddownloadfile.dao;

import java.util.List;

import com.themodestwhite.uploaddownloadfile.entity.FileDetails;


public interface IFileDetailsDAO {
	List<FileDetails> getAllFileDetails(String username);
    FileDetails getFileDetails(String fileName);
    void addFileDetails(FileDetails fileDetails);
    void updateFileDetails(FileDetails fileDetails);
    void deleteFileDetails(String userName, String keyName);
}
