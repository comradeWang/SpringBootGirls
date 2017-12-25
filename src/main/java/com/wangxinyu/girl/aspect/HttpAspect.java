package com.wangxinyu.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author: Avenger
 * @describe: aop
 * @create: 2017年12月22日 10:03
 **/
@Aspect
@Component
public class HttpAspect {

    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 这个是定义一个切入点，以后就可以直接调用了，就不用每个都写一遍
     */
    @Pointcut("execution(public * com.wangxinyu.girl.controller.GirlController.*(..))")
    public void log(){
    }

    /**
     * 之前
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        //记录http请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        javax.servlet.http.HttpServletRequest request=attributes.getRequest();
        //url
        LOGGER.info("url={}", request.getRequestURI());
        //method
        LOGGER.info("method={}",request.getMethod());
        //ip
        LOGGER.info("ip={}", request.getRemoteAddr());
        //类方法
        LOGGER.info("class_name={}",joinPoint.getSignature().getDeclaringTypeName()+","+joinPoint.getSignature().getName());
        //参数
        LOGGER.info("args={}", joinPoint.getArgs());
    }

    /**
     * 在方法执行之后，执行一下代码
     *
     */
    @After("log()")
    public void doAfter(){
        LOGGER.info("222222222222222222");
    }

    /**
     * 获取返回内容
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        LOGGER.info("response={}", object.toString());
    }

}
