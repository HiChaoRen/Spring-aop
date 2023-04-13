/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : db1

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 13/04/2023 09:22:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` double(7, 2) NULL DEFAULT 0.00,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '师父', '123456', 1000.00);
INSERT INTO `user` VALUES (2, '三师妹', 'loveErShiXiong', 10000.00);
INSERT INTO `user` VALUES (3, '二师兄', 'LoveSanShiMei', 100.00);
INSERT INTO `user` VALUES (4, '大师兄', '123456', 1000.00);

SET FOREIGN_KEY_CHECKS = 1;
