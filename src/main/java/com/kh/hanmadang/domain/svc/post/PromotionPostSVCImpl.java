package com.kh.hanmadang.domain.svc.post;

import com.kh.hanmadang.domain.Promotion;
import com.kh.hanmadang.domain.dao.post.PromotionPostDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PromotionPostSVCImpl implements PromotionPostSVC {

  private final PromotionPostDAO promotionPostDAO;
  /**
   * 등록
   *
   * @param promotion 홍보 게시물 정보
   * @return 등록건수(아이디)
   */
  @Override
  public Promotion add(Promotion promotion) {
    Long promotionPostId = promotionPostDAO.generateReviewId();
    promotion.setPromotionPostId(promotionPostId);
    promotionPostDAO.add(promotion);
    return promotionPostDAO.findByPostId(promotionPostId);
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
    int result = promotionPostDAO.edit(pid, promotion);

    return result;
  }

  /**
   * 조회
   *
   * @param pid 글번호
   * @return 홍보 게시물 정보
   */
  @Override
  public Promotion findById(Long pid) {
    return promotionPostDAO.findByPostId(pid);
  }

  /**
   * 글삭제
   *
   * @param pid 글번호
   * @return 삭제건수
   */
  @Override
  public int delete(Long pid) {
    int result = promotionPostDAO.delete(pid);
    return result;
  }

  /**
   * 목록
   *
   * @return 홍보 글목록
   */
  @Override
  public List<Promotion> all() {
    log.info("size={}", promotionPostDAO.all().size());
    return promotionPostDAO.all();
  }
}
