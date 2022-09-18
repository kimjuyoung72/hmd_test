package com.kh.hanmadang.domain.svc.admin;

import com.kh.hanmadang.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminMemberSVCImpl implements AdminMemberSVC{
  @Override
  public Member insert(Member member) {
    return null;
  }

  @Override
  public int update(Long memberId, Member member) {
    return 0;
  }

  @Override
  public Member findById(Long memberId) {
    return null;
  }

  @Override
  public int del(Long memberId, String pw) {
    return 0;
  }

  @Override
  public List<Member> all() {
    return null;
  }
}
