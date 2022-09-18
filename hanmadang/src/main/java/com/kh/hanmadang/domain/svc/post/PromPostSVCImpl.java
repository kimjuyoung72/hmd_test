package com.kh.hanmadang.domain.svc.post;

import com.kh.hanmadang.domain.PromInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PromPostSVCImpl implements PromPostSVC{
  @Override
  public List<PromInfo> all() {
    return null;
  }

  @Override
  public Long add(PromInfo promInfo) {
    return null;
  }

  @Override
  public PromInfo edit(Long pid, PromInfo promInfo) {
    return null;
  }

  @Override
  public PromInfo findById(Long pid) {
    return null;
  }
}
