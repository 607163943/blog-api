package com.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.blog.mapper.ArticleMapper;
import com.blog.mapper.CategoryMapper;
import com.blog.mapper.TagMapper;
import com.blog.pojo.po.Article;
import com.blog.pojo.po.Category;
import com.blog.pojo.po.Tag;
import com.blog.pojo.vo.ArticleTrendVO;
import com.blog.pojo.vo.DataTotalVO;
import com.blog.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 数据统计Service实现类
 */
@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

    private final ArticleMapper articleMapper;
    private final CategoryMapper categoryMapper;
    private final TagMapper tagMapper;

    @Override
    public DataTotalVO getTotal() {
        Long articleTotal = articleMapper.selectCount(
                new LambdaQueryWrapper<Article>().eq(Article::getIsDelete, 0L));
        Long categoryTotal = categoryMapper.selectCount(
                new LambdaQueryWrapper<Category>().eq(Category::getIsDelete, 0L));
        Long tagTotal = tagMapper.selectCount(
                new LambdaQueryWrapper<Tag>().eq(Tag::getIsDelete, 0L));
        return new DataTotalVO(articleTotal, categoryTotal, tagTotal);
    }

    @Override
    public ArticleTrendVO getNewArticleTrend(Integer months) {
        // 计算起始时间
        LocalDateTime startTime = LocalDateTime.now().minusMonths(months);

        // 查询按月分组的文章新增数
        List<Map<String, Object>> dbResults = articleMapper.selectNewArticleCountByMonth(startTime);

        // 转换为 Map<月份, 数量>
        Map<String, Long> monthCountMap = dbResults.stream()
                .collect(Collectors.toMap(
                        row -> (String) row.get("month"),
                        row -> (Long) row.get("count"),
                        (v1, v2) -> v1
                ));

        // 生成最近 months 个月的月份列表，并填充数据
        List<String> monthList = new ArrayList<>();
        List<Long> countList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        YearMonth current = YearMonth.now();

        for (int i = months - 1; i >= 0; i--) {
            YearMonth ym = current.minusMonths(i);
            String monthStr = ym.format(formatter);
            monthList.add(monthStr);
            countList.add(monthCountMap.getOrDefault(monthStr, 0L));
        }

        return new ArticleTrendVO(monthList, countList);
    }
}
