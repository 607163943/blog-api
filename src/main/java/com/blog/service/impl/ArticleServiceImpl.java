package com.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.constant.CommonConstant;
import com.blog.mapper.ArticleMapper;
import com.blog.mapper.ArticleTagRelationMapper;
import com.blog.pojo.dto.ArticleSaveDTO;
import com.blog.pojo.dto.ArticleUpdateDTO;
import com.blog.pojo.po.Article;
import com.blog.pojo.po.ArticleTagRelation;
import com.blog.pojo.vo.ArticleVO;
import com.blog.result.PageResult;
import com.blog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 文章Service实现类
 */
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    private final ArticleTagRelationMapper articleTagRelationMapper;

    @Override
    public PageResult<List<ArticleVO>> page(Integer page, Integer pageSize, String articleTitle, Long categoryId, Long tagId) {
        Page<Article> pageParam = new Page<>(page, pageSize);
        Page<ArticleVO> pageResult = baseMapper.selectPageWithCondition(pageParam, articleTitle, categoryId, tagId);
        return new PageResult<>(pageResult.getRecords(), pageResult.getTotal());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ArticleSaveDTO dto) {
        Article article = new Article();
        article.setArticleTitle(dto.getArticleTitle());
        article.setCategoryId(dto.getCategoryId());
        article.setArticleCover(dto.getArticleCover());
        article.setArticleSummary(dto.getArticleSummary());
        article.setArticleContent(dto.getArticleContent());
        article.setArticleStatus(dto.getArticleStatus());
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        article.setIsDelete(CommonConstant.NOT_DELETED);

        // 若是发布状态，设置发布时间
        if (dto.getArticleStatus() != null && dto.getArticleStatus() == 1) {
            article.setPublishTime(LocalDateTime.now());
        }

        super.save(article);

        // 保存文章-标签关联
        if (dto.getTagIds() != null && dto.getTagIds().length > 0) {
            saveTagRelations(article.getId(), dto.getTagIds());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ArticleUpdateDTO dto) {
        Article article = new Article();
        article.setId(dto.getId());
        if (dto.getArticleTitle() != null) {
            article.setArticleTitle(dto.getArticleTitle());
        }
        if (dto.getCategoryId() != null) {
            article.setCategoryId(dto.getCategoryId());
        }
        if (dto.getArticleCover() != null) {
            article.setArticleCover(dto.getArticleCover());
        }
        if (dto.getArticleSummary() != null) {
            article.setArticleSummary(dto.getArticleSummary());
        }
        if (dto.getArticleContent() != null) {
            article.setArticleContent(dto.getArticleContent());
        }
        if (dto.getArticleStatus() != null) {
            article.setArticleStatus(dto.getArticleStatus());
            // 首次发布时设置发布时间
            if (dto.getArticleStatus() == 1) {
                Article existing = super.getById(dto.getId());
                if (existing != null && existing.getPublishTime() == null) {
                    article.setPublishTime(LocalDateTime.now());
                }
            }
        }
        article.setUpdateTime(LocalDateTime.now());
        super.updateById(article);

        // 更新文章-标签关联（先删后增）
        if (dto.getTagIds() != null) {
            long timestamp = System.currentTimeMillis();
            LambdaUpdateWrapper<ArticleTagRelation> wrapper = new LambdaUpdateWrapper<>();
            wrapper.set(ArticleTagRelation::getIsDelete, timestamp)
                   .eq(ArticleTagRelation::getArticleId, dto.getId());
            articleTagRelationMapper.update(null, wrapper);

            if (dto.getTagIds().length > 0) {
                saveTagRelations(dto.getId(), dto.getTagIds());
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> ids) {
        if (ids.isEmpty()) {
            return;
        }

        long timestamp = System.currentTimeMillis();

        // 软删除文章
        lambdaUpdate()
                .set(Article::getIsDelete, timestamp)
                .in(Article::getId, ids)
                .update();

        // 软删除文章-标签关联
        LambdaUpdateWrapper<ArticleTagRelation> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(ArticleTagRelation::getIsDelete, timestamp)
               .in(ArticleTagRelation::getArticleId, ids);
        articleTagRelationMapper.update(null, wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStatus(Long id, Integer articleStatus) {
        Article existing = super.getById(id);
        if (existing == null) {
            return;
        }

        Article article = new Article();
        article.setId(id);
        article.setArticleStatus(articleStatus);
        article.setUpdateTime(LocalDateTime.now());

        // 首次发布时设置发布时间
        if (articleStatus != null && articleStatus == 1 && existing.getPublishTime() == null) {
            article.setPublishTime(LocalDateTime.now());
        }

        super.updateById(article);
    }

    /**
     * 保存文章-标签关联记录
     *
     * @param articleId 文章ID
     * @param tagIds    标签ID数组
     */
    private void saveTagRelations(Long articleId, Long[] tagIds) {
        LocalDateTime now = LocalDateTime.now();
        for (Long tagId : tagIds) {
            if (tagId == null) {
                continue;
            }
            ArticleTagRelation relation = new ArticleTagRelation();
            relation.setArticleId(articleId);
            relation.setTagId(tagId);
            relation.setCreateTime(now);
            relation.setUpdateTime(now);
            relation.setIsDelete(CommonConstant.NOT_DELETED);
            articleTagRelationMapper.insert(relation);
        }
    }
}
