package com.kh.hanmadang.domain.svc.post;

import com.kh.hanmadang.domain.Review;

import java.util.List;

public interface ReviewPostSVC {

  /**
   * 등록
   *
   * @param review 후기 게시물 정보
   * @return 등록건수(아이디)
   */
   Review add(Review review);

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
  Review findById(Long pid);

  /**
   * 글삭제
   * @param pid 글번호
   * @return 삭제건수
   */
  int delete(Long pid);

  /**
   * 목록
   * @return 후기글목록
   */
  List<Review> all();

}
