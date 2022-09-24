package com.kh.hanmadang.domain.svc.post;

import com.kh.hanmadang.domain.Review;
import com.kh.hanmadang.domain.dao.post.ReviewPostDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewPostSVCImpl implements ReviewPostSVC{

  private final ReviewPostDAO reviewPostDAO;

  @Override
  public Review add(Review review) {

    Long reviewPostId = reviewPostDAO.generateReviewId();
    review.setReviewPostId(reviewPostId);
    reviewPostDAO.add(review);
    return reviewPostDAO.findByPostId(reviewPostId);
  }

  @Override
  public int edit(Long pid, Review review) {
    int result = reviewPostDAO.edit(pid, review);

    return result;
  }

  @Override
  public Review findById(Long pid) {

    return reviewPostDAO.findByPostId(pid);
  }

  @Override
  public int delete(Long pid) {
    int result = reviewPostDAO.delete(pid);
    return result;

  }

  @Override
  public List<Review> all() {

    log.info("size={}", reviewPostDAO.all().size());
    return reviewPostDAO.all();
  }

}
