package com.lql.controller.superadmin;

import com.lql.entity.bo.HeadLine;
import com.lql.entity.bo.ShopCategory;
import com.lql.entity.dto.Result;
import com.lql.service.solo.ShopCategoryService;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.inject.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lql
 * @date 2021/6/4 11:00
 * Description：
 */
@Controller
public class ShopCategoryOperationController {

    @Autowired
    private ShopCategoryService shopCategoryService;


    private Result<Boolean> addShopCategory(HttpServletRequest req, HttpServletResponse resp) {
        //TODO 参数校验以及请求参数转换
        return shopCategoryService.addShopCategory(new ShopCategory());
    }

    private Result<Boolean> removeShopCategory(HttpServletRequest req, HttpServletResponse resp) {
        //TODO 参数校验以及请求参数转换
        return shopCategoryService.removeShopCategory(1);
    }

    private Result<Boolean> modifyShopCategory(HttpServletRequest req, HttpServletResponse resp) {
        //TODO 参数校验以及请求参数转换
        return shopCategoryService.modifyShopCategory(new ShopCategory());
    }

    private Result<HeadLine> QueryShopCategoryById(HttpServletRequest req, HttpServletResponse resp) {
        //TODO 参数校验以及请求参数转换
        return shopCategoryService.QueryShopCategoryById(1);

    }

    private Result<List<ShopCategory>> queryShopCategory(HttpServletRequest req, HttpServletResponse resp) {
        //TODO 参数校验以及请求参数转换
        return shopCategoryService.queryShopCategory(null, 1, 100);
    }

}
