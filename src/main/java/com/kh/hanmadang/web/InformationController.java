package com.kh.hanmadang.web;


import com.kh.hanmadang.domain.svc.member.MemberSVC;
import com.kh.hanmadang.web.member.EditForm;
import com.kh.hanmadang.web.session.LoginMember;
import com.kh.hanmadang.web.session.LoginOkConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/afterLogin")
public class InformationController {

  final MemberSVC memberSVC;

  // 내정보
  @GetMapping("/info")
  public String info(HttpServletRequest request, Model model) {

    HttpSession session = request.getSession();

    String id = request.getParameter(LoginOkConst.LOGIN_MEMBER);
    LoginMember loginMember = (LoginMember)session.getAttribute(LoginOkConst.LOGIN_MEMBER);

    model.addAttribute("form", loginMember);


    //LoginMember

    log.info("@ @ @ request check ={}", model );

    return "member/my_info";
  }

  //수정화면
  @GetMapping("/info_update")
  public String updateInfo(HttpServletRequest request, Model model)  {

    HttpSession session = request.getSession();
    LoginMember loginInfo = (LoginMember)session.getAttribute(LoginOkConst.LOGIN_MEMBER);

    model.addAttribute("form", loginInfo);
    log.info("2222 request check ={}", loginInfo.getName() );

//    /* Object 로 생성되는 getAttribute 를 각각 받아서 EditForm 객체에 담을 수 있는지 */
//    List<String> list = new ArrayList<>();
//
//    list = (ArrayList)session.getAttribute(LoginOkConst.LOGIN_MEMBER);
//
//
//
//    log.info("me = {}", list);


    return "member/my_info_update"; //회원 수정화면
  }
  @PostMapping("/info_update")
  public String updateInfoPost(@Valid HttpServletRequest request, Model model){

    HttpSession session = request.getSession();
    Object LoginInfo = session.getAttribute(LoginOkConst.LOGIN_MEMBER);

    EditForm editForm = new EditForm();





    return "redirect:/info";
  }


}
