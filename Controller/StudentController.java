package com.example.controller;

import com.example.entity.StudentEntity;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/getLogin")
    public String toAddStudent(Model model){
        List<StudentEntity> saveStudent=studentService.findAll();
        model.addAttribute("saveStudent",saveStudent);
        return "/studentIndex";
    }

    @GetMapping("/ask")
    public String showInfo(@RequestParam("id")int id,Model model){
        //List<StudentEntity> showInfo =studentService.findAll();
        StudentEntity showInfo =studentService.findById(id);
        model.addAttribute("showInfo",showInfo);
        return "/ask";
    }

    //根据ID修改信息
    @GetMapping("update/{id}")
    public ModelAndView findById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("studentEntity",studentService.findById(id));
        return new ModelAndView("/update","model",model);
    }
    @GetMapping("/update")
    @ResponseBody
    public StudentEntity modify(@RequestParam("id")int id, @RequestParam("name")String name, @RequestParam("sex")String sex, @RequestParam("age")int age){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(id);
        studentEntity.setName(name);
        studentEntity.setSex(sex);
        studentEntity.setAge(age);
        return studentService.update(studentEntity);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id){
        studentService.deleteById(id);
        return  new ModelAndView("redirect:/getLogin");
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "/add";
    }
    @RequestMapping("/toAskId")
    public String toAskId(){
        return "/id";
    }

    @RequestMapping("/save")
    public String saveStudent(@RequestParam("id")int id,@RequestParam("name")String name,@RequestParam("sex")String sex,@RequestParam("age")int age,Model model){
        List<StudentEntity> saveStudent=studentService.findAll();
        model.addAttribute("saveStudent",saveStudent);
        StudentEntity se = new StudentEntity();
        se.setId(id);
        se.setSex(sex);
        se.setName(name);
        se.setAge(age);
        studentService.save(se);
        return "/studentIndex";
    }

}

