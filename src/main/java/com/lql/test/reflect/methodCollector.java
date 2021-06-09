package com.lql.test.reflect;

import java.lang.reflect.Method;

/**
 * @author lql
 * @date 2021/6/4 18:45
 * Description：
 */
public class methodCollector {

    public static void main(String[] args) throws Exception {


        Class<?> clazz = Class.forName("com.lql.test.reflect.ReflectTarget");

        System.out.println("========================================批量获取所有共有方法，包括父类");
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            System.out.println(method);
        }
        System.out.println("========================================批量获取所有方法，不包括父类");
        methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            System.out.println(method);
        }
        System.out.println("========================================获取单个公有方法");

        Method show1 = clazz.getMethod("show1", String.class);
        System.out.println(show1);

        System.out.println("========================================获取单个方法");
        Method show3 = clazz.getDeclaredMethod("show3");
        System.out.println(show3);


        System.out.println("=======================================调用方法");

        ReflectTarget target = (ReflectTarget) clazz.getConstructor().newInstance();

        show1.invoke(target, "I dont know");

        System.out.println("=======================================调用私有方法");

        Method show4 = clazz.getDeclaredMethod("show4", int.class);
        show4.setAccessible(true);
        Object invoke = show4.invoke(target, 250);

        System.out.println("返回的结果 ：" + invoke);

    }
}
