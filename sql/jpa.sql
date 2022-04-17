/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.29 : Database - jpa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jpa` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `jpa`;

/*Table structure for table `award_info` */

DROP TABLE IF EXISTS `award_info`;

CREATE TABLE `award_info` (
  `aid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `race_id` int(10) unsigned DEFAULT NULL COMMENT '比赛id',
  `team_id` int(10) unsigned DEFAULT NULL COMMENT '队伍id',
  `first_teacherid` int(10) unsigned DEFAULT NULL COMMENT '第一指导老师id',
  `certificate_level` varchar(255) DEFAULT NULL COMMENT '证书等级',
  `certificate_number` varchar(255) DEFAULT NULL COMMENT '证书编号',
  `certificate_picture` varchar(255) DEFAULT NULL COMMENT '证书照片',
  `activity_picture` varchar(255) DEFAULT NULL COMMENT '现场照片',
  `if_award` int(10) unsigned DEFAULT NULL COMMENT '是否获奖，0否1是',
  `if_approve` int(10) unsigned DEFAULT NULL COMMENT '获奖情况是否被管理员批准，0否1是',
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='获奖情况表';

/*Data for the table `award_info` */

insert  into `award_info`(`aid`,`race_id`,`team_id`,`first_teacherid`,`certificate_level`,`certificate_number`,`certificate_picture`,`activity_picture`,`if_award`,`if_approve`) values (10,3,3,2,'国家级','56789','activity_bisai2.png','activity_bisai1.png',1,0),(12,2,1,2,'校级','1231435343','activity_bisai2.png','activity_bisai1.png',1,0),(14,7,13,6,'校级','12312','activity_bisai1.png','activity_bisai1.png',1,1);

/*Table structure for table `final_finance` */

DROP TABLE IF EXISTS `final_finance`;

CREATE TABLE `final_finance` (
  `fid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `pre_id` int(10) unsigned DEFAULT NULL COMMENT '预算数据Id',
  `team_id` int(10) unsigned DEFAULT NULL COMMENT '队伍id',
  `race_id` int(10) unsigned DEFAULT NULL COMMENT '比赛id',
  `payment_fee` decimal(10,2) unsigned DEFAULT NULL COMMENT '报名费',
  `car_fee` decimal(10,2) unsigned DEFAULT NULL COMMENT '差旅费',
  `room_fee` decimal(10,2) unsigned DEFAULT NULL COMMENT '住宿费',
  `total_fee` decimal(10,2) unsigned DEFAULT NULL COMMENT '合计费用',
  PRIMARY KEY (`fid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='最终费用';

/*Data for the table `final_finance` */

insert  into `final_finance`(`fid`,`pre_id`,`team_id`,`race_id`,`payment_fee`,`car_fee`,`room_fee`,`total_fee`) values (1,1,1,1,'800.00','20.00','200.00','1020.00'),(7,6,13,9,'1000.00','10.00','600.00','1610.00'),(8,6,13,9,'1000.00','10.00','500.00','1510.00'),(9,7,16,10,'1500.00','200.00','600.00','2300.00');

/*Table structure for table `predict_finance` */

DROP TABLE IF EXISTS `predict_finance`;

CREATE TABLE `predict_finance` (
  `preid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `team_id` int(10) unsigned DEFAULT NULL COMMENT '队伍id',
  `race_id` int(255) unsigned DEFAULT NULL COMMENT '比赛id',
  `payment_price` decimal(10,2) unsigned DEFAULT NULL COMMENT '报名费',
  `car_price` decimal(10,2) unsigned DEFAULT NULL COMMENT '差旅费',
  `room_price` decimal(10,2) unsigned DEFAULT NULL COMMENT '住宿费',
  `total_price` decimal(10,2) unsigned DEFAULT NULL COMMENT '合计费用',
  PRIMARY KEY (`preid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='预计费用';

/*Data for the table `predict_finance` */

insert  into `predict_finance`(`preid`,`team_id`,`race_id`,`payment_price`,`car_price`,`room_price`,`total_price`) values (1,1,1,'800.00','50.00','200.00','1050.00'),(4,4,6,'500.00','55.00','55.00',NULL),(5,8,6,'1000.00','200.00','500.00','1700.00'),(6,8,9,'1000.00','20.00','0.00','1020.00'),(7,16,10,'1500.00','100.00','600.00','2200.00');

/*Table structure for table `race_info` */

DROP TABLE IF EXISTS `race_info`;

CREATE TABLE `race_info` (
  `rid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `race_name` varchar(255) DEFAULT NULL COMMENT '比赛名称',
  `race_level` int(10) unsigned DEFAULT NULL COMMENT '比赛级别',
  `race_master` varchar(255) DEFAULT NULL COMMENT '主办方',
  `begin_time` timestamp(6) NULL DEFAULT NULL COMMENT '报名开始时间戳',
  `end_time` timestamp(6) NULL DEFAULT NULL COMMENT '报名截止时间戳',
  `race_begintime` timestamp(6) NULL DEFAULT NULL COMMENT '比赛开始时间戳',
  `race_endtime` timestamp(6) NULL DEFAULT NULL COMMENT '比赛结束时间戳',
  `race_location` varchar(255) DEFAULT NULL COMMENT '比赛地点',
  `race_info` text COMMENT '比赛信息',
  `race_file` varchar(255) DEFAULT NULL COMMENT '比赛文件',
  `update_id` int(10) unsigned DEFAULT NULL COMMENT '发布人id',
  `update_time` timestamp(6) NULL DEFAULT NULL COMMENT '最后发布时间',
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='比赛信息表';

/*Data for the table `race_info` */

insert  into `race_info`(`rid`,`race_name`,`race_level`,`race_master`,`begin_time`,`end_time`,`race_begintime`,`race_endtime`,`race_location`,`race_info`,`race_file`,`update_id`,`update_time`) values (1,'机器人pa赛',2,'郑州大学','2020-05-21 00:00:00.000000','2020-05-25 00:00:00.000000','2020-06-07 00:00:00.000000','2020-06-08 00:00:00.000000','郑州大学新区','机器人足球比赛','www.zdg.com',1,NULL),(2,'软件设计大赛',1,'中原工学院','2020-04-02 12:39:04.000000','2020-04-05 12:39:10.000000','2020-04-21 12:39:16.000000','2020-04-22 12:39:22.000000','中原工学院西区','创业中心',NULL,1,'2020-04-21 18:01:14.000000'),(3,'蓝桥杯比赛',3,'北京交通大学','2020-04-18 18:07:30.000000','2020-04-18 18:07:34.000000','2020-04-18 18:07:39.000000','2020-04-18 18:07:43.000000','北京交通大学','北京交通大学创业中心','www.du.com',1,'2020-04-18 18:08:31.000000'),(5,'高压输电系统',1,'郑州大学','2020-05-02 06:37:30.000000','2020-05-02 06:37:34.000000','2020-05-02 06:37:39.000000','2020-05-02 06:37:45.000000','','',NULL,1,'2020-04-21 18:11:49.000000'),(6,'化工实验技能大赛',2,'浙江工业大学','2020-05-21 00:00:00.000000','2020-05-25 00:00:00.000000','2020-06-07 00:00:00.000000','2020-06-08 00:00:00.000000','浙江工业大学新区','浙江工业大学新区',NULL,1,'2020-04-30 17:02:45.000000'),(7,'java设计',2,'郑大','2020-12-10 00:00:00.000000','2020-12-15 00:00:00.000000','2021-02-10 00:00:00.000000','2021-02-12 00:00:00.000000','东区','11231232',NULL,1,'2020-05-02 06:39:37.000000'),(9,'农业生产',3,'河南农业大学','2020-03-23 00:00:00.000000','2020-03-25 00:00:00.000000','2020-04-23 00:00:00.000000','2020-04-24 00:00:00.000000','河南省青少年宫','河南省青少年宫，自带电脑',NULL,1,'2020-05-05 17:26:28.000000'),(10,'工业设计',3,'郑州大学','2020-11-12 00:00:00.000000','2020-11-15 00:00:00.000000','2020-12-12 00:00:00.000000','2020-12-14 00:00:00.000000','中原路146','中原路146',NULL,1,'2020-05-11 22:10:27.000000'),(11,'fdfaf',1,'dsadada','2020-07-03 00:00:00.000000','2020-07-02 00:00:00.000000','2020-07-24 00:00:00.000000','2020-07-16 00:00:00.000000','fsdfsfas','fafasfsa',NULL,1,'2020-07-11 22:15:45.000000');

/*Table structure for table `student_info` */

DROP TABLE IF EXISTS `student_info`;

CREATE TABLE `student_info` (
  `sid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `student_name` varchar(255) DEFAULT NULL COMMENT '学生姓名',
  `student_sex` varchar(10) DEFAULT NULL COMMENT '学生性别',
  `student_class` varchar(255) DEFAULT NULL COMMENT '学生班级',
  `student_number` char(14) DEFAULT NULL COMMENT '学生学号',
  `student_mobile` char(11) DEFAULT NULL COMMENT '学生手机号',
  `student_wechar` varchar(255) DEFAULT NULL COMMENT '学生微信号',
  `student_status` int(1) DEFAULT NULL COMMENT '1是启用，是/否',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='学生信息表';

/*Data for the table `student_info` */

insert  into `student_info`(`sid`,`student_name`,`student_sex`,`student_class`,`student_number`,`student_mobile`,`student_wechar`,`student_status`) values (1,'明仔','女','卓越171','2111801028','13536362850','13536362850wx',0),(3,'时云凤1','女','卓越162','201607104221','13939263878','13939263878wx',1),(5,'时云凤3','女','卓越162','201607104223','13939263878','13939263878wx',0),(7,'时云凤5','女','卓越162','201607104225','13939263878','13939263878wx',0),(9,'时云凤7','女','卓越162','201607104227','13939263878','13939263878wx',0),(10,'张一鸣8','男','卓越161','201607104225','13526263852','13526263852wx',0),(12,'张一鸣10','男','卓越161','201607104225','13526263852','13526263852wx',1),(13,'时云凤11','女','卓越162','2016071042211','13939263878','13939263878wx',0),(21,'时云凤19','女','卓越162','2016071042219','13939263878','13939263878wx',1),(22,'张一鸣20','男','卓越161','201607104225','13526263852','13526263852wx',0),(23,'时云凤21','女','卓越162','2016071042221','13939263878','13939263878wx',1),(24,'张一鸣22','男','卓越161','201607104225','13526263852','13526263852wx',0),(25,'时云凤23','女','卓越162','2016071042223','13939263878','13939263878wx',1);

/*Table structure for table `teacher_info` */

DROP TABLE IF EXISTS `teacher_info`;

CREATE TABLE `teacher_info` (
  `tid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `teacher_name` varchar(255) DEFAULT NULL COMMENT '教师姓名',
  `teacher_sex` varchar(255) DEFAULT NULL COMMENT '教师性别',
  `teacher_profession` varchar(255) DEFAULT NULL COMMENT '教师职称',
  `teacher_number` int(10) unsigned DEFAULT NULL COMMENT '教师工号/登录账号',
  `teacher_password` varchar(255) DEFAULT NULL COMMENT '教师密码',
  `teacher_mobile` char(11) DEFAULT NULL COMMENT '教师手机号',
  `teacher_work` decimal(10,2) unsigned DEFAULT NULL COMMENT '教师工作量',
  `teacher_status` tinyint(3) DEFAULT NULL COMMENT '管理员否，1是/0否',
  `login_time` timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '最后登录时间',
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `teacher_info` */

insert  into `teacher_info`(`tid`,`teacher_name`,`teacher_sex`,`teacher_profession`,`teacher_number`,`teacher_password`,`teacher_mobile`,`teacher_work`,`teacher_status`,`login_time`) values (1,'郭丽','女','讲师',1,'1','135257855','3.10',1,'2020-05-02 08:56:20.899787'),(2,'余雨萍','男','副教授',123456,'000','13526263850','3.00',0,'2020-04-21 09:36:58.647047'),(3,'党明明','女','辅导员',2111801028,'dmm258367','13526263850','0.00',1,'2020-04-22 17:43:16.703930'),(4,'tomsen','男','校长',112,'123456','13536362851','0.00',1,'2020-04-22 17:43:48.514209'),(6,'王文浩','男','教授',114,'114','13536362853','0.00',0,'2020-05-11 22:17:28.000000'),(7,'小铭','男','副教授',115,'115','13536362854','0.00',0,'2020-05-11 22:23:44.000000'),(8,'小张5号','男','教授',116,'123456','13536362855','0.00',0,'2020-04-22 17:43:58.859563'),(9,'小红6号','女','副教授',117,'123456','13536362856','0.00',0,'2020-04-22 17:44:01.754577'),(10,'小张7号','男','教授',118,'123456','13536362850','0.00',0,'2020-04-21 09:37:06.775020'),(12,'小张9号','男','教授',120,'123456','13536362850','0.00',0,'2020-04-21 09:37:09.860326'),(13,'小红10号','女','副教授',121,'123456','13536362850','0.00',0,'2020-04-21 09:37:10.790529'),(14,'小张11号','男','教授',122,'123456','13536362850','0.00',0,'2020-04-21 09:37:11.542903'),(15,'小红12号','女','副教授',123,'123456','13536362850','0.00',0,'2020-04-21 09:37:12.343627'),(16,'小张13号','男','教授',124,'123456','13536362850','0.00',0,'2020-04-21 09:37:13.265582'),(19,'小红16号','女','副教授',127,'123456','13536362850','0.00',0,'2020-04-21 09:37:14.968066'),(20,'小张17号','男','教授',128,'123456','13536362850','0.00',0,'2020-04-21 09:37:16.877587'),(21,'小红18号','女','副教授',129,'123456','13536362850','0.00',0,'2020-04-21 09:37:17.758579'),(22,'小张19号','男','教授',130,'123456','13536362850','0.00',0,'2020-04-21 09:37:18.627912'),(23,'小张1号','男','教授',131,'123456','13536362850','0.00',0,'2020-04-21 09:37:19.574819'),(24,'小红2号','女','副教授',132,'123456','13536362850','0.00',0,'2020-04-21 09:37:23.622291'),(25,'张三','女','教师',111111,'000000',NULL,'0.00',0,'2020-04-22 23:06:01.000000');

/*Table structure for table `team_info` */

DROP TABLE IF EXISTS `team_info`;

CREATE TABLE `team_info` (
  `temid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `team_name` varchar(255) DEFAULT NULL COMMENT '队伍名称',
  `race_id` int(10) unsigned DEFAULT NULL COMMENT '比赛id',
  `student_id` varchar(255) DEFAULT NULL COMMENT '学生id',
  `production_name` varchar(255) DEFAULT NULL COMMENT '作品名称',
  `production_info` text COMMENT '作品简介',
  `teacher_id` int(10) DEFAULT NULL COMMENT '指导教师id',
  `team_status` int(10) DEFAULT '0' COMMENT '是否参赛',
  `update_id` int(10) unsigned DEFAULT NULL COMMENT '更新人id',
  `update_time` timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '最后更新时间',
  PRIMARY KEY (`temid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `team_info` */

insert  into `team_info`(`temid`,`team_name`,`race_id`,`student_id`,`production_name`,`production_info`,`teacher_id`,`team_status`,`update_id`,`update_time`) values (1,'中工机器人小组',1,'1','机器人足球赛','微软机器人比赛',1,0,NULL,'2020-04-15 15:15:45.315976'),(3,'蓝桥杯最强小组',3,'3','蓝桥杯软件设计大赛','蓝桥杯软件设计大赛',1,0,11,'2020-04-18 18:06:44.409765'),(13,'农合第一组',9,'5','水稻杂交','但是复试',6,1,6,'2020-05-05 17:36:23.000000'),(15,'园艺设计组',9,'3','园艺设计','色染发',6,1,6,'2020-05-11 21:48:59.000000'),(16,'工业设计第一组',10,'1','工业机器人','将阿斯顿开发哈即可',6,1,6,'2020-05-11 22:14:16.000000');

/*Table structure for table `work_info` */

DROP TABLE IF EXISTS `work_info`;

CREATE TABLE `work_info` (
  `wid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键wid',
  `total_work` varchar(255) DEFAULT NULL COMMENT '总工作量',
  `teacher_id` int(10) unsigned DEFAULT NULL COMMENT '教师id',
  `race_id` int(10) unsigned DEFAULT NULL COMMENT '比赛id',
  `team_id` int(10) unsigned DEFAULT NULL COMMENT '团队id',
  `status` int(10) unsigned DEFAULT NULL COMMENT '状态',
  `last_time` timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '最后登录时间',
  PRIMARY KEY (`wid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `work_info` */

insert  into `work_info`(`wid`,`total_work`,`teacher_id`,`race_id`,`team_id`,`status`,`last_time`) values (3,'11',1,3,4,1,'2020-05-02 08:18:47.957461'),(26,NULL,3,1,2,0,'2020-05-02 22:08:09.000000'),(27,NULL,3,2,5,NULL,'2020-05-02 22:10:01.135632'),(28,NULL,6,7,1,0,'2020-05-04 06:23:24.000000'),(30,NULL,6,9,13,0,'2020-05-05 17:36:23.000000'),(31,NULL,6,9,14,0,'2020-05-11 21:47:50.000000'),(32,NULL,6,9,15,0,'2020-05-11 21:48:59.000000'),(33,NULL,6,10,16,0,'2020-05-11 22:14:16.000000');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
