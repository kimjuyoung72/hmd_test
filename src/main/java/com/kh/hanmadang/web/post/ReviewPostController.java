package com.kh.hanmadang.web.post;

import com.kh.hanmadang.domain.Review;
import com.kh.hanmadang.domain.svc.post.ReviewPostSVC;
import com.kh.hanmadang.web.form.ReviewForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewPostController {

    private final ReviewPostSVC reviewPostSVC;

    //등록화면
    @GetMapping("/add")
    public String addForm(Model model) {

      model.addAttribute("form", new ReviewForm());
      return "post/review/addForm";
    }
    //등록
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("form") ReviewForm reviewForm,
                      BindingResult bindingResult) {
      log.info("rForm={}", reviewForm);

      Review review = new Review();

      BeanUtils.copyProperties(reviewForm, review);
      Review addedReview = reviewPostSVC.add(review);

      return "redirect:/reviews/"+addedReview.getReviewPostId();
    }
    //수정화면
    @GetMapping("/{pid}/edit")
    public String editForm(@PathVariable("pid") Long pid,
                           Model model) {
      Review findedReview = reviewPostSVC.findById(pid);
      ReviewForm reviewForm = new ReviewForm();
      BeanUtils.copyProperties(findedReview, reviewForm);
      model.addAttribute("form", reviewForm);

      return "post/review/editForm";
    }
    //수정
    @PostMapping("/{pid}/edit")
    public String edit(@Valid @ModelAttribute("form") ReviewForm reviewForm,
                       @PathVariable("pid") Long pid,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {

      Review review = new Review();
      BeanUtils.copyProperties(reviewForm, review);
      reviewPostSVC.edit(pid, review);

      redirectAttributes.addAttribute("pid", pid);
      return "redirect:/reviews/{pid}";
    }
    //조회
    @GetMapping("/{pid}")
    public String findById(@PathVariable("pid") Long pid,
                           Model model) {
      Review findedReview = reviewPostSVC.findById(pid);

      ReviewForm reviewForm = new ReviewForm();
      BeanUtils.copyProperties(findedReview, reviewForm);
      model.addAttribute("form", reviewForm);

      return "post/review/detailForm";
    }

  //삭제
  @GetMapping("/{pid}/del")
  public String deleteById(@PathVariable("pid") Long pid) {
    reviewPostSVC.delete(pid);
    return "redirect:/reviews";
  }
    //목록
    @GetMapping
    public String all(Model model) {

    List<Review> list = reviewPostSVC.all();
    log.info("review size={}", list.size());
    model.addAttribute("list", list);
    return "post/review/all";
  }
}
