package com.kh.hanmadang.domain.dao.post;

import com.kh.hanmadang.domain.EventInfo;
import com.kh.hanmadang.domain.dao.admin.ApiPubDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class EventPostDAOImpl implements EventPostDAO{

  private final JdbcTemplate jt;
  private final ApiPubDAO apiPubDAO;

  /**
   * 등록
   *
   * @param eventInfo 공연 게시물 정보
   * @return 등록건수
   */
  @Override
  public int add(EventInfo eventInfo) {
    return 0;
  }

  /**
   * 수정
   *
   * @param pid       글번호
   * @param eventInfo 후기 게시물 정보
   * @return 수정건수
   */
  @Override
  public int edit(Long pid, EventInfo eventInfo) {
    return 0;
  }

  /**
   * 조회
   *
   * @param pid 글번호
   * @return 후기 게시물 정보
   */
  @Override
  public EventInfo findByPostId(Long pid) {
    return null;
  }

  /**
   * 리뷰 삭제
   *
   * @param pid 글번호
   * @return 삭제건수
   */
  @Override
  public int delete(Long pid) {
    return 0;
  }

  /**
   * 목록
   *
   * @return 후기글목록
   */
  @Override
  public List<EventInfo> all() {
    String sql = "select * from p_event ";
    List<EventInfo> result = jt.query(sql,new BeanPropertyRowMapper<>(EventInfo.class));
    return result;
  }
}
