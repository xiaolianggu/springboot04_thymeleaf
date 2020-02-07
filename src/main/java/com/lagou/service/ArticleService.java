package com.lagou.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lagou.pojo.TArticle;

public interface ArticleService {
    PageInfo<TArticle> queryPage(Page condition);
}
