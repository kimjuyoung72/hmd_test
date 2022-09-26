--drop table review;
--후기

drop table review;

create table review(
    review_from_id      varchar2(12),       --관련 공연 ID
    review_post_id      number(10),       --글번호 ID, pk
    review_post_title   varchar2(100),      --제목
    review_post_link    varchar2(100),      --홍보이미지 링크
    review_post_content clob,               --내용
    rview_post_writer   varchar2(20),       --작성자
    cdate               timestamp default systimestamp, --등록일시
    udate               timestamp default systimestamp, --수정일시
    review_post_good      number(10)          --좋아요 -_-)b
);
--기본키
alter table review add constraint review_post_id_pk primary key(review_post_id);

create sequence review_review_post_id_seq;