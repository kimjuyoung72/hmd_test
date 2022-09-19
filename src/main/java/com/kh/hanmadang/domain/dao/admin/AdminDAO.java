package com.kh.hanmadang.domain.dao.admin;

import com.kh.hanmadang.domain.Statistic;

public interface AdminDAO {
  /**
   * 사이트 통계
   * @return  사이트 통계
   */
  Statistic getStatistic();
}
