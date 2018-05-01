package com.train.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 处理异常
 */
@Controller
@RequestMapping("ex")
public class ExceptionController {

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("exception-student", "command", new Student());
    }

    @RequestMapping(value = "/addstudent", method = RequestMethod.POST)
    @ExceptionHandler({SpringException.class})
    public String addStudent(@ModelAttribute("HelloWeb") Student student,
                             ModelMap model) {
        if (student.getName().length() < 5) {
            throw new SpringException("Given name is too short");
        } else {
            model.addAttribute("name", student.getName());
        }
        if (student.getAge() < 10) {
            throw new SpringException("Given age is too low");
        } else {
            model.addAttribute("age", student.getAge());
        }
        model.addAttribute("id", student.getId());
        return "exception-result";
    }
}
