package com.kh.hanmadang.web.post;

import com.kh.hanmadang.domain.EventInfo;
import com.kh.hanmadang.domain.svc.post.EventPostSVC;
import com.kh.hanmadang.web.form.EventInfoForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventPostController {

  private final EventPostSVC eventPostSVC;
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
  public String edit(Long pid, EventInfoForm eventInfo) {

    return "redirect:/events/{id}";
  }
  @GetMapping("/{id}")
  public String findById(Long pid) {

    return "post/event/detailForm";
  }

  @GetMapping
  public String all(Model model) {
    List<EventInfo> list = eventPostSVC.all();
    log.info("review size={}", list.size());
    model.addAttribute("list", list);
    return "post/event/all";
  }
}
