package com.kh.hanmadang.domain.svc.post;

import com.kh.hanmadang.domain.Promotion;

import java.util.List;

public interface PromotionPostSVC {

  /**
   * 등록
   *
   * @param promotion 홍보 게시물 정보
   * @return 등록건수(아이디)
   */
  Promotion add(Promotion promotion);

  /**
   * 수정
   * @param pid 글번호
   * @param promotion 홍보 게시물 정보
   * @return 수정건수
   */
  int edit(Long pid, Promotion promotion);

  /**
   * 조회
   * @param pid 글번호
   * @return 홍보 게시물 정보
   */
  Promotion findById(Long pid);

  /**
   * 글삭제
   * @param pid 글번호
   * @return 삭제건수
   */
  int delete(Long pid);

  /**
   * 목록
   * @return 홍보 글목록
   */
  List<Promotion> all();
}
