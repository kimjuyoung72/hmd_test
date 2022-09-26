package com.kh.hanmadang.web.session;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UpdateMember {
  private String nickname;    //닉네임
  private String password;        // 패스워드
  private String phone;           // 전화번호
  private Boolean sms_service;    // sms 서비스
  private Boolean email_service;  // 이메일 서비스
  @DateTimeFormat(pattern = "yy-MM-dd HH:mm:ss")
  private LocalDateTime udate;    //수정일
}
