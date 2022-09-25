package com.kh.hanmadang.web.form;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PromotionForm {
  private Long promotionPostId;        //글번호 ID
  private String promotionPostTitle;         //제목 title
  private String promotionPostLink;   //홍보이미지 링크
  private StringBuffer promotionPostContent; //내용 content
  private String promotionPostWriter;              //작성자
  private String promotionStartDate;           //시작일
  private String promotionEndDate;             //마감일
  private String promotionEntFee;                //참가비
  private LocalDateTime cdate;        //작성일
  private LocalDateTime udate;        //수정일
  private Integer promotionPostGood;               //좋아요 -_-)b

}
