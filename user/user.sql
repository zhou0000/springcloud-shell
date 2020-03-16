create table user_info(
    id varchar(32) not null,
    username varchar(32) default '',
    password varchar(32) default '',
    open_id varchar(64) default '' comment '微信openId',
    role tinyint(1) not null comment '1：买家，2：卖家',
    create_time timestamp not null default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary  key  (id)
);

insert into user_info (id,open_id,role) values ('1111','abc',1);
insert into user_info (id,open_id,role) values ('222','123',2);

select * from user_info where open_id = 'abc';
