package com.kh.hanmadang.domain.dao.post;

import com.kh.hanmadang.web.form.PromotionForm;

import java.util.List;

public interface PromotionPostDAO {

  /**
   * 등록
   * @param promInfo 홍보 게시물 정보
   * @return 글번호(아이디)
   */
  Long add(PromotionForm promInfo);

  /**
   * 수정
   * @param pid 글번호
   * @param promInfo 홍보 게시물 정보
   * @return 홍보 게시물 정보
   */
  PromotionForm edit(Long pid, PromotionForm promInfo);

  /**
   * 조회
   * @param pid 글번호
   * @return 홍보 게시물 정보
   */
  PromotionForm findById(Long pid);

  /**
   * 목록
   * @return 홍보글목록
   */
  List<PromotionForm> all();

  /**
   * 홍보게시판 글번호 생성
   */
  Long generatePromotionId();
}
