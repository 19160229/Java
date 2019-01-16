/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : 10

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 08/01/2019 17:59:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for model
-- ----------------------------
DROP TABLE IF EXISTS `model`;
CREATE TABLE `model`  (
  `modelName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `next` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of model
-- ----------------------------
INSERT INTO `model` VALUES ('model1', 'head', 'sta002');
INSERT INTO `model` VALUES ('model1', 'sta002', 'sta003');
INSERT INTO `model` VALUES ('model1', 'sta003', NULL);
INSERT INTO `model` VALUES ('model2', 'sta001', 'sta002');
INSERT INTO `model` VALUES ('model2', 'sta003', NULL);
INSERT INTO `model` VALUES ('model2', 'sta002', 'sta003');
INSERT INTO `model` VALUES ('model2', 'head', 'sta001');
INSERT INTO `model` VALUES ('my', 'head', 'sta001');
INSERT INTO `model` VALUES ('my', 'sta001', 'sta003');
INSERT INTO `model` VALUES ('my', 'sta003', 'sta002');
INSERT INTO `model` VALUES ('my', 'sta002', '');

-- ----------------------------
-- Table structure for mtable
-- ----------------------------
DROP TABLE IF EXISTS `mtable`;
CREATE TABLE `mtable`  (
  `applicationID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `applicant` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `startTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `endTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `currentLevel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`applicationID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mtable
-- ----------------------------
INSERT INTO `mtable` VALUES ('19160232201916', 'A', '事假', '2019/1/6', '2019/1/7', '15651002652', NULL, '0', '默认');
INSERT INTO `mtable` VALUES ('19160234201916', 'B', '病假', '2019/1/6', '2019/1/6', '15651000000', NULL, NULL, 'model1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `applicationID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('adm001', '123', '0', NULL);
INSERT INTO `user` VALUES ('sta001', '123', '3', NULL);
INSERT INTO `user` VALUES ('sta002', '123', '2', NULL);
INSERT INTO `user` VALUES ('sta003', '123', '3', NULL);
INSERT INTO `user` VALUES ('stu19160232', '123', '1', NULL);
INSERT INTO `user` VALUES ('stu19160234', '123', '1', '19160234201916');

SET FOREIGN_KEY_CHECKS = 1;
