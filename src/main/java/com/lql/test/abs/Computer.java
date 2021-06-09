package com.lql.test.abs;

import com.lql.test.simplefactory.Keyboard;
import com.lql.test.simplefactory.Mouse;

/**
 * @author lql
 * @date 2021/6/4 14:54
 * Description：
 */
public interface Computer {

    Mouse mouse();
    Keyboard keyboard();
}
