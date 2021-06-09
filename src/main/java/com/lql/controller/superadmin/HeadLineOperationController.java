package com.lql.controller.superadmin;

import com.lql.entity.bo.HeadLine;
import com.lql.entity.dto.Result;
import com.lql.service.solo.HeadLineService;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.inject.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lql
 * @date 2021/6/4 10:55
 * Description：
 */
@Controller
public class HeadLineOperationController {

    @Autowired
    private HeadLineService headLineService;


    public Result<Boolean> addHeadLine(HttpServletRequest req, HttpServletResponse resp) {
        //TODO 参数校验以及请求参数转换
        return headLineService.addHeadLine(new HeadLine());
    }

    public Result<Boolean> removeHeadLine(HttpServletRequest req, HttpServletResponse resp) {
        //TODO 参数校验以及请求参数转换
        return headLineService.removeHeadLine(1);
    }

    public Result<Boolean> modifyHeadLine(HttpServletRequest req, HttpServletResponse resp) {
        //TODO 参数校验以及请求参数转换
        return headLineService.modifyHeadLine(new HeadLine());
    }

    public Result<HeadLine> QueryHeadLineById(HttpServletRequest req, HttpServletResponse resp) {
        //TODO 参数校验以及请求参数转换
        return headLineService.QueryHeadLineById(1);
    }

    public Result<List<HeadLine>> queryHeadLine(HttpServletRequest req, HttpServletResponse resp) {
        //TODO 参数校验以及请求参数转换
        return headLineService.queryHeadLine(null,1,10);
    }

}
