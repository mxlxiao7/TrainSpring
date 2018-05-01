package com.train.log;


import java.lang.annotation.*;


/**
 * 自定义注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {

    /**
     * 日志描述
     * @return
     */
    String description() default "";

    /**
     * 操作表类型
     * @return
     */
    int tableType() default 0;

}
