package org.simpleframework.inject;

import com.lql.controller.frontend.MainPageController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.simpleframework.core.BeanContainer;

/**
 * @author lql
 * @date 2021/6/9 14:03
 * Description：
 */
public class DependencyInjectorTest {


    @DisplayName("依赖注入doIoc")
    @Test
    public void doIoc() {

        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.lql");

        Assertions.assertEquals(true, beanContainer.isLoaded());

        MainPageController mainPageController = (MainPageController)beanContainer.getBean(MainPageController.class);

        Assertions.assertEquals(true,mainPageController instanceof MainPageController);
        Assertions.assertEquals(null, mainPageController.getHeadLIneShopCategoryCombineService());
        //调用doIoc 方法
        new DependencyInject().doIoc();
        Assertions.assertNotEquals(true, mainPageController.getHeadLIneShopCategoryCombineService());

    }

}
