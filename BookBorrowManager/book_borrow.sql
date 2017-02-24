/*
Navicat MySQL Data Transfer

Source Server         : sql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : book_borrow

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-02-23 21:02:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `ISBN` char(10) NOT NULL,
  `typeid` varchar(20) DEFAULT NULL,
  `bookname` varchar(30) DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  `publish` varchar(30) DEFAULT NULL,
  `publishdate` date DEFAULT NULL,
  `printtime` int(11) DEFAULT NULL,
  `unitprice` double DEFAULT NULL,
  PRIMARY KEY (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('9787309281', '1', 'oracle', '王岩', '清华大学出版社', '2013-03-02', '1', '32');
INSERT INTO `book` VALUES ('9787309282', '1', 'sql', '梁爽', '清华大学出版社', '2013-09-12', '1', '28.9');
INSERT INTO `book` VALUES ('9787309283', '2', '思想', '谢华', '人民邮电出版社', '2014-03-02', '2', '15');

-- ----------------------------
-- Table structure for `booktype`
-- ----------------------------
DROP TABLE IF EXISTS `booktype`;
CREATE TABLE `booktype` (
  `id` int(11) NOT NULL,
  `typename` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of booktype
-- ----------------------------
INSERT INTO `booktype` VALUES ('1', '计算机类');
INSERT INTO `booktype` VALUES ('2', '社科类');

-- ----------------------------
-- Table structure for `borrowbook`
-- ----------------------------
DROP TABLE IF EXISTS `borrowbook`;
CREATE TABLE `borrowbook` (
  `readerid` char(8) NOT NULL,
  `ISBN` char(10) NOT NULL,
  `borrowdate` date DEFAULT NULL,
  `returndate` date DEFAULT NULL,
  `fine` double DEFAULT NULL,
  PRIMARY KEY (`ISBN`,`readerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrowbook
-- ----------------------------
INSERT INTO `borrowbook` VALUES ('11301121', '9787302987', '2013-06-07', '2013-11-23', '34.5');
INSERT INTO `borrowbook` VALUES ('213098', '9787309281', '2014-11-07', '2015-12-23', '37.5');

-- ----------------------------
-- Table structure for `reader`
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
  `readerid` char(8) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `name` char(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` char(4) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `dept` varchar(20) DEFAULT NULL,
  `regdate` date DEFAULT NULL,
  PRIMARY KEY (`readerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('11301121', '1', '金鑫', '23', '男', '18643214221', '计算机', '2011-09-01');
INSERT INTO `reader` VALUES ('213098', '2', '张丽', '33', '女', '18643256221', '计算机', '2001-09-01');

-- ----------------------------
-- Table structure for `readertype`
-- ----------------------------
DROP TABLE IF EXISTS `readertype`;
CREATE TABLE `readertype` (
  `id` int(11) NOT NULL,
  `typename` varchar(20) DEFAULT NULL,
  `maxborrownum` int(11) DEFAULT NULL,
  `limitday` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readertype
-- ----------------------------
INSERT INTO `readertype` VALUES ('1', '学生', '3', '10');
INSERT INTO `readertype` VALUES ('2', '教师', '6', '30');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', '111');
