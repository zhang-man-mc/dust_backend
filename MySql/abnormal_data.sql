/*
Navicat MySQL Data Transfer

Source Server         : lcoal
Source Server Version : 80033
Source Host           : localhost:3306
Source Database       : qianduan_sql

Target Server Type    : MYSQL
Target Server Version : 80033
File Encoding         : 65001

Date: 2023-07-11 11:41:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for abnormal_data
-- ----------------------------
DROP TABLE IF EXISTS `abnormal_data`;
CREATE TABLE `abnormal_data` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '序号',
  `dev_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '设备编号',
  `exception` varchar(20) NOT NULL,
  `exception_type` varchar(20) NOT NULL COMMENT '异常类型',
  `region` varchar(20) DEFAULT NULL COMMENT '地区',
  `begin_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime NOT NULL COMMENT '结束',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=625 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
