package com.kh.hanmadang.domain.svc.post;

import com.kh.hanmadang.domain.EventInfo;

import java.util.List;

public interface EventPostSVC {


  /**
   * 목록
   * @return 후기글목록
   */
  List<EventInfo> all();

}
