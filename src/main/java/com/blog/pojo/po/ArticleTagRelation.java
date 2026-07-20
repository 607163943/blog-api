package com.blog.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 文章-标签关联表
 */
@TableName("tb_article_tag_relation")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleTagRelation extends BasePO {
    /**
     * 文章ID
     */
    private Long articleId;
    /**
     * 标签ID
     */
    private Long tagId;
}
