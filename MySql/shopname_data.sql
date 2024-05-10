/*
Navicat MySQL Data Transfer

Source Server         : lcoal
Source Server Version : 80033
Source Host           : localhost:3306
Source Database       : qianduan_sql

Target Server Type    : MYSQL
Target Server Version : 80033
File Encoding         : 65001

Date: 2023-07-11 11:47:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for shopname_data
-- ----------------------------
DROP TABLE IF EXISTS `shopname_data`;
CREATE TABLE `shopname_data` (
  `fume_dev_id` varchar(30) CHARACTER SET utf8mb3 NOT NULL COMMENT '设备编号',
  `shop_name` varchar(20) CHARACTER SET utf8mb3 NOT NULL COMMENT '餐饮店'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of shopname_data
-- ----------------------------
INSERT INTO `shopname_data` VALUES ('GLHB00000000016004', '上海稔传餐饮管理有限公司（人生一串）');
INSERT INTO `shopname_data` VALUES ('fucheng310104200914', '缘家');
INSERT INTO `shopname_data` VALUES ('GLHB00000000016011', '丰茂烤串');
INSERT INTO `shopname_data` VALUES ('GLHB00000000010279', '上海泰煌餐饮管理有限公司（泰煌鸡）');
INSERT INTO `shopname_data` VALUES ('GLHB00000000010504', '徐汇区辰熙餐馆(小铁君串烧居酒屋)');
INSERT INTO `shopname_data` VALUES ('qinshi_31010320210010', '付小姐在成都');
INSERT INTO `shopname_data` VALUES ('qinshi_31010320200006', '吉刻联盟');
INSERT INTO `shopname_data` VALUES ('hengzhiyuan_64480047347215', '家在塔啦');
INSERT INTO `shopname_data` VALUES ('zhuoquan_31011020175012', '狼来了');
INSERT INTO `shopname_data` VALUES ('qinshi_31010320200007', '乐凯撒星游店');
INSERT INTO `shopname_data` VALUES ('hengzhiyuan_64480047078091', '馨远美食小镇（哈尼美食广场）');
INSERT INTO `shopname_data` VALUES ('qinshi_31010320190005', '棒约翰');
INSERT INTO `shopname_data` VALUES ('zhuoquan_31011020175008', '弄堂咪道');
INSERT INTO `shopname_data` VALUES ('zhuoquan_31011020175002', '杨记齐齐哈尔烤肉');
INSERT INTO `shopname_data` VALUES ('GLHB00000000016155', '泉盛餐饮（上海）有限公司（食其家）');
