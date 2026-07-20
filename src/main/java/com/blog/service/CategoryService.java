package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.pojo.po.Category;
import com.blog.pojo.vo.CategoryVO;
import com.blog.result.PageResult;

import java.util.List;

/**
 * 分类Service接口
 */
public interface CategoryService extends IService<Category> {

    /**
     * 分页获取分类数据
     *
     * @param page         当前页码
     * @param pageSize     每页条数
     * @param categoryName 分类名（模糊匹配）
     * @return 分页结果
     */
    PageResult<List<CategoryVO>> page(Integer page, Integer pageSize, String categoryName);

    /**
     * 新增分类
     *
     * @param categoryName 分类名
     */
    void save(String categoryName);

    /**
     * 修改分类
     *
     * @param id           分类ID
     * @param categoryName 分类名
     */
    void update(Long id, String categoryName);

    /**
     * 批量删除分类
     *
     * @param ids 分类ID数组
     */
    void delete(List<Long> ids);

    /**
     * 获取所有分类数据
     *
     * @return 所有未删除的分类
     */
    List<CategoryVO> listAll();
}
