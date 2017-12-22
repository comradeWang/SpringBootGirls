package com.wangxinyu.girl.controller;

import com.wangxinyu.girl.entity.Girl;
import com.wangxinyu.girl.repository.GirlRepository;
import com.wangxinyu.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    GirlService service;

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
     * @param age
     * @param cup
     * @return
     */
    @PostMapping(value = "/addGirl")
    public Girl addGirl(@RequestParam("age") Integer age,@RequestParam("cup") String cup){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCup(cup);
        return girlRepository.save(girl);
    }

    /**
     * 单个查询
     * @param id
     * @return
     */
    @PostMapping("/findOneGirl/{id}")
    public Girl findOneGirl(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 更新girl但是没有成功，明天看老师怎么说
     * @param id
     * @param age
     * @param cup
     * @return
     */
    @PutMapping("/updateGirl/{id}")
    public Girl updateGirl(@PathVariable("id") int id,Integer age,String cup){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCup(cup);
        return girlRepository.save(girl);
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping("/deleteGirl/{id}")
    public void deleteGirl(@PathVariable("id") int id){
        girlRepository.delete(id);
    }

    /**
     * 用年龄查询
     * @param age
     * @return
     */
    @PostMapping("/findByAge/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping("insertTwo")
    public void insertTwo(){
        service.insertTwo();
    }
}
