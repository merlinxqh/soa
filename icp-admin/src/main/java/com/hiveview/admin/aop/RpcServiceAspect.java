package com.hiveview.admin.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by leo on 2017/11/8.
 */
@Component
@Aspect
public class RpcServiceAspect {
    private static final Logger log= LoggerFactory.getLogger(RpcServiceAspect.class);

    /**
     * 切入点
     */
    @Pointcut("execution(*  com.hiveview.admin.rpc..*(..))")
    public void aspect(){

    }

    /**
     * 前置通知
     */
    @Before("aspect()")
    public void before(JoinPoint joinPoint){
        log.info("前置通知开始.........");
        printPoint(joinPoint);
        log.info("前置通知结束.........");
    }

    /**
     * 后置通知
     * @param joinPoint
     */
    @After("aspect()")
    public void after(JoinPoint joinPoint){
        log.info("后置通知开始.........");
        printPoint(joinPoint);
        log.info("后置通知结束.........");
    }

    /**
     * 环绕通知
     * @param joinPoint
     */
//    @Around("aspect()")
    public void around(JoinPoint joinPoint){

        log.info("环绕通知开始.........");
        printPoint(joinPoint);
        log.info("环绕通知结束.........");
        try {
            ((ProceedingJoinPoint)joinPoint).proceed();
        }catch (Throwable e){
            log.info("",e.getMessage());
        }
    }

    /**
     * 后置返回通知
     */
    @AfterReturning("aspect()")
    public void afterReturn(JoinPoint joinPoint){
        log.info("后置返回通知开始.........");
        printPoint(joinPoint);
        log.info("后置返回通知结束.........");
    }

    /**
     * 配置抛出异常后通知
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(pointcut = "aspect()",throwing = "ex")
    public void afterThrow(JoinPoint joinPoint,Exception ex){
        log.info("抛出异常后通知开始.........");
        printPoint(joinPoint);
        log.info("抛出异常后通知结束.........");
        log.info("afterThrow " + joinPoint + "\t" + ex.getMessage());
    }

    public void printPoint(JoinPoint joinPoint){
       log.info("类型: "+joinPoint.getKind());
       log.info("参数: "+JSON.toJSONString(joinPoint.getArgs()));
       log.info(""+joinPoint.getSourceLocation());
       log.info(""+joinPoint.getTarget());
       log.info(""+joinPoint.getThis());
    }




}
