package com.kh.hanmadang.web.post;

import com.kh.hanmadang.web.form.EventInfoForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/promotions")
public class PromotionPostController {


  @GetMapping("/add")
  public String addForm() {

    return "post/promotion/addForm";
  }
  @PostMapping("/add")
  public String add() {

    return "redirect:/promotions/{id}";
  }
  @GetMapping("/{id}/edit")
  public String editForm() {

    return "post/promotion/editForm";
  }
  @PostMapping("/{id}/edit")
  public String edit(Long pid, EventInfoForm eventInfo) {

    return "redirect:/promotions/{id}";
  }
  @GetMapping("/{id}")
  public String findById(Long pid) {

    return "post/promotion/detailForm";
  }
  @GetMapping
  public String all() {

    return "post/promotion/all";
  }
}
