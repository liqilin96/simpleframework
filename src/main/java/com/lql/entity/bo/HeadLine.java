package com.lql.entity.bo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author lql
 * @date 2021/6/3 14:32
 * Description：
 */
@Data
public class HeadLine {

       private Long lineId;
       private String lineName;
       private String lineLink;
       private String lineImg;
       private Integer priority;
       private Integer enableStatus;
       private Date createTime;
       private Date lastEditTime;

}
