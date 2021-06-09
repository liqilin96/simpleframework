package org.simpleframework.inject;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.inject.annotation.Autowired;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * @author lql
 * @date 2021/6/8 19:01
 * Description：负责依赖注入的服务
 */
@Slf4j
public class DependencyInject {

    /**
     * Bean容器
     */
    private BeanContainer beanContainer;


    public DependencyInject() {
        //获取实例
        beanContainer = BeanContainer.getInstance();
    }

    /**
     * 执行ioc，针对AutoWired注解
     */
    public void doIoc() {

        Set<Class<?>> beanContainerClasses = beanContainer.getClasses();
        if (ValidationUtil.isEmpty(beanContainerClasses)) {
            log.warn("容器没有beans");
            return;
        }
        //1.遍历Bean容器中所有Class对象
        for (Class<?> clazz : beanContainerClasses) {
            //2.遍历Class对象的所有成员变量
            Field[] fields = clazz.getDeclaredFields();
            if (ValidationUtil.isEmpty(fields)) {
                continue;
            }
            for (Field field : fields) {
                //3.找出被Autowired标记的成员变量
                if (field.isAnnotationPresent(Autowired.class)) {

                    Autowired autowired = field.getAnnotation(Autowired.class);
                    String autowiredValue = autowired.name();

                    //4.获取这些成员变量的类型
                    Class<?> fieldType = field.getType();
                    //5.获取这些成员变量的类型在容器里对应的实例
                    Object fieldValue = getFieldInstance(fieldType, autowiredValue);
                    if (fieldValue == null) {
                        //没有获取到
                        throw new RuntimeException("无法从容器获取对应实例：" + fieldType.getName() + ",所需autowiredValue :" + autowiredValue);
                    } else {
                        //6.通过反射将对应的成员变量实例注入到成员变量所在类的实例里
                        Object targetBean = beanContainer.getBean(clazz);
                        ClassUtil.setField(field, targetBean, fieldValue, true);
                    }
                }
            }
        }

    }


    /**
     * @param fieldType 需要注入的属性Class
     * @return 根据Class在beanContainer里获取其实例或者实现类
     */
    private Object getFieldInstance(Class<?> fieldType, String autowiredValue) {

        Object fieldValue = beanContainer.getBean(fieldType);

        //如果是类直接返回
        if (fieldValue != null) {
            return fieldValue;
        } else {
            //可能是接口
            Class<?> implementedClass = getImplementClass(fieldType, autowiredValue);
            if (implementedClass != null) {
                return beanContainer.getBean(implementedClass);
            } else {
                //容器中没有
                return null;
            }
        }


    }

    //获取接口的实现类
    private Class<?> getImplementClass(Class<?> fieldType, String autowiredValue) {
        Set<Class<?>> classSet = beanContainer.getClassesBySuper(fieldType);

        if (!ValidationUtil.isEmpty(classSet)) {
            //@Autowired的name属性为默认值
            if (ValidationUtil.isEmpty(autowiredValue)) {
                if (classSet.size() == 1) {
                    return classSet.iterator().next();
                } else {
                    //如果多余两个实现类并且用户并未指定其中一个实现类则抛出异常
                    throw new RuntimeException("获取多个实现类 ：" + fieldType.getName() + ",请用@Autowired中name 属性标记");
                }
            } else {
                //@Autowired 注解的name属性不为默认值
                for (Class<?> clazz : classSet) {
                    if (autowiredValue.equals(clazz.getSimpleName())) {
                        return clazz;
                    }
                }
            }
        }
        return null;
    }
}
