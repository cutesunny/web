package com.painting.web.dao;

import com.painting.web.entity.Painting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 绘画
 */
@Repository
public interface PaintingDao extends JpaRepository<Painting, Integer> {


/*
 */
/**
  * 最新数据
  * @param pageable
  * @return
  *//*

    Page<Painting> findTopBy(Pageable pageable);


 */
/**
  * 热评数据
  * @param pageable
  * @return
  *//*

    Page<Painting> findAllOrderByCommentAmountDesc(Pageable pageable);
*/

/*

    @Query(value = "select p.* FROM painting p WHERE p.type = :type",
    countQuery = "select count(*) FROM painting p WHERE p.type = :type",
    nativeQuery = true)
    Page<Painting> findAllByType(@Param("type") Integer type, Pageable pageable);

*/


}
