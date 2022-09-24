package com.kh.hanmadang.domain.dao.post;

import com.kh.hanmadang.domain.Review;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ReviewPostDAOImpl implements ReviewPostDAO{

  private final JdbcTemplate jt;

  @Override
  public int add(Review review) {

    int result = 0;
    StringBuffer sql = new StringBuffer();
    sql.append("insert into review(review_from_id,review_post_id,review_post_title,review_post_link,review_post_content,review_post_writer,review_post_good) ");
    sql.append("values(?,?,?,?,?,?,?) ");

    result = jt.update(sql.toString(), review.getReviewFromId(), review.getReviewPostId(),
        review.getReviewPostTitle(), review.getReviewPostLink(),review.getReviewPostContent(),
        review.getReviewPostWriter(), review.getReviewPostGood());

    return result;

  }

  @Override
  public int edit(Long pid, Review review) {

    int result = 0;
    StringBuffer sql = new StringBuffer();
    sql.append("update review ");
    sql.append("   set review_post_content = ?, ");
    sql.append("       udate = systimestamp ");
    sql.append(" where review_post_id = ? ");
//    sql.append("   and pw = ? ");

    result = jt.update(sql.toString(), review.getReviewPostContent(), pid);
    return result;
  }

  @Override
  public Review findByPostId(Long pid) {

    StringBuffer sql = new StringBuffer();

    sql.append("select * ");
    sql.append("  from review ");
    sql.append(" where review_post_id = ? ");

    Review findedReview = null;
    try {
      //BeanPropertyRowMapper는 매핑되는 자바클래스에 디폴트생성자 필수!
      findedReview = jt.queryForObject(sql.toString(), new BeanPropertyRowMapper<>(Review.class), pid);

    } catch (DataAccessException e) {
      log.info("찾고자하는 후기가 없습니다!={}",pid);
    }
    return findedReview;

  }

  @Override
  public int delete(Long pid) {

    int result = 0;
    String sql = "delete from review where review_post_id = ? ";

    result = jt.update(sql, pid);
    return result;
  }

  @Override
  public List<Review> all() {
//    StringBuffer sql = new StringBuffer();
//
//    sql.append("select review_from_id,review_post_id,review_post_title,review_post_link,review_post_content,review_post_writer,review_post_good ");
//    sql.append("  from review ");
    String sql = "select * from review ";
    List<Review> result = jt.query(sql,new BeanPropertyRowMapper<>(Review.class));
    return result;
  }

  @Override
  public Long generateReviewId() {
    String sql = "select review_review_post_id_seq.nextval from dual ";
    Long reviewPostId = jt.queryForObject(sql, Long.class);
    return reviewPostId;

  }
}
