package com.kh.hanmadang.domain.dao.post;

import com.kh.hanmadang.domain.Promotion;
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
public class PromotionPostDAOImpl implements PromotionPostDAO {

  private final JdbcTemplate jt;
  /**
   * 등록
   *
   * @param promotion 홍보 게시물 정보
   * @return 등록건수
   */
  @Override
  public int add(Promotion promotion) {
    int result = 0;
    StringBuffer sql = new StringBuffer();
    sql.append("insert into promotion(promotion_post_id,promotion_post_title,promotion_post_link,promotion_post_content,promotion_post_writer,promotion_start_date,promotion_end_date,promotion_ent_fee) ");
    sql.append("values(?,?,?,?,?,?,?,?) ");

    result = jt.update(sql.toString(), promotion.getPromotionPostId(), promotion.getPromotionPostTitle(),
        promotion.getPromotionPostLink(), promotion.getPromotionPostContent(),promotion.getPromotionPostWriter(),
        promotion.getPromotionStartDate(), promotion.getPromotionEndDate(),promotion.getPromotionEntFee());

    return result;
  }

  /**
   * 수정
   *
   * @param pid       글번호
   * @param promotion 홍보 게시물 정보
   * @return 수정건수
   */
  @Override
  public int edit(Long pid, Promotion promotion) {
    int result = 0;
    StringBuffer sql = new StringBuffer();

    sql.append("update promotion ");
    sql.append("   set promotion_post_title = ?, ");
    sql.append("       promotion_post_content = ?, ");
    sql.append("       promotion_start_date = ?, ");
    sql.append("       promotion_end_date = ?, ");
    sql.append("       promotion_ent_fee = ? ");
    sql.append(" where promotion_post_id = ? ");

    result = jt.update(sql.toString(), promotion.getPromotionPostTitle(), promotion.getPromotionPostContent(),
                promotion.getPromotionStartDate(), promotion.getPromotionEndDate(), promotion.getPromotionEntFee() ,pid);
    return result;
  }

  /**
   * 조회
   *
   * @param pid 글번호
   * @return 홍보 게시물 정보
   */
  @Override
  public Promotion findByPostId(Long pid) {
    StringBuffer sql = new StringBuffer();

    sql.append("select * ");
    sql.append("  from promotion ");
    sql.append(" where promotion_post_id = ? ");

    Promotion findedPrm = null;
    try {
      //BeanPropertyRowMapper는 매핑되는 자바클래스에 디폴트생성자 필수!
      findedPrm = jt.queryForObject(sql.toString(), new BeanPropertyRowMapper<>(Promotion.class), pid);

    } catch (DataAccessException e) {
      log.info("찾고자하는 후기가 없습니다!={}",pid);
    }
    return findedPrm;
  }

  /**
   * 리뷰 삭제
   *
   * @param pid 글번호
   * @return 삭제건수
   */
  @Override
  public int delete(Long pid) {
    int result = 0;
    String sql = "delete from promotion where promotion_post_id = ? ";

    result = jt.update(sql, pid);
    return result;
  }

  /**
   * 목록
   *
   * @return 후기글목록
   */
  @Override
  public List<Promotion> all() {
//    StringBuffer sql = new StringBuffer();
//    sql.append("select promotion_post_id,promotion_post_title,promotion_post_content,promotion_post_writer,promotion_start_date,promotion_end_date,promotion_ent_fee,promotion_post_good");
//    sql.append("  from promotion ");
    String sql = "select * from promotion ";
    List<Promotion> result = jt.query(sql,new BeanPropertyRowMapper<>(Promotion.class));
    return result;
  }

  /**
   * 상품아이디생성
   */
  @Override
  public Long generateReviewId() {
    String sql = "select promotion_promotion_post_id_seq.nextval from dual ";
    Long promotionPostId = jt.queryForObject(sql, Long.class);
    return promotionPostId;
  }
}
