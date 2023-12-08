create database if not exists big_event;
use big_event;

# user -> id username password nickname email user_pic create_time update_time
create table if not exists user
(
    id          int unsigned primary key auto_increment comment 'ID',
    username    varchar(20) not null unique comment '用户名',
    password    varchar(128) comment '密码',
    nickname    varchar(20)  default '' comment '昵称',
    email       varchar(30)  default '' comment '邮箱',
    user_pic    varchar(128) default '' comment '头像',
    create_time datetime    not null comment '创建时间',
    update_time datetime    not null comment '修改时间'
) comment '用户表';

# category -> id category_name category_alias create_user create_time update_time
create table if not exists category
(
    id              int unsigned primary key auto_increment comment 'ID',
    category_name   varchar(32) not null comment '分类名称',
    category_alias  varchar(32) default '' comment '分类别名',
    create_username varchar(20) not null comment '创建人用户名',
    create_time     datetime    not null comment '创建时间',
    update_time     datetime    not null comment '修改时间'
) comment '分类表';


# article -> id title content cover_img state category_id create_user create_time update_time
create table if not exists article
(
    id              int unsigned primary key auto_increment comment 'ID',
    title           varchar(32) not null comment '文章标题',
    content         varchar(10000) default '' comment '文章正文',
    cover_img       varchar(128)   default '' comment '文章封面',
    state           varchar(20) not null comment '文章状态',
    category_name   varchar(32) not null comment '分类名',
    create_username varchar(20) not null comment '创建人用户名',
    create_time     datetime    not null comment '创建时间',
    update_time     datetime    not null comment '修改时间'
) comment '文章表';
