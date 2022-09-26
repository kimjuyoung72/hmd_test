package com.kh.hanmadang.domain.dao.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO{
  private final JdbcTemplate jt;

  /**
   * 가입
   *
   * @param member 가입정보
   * @return 가입건수
   */
  @Override
  public int insert(Member member) {
    int result = 0;
    StringBuffer sql = new StringBuffer();
    sql.append("insert into member ( id,email, password, name, nickname, phone, birthday, ");
    sql.append("                    sms_service, email_service) ");
    sql.append("values(?,?,?,?,?,?,?,?,?) ");

    result = jt.update(sql.toString(), member.getId(), member.getEmail(), member.getPassword(), member.getName(),
            member.getNickname(), member.getPhone(), member.getBirthday(), member.getSms_service(), member.getEmail_service());

    return result;
  }

  /**
   * 조회 by 회원아이디
   *
   * @param id 회원아이디
   * @return 회원정보
   */
  @Override
  public Member findById(Long id) {
    StringBuffer sql = new StringBuffer();

    sql.append("select id,email, password, name, nickname, phone, birthday,");
    sql.append("        sms_service, email_service, cdate, udate ");
    sql.append("  from member ");
    sql.append(" where id = ? ");

    Member findedMember = null;
    try {
      //BeanPropertyRowMapper는 매핑되는 자바클래스에 디폴트생성자 필수!
      findedMember = jt.queryForObject(sql.toString(), new BeanPropertyRowMapper<>(Member.class),id);
    } catch (DataAccessException e) {
      log.info("찾고자하는 회원이 없습니다!={}",id);
    }

    return findedMember;
  }

  /**
   * 수정
   * 수정 가능한 정보 : nickname, phone
   * @param id 아이디
   * @param member 수정할 정보
   * @return 수정건수
   */
  @Override
  public int update(Long id, Member member) {
    int result = 0;
    StringBuffer sql = new StringBuffer();
    sql.append("update member ");
    sql.append("   set nickname = ?, ");
    sql.append("       phone = ?, ");
    sql.append("       sms_service = ?, ");
    sql.append("       email_service = ?, ");
    sql.append("       udate = systimestamp ");
    sql.append(" where id = ? ");
    sql.append("   and password = ? ");

    result = jt.update(sql.toString(), member.getNickname(), member.getPhone(), member.getSms_service(),
            member.getEmail_service(), id, member.getPassword());
    return result;
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
    int result = 0;
    String sql = "delete from member where id = ? and password = ? ";

    result = jt.update(sql, id, password);
    return result;
  }

  /**
   * 신규 회원아이디(내부관리용) 생성
   *
   * @return 회원아이디
   */
  @Override
  public Long generateId() {
    String sql = "select member_id_seq.nextval from dual ";
    Long id = jt.queryForObject(sql, Long.class);
    return id;
  }


  /**
   * 이메일 중복체크
   *
   * @param email 이메일
   * @return 존재하면 true
   */
  @Override
  public Boolean dupChkOfMemberEmail(String email) {
    String sql = "select count(email) from member where email = ? ";
    Integer rowCount = jt.queryForObject(sql, Integer.class, email);
    return rowCount == 1 ? true : false;
  }

  /**
   * 닉네임 중복체크
   *
   * @param nickname 닉네임
   * @return 존재하면 true
   */

  @Override
  public Boolean dupChkOfMemberNickname(String nickname) {
    String sql = "select count(nickname) from member where nickname = ? ";
    Integer rowCount = jt.queryForObject(sql, Integer.class, nickname);
    return rowCount == 1 ? true : false;
  }

  /**
   * 로그인
   *
   * @param email 이메일
   * @param password 비밀번호
   * @return 회원
   */
  @Override
  public Optional<Member> login(String email, String password) {
    StringBuffer sql = new StringBuffer();
    sql.append("select * ");
    sql.append("  from member ");
    sql.append(" where email = ? ");
    sql.append("   and password = ? ");

    try {
      Member member = jt.queryForObject(
              sql.toString(),
              new BeanPropertyRowMapper<>(Member.class),
              email,password
      );
      return Optional.of(member);
    } catch (DataAccessException e) {
      return Optional.empty();
    }
  }
}