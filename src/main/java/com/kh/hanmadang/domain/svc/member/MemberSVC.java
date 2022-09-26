package com.kh.hanmadang.domain.svc.member;


import com.kh.hanmadang.domain.dao.member.Member;

import java.util.Optional;

public interface MemberSVC {
  /**
   * 가입
   * @param member 가입정보
   * @return 회원아이디
   */
  Member insert(Member member);

  /**
   * 조회 by 회원아이디
   * @param id 회원아이디
   * @return 회원정보
   */
  Member findById(Long id);

  /**
   * 수정
   * @param id 아이디
   * @param member  수정할 정보
   * @return 수정건수
   */
  int update(Long id, Member member);

  /**
   * 탈퇴
   * @param id 아이디
   * @param password 비밀번호
   * @return 삭제건수
   */
  int del(Long id, String password);

  /**
   * 이메일 중복체크
   * @param email 이메일
   * @return 존재하면 true
   */
  Boolean dupChkOfMemberEmail(String email);


  /**
   * 닉네임 중복체크
   * @param nickname 닉네임
   * @return 존재하면 true
   */
  Boolean dupChkOfMemberNickname(String nickname);

  /**
   * 로그인
   * @param email 이메일
   * @param password  비밀번호
   * @return  회원
   */
  Optional<Member> login(String email, String password);
}
