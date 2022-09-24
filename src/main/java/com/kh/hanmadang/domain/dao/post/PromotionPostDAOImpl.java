package com.kh.hanmadang.domain.dao.post;

import com.kh.hanmadang.web.form.PromotionForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class PromotionPostDAOImpl implements PromotionPostDAO {

  @Override
  public Long add(PromotionForm promInfo) {
    return null;
  }

  @Override
  public PromotionForm edit(Long pid, PromotionForm promInfo) {
    return null;
  }

  @Override
  public PromotionForm findById(Long pid) {
    return null;
  }
  @Override
  public List<PromotionForm> all() {
    return null;
  }

  @Override
  public Long generatePromotionId() {
    return null;
  }

}
