package com.painting.web.dao;

import com.painting.web.entity.GuestBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Repository
public interface GuestBookDao extends JpaRepository<GuestBook, Integer> {

    GuestBook getById(@Nullable Integer id);


    @Override
    Page<GuestBook> findAll(@Nullable Pageable pageable);


}
