package com.train.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 访问静态页面
 */
@Controller
public class StaticController {

    @RequestMapping(value = "/static-index", method = RequestMethod.GET)
    public String index() {
        return "static-index";
    }

    @RequestMapping(value = "/static-page", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:/pages/static-final.html";
    }


}
