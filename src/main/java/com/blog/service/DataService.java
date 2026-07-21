package com.blog.service;

import com.blog.pojo.vo.ArticleTrendVO;
import com.blog.pojo.vo.DataTotalVO;

/**
 * 数据统计Service接口
 */
public interface DataService {

    /**
     * 统计文章、分类、标签总数据
     *
     * @return 统计数据
     */
    DataTotalVO getTotal();

    /**
     * 统计文章新增趋势数据
     *
     * @param months 统计最近几个月的数量
     * @return 月份列表及对应新增文章数
     */
    ArticleTrendVO getNewArticleTrend(Integer months);
}
