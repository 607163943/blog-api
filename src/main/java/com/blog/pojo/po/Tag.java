package com.blog.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@TableName("tb_tag")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag extends BasePO {
    /**
     * 标签名
     */
    private String tagName;
}
