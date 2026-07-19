package com.blog.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "通用分页查询参数")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasePageDTO {
    /**
     * 当前页码
     */
    @ApiModelProperty(value = "当前页码", required = true)
    private Integer page;
    /**
     * 每页条数
     */
    @ApiModelProperty(value = "每页条数", required = true)
    private Integer pageSize;
}
