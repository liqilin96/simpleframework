package com.lql.test.abs;

import com.lql.test.simplefactory.HpKeyboard;
import com.lql.test.simplefactory.HpMouse;
import com.lql.test.simplefactory.Keyboard;
import com.lql.test.simplefactory.Mouse;

/**
 * @author lql
 * @date 2021/6/4 14:56
 * Description：
 */
public class Hp implements Computer {

    @Override
    public Mouse mouse() {
        return new HpMouse();
    }

    @Override
    public Keyboard keyboard() {
        return new HpKeyboard();
    }
}
