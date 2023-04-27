create table userData
(
    ID           int(100) PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    userName     varchar(20) UNIQUE COMMENT '用户名',
    password     varchar(20) COMMENT '密码',
    role         ENUM ('admin','user') COMMENT '权限',
    emailAddress varchar(254) COMMENT '邮箱',
    headPortrait TEXT(21845) COMMENT '头像URL',
    creatTime    datetime           DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updateTime   timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;