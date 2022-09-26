package com.kh.hanmadang.domain.svc.member;

import com.kh.hanmadang.domain.dao.member.Member;
import com.kh.hanmadang.domain.dao.member.MemberDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberSVCImpl implements MemberSVC{
  private final MemberDAO memberDAO;

  /**
   * 가입
   *
   * @param member 가입정보
   * @return 회원아이디
   */
  @Override
  public Member insert(Member member) {
    //회원 아이디 생성
    Long generateId = memberDAO.generateId();
    member.setId(generateId);
    memberDAO.insert(member);
    return memberDAO.findById(generateId);
  }

  /**
   * 조회 by 회원아이디
   *
   * @param id 회원아이디
   * @return 회원정보
   */
  @Override
  public Member findById(Long id) {
    return memberDAO.findById(id);
  }

  /**
   * 수정
   *
   * @param id 아이디
   * @param member   수정할 정보
   * @return 수정건수
   */
  @Override
  public int update(Long id, Member member) {
    int cnt = memberDAO.update(id, member);
    log.info("수정건수={}",cnt);
    return cnt;
  }

  /**
   * 탈퇴
   *
   * @param id 아이디
   * @param password 비밀번호
   * @return 삭제건수
   */
  @Override
  public int del(Long id, String password) {
    int cnt = memberDAO.del(id, password);
    log.info("삭제건수={}", cnt);
    return cnt;
  }

  /**
   * 이메일 중복체크
   *
   * @param email 이메일
   * @return 존재하면 true
   */
  @Override
  public Boolean dupChkOfMemberEmail(String email) {

    return memberDAO.dupChkOfMemberEmail(email);
  }

  /**
   * 닉네임 중복체크
   *
   * @param nickname 닉네임
   * @return 존재하면 true
   */
  @Override
  public Boolean dupChkOfMemberNickname(String nickname) {
    return memberDAO.dupChkOfMemberNickname(nickname);
  }

  /**
   * 로그인
   *
   * @param email    이메일
   * @param password 비밀번호
   * @return 회원
   */
  @Override
  public Optional<Member> login(String email, String password) {
    return  memberDAO.login(email, password);
  }
}
