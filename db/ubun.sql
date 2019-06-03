/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : ubun

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-06-03 21:00:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sysuser
-- ----------------------------
DROP TABLE IF EXISTS `sysuser`;
CREATE TABLE `sysuser` (
  `ID` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `USERNAME` varchar(255) NOT NULL DEFAULT '',
  `PASSWORD` varchar(255) NOT NULL COMMENT '盐值',
  `SALT` varchar(255) NOT NULL,
  `HEADING` varchar(255) DEFAULT NULL,
  `ROLEID` int(11) NOT NULL,
  `IP` varchar(255) DEFAULT NULL,
  `CREATETIME` timestamp NULL DEFAULT NULL,
  `LASTLOGINTIME` timestamp NULL DEFAULT NULL,
  `CREATEIP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sysuser
-- ----------------------------
INSERT INTO `sysuser` VALUES ('00000000001', 'shwj', 'e10adc3949ba59abbe56e057f20f883e', '49ba59abbe56e057', 'https://www.cmd5.com/', '1', '192.168.0.168', '2019-06-03 20:46:53', '2019-06-03 20:46:51', '192.168.0.168');
