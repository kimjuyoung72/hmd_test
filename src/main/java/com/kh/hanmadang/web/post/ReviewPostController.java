package com.kh.hanmadang.web.post;

import com.kh.hanmadang.domain.Review;
import com.kh.hanmadang.domain.common.file.AttachCode;
import com.kh.hanmadang.domain.common.file.UploadFile;
import com.kh.hanmadang.domain.common.file.UploadFileSVC;
import com.kh.hanmadang.domain.svc.post.ReviewPostSVC;
import com.kh.hanmadang.web.form.post.review.ReviewAddForm;
import com.kh.hanmadang.web.form.post.review.ReviewDetailForm;
import com.kh.hanmadang.web.form.post.review.ReviewUpForm;
import com.kh.hanmadang.web.session.LoginMember;
import com.kh.hanmadang.web.session.LoginOkConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewPostController {

    private final ReviewPostSVC reviewPostSVC;
    private final UploadFileSVC uploadFileSVC;

    //등록화면
    @GetMapping("/add")
    public String addForm(Model model) {

      model.addAttribute("form", new ReviewDetailForm());
      return "post/review/addForm";
    }
    //등록
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("form") ReviewAddForm reviewAddForm,
                      BindingResult bindingResult,
                      HttpSession session) {

      if (bindingResult.hasErrors()) {
        log.info("bindingResult={}", bindingResult);
        return "post/review/addForm";
      }
      //세션 가져오기
      LoginMember loginInfo = (LoginMember) session.getAttribute(LoginOkConst.LOGIN_MEMBER);
      //세션 정보가 없으면 로그인페이지로 이동
      if (loginInfo == null) {
        return "redirect:/login";
      }

      Review review = new Review();

      BeanUtils.copyProperties(reviewAddForm, review);
      review.setReviewPostWriter(loginInfo.getName());
//      review.setReviewPostWriter("김재미");
      Review addedReview = new Review();
      if (!reviewAddForm.getFiles().get(0).isEmpty()) {
        addedReview = reviewPostSVC.add(review, reviewAddForm.getFiles());
      }else {

        addedReview = reviewPostSVC.add(review);
      }
      return "redirect:/reviews/" + addedReview.getReviewPostId();
    }

    //수정화면
    @GetMapping("/{pid}/edit")
    public String editForm(@PathVariable("pid") Long pid, Model model) {
      Review findedReview = reviewPostSVC.findById(pid);
      ReviewUpForm reviewUpForm = new ReviewUpForm();
      BeanUtils.copyProperties(findedReview, reviewUpForm);
      model.addAttribute("form", reviewUpForm);

      return "post/review/editForm";
    }
    //수정======================================================================
    @PostMapping("/{pid}/edit")
    public String edit(@Valid @ModelAttribute("form") ReviewUpForm reviewUpForm,
                       @PathVariable("pid") Long pid,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {

      log.info("reviewUpForm={}",reviewUpForm);
      if (bindingResult.hasErrors()) {
        log.info("bindingResult={}", bindingResult);
        return "review/editForm";
      }

      Review review = new Review();
      BeanUtils.copyProperties(reviewUpForm, review);

      if (reviewUpForm.getMpFiles() == null || reviewUpForm.getMpFiles().size() == 0) { /////////////////////////////////
//      if (!reviewUpForm.getMpFiles().get(0).isEmpty()) { /////////////////////////////////
        log.info("file={}", pid);
        reviewPostSVC.edit(pid, review);
      }else {
        log.info("files={}", pid);
        reviewPostSVC.edit(pid, review, reviewUpForm.getMpFiles());
      }

      redirectAttributes.addAttribute("pid", pid);
      return "redirect:/reviews/{pid}";
    }
    //조회=====================================================================
    @GetMapping("/{pid}")
    public String findById(@PathVariable("pid") Long pid,
                           Model model) {
      Review findedReview = reviewPostSVC.findById(pid);

      ReviewDetailForm reviewDetailForm = new ReviewDetailForm();
      BeanUtils.copyProperties(findedReview, reviewDetailForm);

      //2-2)상품이미지 조회
      List<UploadFile> uploadFiles = uploadFileSVC.getFilesByCodeWithRid(AttachCode.B0103.name(), pid);
      if(uploadFiles.size() > 0 ){
        List<UploadFile> upFiles = new ArrayList<>();
        for (UploadFile file : uploadFiles) {
          upFiles.add(file);
        }
        reviewDetailForm.setFiles(upFiles);
      }

      model.addAttribute("form", reviewDetailForm);

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
