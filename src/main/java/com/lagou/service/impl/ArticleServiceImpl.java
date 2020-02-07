package com.lagou.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.mapper.TArticleMapper;
import com.lagou.pojo.TArticle;
import com.lagou.pojo.TArticleExample;
import com.lagou.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private TArticleMapper  articleMapper;

    @Override
    public PageInfo<TArticle> queryPage(Page condition) {
        Page<TArticle> page = new Page<TArticle>();
        page.setPageNum(condition.getPageNum());
        page.setPageSize(condition.getPageSize());
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        TArticleExample example = new TArticleExample();
        List<TArticle> list = articleMapper.selectByExampleWithBLOBs(example);
        PageInfo<TArticle> pageInfo = new PageInfo<TArticle>(list);
        return pageInfo;
    }
}
