package org.simpleframework.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.annotation.Component;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.core.annotation.Repository;
import org.simpleframework.core.annotation.Service;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lql
 * @date 2021/6/8 13:20
 * Description：
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class BeanContainer {

    /**
     * 存放所有被配置标记的目标对象的Map
     */
    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();


    public int size() {
        return beanMap.size();
    }

    private static final List<Class<? extends Annotation>> BEAN_ANNOTATIONS = Arrays.asList(Component.class, Controller.class, Repository.class, Service.class);


    //容器是已经加载过bean
    private boolean loaded = false;

    public boolean isLoaded() {
        return loaded;
    }


    /**
     * 获取Bean容器
     *
     * @return
     */
    public static BeanContainer getInstance() {
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder {
        HOLDER;
        private BeanContainer instance;

        ContainerHolder() {
            instance = new BeanContainer();
        }
    }


    public synchronized void loadBeans(String packageName) {

        //判断bean容器是否被加载过
        if (isLoaded()) {
            log.warn("BeanContainer has been loaden...");
            return;
        }


        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);
        if (ValidationUtil.isEmpty(classSet)) {
            log.warn("提取不到任何东西，包名： " + packageName);
            return;
        }
        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> annotation : BEAN_ANNOTATIONS) {
                //如果类上面标记定义的注解
                if (clazz.isAnnotationPresent(annotation)) {
                    //将目标类本身作为键，目标类的实例作为值，放到beanMap中
                    beanMap.put(clazz, ClassUtil.getInstance(clazz, true));
                }
            }
        }
        loaded = true;
    }


    /**
     * 添加一个class对象及其bean 实例
     *
     * @param clazz Class对象
     * @param bean  Bean实例
     * @return 原有的Bean实例，没有则返回NUll
     */
    public Object addBean(Class<?> clazz, Object bean) {
        return beanMap.put(clazz, bean);
    }


    /**
     * 移除一个IOC容器管理的对象
     *
     * @param clazz
     * @return 返回被删除bean的实例，没有则返回null
     */
    public Object removeBean(Class<?> clazz) {
        return beanMap.remove(clazz);
    }

    /**
     * 根据Class对象获取Bean实例
     *
     * @param clazz Class对象
     * @return 返回Bean的实例
     */
    public Object getBean(Class<?> clazz) {
        return beanMap.get(clazz);
    }

    /**
     * 获取容器管理的所有Class对象集合
     *
     * @return
     */
    public Set<Class<?>> getClasses() {
        return beanMap.keySet();
    }


    /**
     * 获取所有Bean集合
     *
     * @return
     */
    public Set<Object> getBeans() {
        return new HashSet<>(beanMap.values());
    }


    /**
     * 根据注解筛选出Bean的Class集合
     *
     * @param annotation 注解
     * @return Class集合
     */
    public Set<Class<?>> getClassesByAnnotation(Class<? extends Annotation> annotation) {

        //1.获取beanMap的所有class对象
        Set<Class<?>> classes = getClasses();
        if (ValidationUtil.isEmpty(classes)) {
            log.warn("nothing in beanMap");
            return null;
        }
        //2.通过注解筛选被注解标记的class对象，并添加到classSet中
        Set<Class<?>> classSet = new HashSet<>();

        for (Class<?> clazz : classes) {
            if (clazz.isAnnotationPresent(annotation)) {
                classSet.add(clazz);
            }
        }
        System.out.println(classSet.size());
        return classSet.size() > 0 ? classSet : null;
    }

    /**
     * 通过接口或者父类获取实现类或子类的Class集合，不包括其本身
     *
     * @param interfaceOrClass
     * @return
     */
    public Set<Class<?>> getClassesBySuper(Class<?> interfaceOrClass) {

        //1.获取beanMap的所有class对象
        Set<Class<?>> classes = getClasses();
        if (ValidationUtil.isEmpty(classes)) {
            log.warn("nothing in beanMap");
            return null;
        }
        //2.判断classes里的元素是否是传入的接口或者类的子类，如果是则添加到classSet中
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz : classes) {
            //判断集合里的元素是否是传入的接口或者类的子类，排除本身
            if (interfaceOrClass.isAssignableFrom(clazz) && !clazz.equals(interfaceOrClass)) {
                classSet.add(clazz);
            }
        }
        return classSet.size() > 0 ? classSet : null;
    }
}
