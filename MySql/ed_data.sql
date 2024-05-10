/*
Navicat MySQL Data Transfer

Source Server         : lcoal
Source Server Version : 80033
Source Host           : localhost:3306
Source Database       : qianduan_sql

Target Server Type    : MYSQL
Target Server Version : 80033
File Encoding         : 65001

Date: 2023-07-11 11:45:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ed_data
-- ----------------------------
DROP TABLE IF EXISTS `ed_data`;
CREATE TABLE `ed_data` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `provider` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '供应商',
  `shop_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '餐饮店',
  `equipment_number` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '设备编号',
  `equipment_name` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '设备名称',
  `smoke_push_density` double(8,0) DEFAULT NULL COMMENT '禁烟浓度，单位mg/m^3',
  `smoke_pop_density` double(8,2) DEFAULT NULL COMMENT '排烟浓度，单位mg/m^3',
  `wind_turbine` double(8,2) DEFAULT NULL COMMENT '风机电,单位A',
  `purifier` double(8,2) DEFAULT NULL COMMENT '净化器，单位A',
  `level` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '级别',
  `alarm_required` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '需报警',
  `alarm_triggered` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '已报警',
  `attribution_time` datetime DEFAULT NULL COMMENT '归属时间，每10分钟一段',
  `reporting_time` datetime DEFAULT NULL COMMENT '上报时间',
  `data_time` datetime DEFAULT NULL COMMENT '数据时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36751 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
