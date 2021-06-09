package com.lql.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lql
 * @date 2021/6/7 10:32
 * Description：
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface CourseInfoAnnotation {

    //课程名称
    public String courseName();

    //课程标签
    public String courseTag();

    //课程简介
    public String courseProfile();

    //课程序号
    public int courseIndex() default 101;

}
