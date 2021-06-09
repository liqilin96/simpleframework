package com.lql.test.singletion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author lql
 * @date 2021/6/8 12:43
 * Description：
 */
public class singleton {

    public static void main(String[] args) throws Exception{

        System.out.println(EnumStarvingSingletion.getInstance());
        Class<EnumStarvingSingletion> clazz = EnumStarvingSingletion.class;

        Constructor<EnumStarvingSingletion> constructor = clazz.getDeclaredConstructor();

        constructor.setAccessible(true);
        EnumStarvingSingletion singletion = constructor.newInstance();

        System.out.println(singletion.getInstance());


    }
}
