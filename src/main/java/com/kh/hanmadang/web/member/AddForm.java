package com.kh.hanmadang.web.member;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class AddForm {
  @NotBlank
  @Email(regexp = ".+@.+\\..+")
  private String email;           // 이메일
  @NotBlank
  @Size(min = 6, max=20)
  private String password;        // 비밀번호
  @NotBlank
  private String name;            // 이름
  @NotBlank
  @Size(min = 2, max=10)
  private String nickname;        // 닉네임
  @NotBlank
  @Size(min = 0, max=12)
  private String phone;           // 전화번호
  @NotBlank
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDateTime birthday; // 생일

  private Boolean sms_service;    // sms 서비스
  private Boolean email_service;  // 이메일 서비스
}