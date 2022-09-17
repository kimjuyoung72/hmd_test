package com.kh.hanmadang_BUK.web.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {


    //신고계정화면
    @GetMapping("/members/judge")
    public String dclrPostForm() {

        return "/admin/member/dclrPostForm";
    }
    //신고계정처리
    @PostMapping("members/judge")
    public String judge() {

        return "redirect:/members/judge";
    }
    //등록화면
    @GetMapping("/members/add")
    public String addForm() {

        return "/admin/member/addForm";
    }
    //등록처리

    //조회화면

    //수정화면

    //탈퇴화면

    //탈퇴처리

    //회원목록
}
