package com.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.pojo.po.Article;
import com.blog.pojo.vo.ArticleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 文章Mapper接口
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 分页查询文章数据（含分类名和标签名数组）
     *
     * @param page         分页对象
     * @param articleTitle 文章标题（模糊匹配）
     * @param categoryId   文章分类ID
     * @param tagId        标签ID（通过中间表关联）
     * @return 分页结果
     */
    Page<ArticleVO> selectPageWithCondition(Page<Article> page,
                                            @Param("articleTitle") String articleTitle,
                                            @Param("categoryId") Long categoryId,
                                            @Param("tagId") Long tagId);
}
