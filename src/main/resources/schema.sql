create table if not exists sys_user
(
    id                 bigint auto_increment primary key,
    username           varchar(20),
    password           varchar(255),
    created_time       timestamp,
    last_modified_time timestamp
);