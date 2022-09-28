package com.kh.hanmadang.domain.dao.post;

import java.util.List;

public interface PostDAO {

  /**
   * 원글작성
   * @param post
   * @return 게시글 번호
   */
  Long saveOrigin(Post post);

  /**
   * 목록
   * @return
   */
  List<Post> findAll();
  List<Post>  findAll(String category);

  List<Post>  findAll(int startRec, int endRec);
  List<Post>  findAll(String category,int startRec, int endRec);

  /**
   * 검색
   * @param filterCondition 분류,시작레코드번호,종료레코드번호,검색유형,검색어
   * @return
   */
  List<Post>  findAll(PostFilterCondition filterCondition);

  /**
   * 상세 조회
   * @param id 게시글번호
   * @return
   */
  Post findByBbsId(Long id);

  /**
   * 삭제
   * @param id 게시글번호
   * @return 삭제건수
   */
  int deleteByBbsId(Long id);

  /**
   * 수정
   * @param id 게시글 번호
   * @param post 수정내용
   * @return 수정건수
   */
  int updateByBbsId(Long id,Post post);


  /**
   * 답글작성
   * @param pbbsId 부모글번호
   * @param replyBbs 답글
   * @return 답글번호
   */
  Long saveReply(Long pbbsId,Post replyBbs);

  /**
   * 조회수증가
   * @param id 게시글번호
   * @return  수정건수
   */
  int increaseHitCount(Long id);

  /**
   * 전체건수
   * @return 게시글 전체건수
   */
  int totalCount();
  int totalCount(String bcategory);
  int totalCount(PostFilterCondition filterCondition);

}
