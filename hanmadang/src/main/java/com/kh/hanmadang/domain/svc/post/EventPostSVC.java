package com.kh.hanmadang.domain.svc.post;

import com.kh.hanmadang.domain.EventInfo;

import java.util.List;

public interface EventPostSVC {

  /**
   * 목록
   * @return 이벤트목록
   */
  List<EventInfo> all();

  /**
   * 등록
   * @param eventInfo 이벤트정보
   * @return 글번호(아이디)
   */
  Long add(EventInfo eventInfo);

  /**
   * 수정
   * @param pid 글번호
   * @param eventInfo 이벤트정보
   * @return 이벤트정보
   */
  EventInfo edit(Long pid, EventInfo eventInfo);

  /**
   * 조회
   * @param pid 글번호
   * @return 이벤트정보
   */
  EventInfo findById(Long pid);

}
