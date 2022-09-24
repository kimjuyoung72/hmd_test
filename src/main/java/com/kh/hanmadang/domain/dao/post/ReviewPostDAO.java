package com.kh.hanmadang.domain.dao.post;

import com.kh.hanmadang.domain.Review;

import java.util.List;

public interface ReviewPostDAO {

  /**
   * 등록
   * @param review 후기 게시물 정보
   * @return 등록건수
   */
  int add(Review review);

  /**
   * 수정
   * @param pid 글번호
   * @param review 후기 게시물 정보
   * @return 수정건수
   */
  int edit(Long pid, Review review);

  /**
   * 조회
   * @param pid 글번호
   * @return 후기 게시물 정보
   */
  Review findByPostId(Long pid);


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
  List<Review> all();


  /**
   * 상품아이디생성
   */
  Long generateReviewId();
}
