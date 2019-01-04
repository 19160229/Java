/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : 11

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 26/12/2018 21:46:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cno` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `credit` tinyint(5) NULL DEFAULT NULL,
  `semester` tinyint(5) NULL DEFAULT NULL,
  PRIMARY KEY (`cno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('c001', '计算机文化学', 3, 1);
INSERT INTO `course` VALUES ('c002', '高等数学(上)', 6, 1);
INSERT INTO `course` VALUES ('c003', '高等数学(下)', 3, 2);
INSERT INTO `course` VALUES ('c004', '大学英语', 6, 2);
INSERT INTO `course` VALUES ('c005', 'Java', 2, 3);
INSERT INTO `course` VALUES ('c006', '程序设计', 3, 3);
INSERT INTO `course` VALUES ('c007', '数据结构', 5, 4);
INSERT INTO `course` VALUES ('c008', '操作系统', 4, 4);
INSERT INTO `course` VALUES ('c009', '数据库基础', 4, 5);
INSERT INTO `course` VALUES ('c010', '计算机网络', 5, 6);

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc`  (
  `sno` char(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cno` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `grade` smallint(6) NULL DEFAULT NULL,
  PRIMARY KEY (`sno`, `cno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('1512101', 'c001', 90);
INSERT INTO `sc` VALUES ('1512101', 'c002', 86);
INSERT INTO `sc` VALUES ('1512101', 'c003', 92);
INSERT INTO `sc` VALUES ('1512101', 'c005', 88);
INSERT INTO `sc` VALUES ('1512101', 'c006', 60);
INSERT INTO `sc` VALUES ('1512102', 'c001', 76);
INSERT INTO `sc` VALUES ('1512102', 'c002', 78);
INSERT INTO `sc` VALUES ('1512102', 'c005', 66);
INSERT INTO `sc` VALUES ('1512104', 'c002', 66);
INSERT INTO `sc` VALUES ('1512104', 'c005', 78);
INSERT INTO `sc` VALUES ('1512104', 'c008', 66);
INSERT INTO `sc` VALUES ('1521102', 'c001', 82);
INSERT INTO `sc` VALUES ('1521102', 'c005', 75);
INSERT INTO `sc` VALUES ('1521102', 'c007', 92);
INSERT INTO `sc` VALUES ('1521102', 'c009', 50);
INSERT INTO `sc` VALUES ('1521103', 'c002', 68);
INSERT INTO `sc` VALUES ('1521103', 'c006', NULL);
INSERT INTO `sc` VALUES ('1521103', 'c007', NULL);
INSERT INTO `sc` VALUES ('1521103', 'c008', 78);
INSERT INTO `sc` VALUES ('1531101', 'c001', 80);
INSERT INTO `sc` VALUES ('1531101', 'c005', 50);
INSERT INTO `sc` VALUES ('1531101', 'c007', 45);
INSERT INTO `sc` VALUES ('1531102', 'c001', 80);
INSERT INTO `sc` VALUES ('1531102', 'c002', 75);
INSERT INTO `sc` VALUES ('1531102', 'c005', 85);
INSERT INTO `sc` VALUES ('1531102', 'c009', 88);

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu`  (
  `sno` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ssex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sage` tinyint(10) NULL DEFAULT NULL,
  `sdept` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES ('1512101', '李勇', '男', 19, '计算机系');
INSERT INTO `stu` VALUES ('1512102', '刘晨', '男', 20, '计算机系');
INSERT INTO `stu` VALUES ('1512103', '王敏', '女', 18, '计算机系');
INSERT INTO `stu` VALUES ('1512104', '李小玲', '女', 19, '计算机系');
INSERT INTO `stu` VALUES ('1521101', '张立', '男', 22, '信息系');
INSERT INTO `stu` VALUES ('1521102', '吴宾', '女', 21, '信息系');
INSERT INTO `stu` VALUES ('1521103', '张海', '男', 20, '信息系');
INSERT INTO `stu` VALUES ('1531101', '钱小平', '女', 18, '数学系');
INSERT INTO `stu` VALUES ('1531102', '王大力', '男', 19, '数学系');

-- ----------------------------
-- Table structure for usr
-- ----------------------------
DROP TABLE IF EXISTS `usr`;
CREATE TABLE `usr`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usrname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authority` tinyint(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usr
-- ----------------------------
INSERT INTO `usr` VALUES (1, 'admin', 'admin', 1);
INSERT INTO `usr` VALUES (2, 'stu', 'stu', 2);
INSERT INTO `usr` VALUES (3, '1512101', '1512101', 2);
INSERT INTO `usr` VALUES (4, '1512102', '1512102', 2);
INSERT INTO `usr` VALUES (5, '1512103', '1512103', 2);
INSERT INTO `usr` VALUES (6, '1512104', '1512104', 2);
INSERT INTO `usr` VALUES (7, '1521101', '1521101', 2);
INSERT INTO `usr` VALUES (8, '1521102', '1521102', 2);
INSERT INTO `usr` VALUES (9, '1521103', '1521103', 2);
INSERT INTO `usr` VALUES (10, '1531101', '1531101', 2);
INSERT INTO `usr` VALUES (11, '1531102', '1531102', 2);

SET FOREIGN_KEY_CHECKS = 1;
