package com.kh.hanmadang.web.post;

import com.kh.hanmadang.domain.EventInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/events")
public class EventPostController {

  @GetMapping
  public String all() {

    return "post/event/all";
  }
  @GetMapping("/add")
  public String addForm() {

    return "post/event/addForm";
  }
  @PostMapping("/add")
  public String add() {

    return "redirect:/events/{id}";
  }
  @GetMapping("/{id}/edit")
  public String editForm() {

    return "post/event/editForm";
  }
  @PostMapping("/{id}/edit")
  public String edit(Long pid, EventInfo eventInfo) {

    return "redirect:/events/{id}";
  }
  @GetMapping("/{id}")
  public String findById(Long pid) {

    return "post/event/detailForm";
  }
}
