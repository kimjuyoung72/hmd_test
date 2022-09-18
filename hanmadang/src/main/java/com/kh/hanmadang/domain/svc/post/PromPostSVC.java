package com.kh.hanmadang.domain.svc.post;

import com.kh.hanmadang.domain.PromInfo;

import java.util.List;

public interface PromPostSVC {

  /**
   * 목록
   * @return 홍보글목록
   */
  List<PromInfo> all();

  /**
   * 등록
   * @param promInfo 홍보 게시물 정보
   * @return 글번호(아이디)
   */
  Long add(PromInfo promInfo);

  /**
   * 수정
   * @param pid 글번호
   * @param promInfo 홍보 게시물 정보
   * @return 홍보 게시물 정보
   */
  PromInfo edit(Long pid, PromInfo promInfo);

  /**
   * 조회
   * @param pid 글번호
   * @return 홍보 게시물 정보
   */
  PromInfo findById(Long pid);
}
