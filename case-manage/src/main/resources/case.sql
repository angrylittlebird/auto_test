/*
Navicat MySQL Data Transfer

Source Server         : 47.105.95.225
Source Server Version : 80013
Source Host           : 47.105.95.225:3306
Source Database       : course

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-10-30 17:22:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for addUserCase
-- ----------------------------
DROP TABLE IF EXISTS `addUserCase`;
CREATE TABLE `addUserCase` (
  `id` varchar(255) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `permission` tinyint(4) DEFAULT NULL,
  `isDelete` tinyint(4) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of addUserCase
-- ----------------------------
INSERT INTO `addUserCase` VALUES ('1', 'zhao', 'zhao9', '1', '12', '1', '0', 'true');

-- ----------------------------
-- Table structure for getUserInfoCase
-- ----------------------------
DROP TABLE IF EXISTS `getUserInfoCase`;
CREATE TABLE `getUserInfoCase` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of getUserInfoCase
-- ----------------------------
INSERT INTO `getUserInfoCase` VALUES ('1', '1', 'getUserInfo');

-- ----------------------------
-- Table structure for getUserListCase
-- ----------------------------
DROP TABLE IF EXISTS `getUserListCase`;
CREATE TABLE `getUserListCase` (
  `id` int(11) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of getUserListCase
-- ----------------------------
INSERT INTO `getUserListCase` VALUES ('1', null, null, '0', 'getUserList');

-- ----------------------------
-- Table structure for loginCase
-- ----------------------------
DROP TABLE IF EXISTS `loginCase`;
CREATE TABLE `loginCase` (
  `id` int(11) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of loginCase
-- ----------------------------
INSERT INTO `loginCase` VALUES ('1', 'zhangsan', '123', 'true');
INSERT INTO `loginCase` VALUES ('2', 'zhangsanerror', '123456', 'false');

-- ----------------------------
-- Table structure for updateUserInfoCase
-- ----------------------------
DROP TABLE IF EXISTS `updateUserInfoCase`;
CREATE TABLE `updateUserInfoCase` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `isDelete` tinyint(4) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of updateUserInfoCase
-- ----------------------------
INSERT INTO `updateUserInfoCase` VALUES ('1', '2', 'haaha', null, null, null, null, 'getUpdateUserInfo');
INSERT INTO `updateUserInfoCase` VALUES ('2', '8', null, null, null, null, '1', 'getUpdateUserInfo');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `permission` tinyint(4) DEFAULT NULL,
  `isDelete` tinyint(4) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', '3', '0', '1', '1', '123');
INSERT INTO `user` VALUES ('2', 'haaha', '1', '1', '1', '1', '123');
INSERT INTO `user` VALUES ('4', 'zhao', '12', '0', '1', '0', 'zhao9');
INSERT INTO `user` VALUES ('5', 'zhao', '12', '1', '1', '0', 'zhao9');
INSERT INTO `user` VALUES ('6', 'zhao', '12', '1', '1', '0', 'zhao9');
INSERT INTO `user` VALUES ('8', 'zhao', '12', '1', '1', '1', 'zhao9');
