package com.lql.service.combine.impl;

import com.lql.entity.bo.HeadLine;
import com.lql.entity.bo.ShopCategory;
import com.lql.entity.dto.MainPageInfoDTO;
import com.lql.entity.dto.Result;
import com.lql.service.combine.HeadLIneShopCategoryCombineService;
import com.lql.service.solo.HeadLineService;
import com.lql.service.solo.ShopCategoryService;
import org.simpleframework.core.annotation.Service;
import org.simpleframework.inject.annotation.Autowired;

import java.util.List;

/**
 * @author lql
 * @date 2021/6/3 18:52
 * Description：
 */
@Service
public class HeadLIneShopCategoryCombineServiceImpl implements HeadLIneShopCategoryCombineService {

    @Autowired
    private HeadLineService headLineService;
    @Autowired
    private ShopCategoryService shopCategoryService;

    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {

        HeadLine headLine = new HeadLine();
        headLine.setEnableStatus(1);
        ShopCategory shopCategory = new ShopCategory();
        Result<List<HeadLine>> headLine1 = headLineService.queryHeadLine(headLine, 1, 10);
        Result<List<ShopCategory>> shopCategory1 = shopCategoryService.queryShopCategory(shopCategory, 1, 100);

        Result<MainPageInfoDTO> result = mergeMainPageInfoResult(shopCategory1, headLine1);
        return result;
    }

    private Result<MainPageInfoDTO> mergeMainPageInfoResult(Result<List<ShopCategory>> shopCategory1, Result<List<HeadLine>> headLine1) {

        return null;
    }
}
