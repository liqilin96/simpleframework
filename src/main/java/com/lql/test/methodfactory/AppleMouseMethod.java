package com.lql.test.methodfactory;

import com.lql.test.simplefactory.Mouse;

/**
 * @author lql
 * @date 2021/6/4 14:48
 * Description：
 */
public class AppleMouseMethod implements Mouse{

    @Override
    public void sayHi() {
        System.out.println("我是苹果鼠标……");
    }
}
