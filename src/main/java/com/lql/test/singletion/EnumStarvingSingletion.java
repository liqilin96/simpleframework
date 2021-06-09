package com.lql.test.singletion;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author lql
 * @date 2021/6/8 10:33
 * Description：
 */
public class EnumStarvingSingletion {

    private EnumStarvingSingletion(){}

    public static EnumStarvingSingletion getInstance() {
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder {
        HOLDER;

        private EnumStarvingSingletion instance;

        ContainerHolder() {
            instance = new EnumStarvingSingletion();
        }

    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<ContainerHolder> clazz = ContainerHolder.class;

        Constructor<ContainerHolder> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        System.out.println(EnumStarvingSingletion.getInstance());
        System.out.println(constructor.newInstance());


    }

}
