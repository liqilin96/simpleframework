package org.simpleframework.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lql
 * @date 2021/6/7 14:48
 * Description： 和类相关的通用工具
 */
@Slf4j
public class ClassUtil {


    public static final String FILE_PROTOCOL = "file";

    public static void main(String[] args) {

        extractPackageClass("com.lql.entity");
    }

    /**
     * @param packageName 包名
     * @return 提取给定包下类集合
     */
    public static Set<Class<?>> extractPackageClass(String packageName) {
        // 1.获取到类的加载器
        ClassLoader classLoader = getClassLoader();
        // 2. 通过类加载器获取到加载的资源
        URL url = classLoader.getResource(packageName.replace(".", "/"));

        if (url == null) {
            log.warn("无法获取任何东西，package:" + packageName);
            return null;
        }

        // 3. 依据不同的资源类型，采用不同的方式获取资源的集合
        Set<Class<?>> classSet = null;
        //过滤出文件类型的资源
        if (url.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)) {
            classSet = new HashSet<>();
            File packageDirectory = new File(url.getPath());
            extractClassFile(classSet, packageDirectory, packageName);
        }
//TODO 此处可以加入针对其他类型资源的处理
        return classSet;
    }

    /**
     * 递归获取目标package里面所有class文件（包括子package里的class文件）
     *
     * @param emptyClassSet 装载目标类的集合
     * @param fileSource    文件或者目录
     * @param packageName   包名
     */
    private static void extractClassFile(Set<Class<?>> emptyClassSet, File fileSource, String packageName) {

        //如果不是文件夹就终止
        if (!fileSource.isDirectory()) {
            return;
        }

        //如果是文件夹则获取文件夹下的文件或文件夹
        File[] files = fileSource.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {

                if (file.isDirectory()) {
                    return true;
                } else {
                    //获取文件的绝对值路径
                    String absolutePath = file.getAbsolutePath();
                    //是否以.class结尾
                    if (absolutePath.endsWith(".class")) {
                        //加载的不是文件，而是class实例
                        addToClassSet(absolutePath);
                    }
                }

                return false;
            }

            //根据class文件的绝对值路径，获取并生成class对象，并加入classSey中
            private void addToClassSet(String absolutePath) {
                //1.从class文件的绝对值路径提取包含了package类名，2.通过反射机制获取对应的class对象并加入classSet数组中
                String replaceStr = absolutePath.replace(File.separator, ".");
                String packagePath = replaceStr.substring(replaceStr.indexOf(packageName));
                String path = packagePath.substring(0, packagePath.lastIndexOf("."));
                emptyClassSet.add(getClass(path));

            }

            private Class<?> getClass(String path) {
                Class<?> clazz = null;
                try {
                    clazz = Class.forName(path);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return clazz;
            }
        });

        if (files != null) {
            for (File f : files) {
                extractClassFile(emptyClassSet, f, packageName);
            }
        }
    }


    /**
     * 获取classloader
     *
     * @return 当前ClassLoader
     */
    public static ClassLoader getClassLoader() {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        return classLoader;
    }


    /**
     * @param clazz      要实例化的class对象
     * @param <T>        class类型
     * @param accessible 是否暴利破解
     * @return 类的实例化
     */
    public static <T> T getInstance(Class<?> clazz, boolean accessible) {
        Constructor<?> constructor = null;
        T t = null;
        try {
            constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(accessible);
            t = (T) constructor.newInstance();
        } catch (Exception e) {
            log.error("newInstance error", e);
            throw new RuntimeException(e);
        }
        return t;
    }


    /**
     * 反射设置类的属性
     *
     * @param field      成员变量
     * @param target     类实例
     * @param value      要设置的成员变量的值
     * @param accessible 是否暴力破除
     */
    public static void setField(Field field, Object target, Object value, boolean accessible) {
        field.setAccessible(accessible);
        try {
            field.set(target, value);
        } catch (IllegalAccessException e) {
            log.error("setField error ", e);
            throw new RuntimeException(e);
        }
    }

}
