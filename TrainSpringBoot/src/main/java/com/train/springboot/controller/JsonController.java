package com.train.springboot.controller;


import com.train.springboot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class JsonController {

    @RequestMapping(value = "/getPerson")
    @ResponseBody
    public Object getPerson() {
        Person p = new Person();
        p.setId(1000000L);
        p.setName("leon");
        p.setAge(29);
//        p.setMessage("hello spring boot");
        p.setMessage(null);
        p.setHobby("爬山");

        return p;
    }


}
