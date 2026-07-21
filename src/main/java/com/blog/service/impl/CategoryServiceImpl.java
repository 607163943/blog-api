package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.constant.CommonConstant;
import com.blog.mapper.CategoryMapper;
import com.blog.pojo.po.Category;
import com.blog.pojo.vo.CategoryVO;
import com.blog.result.PageResult;
import com.blog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 分类Service实现类
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    public PageResult<List<CategoryVO>> page(Integer page, Integer pageSize, String categoryName) {
        Page<Category> pageParam = new Page<>(page, pageSize);
        Page<CategoryVO> pageResult = baseMapper.selectPageWithCondition(pageParam, categoryName);
        return new PageResult<>(pageResult.getRecords(), pageResult.getTotal());
    }

    @Override
    public void save(String categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        category.setIsDelete(CommonConstant.NOT_DELETED);
        super.save(category);
    }

    @Override
    public void update(Long id, String categoryName) {
        Category category = new Category();
        category.setId(id);
        category.setCategoryName(categoryName);
        category.setUpdateTime(LocalDateTime.now());
        super.updateById(category);
    }

    @Override
    public void delete(List<Long> ids) {
        if(ids.isEmpty()) return;

        lambdaUpdate()
                .set(Category::getIsDelete, System.currentTimeMillis())
                .in(Category::getId, ids)
                .update();
    }

    @Override
    public CategoryVO getCategoryById(Long id) {
        return baseMapper.selectCategoryById(id);
    }

    @Override
    public List<CategoryVO> listAll() {
        return baseMapper.selectAll();
    }
}
