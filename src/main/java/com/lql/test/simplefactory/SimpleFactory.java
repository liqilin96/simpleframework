package com.lql.test.simplefactory;

/**
 * @author lql
 * @date 2021/6/4 14:42
 * Description：
 */
public class SimpleFactory {

    public static Mouse create(int type) {

        switch (type) {
            case 0:return new DellMouse();
            case 1:return new HpMouse();
            default:return new DellMouse();
        }

    }

    public static void main(String[] args) {

        Mouse mouse = SimpleFactory.create(0);
        mouse.sayHi();
    }
}
