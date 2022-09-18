package com.kh.hanmadang.domain.svc.admin;

import com.kh.hanmadang.domain.Statistic;

public interface AdminSVC {
  /**
   * 사이트 통계, 관리자 메인
   * @return 사이트 통계
   */
  Statistic getStatistic();
}
