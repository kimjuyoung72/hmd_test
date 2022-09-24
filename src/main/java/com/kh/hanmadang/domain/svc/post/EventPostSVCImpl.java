package com.kh.hanmadang.domain.svc.post;

import com.kh.hanmadang.web.form.EventInfoForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EventPostSVCImpl implements EventPostSVC{
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
