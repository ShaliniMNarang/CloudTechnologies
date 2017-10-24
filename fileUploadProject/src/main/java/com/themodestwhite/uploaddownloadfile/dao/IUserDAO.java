package com.themodestwhite.uploaddownloadfile.dao;

import java.util.List;

import com.themodestwhite.uploaddownloadfile.entity.User;;

public interface IUserDAO {
	User getUserDetails(String userName, String password);
    void addUser(User user);
 }
