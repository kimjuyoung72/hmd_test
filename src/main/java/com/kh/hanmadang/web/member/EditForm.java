package com.kh.hanmadang.web.member;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class EditForm {
  private Long id;                //아이디
  @NotBlank
  @Size(min = 6, max=20)
  private String password;        // 비밀번호
  @NotBlank
  @Size(min = 2, max=10)
  private String nickname;        // 닉네임
  @NotBlank
  @Size(min = 0, max=12)
  private String phone;           // 전화번호
  private Boolean sms_service;    // sms 서비스
  private Boolean email_service;  // 이메일 서비스
}