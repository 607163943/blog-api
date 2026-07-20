package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.constant.CommonConstant;
import com.blog.mapper.TagMapper;
import com.blog.pojo.po.Tag;
import com.blog.pojo.vo.TagVO;
import com.blog.result.PageResult;
import com.blog.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 标签Service实现类
 */
@Service
@RequiredArgsConstructor
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Override
    public PageResult<List<TagVO>> page(Integer page, Integer pageSize, String tagName) {
        Page<Tag> pageParam = new Page<>(page, pageSize);
        Page<TagVO> pageResult = baseMapper.selectPageWithCondition(pageParam, tagName);
        return new PageResult<>(pageResult.getRecords(), pageResult.getTotal());
    }

    @Override
    public void save(String tagName) {
        Tag tag = new Tag();
        tag.setTagName(tagName);
        tag.setCreateTime(LocalDateTime.now());
        tag.setUpdateTime(LocalDateTime.now());
        tag.setIsDelete(CommonConstant.NOT_DELETED);
        super.save(tag);
    }

    @Override
    public void update(Long id, String tagName) {
        Tag tag = new Tag();
        tag.setId(id);
        tag.setTagName(tagName);
        tag.setUpdateTime(LocalDateTime.now());
        super.updateById(tag);
    }

    @Override
    public void delete(List<Long> ids) {
        if (ids.isEmpty()) return;

        lambdaUpdate()
                .set(Tag::getIsDelete, System.currentTimeMillis())
                .in(Tag::getId, ids)
                .update();
    }

    @Override
    public List<TagVO> listAll() {
        return baseMapper.selectAll();
    }
}
