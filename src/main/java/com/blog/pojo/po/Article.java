package com.blog.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@TableName("tb_article")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article extends BasePO {
    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 文章分类ID
     */
    private Long categoryId;
    /**
     * 文章摘要
     */
    private String articleSummary;
    /**
     * 文章内容
     */
    private String articleContent;
    /**
     * 文章封面
     */
    private String articleCover;
    /**
     * 文章状态
     */
    private Integer articleStatus;
    /**
     * 发表时间
     */
    private LocalDateTime publishTime;
}
