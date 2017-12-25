package com.wangxinyu.girl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author: Avenger
 * @describe: TODO
 * @create: 2017年12月21日 14:34
 **/
@Entity
public class Girl {
    /**
     * id，自增
     */
    @Id
    @GeneratedValue
    private Integer id;

    private String cup;
    /**
     * 设置age 的最小值为18
     */
    @Min(value = 18,message = "未成年人禁止入内！")
    private Integer age;
    /**
     * 身高
     */
    @NotNull(message = "身高必传")
    private double tall;

    public Girl(){
        //必须是无参的构造方法，否则数据库会报错
    }

    public double getTall() {
        return tall;
    }

    public void setTall(double tall) {
        this.tall = tall;
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

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cup='" + cup + '\'' +
                ", age=" + age +
                '}';
    }
}
