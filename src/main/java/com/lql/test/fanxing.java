package com.lql.test;

/**
 * @author lql
 * @date 2021/6/3 14:56
 * Description：
 */
public class fanxing<L> {


    private L member;

    public fanxing(L temp) {
        this.member = temp;
    }

    public L hehe () {
        return this.member;
    }



    public <A> void printArray(A[] array) {

        for (A a : array) {
            System.out.printf("%s",a);
            System.out.println(" ");
        }
        System.out.println();
    }
}
