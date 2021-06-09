package com.lql.test.methodfactory;

/**
 * @author lql
 * @date 2021/6/4 14:47
 * Description：
 */
public class MethodFactory {


    public static void main(String[] args) {

        MouseFactory mouseFactory = new DellMouseMethod();
        mouseFactory.createMouse().sayHi();

        MouseFactory hpMouseMethod = new HpMouseMethod();
        hpMouseMethod.createMouse().sayHi();


        MouseFactory apple = new AppleMouse();
        apple.createMouse().sayHi();
    }
}
