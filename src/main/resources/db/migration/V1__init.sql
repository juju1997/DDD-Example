-- PARENT
create table parent comment '부모 테이블'
(
    id                  bigint auto_increment primary key comment 'ID',
    token               varchar(255) not null comment 'token',
    parent_field_one    varchar(255) not null comment '부모 필드 1',
    parent_field_two    varchar(255) not null comment '부모 필드 2',
    parent_field_three  bigint not null comment '부모 필드 3',
    status              varchar(30) not null default 'ENABLE' comment '상태코드',
    created_at          datetime(6) not null comment '생성 일시',
    updated_at          datetime(6) null comment '수정 일시'
);
create index parent_idx01 on parent (token);


-- CHILD
create table child comment '자식 테이블'
(
    id                  bigint auto_increment primary key comment 'ID',
    token               varchar(255) not null comment 'token',
    parent_id           bigint not null comment '부모 테이블 FK',
    child_field_One     varchar(255) not null comment '자식 필드 1',
    child_field_two     varchar(255) not null comment '자식 필드 2',
    child_field_three   bigint not null comment '자식 필드 3',
    status              varchar(30) not null default 'ENABLE' comment '상태코드',
    created_at          datetime(6) not null comment '생성 일시',
    updated_at          datetime(6) null comment '수정 일시'
);
create index child_idx01 on child (token);