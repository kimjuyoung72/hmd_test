package com.kh.hanmadang.domain.svc.admin;

import com.kh.hanmadang.domain.Statistic;
import com.kh.hanmadang.domain.dao.admin.AdminDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminSVCImpl implements AdminSVC{

  private final AdminDAO adminDAO;

  @Override
  public Statistic getStatistic() {
    return null;
  }
}
