package com.blog.controller;

import com.blog.pojo.vo.ArticleTrendVO;
import com.blog.pojo.vo.DataTotalVO;
import com.blog.result.Result;
import com.blog.service.DataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 数据统计Controller
 */
@Api(tags = "数据统计")
@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class DataController {

    private final DataService dataService;

    /**
     * 统计文章、分类、标签总数据
     *
     * @return 统计数据
     */
    @ApiOperation("统计文章、分类、标签总数据")
    @GetMapping("/total")
    public Result<DataTotalVO> total() {
        DataTotalVO data = dataService.getTotal();
        return Result.success(data);
    }

    /**
     * 统计文章新增趋势数据（近N个月）
     *
     * @param months 统计月份数，默认6个月
     * @return 月份列表及对应新增文章数
     */
    @ApiOperation("统计文章新增趋势数据")
    @GetMapping("/newArticleTrend")
    public Result<ArticleTrendVO> newArticleTrend(@RequestParam(defaultValue = "6") Integer months) {
        ArticleTrendVO data = dataService.getNewArticleTrend(months);
        return Result.success(data);
    }
}
