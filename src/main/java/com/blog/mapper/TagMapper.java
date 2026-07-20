package com.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.pojo.po.Tag;
import com.blog.pojo.vo.TagVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 标签Mapper接口
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    /**
     * 分页查询标签数据
     *
     * @param page    分页对象
     * @param tagName 标签名（模糊匹配）
     * @return 分页结果
     */
    Page<TagVO> selectPageWithCondition(Page<Tag> page, @Param("tagName") String tagName);

    /**
     * 查询所有标签数据
     *
     * @return 所有未删除的标签
     */
    List<TagVO> selectAll();
}
