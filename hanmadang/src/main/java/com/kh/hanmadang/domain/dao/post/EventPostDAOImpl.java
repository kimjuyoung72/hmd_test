package com.kh.hanmadang.domain.dao.post;

import com.kh.hanmadang.domain.EventInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class EventPostDAOImpl implements EventPostDAO{
  @Override
  public List<EventInfo> all() {
    return null;
  }

  @Override
  public Long add(EventInfo eventInfo) {
    return null;
  }

  @Override
  public EventInfo edit(Long pid, EventInfo eventInfo) {
    return null;
  }

  @Override
  public EventInfo findById(Long pid) {
    return null;
  }
}
