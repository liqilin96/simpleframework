package com.lql.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lql
 * @date 2021/6/5 10:08
 * Description： 自定义注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserInfoAnnotation {

            public String name();

            public int age() default 18;

            public String gender() default "男";

            public String[] language();

}
