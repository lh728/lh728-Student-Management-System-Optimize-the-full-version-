package com.example.dao;

import com.example.entity.LoginEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginDao extends CrudRepository<LoginEntity,Integer> {
    List<LoginEntity> findByUsernameAndPassword(int username, int password);
}
