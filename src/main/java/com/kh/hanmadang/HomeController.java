package com.kh.hanmadang;

import com.kh.hanmadang.domain.dao.member.Member;
import com.kh.hanmadang.domain.svc.member.MemberSVC;
import com.kh.hanmadang.web.member.AddForm;
import com.kh.hanmadang.web.member.LoginForm;
import com.kh.hanmadang.web.session.LoginMember;
import com.kh.hanmadang.web.session.LoginOkConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

  final MemberSVC memberSVC;

  @GetMapping
  private String home() {
    //세션이 존재하면 로그인 후 화면 이동
    //세션이 없으면 로그인 전 화면 이동
    return "member/beforeLogin";
  }

  // 회원가입 GET
  @GetMapping("/sign_in")
  public String add(Model model){

    model.addAttribute("form", new AddForm());

    return "member/sign_in";
  }
  // 회원가입 처리 POST
  @PostMapping("/sign_in")
  public String add(
          @Valid @ModelAttribute("form") AddForm addForm,
          BindingResult bindingResult,
          RedirectAttributes redirectAttributes // 리다이렉트할때 정보를 유지하기위해사용
  ){
    //model.addAttribute("addForm",addForm);
    log.info("addForm={}",addForm);

    //검증
    if(bindingResult.hasErrors()){
      log.info("errors={}",bindingResult);
      return "member/sign_in";
    }
//    //회원아이디 중복체크
//    Boolean isExist = memberSVC.dupChkOfMemberEmail(addForm.getEmail());
//    if(isExist){
//      bindingResult.rejectValue("email","dup.email", "동일한 이메일이 존재합니다.");
//      return "admin/member/addForm";
//    }
    //회원등록 아이디 이름 닉네임 폰 비밀번호 생년월일
    Member member = new Member();
    member.setEmail(addForm.getEmail());
    member.setName(addForm.getName());
    member.setNickname(addForm.getNickname());
    member.setPhone(addForm.getPhone());
    member.setPassword(addForm.getPassword());
    member.setBirthday(addForm.getBirthday());
    Member insertedMember = memberSVC.insert(member);

    log.info("new Member = {}", member);

    Long id = insertedMember.getId();
    redirectAttributes.addAttribute("id",id);

    return "redirect:/afterLogin/{id}"; //회원 상세
  }



  //로그인 화면
  @GetMapping("/login")
  public String loginForm(@ModelAttribute("form") LoginForm loginForm){

    return "member/login";
  }

  //로그인 처리
  @PostMapping("/login")
  public String login(@Valid @ModelAttribute("form") LoginForm loginForm,
                      BindingResult bindingResult,
                      HttpServletRequest request,
                      @RequestParam(value = "requestURI",required = false,defaultValue = "/") String requestURI){

    //기본 검증
    if (bindingResult.hasErrors()) {
      log.info("bindingResult={}",bindingResult);
      return "member/login";
    }

    //회원유무
    Optional<Member> member = memberSVC.login(loginForm.getEmail(), loginForm.getPassword());
    log.info("member={}", member);
    if(member.isEmpty()){
      bindingResult.reject("LoginForm.login","회원정보가 없습니다.");
      return "member/login";
    }

    //회원인경우
    Member findedMember = member.get();

    //세션에 회원정보 저장
    LoginMember loginMember = new LoginMember( findedMember.getEmail(),findedMember.getPassword(), findedMember.getName(),
            findedMember.getNickname(), findedMember.getPhone(), findedMember.getBirthday(), findedMember.getSms_service(),
            findedMember.getEmail_service(), findedMember.getCdate(),findedMember.getUdate());

    //request.getSession(true) : 세션정보가 있으면 가져오고 없으면 세션을 많듬
    HttpSession session = request.getSession(true);
    session.setAttribute(LoginOkConst.LOGIN_MEMBER, loginMember);

    if(requestURI.equals("/")){log.info("로그인 eqqqq");
      return "member/afterLogin";
    }
    log.info("로그인 info : {}",requestURI);
    return "redirect:"+requestURI;
  }

  // 로그인 후 화면
  @GetMapping("/afterLogin")
  public String after() {
    return "member/afterLogin";
  }


  //로그아웃
  @GetMapping("/logout")
  public String logout(HttpServletRequest request){
    //request.getSession(false) : 세션정보가 있으면 가져오고 없으면 세션을 만들지 않음
    HttpSession session = request.getSession(false);
    if (session != null) {
      session.invalidate();
    }
    return "redirect:/"; //초기화면 이동
  }
}