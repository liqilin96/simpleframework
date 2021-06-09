package org.simpleframework.util;

import java.util.Collection;
import java.util.Map;

/**
 * @author lql
 * @date 2021/6/8 14:29
 * Description：
 */
public class ValidationUtil {


    /**
     * Collection是否为null 或 size为0
     *
     * @param obj
     * @return 是否为null
     */
    public static boolean isEmpty(Collection<?> obj) {
        return (obj == null || obj.isEmpty());
    }


    /**
     * String 是否为null 或“”
     *
     * @param
     * @return
     */
    public static boolean isEmpty(String obj) {
        return (obj == null || "".equals(obj));
    }


    /**
     * 数组是否为null或者size为0
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object[] obj) {
        return obj == null || obj.length == 0;
    }


    /**
     * Map是否为null 或者size为0
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Map<?, ?> obj) {

        return obj == null || obj.isEmpty();

    }

}
