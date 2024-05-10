/*
Navicat MySQL Data Transfer

Source Server         : lcoal
Source Server Version : 80033
Source Host           : localhost:3306
Source Database       : qianduan_sql

Target Server Type    : MYSQL
Target Server Version : 80033
File Encoding         : 65001

Date: 2023-07-11 11:42:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ea_t_device_info
-- ----------------------------
DROP TABLE IF EXISTS `ea_t_device_info`;
CREATE TABLE `ea_t_device_info` (
  `DI_GUID` varchar(16) NOT NULL,
  `DI_Code` varchar(50) DEFAULT NULL,
  `DI_Name` varchar(255) DEFAULT NULL COMMENT '设备名称',
  `DI_Device_Type_Id` int DEFAULT NULL,
  `DI_Device_Type` varchar(50) DEFAULT NULL,
  `DI_Scene_Type_Id` int DEFAULT NULL,
  `DI_Scene_Type` varchar(50) DEFAULT NULL,
  `DI_Province_Code` varchar(50) DEFAULT NULL,
  `DI_Province_Name` varchar(50) DEFAULT NULL,
  `DI_City_Code` varchar(50) DEFAULT NULL,
  `DI_City_Name` varchar(50) DEFAULT NULL,
  `DI_District_Code` varchar(50) DEFAULT NULL,
  `DI_District_Name` varchar(50) DEFAULT NULL,
  `DI_Town_Code` varchar(50) DEFAULT NULL,
  `DI_Town_Name` varchar(50) DEFAULT NULL,
  `DI_Supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `DI_Online` bit(1) DEFAULT NULL COMMENT '是否在线',
  PRIMARY KEY (`DI_GUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
