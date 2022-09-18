package com.kh.hanmadang.domain.dao.admin;

import com.kh.hanmadang.domain.Statistic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AdminDAOImpl implements AdminDAO{
  @Override
  public Statistic getStatistic() {
    return null;
  }
}
