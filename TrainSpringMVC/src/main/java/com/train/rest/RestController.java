package com.train.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("json")
public class RestController {


    private static final String MAX_LONG_AS_SPRING = "-1";
    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @Resource(name = "spittleDao")
    private SpittleDao dao;


    /**
     * 方式一：古老的方式
     * <p>
     * ViewResolver
     *
     * @param max
     * @param count
     * @return
     */
    @RequestMapping(value = "/type1", method = RequestMethod.GET)
    public ModelAndView spittle1(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_SPRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        logger.debug("spittle1() max=" + max + " count=" + count, "mxl");
        List<Spittle> spittles = dao.findSpittles(max, count);
        ModelAndView view = new ModelAndView(new MappingJackson2JsonView());
        view.addObject("info", spittles);
        return view;
    }


    /**
     * 方式二：第二种使用JSON工具将对象序列化成json，常用工具Jackson，fastjson，gson。
     * <p>
     * 利用HttpServletResponse，然后获取response.getOutputStream()或response.getWriter()
     *
     * @param max
     * @param count
     * @return
     */
    @RequestMapping(value = "/type2", method = RequestMethod.GET)
    public @ResponseBody
    List<Spittle> spittle2(
            @RequestParam(value = "max") Long max,
            @RequestParam(value = "count") Integer count) {
        logger.debug("spittle2() max=" + max + " count=" + count, "mxl");
        return null;
    }


    /**
     * 方式三：SpringMVC3支持的方式，加上  依赖包即可
     * <p>
     * MessageConversion
     *
     * @param max
     * @param count
     * @return
     */
    @RequestMapping(value = "/type3", method = RequestMethod.GET)
    public @ResponseBody
    List<Spittle> spittle3(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_SPRING) long max,
            @RequestParam(value = "count", defaultValue = "-1") int count) {
        logger.debug("spittle3() max=" + max + " count=" + count, "mxl");
        return dao.findSpittles(max, count);
    }
}
