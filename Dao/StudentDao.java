package com.example.dao;

import com.example.entity.StudentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentDao extends JpaRepository<StudentEntity,Integer> {
    void deleteById(int id);
    Optional<StudentEntity> findById(Integer id);
}
