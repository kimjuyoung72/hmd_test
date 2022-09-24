package com.kh.hanmadang.domain.svc.post;

import com.kh.hanmadang.web.form.EventInfoForm;

import java.util.List;

public interface EventPostSVC {

  /**
   * 목록
   * @return 이벤트목록
   */
  List<EventInfoForm> all();

  /**
   * 등록
   * @param eventInfo 이벤트정보
   * @return 글번호(아이디)
   */
  Long add(EventInfoForm eventInfo);

  /**
   * 수정
   * @param pid 글번호
   * @param eventInfo 이벤트정보
   * @return 이벤트정보
   */
  EventInfoForm edit(Long pid, EventInfoForm eventInfo);

  /**
   * 조회
   * @param pid 글번호
   * @return 이벤트정보
   */
  EventInfoForm findById(Long pid);

}
