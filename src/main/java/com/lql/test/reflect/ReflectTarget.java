package com.lql.test.reflect;

import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;

/**
 * @author lql
 * @date 2021/6/4 15:20
 * Description：
 */
public class ReflectTarget {

    ReflectTarget(String str) {
        System.out.println("默认的构造函数：" + str);
    }

    public ReflectTarget() {
        System.out.println("无参构造器……");
    }


    public ReflectTarget(char name) {
        System.out.println("调用一个有参构造器 ： "+ name);
    }

    public ReflectTarget(String name,int index) {
        System.out.println("调用了多参构造器:name :" + name+ ", index = " + index);
    }

    protected ReflectTarget(Boolean b) {
        System.out.println("受保护的构造器：" + b);
    }

    private ReflectTarget(int index) {
        System.out.println("私有的构造函数 ： "+ index);
    }

//**************字段***************************
    public String name;
    protected int index;
    char type;
    private String userInfo;


    @Override
    public String toString() {
        return "ReflectTarget{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", type=" + type +
                ", userInfo='" + userInfo + '\'' +
                '}';
    }











    //******************************************************成员方法！

    public void show1(String s) {
        System.out.println("调用了公有的，String 参数的show1(): s =" + s);
    }

    protected void show2(){
        System.out.println("调用了受保护无参方法show2()");
    }

    void show3() {
        System.out.println("调用了默认的，无参方法show3()");
    }

    private String show4(int index) {
        System.out.println("调用了私有的，并有返回值，int参数的show4(), index = " + index);
        return "show4()的返回值";
    }
    




    public static void main(String[] args) throws Exception{

        ReflectTarget target = new ReflectTarget();

        Class<? extends ReflectTarget> aClass = target.getClass();

        System.out.println(aClass.getName());


        Class<ReflectTarget> aClass1 = ReflectTarget.class;

        System.out.println(aClass1.getName());

        Class<?> aClass2 = Class.forName("com.lql.test.reflect.ReflectTarget");
        System.out.println(aClass2.getName());


        System.out.println(aClass == aClass1);
        System.out.println(aClass == aClass2);
        System.out.println(aClass1 == aClass2);
    }
}
