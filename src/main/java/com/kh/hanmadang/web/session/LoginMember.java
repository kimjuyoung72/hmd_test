package com.kh.hanmadang.web.session;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LoginMember {
  private String email;           //이메일
  private String password;        // 패스워드
  private String name;            //이름
  private String nickname;        //닉네임
  private String phone;           // 전화번호
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDateTime birthday; // 생일 ex)2022-01-01
  private Boolean sms_service;    // sms 서비스
  private Boolean email_service;  // 이메일 서비스
  @DateTimeFormat(pattern = "yy-MM-dd HH:mm:ss")
  private LocalDateTime cdate;    //가입일
  @DateTimeFormat(pattern = "yy-MM-dd HH:mm:ss")
  private LocalDateTime udate;    //수정일
}

