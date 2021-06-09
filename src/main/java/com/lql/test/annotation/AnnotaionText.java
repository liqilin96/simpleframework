package com.lql.test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author lql
 * @date 2021/6/7 10:36
 * Description：
 */
public class AnnotaionText {


    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("com.lql.test.annotation.AnnotationDemo");

        //成员注解
        Field author = clazz.getDeclaredField("author");
        boolean annotationPresent = author.isAnnotationPresent(UserInfoAnnotation.class);
        if (annotationPresent) {
            Annotation[] annotations = author.getAnnotations();
            for (int i = 0; i < annotations.length; i++) {
                UserInfoAnnotation userInfoAnnotation = (UserInfoAnnotation) annotations[i];
                System.out.println("用户名称： " + userInfoAnnotation.name() + ", 用户性别：" + userInfoAnnotation.gender()
                + ",用户年纪：" + userInfoAnnotation.age());

                for (String langu :  userInfoAnnotation.language()) {
                    System.out.println("用户会的语言：" +  langu);
                }
            }
        }


        //类注解
//        Annotation[] clazzAnnotations = clazz.getAnnotations();
//
//        for (int i = 0; i < clazzAnnotations.length; i++) {
//            CourseInfoAnnotation courseInfoAnnotation = (CourseInfoAnnotation) clazzAnnotations[i];
//            System.out.println("课程名：" + courseInfoAnnotation.courseName()+ ", 课程简介 ： " + courseInfoAnnotation.courseProfile() + " ，课程标签：" + courseInfoAnnotation.courseTag() + ", 课程序号：" + courseInfoAnnotation.courseIndex());
//        }


        //方法注解

//        Constructor<?> constructor = clazz.getDeclaredConstructor();
//        AnnotationDemo annotationDemo = (AnnotationDemo) constructor.newInstance();
//        Method method = clazz.getDeclaredMethod("courseText");
//        method.invoke(annotationDemo);
//        if (method.isAnnotationPresent(CourseInfoAnnotation.class)) {
//            Annotation[] annotations = method.getAnnotations();
//
//            CourseInfoAnnotation annotation = method.getAnnotation(CourseInfoAnnotation.class);
//            System.out.println("课程名：" + annotation.courseName() + ", 课程简介 ： " + annotation.courseProfile() + " ，课程标签：" + annotation.courseTag() + ", 课程序号：" + annotation.courseIndex());
//
////            for (int i = 0; i < annotations.length; i++) {
////                CourseInfoAnnotation courseInfoAnnotation = (CourseInfoAnnotation) annotations[i];
////                System.out.println("课程名：" + courseInfoAnnotation.courseName() + ", 课程简介 ： " + courseInfoAnnotation.courseProfile() + " ，课程标签：" + courseInfoAnnotation.courseTag() + ", 课程序号：" + courseInfoAnnotation.courseIndex());
////            }
//        }

    }
}


@CourseInfoAnnotation(courseName = "Java从入门到入坟", courseProfile = "让你学个掉毛的java", courseTag = "面试")
class AnnotationDemo {

    @UserInfoAnnotation(name = "lql", language = {"java", "Mysql"})
    private String author;


    @CourseInfoAnnotation(courseName = "易买网", courseProfile = "电商项目", courseTag = "测试", courseIndex = 25041)
    public void courseText() {
        System.out.println("不写方法体，测试注解而已");
    }

}
