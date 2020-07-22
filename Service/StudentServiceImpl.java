package com.example.service;

import com.example.dao.StudentDao;
import com.example.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<StudentEntity> findAll(){
        return studentDao.findAll();
    }
    @Override
    public boolean save(StudentEntity studentEntity){
        System.out.println(studentEntity.toString());
        studentDao.save(studentEntity);
        return true;
    }
    @Override
    public StudentEntity findById(Integer id){
        Optional<StudentEntity> opt = studentDao.findById(id);
        return opt.get();
    }
    @Override
    public StudentEntity update(StudentEntity studentEntity){
        return studentDao.save(studentEntity);
    }
    @Override
    public void deleteById(Integer id){
        studentDao.deleteById(id);
    }


}
