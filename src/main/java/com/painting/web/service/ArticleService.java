package com.painting.web.service;

import com.painting.web.dao.ArticleDao;
import com.painting.web.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;



    public Article getById(Integer id) {
        return articleDao.getOne(id);
    }

    /**
     * 分页
     */
    public Page<Article> findAll(Integer page, Integer size, Integer type) {
        Pageable pageable1 = new QPageRequest(page-1, size);
        return articleDao.findAllByTypeOrderByIdDesc(type.toString(), pageable1);
    }

    /**
     * 首页固定数据
     * @return
     */
    public List<Article> getIndexData() {
        return articleDao.findAllByTypeOrderByIdAsc(Article.INDEX_DATA);
    }

    /**
     * show页面
     * @param model
     */
    public void setShowData(Model model){
        model.addAttribute("data1", articleDao.findAllByTypeOrderByIdDesc(Article.RECENTLY_EXHIBITION, new QPageRequest(0,3)));
        List<Article> articles =  articleDao.findAllByTypeOrderByIdAsc(Article.INDEX_DATA);
        model.addAttribute("data2", articles.get(0));
        model.addAttribute("data3", articles.get(1));
        model.addAttribute("data4",  articleDao.findAllByTypeOrderByIdDesc(Article.GALLERY, new QPageRequest(0,3)));
        model.addAttribute("data5",  articleDao.findAllByTypeOrderByIdDesc(Article.ONLINE, new QPageRequest(0,3)));
    }
}
