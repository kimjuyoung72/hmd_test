package com.kh.hanmadang.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Promotion {
  private Long promotionPostId;        //글번호 ID
  private String PromotionPostTitle;         //제목 title
  private String promotionPostLink;   //홍보이미지 링크
  private StringBuffer promotionPostContent; //내용 content
  private String promotionPostwriter;              //작성자
  private LocalDateTime cdate;        //작성일
  private LocalDateTime udate;        //수정일
  private Integer promotionPostGood;               //좋아요 -_-)b

}
