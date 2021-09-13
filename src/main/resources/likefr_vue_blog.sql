/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.22 : Database - likefr_vue_blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`likefr_vue_blog` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `likefr_vue_blog`;

/*Table structure for table `t_article` */

DROP TABLE IF EXISTS `t_article`;

CREATE TABLE `t_article` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `author` int DEFAULT NULL COMMENT '文章作者',
  `title` varchar(255) NOT NULL COMMENT '文章标题',
  `content` mediumtext COMMENT '文章内容',
  `classify` varchar(50) DEFAULT NULL COMMENT '文章分类',
  `password` varchar(30) DEFAULT NULL COMMENT '文章密码',
  `status` char(1) DEFAULT NULL COMMENT '文章状态',
  `create_date` datetime DEFAULT NULL COMMENT '文章创建时间',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_article` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(30) NOT NULL COMMENT '用户账号',
  `nickname` varchar(30) NOT NULL COMMENT '用户昵称',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `email` varchar(50) DEFAULT NULL COMMENT '用户邮箱',
  `telephone` varchar(20) DEFAULT NULL COMMENT '用户手机',
  `sex` char(1) DEFAULT NULL COMMENT '用户性别 0男1女2未知',
  `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `enable_flag` char(1) DEFAULT NULL COMMENT '账户状态 0正常 1停用',
  `del_flag` char(1) DEFAULT NULL COMMENT '销号状态 0正常 1销号',
  `random_salt` varchar(100) DEFAULT NULL COMMENT '随机盐',
  `create_date` datetime DEFAULT NULL COMMENT '用户创建时间',
  `last_login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后修改时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_user` */

insert  into `t_user`(`user_id`,`username`,`nickname`,`password`,`email`,`telephone`,`sex`,`avatar`,`enable_flag`,`del_flag`,`random_salt`,`create_date`,`last_login_date`,`last_update_date`,`remark`) values 
(1,'admin','admin','123456','1111@163.com','13100001111','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2,'wangfz','wangfz','111111',NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(3,'wangfr','wangfr','112233',NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
