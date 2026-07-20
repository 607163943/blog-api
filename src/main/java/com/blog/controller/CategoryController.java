package com.blog.controller;

import com.blog.pojo.dto.CategoryPageDTO;
import com.blog.pojo.dto.CategoryUpdateDTO;
import com.blog.pojo.vo.CategoryVO;
import com.blog.result.PageResult;
import com.blog.result.Result;
import com.blog.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分类Controller
 */
@Api(tags = "分类管理")
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    /**
     * 分页获取分类数据
     *
     * @param dto 分页查询参数
     * @return 分页分类数据
     */
    @ApiOperation("分页获取分类数据")
    @GetMapping
    public Result<PageResult<List<CategoryVO>>> page(CategoryPageDTO dto) {
        PageResult<List<CategoryVO>> data = categoryService.page(dto.getPage(), dto.getPageSize(), dto.getCategoryName());
        return Result.success(data);
    }

    /**
     * 新增分类
     *
     * @param categoryName 分类名
     * @return 操作结果
     */
    @ApiOperation("新增分类")
    @PostMapping
    public Result<Object> save(@RequestParam String categoryName) {
        categoryService.save(categoryName);
        return Result.success();
    }

    /**
     * 修改分类
     *
     * @param dto 修改分类参数
     * @return 操作结果
     */
    @ApiOperation("修改分类")
    @PutMapping
    public Result<Object> update(@RequestBody CategoryUpdateDTO dto) {
        categoryService.update(dto.getId(), dto.getCategoryName());
        return Result.success();
    }

    /**
     * 批量删除分类
     *
     * @param ids 分类ID数组
     * @return 操作结果
     */
    @ApiOperation("批量删除分类")
    @DeleteMapping
    public Result<Object> delete(@RequestBody Long[] ids) {
        categoryService.delete(java.util.Arrays.asList(ids));
        return Result.success();
    }

    /**
     * 获取所有分类数据
     *
     * @return 所有分类数据
     */
    @ApiOperation("获取所有分类数据")
    @GetMapping("/all")
    public Result<List<CategoryVO>> listAll() {
        List<CategoryVO> data = categoryService.listAll();
        return Result.success(data);
    }
}
