drop table member;

create table member (
  id 			number(8), --기본키
  email 		varchar(30),  --(이메일이 아이디)
  password 		varchar2(20), -- nn
  name 			varchar2 (10), -- 유니크 nn
  nickname 		varchar2 (20), -- 유니크 nn
  phone 		varchar2 (12), -- 유니크 nn
  birthday 		date, -- nn
  sms_service 	number(1),
  email_service number(1),
  cdate       	timestamp default systimestamp,
  udate       	timestamp default systimestamp
);
-- 회원가입시 사용자가 입력해야할 요소
-- 1. 아이디(이메일) 2. 패스워드 3. 닉네임 4.이름 5. 전화번호 6. 생일

alter table member add constraint member_id_pk primary key(id);

alter table member modify email constraint member_email_nn not null;
alter table member modify nickname constraint member_nickname_nn not null;
alter table member modify password constraint member_password_nn not null;
alter table member modify name constraint member_name_nn not null;
alter table member modify phone constraint member_phone_nn not null;
alter table member modify birthday constraint member_birthday_nn not null;

alter table member add constraint member_email_unique unique (email);
alter table member add constraint member_nickname_unique unique (nickname);


drop sequence member_id_seq;
create sequence member_id_seq;


desc member;

select * from member;

------------ End Create Table MEMBER Query ------------
insert into member values (member_id_seq.nextval, 'test1@test.com', '1234', '김일번', '퍼스트맨',
                            '01011110001','1991-11-11',  1, 1, systimestamp, systimestamp);

commit;
