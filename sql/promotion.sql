--drop table promotion;
--홍보

create table promotion(
    promotion_post_id       number(10),       --글번호 ID
    promotion_post_titel    varchar2(100),      --제목
    promotion_post_link     varchar2(100),      --홍보이미지 링크
    promotion_post_content  clob,               --내용
    promotion_post_writer   varchar2(20),       --작성자
    cdate                   timestamp default systimestamp, --등록일시
    udate                   timestamp default systimestamp, --수정일시
    promotion_postgood      number(10)          --좋아요 -_-)b
);
--기본키
alter table promotion add constraint promotion_promotion_post_id_pk primary key(promotion_post_id);

create sequence promotion_promotion_post_id_seq;