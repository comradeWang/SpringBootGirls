package com.wangxinyu.girl.controller;

import com.wangxinyu.girl.entity.Girl;
import com.wangxinyu.girl.repository.GirlRepository;
import com.wangxinyu.girl.service.GirlService;
import com.wangxinyu.girl.entity.Response;
import com.wangxinyu.girl.utils.ResponseUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Avenger
 * @describe: TODO
 * @create: 2017年12月21日 14:44
 **/
@RestController
public class GirlController {

    /**
     * 导入日志
     */
    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(GirlController.class);
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
        LOGGER.info("查询所有女生信息！");
        List<Girl> girls = new ArrayList<>();
        girls = girlRepository.findAll();
        return girls;
    }

    /**
     * 单个查询
     * @param id
     * @return
     */
    @GetMapping("/girls/{id}")
    public Girl findOneGirl(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }
    /**
     * 新增一个女生
     * @param girls
     * @return
     */
    @PostMapping(value = "/addGirl")
    public Response addGirl(@Valid Girl girls, BindingResult bindingResult){

        Girl girl = new Girl();
        girl.setAge(girls.getAge());
        girl.setCup(girls.getCup());
        girl.setTall(girls.getTall());
        /*插入女生时，女生的最小岁数为18,不能执行插入操作，并进行信息打印*/
        if (bindingResult.hasErrors()) {
            Response response=ResponseUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
            return response;
        }
        Response response = ResponseUtil.success(girlRepository.save(girl));
        return response;
    }


    /**
     * 更新girl
     * @param id
     * @param age
     * @param cup
     * @return
     */
    @PutMapping("/updateGirl/{id}")
    public Girl updateGirl(@PathVariable("id") int id,Integer age,String cup,Double tall){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCup(cup);
        girl.setTall(tall);
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

    @PostMapping("/getAge/{id}")
    public Response getAge(Integer id){


    }
}
