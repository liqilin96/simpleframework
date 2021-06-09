package com.lql.test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author lql
 * @date 2021/6/4 18:12
 * Description：
 */
public class FieldCollector {

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("com.lql.test.reflect.ReflectTarget");

        System.out.println("=================================获取所有public成员");
        Field[] fields = clazz.getFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            System.out.println(field);
        }
        System.out.println("=================================获取所有成员");

        fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            System.out.println(field);
        }

        System.out.println("=================================获取指定public成员");
        Field name = clazz.getField("name");
        System.out.println(name);

        System.out.println("=================================获取指定成员");
        //如果字段不存在则会报错 NoSuchFieldException
        Field name1 = clazz.getDeclaredField("name");
        Field userInfo = clazz.getDeclaredField("userInfo");
        System.out.println(name1);
        System.out.println(userInfo);

        System.out.println("=================================给成员赋值");

        Constructor<?> constructor = clazz.getConstructor();
        ReflectTarget reflectTarget = (ReflectTarget) constructor.newInstance();
        name.set(reflectTarget,"lql");
        userInfo.setAccessible(true);

        userInfo.set(reflectTarget,"今天下雨，不想上班");

        System.out.println(reflectTarget);



    }
}
