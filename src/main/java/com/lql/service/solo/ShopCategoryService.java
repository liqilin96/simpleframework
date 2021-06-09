package com.lql.service.solo;

import com.lql.entity.bo.HeadLine;
import com.lql.entity.bo.ShopCategory;
import com.lql.entity.dto.Result;
import org.simpleframework.core.annotation.Service;

import java.util.List;

/**
 * @author lql
 * @date 2021/6/3 16:48
 * Description：
 */
public interface ShopCategoryService {

    Result<Boolean> addShopCategory(ShopCategory shopCategory);

    Result<Boolean> removeShopCategory(int shopCategoryId);

    Result<Boolean> modifyShopCategory(ShopCategory shopCategory);

    Result<HeadLine> QueryShopCategoryById(int shopCategoryId);

    Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize);
}
