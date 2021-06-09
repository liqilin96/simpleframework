package com.lql.test.methodfactory;


import com.lql.test.simplefactory.Mouse;

/**
 * @author lql
 * @date 2021/6/4 14:49
 * Description：
 */
public class AppleMouse implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new AppleMouseMethod();
    }
}
