package com.kh.hanmadang.domain.svc.post;

import com.kh.hanmadang.domain.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ReviewPostSVCImpl implements ReviewPostSVC{
  @Override
  public List<Review> all() {
    return null;
  }

  @Override
  public Long add(Review review) {
    return null;
  }

  @Override
  public Review edit(Long pid, Review review) {
    return null;
  }

  @Override
  public Review findById(Long pid) {
    return null;
  }
}
