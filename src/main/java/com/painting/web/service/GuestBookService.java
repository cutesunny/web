package com.painting.web.service;


import com.painting.web.entity.GuestBook;
import com.painting.web.entity.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GuestBookService {

    ResponseEntity<GuestBook> getById(Integer id);

    ResponseEntity<Page<GuestBook>> findAll(Integer page, Integer size);

    ResponseEntity<String> save(GuestBook guestBook);
}
