package com.lql.service.solo.impl;

import com.lql.entity.bo.HeadLine;
import com.lql.entity.bo.ShopCategory;
import com.lql.entity.dto.Result;
import com.lql.service.solo.ShopCategoryService;
import org.simpleframework.core.annotation.Service;

import java.util.List;

/**
 * @author lql
 * @date 2021/6/3 17:27
 * Description：
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Override
    public Result<Boolean> addShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<Boolean> removeShopCategory(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<HeadLine> QueryShopCategoryById(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize) {
        return null;
    }
}
