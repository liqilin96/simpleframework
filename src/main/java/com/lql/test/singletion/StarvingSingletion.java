package com.lql.test.singletion;

/**
 * @author lql
 * @date 2021/6/7 18:37
 * Description： 饿汉模式
 */
public class StarvingSingletion {

    private static final StarvingSingletion STARVING_SINGLETION = new StarvingSingletion();

    private StarvingSingletion() {
    }

    public static StarvingSingletion getInstance() {
        return STARVING_SINGLETION;
    }
}
