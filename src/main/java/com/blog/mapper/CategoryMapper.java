package com.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.pojo.po.Category;
import com.blog.pojo.vo.CategoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 分类Mapper接口
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 分页查询分类数据
     *
     * @param page         分页对象
     * @param categoryName 分类名（模糊匹配）
     * @return 分页结果
     */
    Page<CategoryVO> selectPageWithCondition(Page<Category> page, @Param("categoryName") String categoryName);

    /**
     * 查询所有分类数据
     *
     * @return 所有未删除的分类
     */
    List<CategoryVO> selectAll();
}
