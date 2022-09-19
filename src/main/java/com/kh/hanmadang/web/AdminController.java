package com.kh.hanmadang.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

  //관리자 메인, 통계 화면
  @GetMapping("/")
  public String statForm() {

    return "/admin/statForm";
  }


  //공공데이터 요청 화면
  @GetMapping("/api")
  public String ApiForm() {

    return "/admin/apiForm";
  }


}
