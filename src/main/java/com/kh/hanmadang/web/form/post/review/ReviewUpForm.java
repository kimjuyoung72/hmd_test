package com.kh.hanmadang.web.form.post.review;

import com.kh.hanmadang.domain.common.file.UploadFile;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ReviewUpForm {
  private String reviewFromId;            //관련 공연 ID
  private Long reviewPostId;            //글번호 ID
  private String reviewPostTitle;         //제목
  private String reviewPostLink;          //홍보이미지 링크
  private StringBuffer reviewPostContent; //내용
  private String reviewPostWriter;        //작성자
  private LocalDateTime cdate;            //작성일
  private LocalDateTime udate;            //수정일
  private Integer reviewPostGood;         //좋아요 -_-)b

  private List<MultipartFile> mpFiles;  // 파일 첨부(여러건)
  private List<UploadFile> files;  // 파일 첨부(여러건)

}
