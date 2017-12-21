package com.wangxinyu.girl.controller;

import com.wangxinyu.girl.Girl;
import com.wangxinyu.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Avenger
 * @describe: TODO
 * @create: 2017年12月21日 14:44
 **/
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    /**
    * 查询所有女生列表
    * 
    * @param 
    * @return 
    */
    @GetMapping("/girls")
    public List<Girl> girlList(){
        List<Girl> girls = new ArrayList<>();
        girls = girlRepository.findAll();
        return girls;
    }
    /**
     * 新增一个女生
     */
    @PostMapping(value = "/addGirl")
    public String addGirl(){
        return "s";
    }
}
