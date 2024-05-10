/*
Navicat MySQL Data Transfer

Source Server         : lcoal
Source Server Version : 80033
Source Host           : localhost:3306
Source Database       : qianduan_sql

Target Server Type    : MYSQL
Target Server Version : 80033
File Encoding         : 65001

Date: 2023-07-11 11:42:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for exceeding_st_data
-- ----------------------------
DROP TABLE IF EXISTS `exceeding_st_data`;
CREATE TABLE `exceeding_st_data` (
  `MV_ID` int NOT NULL AUTO_INCREMENT,
  `MV_Stat_Code` varchar(50) DEFAULT NULL COMMENT '设备编号',
  `MV_Create_Time` datetime DEFAULT NULL COMMENT '上报时间',
  `MV_Data_Time` datetime DEFAULT NULL COMMENT '归属时间',
  `MV_Power_On_Time` datetime DEFAULT NULL COMMENT '开机时间',
  `MV_Recent_Down_Time` datetime DEFAULT NULL COMMENT '最近关机时间',
  `MV_signal` double(6,0) DEFAULT NULL,
  `MV_Fan_Status` bit(1) DEFAULT NULL COMMENT '风机开关状态',
  `MV_Purifier_Status` bit(1) DEFAULT NULL COMMENT '净化器开关状态',
  `MV_Fan_Electricity` double(8,2) DEFAULT NULL COMMENT '风机电流',
  `MV_Purifier_Electricity` double(8,2) DEFAULT NULL COMMENT '净化器电流',
  `MV_Fume_Concentration` double(8,2) DEFAULT NULL COMMENT '进油烟浓度值',
  `MV_Fume_Concentration2` double(8,2) DEFAULT NULL COMMENT '排油烟浓度值（后）',
  `MV_PM` double(8,2) DEFAULT NULL COMMENT '颗粒物（气溶胶）',
  `MV_NMHC` double(8,2) DEFAULT NULL COMMENT '非甲烷总烃',
  `MV_Upload` bit(1) DEFAULT NULL COMMENT '是否上传',
  PRIMARY KEY (`MV_ID`),
  KEY `MV_Stat_Code` (`MV_Stat_Code`)
) ENGINE=InnoDB AUTO_INCREMENT=1052 DEFAULT CHARSET=utf8mb3;
