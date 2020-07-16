package com.example.service;

import com.example.dao.LoginDao;
import com.example.entity.LoginEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginService {
    @Autowired
    private LoginDao loginDao;
    public boolean Find(int username,int password){
        List<LoginEntity> userList = loginDao.findByUsernameAndPassword(username,password);
        return userList.size()>0;
    }
}
