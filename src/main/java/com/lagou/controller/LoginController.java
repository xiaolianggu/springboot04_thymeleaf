package com.lagou.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lagou.pojo.TArticle;
import com.lagou.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

@Controller
public class LoginController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping("/toLoginPage")
    public String toLoginPage(Model model){

        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }

    @RequestMapping("/index")
    public String index(Model model,Integer pageNum,Integer pageSize){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 2;
        }
        Page page = new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        PageInfo<TArticle> pageInfo = articleService.queryPage(page);
        model.addAttribute("pageInfo", pageInfo);
        return "client/index";
    }

}
