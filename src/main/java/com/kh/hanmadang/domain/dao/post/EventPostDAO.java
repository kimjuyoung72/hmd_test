package com.kh.hanmadang.domain.dao.post;

import com.kh.hanmadang.domain.EventInfo;

import java.util.List;

public interface EventPostDAO {

  /**
   * 등록
   * @param eventInfo 공연 게시물 정보
   * @return 등록건수
   */
  int add(EventInfo eventInfo);

  /**
   * 수정
   * @param pid 글번호
   * @param eventInfo 후기 게시물 정보
   * @return 수정건수
   */
  int edit(Long pid, EventInfo eventInfo);

  /**
   * 조회
   * @param pid 글번호
   * @return 후기 게시물 정보
   */
  EventInfo findByPostId(Long pid);


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
  List<EventInfo> all();


}
