--drop table promotion;
--홍보

create table promotion(
    promotion_post_id       number(10),       --글번호 ID
    promotion_post_title    varchar2(100),      --제목
    promotion_post_link     varchar2(100),      --홍보이미지 링크
    promotion_post_content  clob,               --내용
    promotion_post_writer   varchar2(20),       --작성자
    promotion_start_date    varchar2(10),       --시작일
    promotion_end_date      varchar2(10),       --마감일
    promotion_ent_fee       varchar2(10),       --비용
    cdate                   timestamp default systimestamp, --등록일시
    udate                   timestamp default systimestamp, --수정일시
    promotion_post_good      number(10)          --좋아요 -_-)b
);
--기본키
alter table promotion add constraint promotion_promotion_post_id_pk primary key(promotion_post_id);

create sequence promotion_promotion_post_id_seq;