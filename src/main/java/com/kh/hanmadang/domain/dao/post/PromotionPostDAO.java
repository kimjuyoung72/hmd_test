package com.kh.hanmadang.domain.dao.post;

import com.kh.hanmadang.domain.Promotion;

import java.util.List;

public interface PromotionPostDAO {

  /**
   * 등록
   * @param promotion 홍보 게시물 정보
   * @return 등록건수
   */
  int add(Promotion promotion);

  /**
   * 수정
   * @param pid 글번호
   * @param promotion 홍보 게시물 정보
   * @return 수정건수
   */
  int edit(Long pid, Promotion promotion);

  /**
   * 조회
   *
   * @param pid 글번호
   * @return 홍보 게시물 정보
   */
  Promotion findByPostId(Long pid);


  /**
   * 리뷰 삭제
   * @param pid 글번호
   * @return 삭제건수
   */
  int delete(Long pid);

  /**
   * 목록
   * @return 후기글목록
   */
  List<Promotion> all();


  /**
   * 상품아이디생성
   */
  Long generateReviewId();
}
