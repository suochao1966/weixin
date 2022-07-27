package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.utils.HttpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author suochao
 * @date 2022/7/27 1:27 下午
 */
@Controller
public class ArticleController {


    /**
     * 获取文章列表
     */
    public String ARTICLE_LIST_URL = "https://api.weixin.qq.com/cgi-bin/freepublish/batchget";

    /**
     *
     * @return
     */
    @GetMapping(value = "/article/list")
    public ApiResponse list() throws Exception {

        String s = HttpUtils.get(ARTICLE_LIST_URL);
        return ApiResponse.ok(s);
    }
}
