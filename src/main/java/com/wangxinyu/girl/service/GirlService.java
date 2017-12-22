package com.wangxinyu.girl.service;

import com.wangxinyu.girl.entity.Girl;
import com.wangxinyu.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Avenger
 * @describe: TODO
 * @create: 2017年12月22日 9:15
 **/
@Service
public class GirlService {

    @Autowired
    GirlRepository girlRepository;

    /**
     * 同时插入或者同时不插入
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertTwo(){
        Girl girl1 = new Girl();
        girl1.setAge(33);
        girl1.setCup("A");
        girlRepository.save(girl1);

        Girl girl2 = new Girl();
        girl2.setAge(23);
        girl2.setCup("DDDDDDD");
        girlRepository.save(girl2);

    }
}
