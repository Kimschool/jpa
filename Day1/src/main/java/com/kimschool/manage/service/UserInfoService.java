package com.kimschool.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimschool.manage.dao.UserInfoDao;
import com.kimschool.manage.entity.User_Info;

@Service
public class UserInfoService {

	@Autowired
    private UserInfoDao userInfoDao;

//	public List<UserInfo> findAll() {
//		return userInfoDao.findAll();
//	}
}
