package com.kh.hanmadang.domain.svc.post;

import com.kh.hanmadang.domain.dao.post.Post;
import com.kh.hanmadang.domain.dao.post.PostDAO;
import com.kh.hanmadang.domain.dao.post.PostFilterCondition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.kh.hanmadang.domain.common.file.UploadFileSVC;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class PostSVCImpl implements PostSVC{

  private final PostDAO postDAO;
  private final UploadFileSVC uploadFileSVC;

  //원글
  @Override
  public Long saveOrigin(Post post) {
    return postDAO.saveOrigin(post);
  }

  @Override
  public Long saveOrigin(Post post, List<MultipartFile> files) {
    //1)원글 저장
    Long postId = saveOrigin(post);

    //2)첨부 저장
    uploadFileSVC.addFile(post.getBcategory(),postId,files);

    return postId;
  }

  //목록
  @Override
  public List<Post> findAll() {
    return postDAO.findAll();
  }

  @Override
  public List<Post> findAll(int startRec, int endRec) {
    return postDAO.findAll(startRec, endRec);
  }

  @Override
  public List<Post> findAll(String category, int startRec, int endRec) {
    return postDAO.findAll(category, startRec, endRec);
  }

  @Override
  public List<Post> findAll(PostFilterCondition filterCondition) {
    return postDAO.findAll(filterCondition);
  }

  //상세조회
  @Override
  public Post findByBbsId(Long id) {
    Post findedItem = postDAO.findByBbsId(id);
    postDAO.increaseHitCount(id);
    return findedItem;
  }

  //삭제
  @Override
  public int deleteByBbsId(Long id) {
    //1)첨부파일 삭제
    String bcategory = postDAO.findByBbsId(id).getBcategory();
    uploadFileSVC.deleteFileByCodeWithRid(bcategory, id);

    //2)게시글 삭제
    int affectedRow =  postDAO.deleteByBbsId(id);

    return affectedRow;
  }

  //수정
  @Override
  public int updateByBbsId(Long id, Post post) {
    return postDAO.updateByBbsId(id, post);
  }

  //수정-첨부파일
  @Override
  public int updateByBbsId(Long id, Post post, List<MultipartFile> files) {
    //1)수정
    int affectedRow = updateByBbsId(id,post);

    //2)첨부 저장
    uploadFileSVC.addFile(post.getBcategory(),id,files);

    return affectedRow;
  }

  //답글
  @Override
  public Long saveReply(Long pbbsId, Post replyBbs) {
    return postDAO.saveReply(pbbsId, replyBbs);
  }

  @Override
  public Long saveReply(Long pbbsId, Post replyBbs, List<MultipartFile> files) {
    //1)답글 작성
    Long bbsId = postDAO.saveReply(pbbsId, replyBbs);

    //2)첨부 저장
    uploadFileSVC.addFile(replyBbs.getBcategory(),bbsId,files);

    return bbsId;
  }

  @Override
  public int totalCount() {
    return postDAO.totalCount();
  }

  @Override
  public int totalCount(String bcategory) {
    return postDAO.totalCount(bcategory);
  }

  @Override
  public int totalCount(PostFilterCondition filterCondition) {
    return postDAO.totalCount(filterCondition);
  }
}
