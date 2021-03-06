package com.painting.web.api;

import com.painting.web.entity.Calligraphy;
import com.painting.web.service.CalligraphyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 书法
 */
@RestController
@RequestMapping(value = "/api/calligraphy")
public class CalligraphyApi {

    @Autowired
    private CalligraphyService calligraphyService;


    @GetMapping(value = "/list")
    public Page<Calligraphy> getList(Integer pageNum, Integer pageSize, Integer type){
        return calligraphyService.findAll(pageNum, pageSize, type);
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public List<Calligraphy> getList(){
        return calligraphyService.getIndexData();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id){
        calligraphyService.delete(id);
    }

    @PostMapping
    public void add(Calligraphy calligraphy){
        calligraphyService.save(calligraphy);
    }

    @PutMapping
    public void update(Calligraphy calligraphy){
        calligraphyService.update(calligraphy);
    }
}
