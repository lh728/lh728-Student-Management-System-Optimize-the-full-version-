package com.example.controller;


import com.example.entity.StudentEntity;

import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class LoginController {
    @Autowired
    private com.example.service.LoginService loginService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/loginIndex")
    public String loginIndex(){
        return "loginIndex";
    }
    @GetMapping("/loginFail")
    public String loginFail(){
        return "loginFail";
    }
    @PostMapping("/getLogin")
    public String getLogin(@RequestParam("username")int username,@RequestParam("password")int password,Model model){
        boolean judge = loginService.Find(username,password);
        System.out.println(username);
        System.out.println(password);

        List<StudentEntity> saveStudent=studentService.findAll();
        model.addAttribute("saveStudent",saveStudent);
        if(judge == true){
            return "/studentIndex";
        }
        return "/loginFail";
    }

}
