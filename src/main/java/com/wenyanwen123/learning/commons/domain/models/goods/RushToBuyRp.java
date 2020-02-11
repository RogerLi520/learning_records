package com.wenyanwen123.learning.commons.domain.models.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 抢购活动
 * @Author liww
 * @Date 2020/2/6
 * @Version 1.0
 */
@Data
@ApiModel(value = "RushToBuyRp", description = "抢购请求参数")
public class RushToBuyRp {

    @ApiModelProperty(value = "用户ID", name = "userId")
    private Integer userId;

    @ApiModelProperty(value = "用户名", name = "userName")
    private String userName;

    @ApiModelProperty(value = "商品编号", name = "goodsId")
    private Integer goodsId;

}
