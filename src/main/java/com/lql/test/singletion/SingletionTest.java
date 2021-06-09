package com.lql.test.singletion;

import java.lang.reflect.Constructor;

/**
 * @author lql
 * @date 2021/6/7 18:39
 * Description：
 */
public class SingletionTest {

    public static void main(String[] args) throws Exception {

        System.out.println(StarvingSingletion.getInstance());
        System.out.println(LazyDoubleCheckSingletion.getInstance());


        Class<LazyDoubleCheckSingletion> clazz = LazyDoubleCheckSingletion.class;

        Constructor<LazyDoubleCheckSingletion> constructor = clazz.getDeclaredConstructor();

        constructor.setAccessible(true);
        LazyDoubleCheckSingletion starvingSingletion = constructor.newInstance();


        System.out.println(starvingSingletion);

//        System.out.println(LazyDoubleCheckSingletion.getInstance());
    }
}
