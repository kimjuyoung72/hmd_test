package com.kh.hanmadang.domain.dao.post;

import com.kh.hanmadang.domain.PromInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class PromPostDAOImpl implements PromPostDAO{
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
