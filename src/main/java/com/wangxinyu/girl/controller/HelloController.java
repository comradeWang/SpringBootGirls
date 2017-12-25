package com.wangxinyu.girl.controller;

import com.wangxinyu.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Avenger
 * @describe: TODO
 * @create: 2017年12月21日 9:19
 **/
@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;


    @RequestMapping(value = {"/hello","/hi"}, method = RequestMethod.GET)
    public String SayHi() {
        return girlProperties.getAge().toString();
    }
    @RequestMapping(value = "/wxy",method = RequestMethod.GET)
    public String ShowId(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return id.toString();
    }
}
