package com.kh.hanmadang.domain.dao.post;

import com.kh.hanmadang.domain.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class ReviewPostDAOImpl implements ReviewPostDAO{
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
