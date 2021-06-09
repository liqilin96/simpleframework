package com.lql.service.solo.impl;

import com.lql.entity.bo.HeadLine;
import com.lql.entity.dto.Result;
import com.lql.service.solo.HeadLineService;
import org.simpleframework.core.annotation.Service;

import java.util.List;

/**
 * @author lql
 * @date 2021/6/3 17:28
 * Description：
 */
@Service
public class HeadLineServiceImpl implements HeadLineService {

    @Override
    public Result<Boolean> addHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<Boolean> removeHeadLine(int headLineId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<HeadLine> QueryHeadLineById(int headLineId) {
        return null;
    }

    @Override
    public Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize) {
        return null;
    }
}
