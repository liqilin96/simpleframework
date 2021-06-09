package org.simpleframework.core;

import com.lql.HelloServlet;
import com.lql.controller.frontend.MainPageController;
import com.lql.service.combine.HeadLIneShopCategoryCombineService;
import org.junit.jupiter.api.*;
import org.simpleframework.core.annotation.Controller;

import java.util.Set;

/**
 * @author lql
 * @date 2021/6/8 14:56
 * Description：单元测试
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeanContainerTest {

    private static BeanContainer beanContainer;


    @BeforeAll
    static void init() {
        beanContainer = BeanContainer.getInstance();
    }

    @Order(1)
    @DisplayName("加载目标类及其实例到BeanContainer：loadBeansTest")
    @Test
    public void loadBeansTest() {
        Assertions.assertEquals(false, beanContainer.isLoaded());
        beanContainer.loadBeans("com.lql");
        Assertions.assertEquals(6, beanContainer.size());
        Assertions.assertEquals(true, beanContainer.isLoaded());
    }

    @Order(2)
    @DisplayName("根据类获取其实例：getBeanTest")
    @Test
    public void getBean() {
        MainPageController bean = (MainPageController) beanContainer.getBean(MainPageController.class);
        Assertions.assertEquals(true, bean instanceof MainPageController);

        HelloServlet bean1 = (HelloServlet) beanContainer.getBean(HelloServlet.class);
        Assertions.assertEquals(false, bean1 instanceof HelloServlet);
    }

    @Order(3)
    @DisplayName("根据注解获取对应的实例： getClassesByAnnotationTest")
    @Test
    public void getClassesByAnnotation() {
        Assertions.assertEquals(true, beanContainer.isLoaded());
        Set<Class<?>> classSet = beanContainer.getClassesByAnnotation(Controller.class);
        System.out.println(classSet);
        Assertions.assertEquals(3, classSet.size());
    }


    @Order(4)
    @DisplayName("根据接口获取实现类:getClassesBySuperTest")
    @Test
    public void getClassesBySuper() {
        Assertions.assertEquals(true, beanContainer.isLoaded());
        Assertions.assertEquals(1, beanContainer.getClassesBySuper(HeadLIneShopCategoryCombineService.class).size());
    }
}
