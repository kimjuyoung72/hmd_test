package com.kh.hanmadang.domain.dao.post;

import com.kh.hanmadang.domain.Review;

import java.util.List;

public interface ReviewPostDAO {
  /**
   * 목록
   * @return 후기글목록
   */
  List<Review> all();

  /**
   * 등록
   * @param review 후기 게시물 정보
   * @return 글번호(아이디)
   */
  Long add(Review review);

  /**
   * 수정
   * @param pid 글번호
   * @param review 후기 게시물 정보
   * @return 후기 게시물 정보
   */
  Review edit(Long pid, Review review);

  /**
   * 조회
   * @param pid 글번호
   * @return 후기 게시물 정보
   */
  Review findById(Long pid);
}
