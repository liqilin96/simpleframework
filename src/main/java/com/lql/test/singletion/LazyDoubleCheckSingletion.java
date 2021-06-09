package com.lql.test.singletion;

/**
 * @author lql
 * @date 2021/6/7 18:41
 * Description：懒汉模式
 */
public class LazyDoubleCheckSingletion {

    private volatile static LazyDoubleCheckSingletion instance;

    private LazyDoubleCheckSingletion(){}

    public static LazyDoubleCheckSingletion getInstance() {
        if (instance == null) {
            synchronized (LazyDoubleCheckSingletion.class) {
                if (instance == null) {
                    instance = new LazyDoubleCheckSingletion();
                }
            }
        }
        return instance;
    }



}
