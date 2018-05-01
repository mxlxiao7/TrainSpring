package com.train.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


/**
 * 表单处理
 */
@Controller
@RequestMapping("student")
public class StudentController {

    @Resource(name = "studentService")
    private StudentService studentService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView student() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("student-show");
        mav.addObject("command", new Student());
        return mav;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(
            @ModelAttribute("student") Student student,
            ModelMap model) {
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("id", student.getId());
        return "student-result";
    }

    //@ResponseBody(之前我因为加了这个注解，导致页面访问一直是406错误，注释了就好啦，具体为啥我暂时还不知道)
    @RequestMapping(value = "/getAllStudent", method = RequestMethod.GET)
    public ModelAndView getAllStudent() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("student-display");
        mav.addObject("students", studentService.getAllStudent());
        return mav;
    }
}
