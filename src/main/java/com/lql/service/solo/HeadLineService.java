package com.lql.service.solo;

import com.lql.entity.bo.HeadLine;
import com.lql.entity.dto.Result;
import org.simpleframework.core.annotation.Service;

import java.util.List;

/**
 * @author lql
 * @date 2021/6/3 17:11
 * Description：
 */
public interface HeadLineService {

    Result<Boolean> addHeadLine(HeadLine headLine);

    Result<Boolean> removeHeadLine(int headLineId);

    Result<Boolean> modifyHeadLine(HeadLine headLine);

    Result<HeadLine> QueryHeadLineById(int headLineId);

    Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize);
}
