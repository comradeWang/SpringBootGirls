package com.wangxinyu.girl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author: Avenger
 * @describe: TODO
 * @create: 2017年12月21日 14:34
 **/
@Entity
public class Girl {
    //id，自增
    @Id
    @GeneratedValue
    private Integer id;
    private String cup;
    private Integer age;
    public Girl(){
        //必须是无参的构造方法，否则数据库会报错
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCup() {
        return cup;
    }

    public void setCup(String cup) {
        this.cup = cup;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
