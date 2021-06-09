package com.lql.controller.frontend;

import com.lql.entity.dto.MainPageInfoDTO;
import com.lql.entity.dto.Result;
import com.lql.service.combine.HeadLIneShopCategoryCombineService;
import lombok.Getter;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.inject.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lql
 * @date 2021/6/4 10:52
 * Description：
 */
@Controller
@Getter
public class MainPageController {

    @Autowired
    private HeadLIneShopCategoryCombineService headLIneShopCategoryCombineService;


    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest req, HttpServletResponse resp) {
        return headLIneShopCategoryCombineService.getMainPageInfo();
    }

}
