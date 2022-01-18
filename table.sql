/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : table

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2022-01-18 18:04:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `child1` varchar(255) NOT NULL,
  `child2` varchar(255) NOT NULL,
  `child3` varchar(255) NOT NULL,
  `child4` varchar(255) NOT NULL,
  `child5` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '修改1', '修改2', '修改3', '修改4', '修改5');
INSERT INTO `item` VALUES ('4', '修改为1', '修改为2', '修改为3', '修改为4', '修改为5');
INSERT INTO `item` VALUES ('6', '222', '222', '222', '222', '222');
