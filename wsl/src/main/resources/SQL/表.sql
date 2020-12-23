use Gameshop;
drop table if exists 游戏;
drop table if exists 用户;
drop table if exists 管理员;
drop table if exists 生产商;
drop table if exists 订单;
drop table if exists 购物车;
drop table if exists 评论;
drop table if exists 公告;
drop table if exists 购物车游戏;

CREATE TABLE IF NOT EXISTS `游戏` (
  id int(11) NOT NULL AUTO_INCREMENT,
  名称 varchar(20) DEFAULT NULL,
  类型 varchar(20) DEFAULT NULL,
  生产商 varchar(20) DEFAULT NULL,
  价格 int(11) DEFAULT 0,
  游戏内容 varchar(20) DEFAULT NULL,
  管理员姓名 varchar(20) DEFAULT "admin",
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 ;


CREATE TABLE IF NOT EXISTS 用户(
    id int(11) NOT NULL AUTO_INCREMENT,
    用户名 VARCHAR(20),
    姓名 varchar(20),
    密码 int(11),
    地区 varchar(20) default "南京",
    电话 varchar(20) default "13306",
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS 管理员(
    id int(11) NOT NULL AUTO_INCREMENT,
    用户名 VARCHAR(20),
    密码 int(11),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS 生产商(
    id int(11) NOT NULL AUTO_INCREMENT,
    用户名 VARCHAR(20),
    密码 int(11),
    生产商地区 varchar(20) default "南京",
    管理员用户名 varchar(20) default "admin",
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS 订单(
    id int(11) NOT NULL AUTO_INCREMENT,
    用户 varchar(20),
    游戏编号 int(20),
    时间 varchar(200),
    状态 varchar(20) DEFAULT NULL,
    管理员用户名 varchar(20) default "admin",
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS 购物车(
    id int(11) NOT NULL AUTO_INCREMENT,
    用户 varchar(20),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS 评论(
    id int(11) NOT NULL AUTO_INCREMENT,
    游戏名称 varchar(20),
    用户名 varchar(20),
    内容 varchar(20),
    管理员用户名 varchar(20) default "admin",
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS 公告(
    id int(11) NOT NULL AUTO_INCREMENT,
    标题 VARCHAR(20) DEFAULT "",
    发布时间 TIMESTAMP default CURRENT_TIMESTAMP,
    内容 varchar(20),
    管理员用户名 varchar(20) default "admin",
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS 购物车游戏(
    id int(11) NOT NULL AUTO_INCREMENT,
    购物车编号 int(11) ,
    游戏编号 int(11),
    PRIMARY KEY (id)
);