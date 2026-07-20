package com.blog.controller;

import com.blog.pojo.dto.ArticlePageDTO;
import com.blog.pojo.dto.ArticleSaveDTO;
import com.blog.pojo.dto.ArticleStatusUpdateDTO;
import com.blog.pojo.dto.ArticleUpdateDTO;
import com.blog.pojo.vo.ArticleVO;
import com.blog.result.PageResult;
import com.blog.result.Result;
import com.blog.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章Controller
 */
@Api(tags = "文章管理")
@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    /**
     * 分页获取文章数据
     *
     * @param dto 分页查询参数
     * @return 分页文章数据
     */
    @ApiOperation("分页获取文章数据")
    @GetMapping
    public Result<PageResult<List<ArticleVO>>> page(ArticlePageDTO dto) {
        PageResult<List<ArticleVO>> data = articleService.page(dto.getPage(), dto.getPageSize(),
                dto.getArticleTitle(), dto.getCategoryId(), dto.getTagId());
        return Result.success(data);
    }

    /**
     * 新增文章
     *
     * @param dto 新增文章参数
     * @return 操作结果
     */
    @ApiOperation("新增文章")
    @PostMapping
    public Result<Object> save(@RequestBody ArticleSaveDTO dto) {
        articleService.save(dto);
        return Result.success();
    }

    /**
     * 修改文章
     *
     * @param dto 修改文章参数
     * @return 操作结果
     */
    @ApiOperation("修改文章")
    @PutMapping
    public Result<Object> update(@RequestBody ArticleUpdateDTO dto) {
        articleService.update(dto);
        return Result.success();
    }

    /**
     * 批量删除文章
     *
     * @param ids 文章ID数组
     * @return 操作结果
     */
    @ApiOperation("批量删除文章")
    @DeleteMapping
    public Result<Object> delete(@RequestBody Long[] ids) {
        articleService.delete(java.util.Arrays.asList(ids));
        return Result.success();
    }

    /**
     * 修改文章状态
     *
     * @param dto 修改状态参数
     * @return 操作结果
     */
    @ApiOperation("修改文章状态")
    @PatchMapping
    public Result<Object> updateStatus(@RequestBody ArticleStatusUpdateDTO dto) {
        articleService.updateStatus(dto.getId(), dto.getArticleStatus());
        return Result.success();
    }
}
