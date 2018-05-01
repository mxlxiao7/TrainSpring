package com.train.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 重定向实例
 */
@Controller
public class RedirectController {


    @RequestMapping(value = "/re-index", method = RequestMethod.GET)
    public String index() {
        return "redirect-index";
    }

    @RequestMapping(value = "/re-redirect", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:re-finalPage";
    }

    @RequestMapping(value = "/re-finalPage", method = RequestMethod.GET)
    public String finalPage() {
        return "redirect-final";
    }

}
