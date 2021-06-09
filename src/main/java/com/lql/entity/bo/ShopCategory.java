package com.lql.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * @author lql
 * @date 2021/6/3 14:32
 * Description：
 */
@Data
public class ShopCategory {

    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private ShopCategory parent;
}
