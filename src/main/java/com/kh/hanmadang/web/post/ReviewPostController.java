package com.kh.hanmadang.web.post;

import com.kh.hanmadang.domain.EventInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/reviews")
public class ReviewPostController {


    @GetMapping
    public String all() {

      return "post/review/all";
    }
    @GetMapping("/add")
    public String addForm() {

      return "post/event/addForm";
    }
    @PostMapping("/add")
    public String add() {

      return "redirect:/reviews/{id}";
    }
    @GetMapping("/{id}/edit")
    public String editForm() {

      return "post/review/editForm";
    }
    @PostMapping("/{id}/edit")
    public String edit(Long pid, EventInfo eventInfo) {

      return "redirect:/reviews/{id}";
    }
    @GetMapping("/{id}")
    public String findById(Long pid) {

      return "post/review/detailForm";
    }
}
