package com.train.jdbc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("person")
public class PersonController {

    @Resource(name = "personService")
    private PersonService service;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView person() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("person-show");
        mav.addObject("command", new Person());
        return mav;
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public String addPerson(
            @ModelAttribute("person") Person person,
            ModelMap model) {
        model.addAttribute("name", person.getName());
        model.addAttribute("age", person.getAge());
        model.addAttribute("id", person.getId());
        service.addPerson(person);
        return "person-result";
    }


    @RequestMapping(value = "/getAllPerson", method = RequestMethod.GET)
    public ModelAndView getAllPerson() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("person-display");
        mav.addObject("personList", service.getAllPerson());
        return mav;
    }
}
