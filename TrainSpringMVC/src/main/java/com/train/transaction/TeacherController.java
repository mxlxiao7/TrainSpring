package com.train.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("teacher")
public class TeacherController {


    private static final String MAX_LONG_AS_SPRING = "-1";
    private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Resource(name = "teacherService")
    private TeacherService service;

    /**
     * 方式一：古老的方式  ViewResolver
     *
     * @param name
     * @param age
     * @param marks
     * @param year
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addTeacher(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "age", defaultValue = "0") Integer age,
            @RequestParam(value = "marks", defaultValue = "0") Integer marks,
            @RequestParam(value = "year", defaultValue = "0") Integer year) {

        Teacher teacher = new Teacher(name, age, marks, year);
        logger.debug("addTeacher() " + teacher.toString());
        service.addTeacher(teacher);

        ModelAndView view = new ModelAndView(new MappingJackson2JsonView());
        view.addObject("info", teacher);
        return view;
    }


    /**
     * 方式二：SpringMVC3支持的方式，加上依赖包即可
     * <p>
     * MappingJackson2HttpMessageConverter
     *
     * @return
     */
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public List<Teacher> getAll() {
        logger.debug("getAll()");
        List<Teacher> teachers = service.getAllTeacher();
        return teachers;
    }
}
