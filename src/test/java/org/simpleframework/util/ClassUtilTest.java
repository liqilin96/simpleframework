package org.simpleframework.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * @author lql
 * @date 2021/6/7 17:00
 * Description：
 */
public class ClassUtilTest {

    @DisplayName("提取目标类方法： extractPackageClassTest" )
    @Test
    public void extractPackageClassTest() {

        Set<Class<?>> classSet = ClassUtil.extractPackageClass("com.lql.entity");

        Assertions.assertEquals(4,classSet.size());
    }

}
