package com.kh.hanmadang.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//    String requestURI = request.getRequestURI();
//    log.info("인증체크={}",requestURI);
//
//    //세션정보 있으면 가져오고 없으면 세션 생성하지 않음.
//    HttpSession session = request.getSession(false);
//
//    if (session == null || session.getAttribute(LoginOkConst.LOGIN_MEMBER) == null) {
//      log.info("미인증 사용자 요청");
//      // 로그인 화면으로 redirect. 리다이렉트 할때 요청 URI를 담아서 보내줘야함
//      response.sendRedirect("/login?requestURI="+requestURI);
//      return false;
//    }

    return true;
  }
}
