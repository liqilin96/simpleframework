package com.lql.test.methodfactory;

import com.lql.test.simplefactory.HpMouse;
import com.lql.test.simplefactory.Mouse;

/**
 * @author lql
 * @date 2021/6/4 14:46
 * Description：
 */
public class HpMouseMethod implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
}
