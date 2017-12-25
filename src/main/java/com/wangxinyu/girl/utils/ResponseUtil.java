package com.wangxinyu.girl.utils;

import com.wangxinyu.girl.entity.Response;

/**
 *  返回数据utils
 * @author: Avenger
 * @describe: TODO
 * @create: 2017年12月22日 13:40
 **/
public class ResponseUtil {
    public static Response success(Object object){
        Response response = new Response();
        response.setErrorCode(0);
        response.setMsg("请求成功！");
        response.setData(object);
        return response;
    }

    /**
     * 请求成功但是返回数据为空时
     * @return
     */
    public static Response success(){
        return success(null);
    }
    public static Response error(Integer errorCode,String message){
        Response response = new Response();
        response.setErrorCode(errorCode);
        response.setMsg(message);
        response.setData(null);
        return response;
    }
}
