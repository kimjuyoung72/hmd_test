package com.kh.hanmadang.domain.svc.post;

import com.kh.hanmadang.domain.EventInfo;
import com.kh.hanmadang.domain.dao.post.EventPostDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventPostSVCImpl implements EventPostSVC{

  private final EventPostDAO eventPostDAO;
  /**
   * 목록
   *
   * @return 후기글목록
   */
  @Override
  public List<EventInfo> all() {
    log.info("size={}", eventPostDAO.all().size());
    return eventPostDAO.all();
  }
}
