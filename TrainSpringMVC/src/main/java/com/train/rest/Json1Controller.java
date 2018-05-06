package com.train.rest;


import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("json1")
public class Json1Controller {

    @Resource(name = "spittleDao")
    private SpittleDao dao;


    @RequestMapping(value = "/getSpittles", method = RequestMethod.GET)
    @ResponseBody
    public List<Spittle> getSpittles() {
        return dao.getAllSpittles();
    }


}
