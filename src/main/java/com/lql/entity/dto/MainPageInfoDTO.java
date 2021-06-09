package com.lql.entity.dto;

import com.lql.entity.bo.HeadLine;
import com.lql.entity.bo.ShopCategory;
import lombok.Data;

import java.util.List;

/**
 * @author lql
 * @date 2021/6/3 18:51
 * Description：
 */
@Data
public class MainPageInfoDTO {

    private List<ShopCategory> shopCategory;
    private List<HeadLine> headLines;

}
