package com.kh.hanmadang.web.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin/members")
public class AdminMemberController {


  //신고계정화면
  @GetMapping("/judge")
  public String dclrPostForm() {

    return "/admin/member/dclrMemberForm";
  }
  //신고계정처리
  @PostMapping("/judge")
  public String judge() {

    return "redirect:/admin/members/judge";
  }
  //등록화면
  @GetMapping("/add")
  public String addForm() {

    return "/admin/member/addForm";
  }
  //등록처리
  @PostMapping("/add")
  public String add() {

    return "redirect:/admin/members/{id}";
  }
  //조회화면
  @GetMapping("/{id}")
  public String findById() {

    return "admin/member/memberForm";
  }
  //수정화면
  @GetMapping("/{id}/edit")
  public String editForm() {

    return "admin/member/editForm";
  }
  //수정처리
  @PostMapping("/{id}/edit")
  public String edit() {

    return "redirect:/admin/members/{id}";
  }
  //탈퇴화면
  @GetMapping("/del")
  public String delForm() {

    return "/admin/member/delForm";
  }
  //탈퇴처리
  @GetMapping("/{id}/del")
  public String del() {

    return "redirect:admin/members/del";
  }
  //회원목록
  @GetMapping("/all")
  public String all() {

    return "admin/member/all";
  }
}