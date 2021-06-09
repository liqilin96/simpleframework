package com.lql.test.reflect;

import java.lang.reflect.Constructor;

/**
 * @author lql
 * @date 2021/6/4 15:48
 * Description：
 */
public class ConstructorCollector {

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("com.lql.test.reflect.ReflectTarget");

        System.out.println("===============================所有的public构造方法");
        Constructor<?>[] constructors = clazz.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            Constructor<?> constructor = constructors[i];
            System.out.println(constructor);
        }
        System.out.println("===============================所有的构造方法");
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (int i = 0; i < declaredConstructors.length; i++) {
            Constructor<?> declaredConstructor = declaredConstructors[i];
            System.out.println(declaredConstructor);
        }

        System.out.println("===============================获取指定public构造方法");
        Constructor<?> constructor = clazz.getConstructor(char.class);
        System.out.println(constructor);

        System.out.println("===============================获取指定构造方法，所有类型");

        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(Boolean.class);
        System.out.println(declaredConstructor);

        System.out.println("================================获取私有构造方法");
        Constructor<?> privateCon = clazz.getDeclaredConstructor(int.class);
        privateCon.setAccessible(true);
        ReflectTarget target = (ReflectTarget) privateCon.newInstance(2);
        System.out.println(target);




    }
}
