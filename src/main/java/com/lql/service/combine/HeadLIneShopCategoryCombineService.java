package com.lql.service.combine;

import com.lql.entity.dto.MainPageInfoDTO;
import com.lql.entity.dto.Result;
import org.simpleframework.core.annotation.Service;

/**
 * @author lql
 * @date 2021/6/3 17:51
 * Description：
 */
public interface HeadLIneShopCategoryCombineService {

    Result<MainPageInfoDTO> getMainPageInfo();

}
