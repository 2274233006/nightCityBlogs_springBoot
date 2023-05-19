### article文章表

```mysql
create table article
(
	id int auto_increment
		primary key,
	isTop enum('true', 'false') default 'false' not null comment '置顶文章 true flase',
	isHot enum('true', 'false') default 'true' not null comment '热门文章 true false',
	banner text null comment '文章图片',
	pubTime timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '发布时间/修改时间',
	title varchar(255) not null comment '文章标题',
	summary varchar(255) not null comment '文章简介',
	viewsCount int default 1 null comment '观看人数',
	commentsCount int default 1 null comment '评论数',
	contents text not null comment '文章内容',
	classification varchar(255) not null comment '分类',
	isFocus enum('true', 'false') default 'false' not null comment '是否为焦点文章'
);
```

### classification分类信息

```mysql
create table classification
(
	id int(255) auto_increment
		primary key,
	creatTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
	updateTime timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
	classification varchar(255) null
);
```

### userData用户表

```mysql
create table userData
(
	ID int(100) auto_increment comment 'id'
		primary key,
	userName varchar(20) not null comment '用户名',
	password varchar(255) not null comment '密码',
	role enum('admin', 'user') default 'user' not null comment '权限',
	emailAddress varchar(254) null comment '邮箱',
	headPortrait text null comment '头像URL',
	creatTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
	updateTime timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
	address varchar(255) null comment '城市',
	constraint userName
		unique (userName)
);
```

