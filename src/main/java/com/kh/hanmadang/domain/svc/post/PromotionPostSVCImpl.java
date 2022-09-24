package com.kh.hanmadang.domain.svc.post;

import com.kh.hanmadang.web.form.PromotionForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PromotionPostSVCImpl implements PromotionPostSVC {
  @Override
  public List<PromotionForm> all() {
    return null;
  }

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
}
