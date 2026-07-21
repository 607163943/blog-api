package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.pojo.dto.ArticleSaveDTO;
import com.blog.pojo.dto.ArticleUpdateDTO;
import com.blog.pojo.po.Article;
import com.blog.pojo.vo.ArticleDetailVO;
import com.blog.pojo.vo.ArticleVO;
import com.blog.result.PageResult;

import java.util.List;

/**
 * 文章Service接口
 */
public interface ArticleService extends IService<Article> {

    /**
     * 分页获取文章数据
     *
     * @param page         当前页码
     * @param pageSize     每页条数
     * @param articleTitle 文章标题（模糊匹配）
     * @param categoryId   文章分类ID
     * @param tagId        标签ID
     * @param articleStatus 文章状态（0-草稿，1-发布）
     * @return 分页结果
     */
    PageResult<List<ArticleVO>> page(Integer page, Integer pageSize, String articleTitle, Long categoryId, Long tagId,Integer articleStatus);

    /**
     * 新增文章
     *
     * @param dto 新增文章参数
     */
    void save(ArticleSaveDTO dto);

    /**
     * 修改文章
     *
     * @param dto 修改文章参数
     */
    void update(ArticleUpdateDTO dto);

    /**
     * 批量删除文章
     *
     * @param ids 文章ID数组
     */
    void delete(List<Long> ids);

    /**
     * 修改文章状态
     *
     * @param id            文章ID
     * @param articleStatus 新文章状态
     */
    void updateStatus(Long id, Integer articleStatus);

    /**
     * 根据ID获取文章数据
     *
     * @param id 文章ID
     * @return 文章详情数据
     */
    ArticleDetailVO getArticleById(Long id);
}
