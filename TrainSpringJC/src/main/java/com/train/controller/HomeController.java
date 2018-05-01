package com.train.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

/**
 *
 */
@Controller
public class HomeController {

    /**
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }
}
