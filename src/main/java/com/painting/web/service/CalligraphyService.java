package com.painting.web.service;

import com.painting.web.dao.CalligraphyDao;
import com.painting.web.entity.Calligraphy;
import com.painting.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalligraphyService {


    @Autowired
    private CalligraphyDao calligraphyDao;



    public Calligraphy getById(Integer id) {
        Calligraphy calligraphy = calligraphyDao.findTopById(id);
        return calligraphy;
    }

    /**
     * 分页
     */
    public Page<Calligraphy> findAll(Integer pageNum, Integer pageSize, Integer type) {
        pageNum= pageNum==null?1:pageNum;
        pageSize= pageSize==null?12:pageSize;
        Pageable pageable1 = new QPageRequest(pageNum-1, pageSize);
        Page<Calligraphy> calligraphyPage;
        if(type == null){
            calligraphyPage = calligraphyDao.findAll(pageable1);
        }else{
            calligraphyPage = calligraphyDao.findAllByTypeOrderByIdDesc(type, pageable1);
        }
        return calligraphyPage;
    }


    /**
     * 获取首页数据
     * @return
     */
    public List<Calligraphy> getIndexData() {
        return calligraphyDao.findAllByTypeOrderByIdAsc(Calligraphy.INDEX_DATA);
    }
    public List<Calligraphy> findAll(){
        List<Calligraphy> list = calligraphyDao.findAll();
        return list;
    }
    /**
     * 删除
     */
    public void delete(Integer id){
        calligraphyDao.deleteById(id);
    }

    public void save(Calligraphy calligraphy) {
        calligraphy.setCommentAmount(0);
        calligraphyDao.save(calligraphy);
    }
    public void update(Calligraphy calligraphy){
        calligraphyDao.save(calligraphy);
    }
}
