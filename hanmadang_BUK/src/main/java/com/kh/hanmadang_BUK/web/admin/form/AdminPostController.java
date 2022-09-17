package com.kh.hanmadang_BUK.web.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin/posts")
public class AdminPostController {

    //포스터 이미지 링크 화면
    @GetMapping("/poster")
    public String posterLinkForm() {

        return "/admin/post/posterLinkForm";
    }
    //포스터 이미지 처리
    @PostMapping("/poster")
    public String getPoster() {

        return "redirect:/poster";
    }

    //신고게시물 화면
    @GetMapping("/dclr")
    public String dclrPostForm() {

        return "/admin/post/dclrPostForm";
    }
    //신고게시물 처리
    @PostMapping("/dclr")
    public String decideDclr() {

        return "redirect:/dclr";
    }
}
