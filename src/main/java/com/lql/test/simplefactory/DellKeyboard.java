package com.lql.test.simplefactory;

/**
 * @author lql
 * @date 2021/6/4 14:59
 * Description：
 */
public class DellKeyboard implements Keyboard{
    @Override
    public void sayHello() {
        System.out.println("我是戴尔键盘……");
    }
}
