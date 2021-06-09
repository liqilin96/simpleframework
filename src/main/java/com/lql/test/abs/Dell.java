package com.lql.test.abs;

import com.lql.test.simplefactory.DellKeyboard;
import com.lql.test.simplefactory.DellMouse;
import com.lql.test.simplefactory.Keyboard;
import com.lql.test.simplefactory.Mouse;

/**
 * @author lql
 * @date 2021/6/4 14:55
 * Description：
 */
public class Dell implements Computer {


    @Override
    public Mouse mouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard keyboard() {
        return new DellKeyboard();
    }
}

