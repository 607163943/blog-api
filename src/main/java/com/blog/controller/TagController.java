package com.blog.controller;

import com.blog.pojo.dto.TagPageDTO;
import com.blog.pojo.dto.TagUpdateDTO;
import com.blog.pojo.vo.TagVO;
import com.blog.result.PageResult;
import com.blog.result.Result;
import com.blog.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签Controller
 */
@Api(tags = "标签管理")
@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    /**
     * 分页获取标签数据
     *
     * @param dto 分页查询参数
     * @return 分页标签数据
     */
    @ApiOperation("分页获取标签数据")
    @GetMapping
    public Result<PageResult<List<TagVO>>> page(TagPageDTO dto) {
        PageResult<List<TagVO>> data = tagService.page(dto.getPage(), dto.getPageSize(), dto.getTagName());
        return Result.success(data);
    }

    /**
     * 新增标签
     *
     * @param tagName 标签名
     * @return 操作结果
     */
    @ApiOperation("新增标签")
    @PostMapping
    public Result<Object> save(@RequestParam String tagName) {
        tagService.save(tagName);
        return Result.success();
    }

    /**
     * 修改标签
     *
     * @param dto 修改标签参数
     * @return 操作结果
     */
    @ApiOperation("修改标签")
    @PutMapping
    public Result<Object> update(@RequestBody TagUpdateDTO dto) {
        tagService.update(dto.getId(), dto.getTagName());
        return Result.success();
    }

    /**
     * 批量删除标签
     *
     * @param ids 标签ID数组
     * @return 操作结果
     */
    @ApiOperation("批量删除标签")
    @DeleteMapping
    public Result<Object> delete(@RequestBody Long[] ids) {
        tagService.delete(java.util.Arrays.asList(ids));
        return Result.success();
    }

    /**
     * 根据ID获取标签数据
     *
     * @param id 标签ID
     * @return 标签数据
     */
    @ApiOperation("根据ID获取标签数据")
    @GetMapping("/{id}")
    public Result<TagVO> getById(@PathVariable Long id) {
        TagVO data = tagService.getTagById(id);
        return Result.success(data);
    }

    /**
     * 获取所有标签数据
     *
     * @return 所有标签数据
     */
    @ApiOperation("获取所有标签数据")
    @GetMapping("/all")
    public Result<List<TagVO>> listAll() {
        List<TagVO> data = tagService.listAll();
        return Result.success(data);
    }
}
