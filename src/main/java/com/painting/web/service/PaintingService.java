package com.painting.web.service;

import com.painting.web.dao.CalligraphyDao;
import com.painting.web.dao.PaintingDao;
import com.painting.web.entity.Calligraphy;
import com.painting.web.entity.Painting;
import com.painting.web.vo.ResponseVO;
import com.querydsl.core.types.OrderSpecifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.querydsl.QSort;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PagesPerMinute;
import java.util.List;

@Service
public class PaintingService {


    @Autowired
    private PaintingDao paintingDao;



    public Painting getById(Integer id) {
        return paintingDao.getOne(id);
    }

    /**
     * 分页
     */
    public Page<Painting> findAll(Integer pageNum, Integer pageSize) {
        pageNum= pageNum==null?1:pageNum;
        pageSize= pageSize==null?12:pageSize;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable1 = PageRequest.of(pageNum-1, pageSize, sort);
        return paintingDao.findAll(pageable1);

    }
    /**
     * 获取热门top8
     */
    public List<Painting> findHotTop8(){
        Sort sort = Sort.by(Sort.Direction.DESC, "commentAmount");
        Pageable pageable1 =  PageRequest.of(0, 8,sort);
        return paintingDao.findAll(pageable1).getContent();
    }

    public List<Painting> findAll(){
        return paintingDao.findAll();
    }
    /**
     * 删除
     */
    public void delete(Integer id){
        paintingDao.deleteById(id);
    }

    public void save(Painting painting) {
        paintingDao.save(painting);
    }

    public Page<Painting> page(Integer pageNo) {
        pageNo=pageNo==null?1:pageNo;
        Integer pageSize = 10;
        Pageable pageable1 =  PageRequest.of(pageNo-1, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        Page<Painting> page;
        page = paintingDao.findAll(pageable1);
        return page;
    }

    public Painting search(String key){
        return paintingDao.search(key);
    }

}
