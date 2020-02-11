package com.wenyanwen123.learning.commons.domain.models.thread;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: TODO
 * @Author liww
 * @Date 2020/2/8
 * @Version 1.0
 */
@Data
@ApiModel(value = "RushToBuyRp", description = "抢购请求参数")
public class RunThreadRp {

    @ApiModelProperty(value = "线程数量", name = "total")
    private Integer total;

}
