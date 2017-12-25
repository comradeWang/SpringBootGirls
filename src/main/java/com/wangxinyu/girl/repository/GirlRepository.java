package com.wangxinyu.girl.repository;

import com.wangxinyu.girl.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: Avenger
 * @describe: TODO
 * @create: 2017年12月21日 15:01
 **/
public interface GirlRepository extends JpaRepository<Girl,Integer>{

    public List<Girl> findByAge(Integer age);

}
