package com.lql.test.abs;

/**
 * @author lql
 * @date 2021/6/4 15:01
 * Description：
 */
public class test {


    public static void main(String[] args) {


        Computer dell = new Dell();
        dell.mouse().sayHi();
        dell.keyboard().sayHello();


        Computer hp = new Hp();
        hp.mouse().sayHi();
        hp.keyboard().sayHello();
    }
}
