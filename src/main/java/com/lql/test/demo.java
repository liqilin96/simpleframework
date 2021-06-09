package com.lql.test;

/**
 * @author lql
 * @date 2021/6/3 14:56
 * Description：
 */
public class demo {


    public static void main(String[] args) {

        fanxing<String> str = new fanxing<>("abc");
        fanxing<Integer> igr = new fanxing<>(123);

        System.out.println(str.hehe().getClass());
        System.out.println(igr.hehe().getClass());

        Integer a1[] = {1,2,3,4,5};
        Double a2[] = {1.1,2.2,3.3,4.5};
        Character a3[] = {'A','B','C'};

        str.printArray(a1);
        str.printArray(a2);
        str.printArray(a3);
    }
}
