package com.lql.test.methodfactory;

import com.lql.test.simplefactory.DellMouse;
import com.lql.test.simplefactory.Mouse;

/**
 * @author lql
 * @date 2021/6/4 14:46
 * Description：
 */
public class DellMouseMethod implements MouseFactory{
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
}
