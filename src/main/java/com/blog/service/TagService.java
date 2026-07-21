package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.pojo.po.Tag;
import com.blog.pojo.vo.TagVO;
import com.blog.result.PageResult;

import java.util.List;

/**
 * 标签Service接口
 */
public interface TagService extends IService<Tag> {

    /**
     * 分页获取标签数据
     *
     * @param page     当前页码
     * @param pageSize 每页条数
     * @param tagName  标签名（模糊匹配）
     * @return 分页结果
     */
    PageResult<List<TagVO>> page(Integer page, Integer pageSize, String tagName);

    /**
     * 新增标签
     *
     * @param tagName 标签名
     */
    void save(String tagName);

    /**
     * 修改标签
     *
     * @param id      标签ID
     * @param tagName 标签名
     */
    void update(Long id, String tagName);

    /**
     * 批量删除标签
     *
     * @param ids 标签ID数组
     */
    void delete(List<Long> ids);

    /**
     * 根据ID获取标签数据
     *
     * @param id 标签ID
     * @return 标签数据
     */
    TagVO getTagById(Long id);

    /**
     * 获取所有标签数据
     *
     * @return 所有未删除的标签
     */
    List<TagVO> listAll();
}
