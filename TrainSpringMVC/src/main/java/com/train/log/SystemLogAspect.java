package com.train.log;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 切面
 */
@Aspect
@Component
public class SystemLogAspect {


    private static final Logger LOGGER = LoggerFactory.getLogger(SystemLogAspect.class);


    private static final Gson GSON = new Gson();

    /**
     * Service层切点
     */
    @Pointcut("@annotation(com.train.log.SystemServiceLog)")
    public void serviceAspect() {

    }


    /**
     * doServiceLog:获取注解参数，记录日志. <br/>
     *
     * @param joinPoint 切入点参数
     * @author lcma
     * @since JDK 1.7
     */
    @After("serviceAspect()")
    public void doServiceLog(JoinPoint joinPoint) throws Exception {
        LOGGER.info("---------------- AOP 切面日志-------------------");

        String admin = "管理员";
        StringBuilder s = new StringBuilder();
        s.append(admin);
        s.append(" ");
        s.append(getServiceMthodDescription(joinPoint));
        s.append(" ");
        s.append(getServiceMthodTableType(joinPoint));
        s.append(" ");
        s.append(getServiceMthodParams(joinPoint));

        try {
            LOGGER.info(s.toString());
            LOGGER.info("\n");
        } catch (Exception e) {
            LOGGER.error(SystemLogAspect.class.getSimpleName(), e);
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于service层注解  . <br/>
     */
    private String getServiceMthodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemServiceLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

    /**
     * 获取注解中对方法的数据表类型 用于service层注解 . <br/>
     */
    private int getServiceMthodTableType(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        int tableType = 0;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    tableType = method.getAnnotation(SystemServiceLog.class).tableType();
                    break;
                }
            }
        }
        return tableType;
    }

    /**
     * 获取json格式的参数. <br/>
     */
    private String getServiceMthodParams(JoinPoint joinPoint) throws Exception {
        Object[] arguments = joinPoint.getArgs();
        String params = GSON.toJson(arguments);
        return params;
    }
}