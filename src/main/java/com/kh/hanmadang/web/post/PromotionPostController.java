package com.kh.hanmadang.web.post;

import com.kh.hanmadang.domain.Promotion;
import com.kh.hanmadang.domain.svc.post.PromotionPostSVC;
import com.kh.hanmadang.web.form.PromotionForm;
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
@RequestMapping("/promotions")
public class PromotionPostController {

  private final PromotionPostSVC promotionPostSVC;
  //등록화면
  @GetMapping("/add")
  public String addForm(Model model) {

    model.addAttribute("form", new PromotionForm());
    return "post/promotion/addForm";
  }
  //등록
  @PostMapping("/add")
  public String add(@Valid @ModelAttribute("form") PromotionForm promotionForm,
                    BindingResult bindingResult) {
    log.info("rForm={}", promotionForm);

    Promotion promotion = new Promotion();

    BeanUtils.copyProperties(promotionForm, promotion);
    Promotion addedPromotion = promotionPostSVC.add(promotion);

    return "redirect:/promotions/"+addedPromotion.getPromotionPostId();
  }
  //수정화면
  @GetMapping("/{pid}/edit")
  public String editForm(@PathVariable("pid") Long pid,
                         Model model) {
    Promotion findedPromotion = promotionPostSVC.findById(pid);
    PromotionForm promotionForm = new PromotionForm();
    BeanUtils.copyProperties(findedPromotion, promotionForm);
    model.addAttribute("form", promotionForm);

    return "post/promotion/editForm";
  }
  //수정
  @PostMapping("/{pid}/edit")
  public String edit(@Valid @ModelAttribute("form") PromotionForm promotionForm,
                     @PathVariable("pid") Long pid,
                     BindingResult bindingResult,
                     RedirectAttributes redirectAttributes) {

    Promotion promotion = new Promotion();
    BeanUtils.copyProperties(promotionForm, promotion);
    promotionPostSVC.edit(pid, promotion);

    redirectAttributes.addAttribute("pid", pid);
    return "redirect:/promotions/{pid}";
  }
  //조회
  @GetMapping("/{pid}")
  public String findById(@PathVariable("pid") Long pid,
                         Model model) {
    Promotion findedPromotion = promotionPostSVC.findById(pid);

    PromotionForm promotionForm = new PromotionForm();
    BeanUtils.copyProperties(findedPromotion, promotionForm);
    model.addAttribute("form", promotionForm);

    return "post/promotion/detailForm";
  }

  //삭제
  @GetMapping("/{pid}/del")
  public String deleteById(@PathVariable("pid") Long pid) {
    promotionPostSVC.delete(pid);
    return "redirect:/promotions";
  }
  //목록
  @GetMapping
  public String all(Model model) {

    List<Promotion> list = promotionPostSVC.all();
    log.info("review size={}", list.size());
    model.addAttribute("list", list);
    return "post/promotion/all";
  }
}
