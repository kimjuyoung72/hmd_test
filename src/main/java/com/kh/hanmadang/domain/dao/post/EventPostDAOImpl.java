package com.kh.hanmadang.domain.dao.post;

import com.kh.hanmadang.web.form.EventInfoForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class EventPostDAOImpl implements EventPostDAO{
  @Override
  public List<EventInfoForm> all() {
    return null;
  }

  @Override
  public Long add(EventInfoForm eventInfo) {
    return null;
  }

  @Override
  public EventInfoForm edit(Long pid, EventInfoForm eventInfo) {
    return null;
  }

  @Override
  public EventInfoForm findById(Long pid) {
    return null;
  }
}
