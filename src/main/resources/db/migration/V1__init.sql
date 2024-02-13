-- Aggregate Root
create table root comment 'Aggregate Root 테이블'
(
    id                  bigint auto_increment primary key comment 'ID',
    token               varchar(255) not null comment 'token',
    root_field_one    varchar(255) not null comment 'ROOT 필드 1',
    root_field_two    varchar(255) not null comment 'ROOT 필드 2',
    root_field_three  bigint not null comment 'ROOT 필드 3',
    status              varchar(30) not null default 'ENABLE' comment '상태코드',
    created_at          datetime(6) not null comment '생성 일시',
    updated_at          datetime(6) null comment '수정 일시'
);
create index root_idx01 on root (token);


-- Aggregate Sub
create table sub comment 'Aggregate Sub 테이블'
(
    id                  bigint auto_increment primary key comment 'ID',
    token               varchar(255) not null comment 'token',
    root_id             bigint not null comment 'Root 테이블 FK',
    sub_field_One       varchar(255) not null comment 'SUB 필드 1',
    sub_field_two       varchar(255) not null comment 'SUB 필드 2',
    sub_field_three     bigint not null comment 'SUB 필드 3',
    status              varchar(30) not null default 'ENABLE' comment '상태코드',
    created_at          datetime(6) not null comment '생성 일시',
    updated_at          datetime(6) null comment '수정 일시'
);
create index sub_idx01 on sub (token);