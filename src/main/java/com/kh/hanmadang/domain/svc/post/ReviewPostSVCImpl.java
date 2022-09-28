package com.kh.hanmadang.domain.svc.post;

import com.kh.hanmadang.domain.Review;
import com.kh.hanmadang.domain.common.file.AttachCode;
import com.kh.hanmadang.domain.common.file.FileUtils;
import com.kh.hanmadang.domain.common.file.UploadFileSVC;
import com.kh.hanmadang.domain.dao.post.ReviewPostDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewPostSVCImpl implements ReviewPostSVC{

  private final ReviewPostDAO reviewPostDAO;
  private final UploadFileSVC uploadFileSVC;
  private final FileUtils fileUtils;

  @Override
  public Review add(Review review) {

    Long reviewPostId = reviewPostDAO.generateReviewId();
    review.setReviewPostId(reviewPostId);
    reviewPostDAO.add(review);
    return reviewPostDAO.findByPostId(reviewPostId);
  }

  @Override
  @Transactional
  public Review add(Review review, List<MultipartFile> files) {
    Long reviewPostId = reviewPostDAO.generateReviewId();
    review.setReviewPostId(reviewPostId);
    reviewPostDAO.add(review);
    uploadFileSVC.addFile(files, AttachCode.B0103, reviewPostId);
    return reviewPostDAO.findByPostId(reviewPostId);
  }

  @Override
  public int edit(Long pid, Review review) {
    int result = reviewPostDAO.edit(pid, review);

    return result;
  }

  @Transactional
  @Override
  public int edit(Long pid, Review review, List<MultipartFile> files) {
    int affectedRow = edit(pid, review);
    uploadFileSVC.addFile(files, AttachCode.B0103, pid);
    return affectedRow;
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
