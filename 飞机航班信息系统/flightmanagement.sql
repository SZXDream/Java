/*
Navicat MySQL Data Transfer

Source Server         : szx
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : flightmanagement

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-05-16 14:37:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `flightmessage`
-- ----------------------------
DROP TABLE IF EXISTS `flightmessage`;
CREATE TABLE `flightmessage` (
  `Fly_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Fly_Number` varchar(20) NOT NULL,
  `Departure_Time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `Arrivival_Time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `Off_Place` varchar(50) NOT NULL,
  `Arrivival_Place` varchar(50) NOT NULL,
  `Ticket_Price` int(11) NOT NULL,
  `Ticket_Number` int(11) NOT NULL,
  `Remanent_Ticket` int(11) NOT NULL,
  PRIMARY KEY (`Fly_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10011 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flightmessage
-- ----------------------------
INSERT INTO `flightmessage` VALUES ('10001', '10001', '2016-03-13 19:18:43', '2016-03-14 19:18:43', '南京', '上海', '500', '400', '400');
INSERT INTO `flightmessage` VALUES ('10002', '10002', '2016-03-12 19:14:49', '2016-03-13 19:14:49', '南京', '北京', '400', '400', '400');
INSERT INTO `flightmessage` VALUES ('10003', '10003', '2016-03-13 19:14:49', '2016-03-14 19:14:49', '南京', '伦敦', '1000', '400', '400');
INSERT INTO `flightmessage` VALUES ('10004', '10004', '2016-03-15 19:14:49', '2016-03-15 19:14:49', '上海', '日本', '1300', '400', '400');
INSERT INTO `flightmessage` VALUES ('10005', '10005', '2016-03-17 18:18:31', '2016-03-18 18:18:31', '黑龙江', '青岛', '1000', '300', '300');
INSERT INTO `flightmessage` VALUES ('10006', '10006', '2016-03-14 18:29:39', '2016-03-15 18:29:39', '西藏', '南京', '800', '400', '400');
INSERT INTO `flightmessage` VALUES ('10007', '10007', '2016-03-07 08:01:30', '2016-03-07 11:01:43', '南京', '徐州', '300', '300', '300');
INSERT INTO `flightmessage` VALUES ('10008', '10008', '2016-03-19 14:52:39', '2016-03-19 14:52:39', '南京', '西藏', '500', '500', '500');
INSERT INTO `flightmessage` VALUES ('10010', '10010', '2016-03-21 14:54:26', '2016-03-22 14:54:26', '上海', '瑞典', '5000', '500', '500');

-- ----------------------------
-- Table structure for `logtable`
-- ----------------------------
DROP TABLE IF EXISTS `logtable`;
CREATE TABLE `logtable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `LogLevel` varchar(50) NOT NULL,
  `UseTime` varchar(50) NOT NULL,
  `MSG` varchar(60) CHARACTER SET gbk NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logtable
-- ----------------------------
INSERT INTO `logtable` VALUES ('23', 'INFO', '2016-03-13 18:30:29', 'Admin insert a flight message!');
INSERT INTO `logtable` VALUES ('24', 'INFO', '2016-03-19 14:53:48', 'Admin Update a flight Message,it is 10008');
INSERT INTO `logtable` VALUES ('25', 'INFO', '2016-03-19 14:55:38', 'Admin insert a flight message!');
INSERT INTO `logtable` VALUES ('26', 'INFO', '2016-03-19 14:56:06', 'admin delete flightmessage?');
INSERT INTO `logtable` VALUES ('27', 'INFO', '2016-03-19 14:56:43', '555 update a password');
INSERT INTO `logtable` VALUES ('28', 'INFO', '2016-03-19 14:57:25', '403join us,(Admin)');
INSERT INTO `logtable` VALUES ('29', 'INFO', '2016-03-19 14:57:44', 'Admin delete a user,he is 403');
INSERT INTO `logtable` VALUES ('30', 'INFO', '2016-03-22 16:08:24', '401 update a password');
INSERT INTO `logtable` VALUES ('31', 'INFO', '2016-03-22 17:45:46', 'Admin delete a user,he is 501');
INSERT INTO `logtable` VALUES ('32', 'INFO', '2016-03-22 17:57:54', '0 join us!(Public)');
INSERT INTO `logtable` VALUES ('33', 'INFO', '2016-03-22 18:00:20', '0join us,(Admin)');
INSERT INTO `logtable` VALUES ('34', 'INFO', '2016-03-22 18:03:22', '100join us,(Admin)');
INSERT INTO `logtable` VALUES ('35', 'INFO', '2016-03-22 18:04:23', '102 join us!(Public)');
INSERT INTO `logtable` VALUES ('36', 'INFO', '2016-03-22 18:04:47', '101 join us!(Public)');
INSERT INTO `logtable` VALUES ('37', 'INFO', '2016-03-22 18:05:22', '102 update a password');
INSERT INTO `logtable` VALUES ('38', 'INFO', '2016-03-22 18:06:07', '104 join us!(Public)');
INSERT INTO `logtable` VALUES ('39', 'INFO', '2016-03-22 18:06:51', '0 join us!(Public)');
INSERT INTO `logtable` VALUES ('40', 'INFO', '2016-03-22 18:29:24', '108 join us!(Public)');
INSERT INTO `logtable` VALUES ('41', 'INFO', '2016-03-22 18:30:01', '108 update a password');

-- ----------------------------
-- Table structure for `userslogin`
-- ----------------------------
DROP TABLE IF EXISTS `userslogin`;
CREATE TABLE `userslogin` (
  `User_Id` int(11) NOT NULL AUTO_INCREMENT,
  `User_Name` varchar(50) NOT NULL,
  `User_Password` varchar(50) NOT NULL,
  `User_Authority` char(20) NOT NULL,
  PRIMARY KEY (`User_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=559 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userslogin
-- ----------------------------
INSERT INTO `userslogin` VALUES ('100', '100', '100', '普通用户');
INSERT INTO `userslogin` VALUES ('101', '101', '101', '普通用户');
INSERT INTO `userslogin` VALUES ('102', '102', '102', '普通用户');
INSERT INTO `userslogin` VALUES ('103', 'Toory', 'toory', '普通用户');
INSERT INTO `userslogin` VALUES ('104', '104', '104', '普通用户');
INSERT INTO `userslogin` VALUES ('108', '108', '108', '普通用户');
INSERT INTO `userslogin` VALUES ('201', 'Admin', 'admi', '管理员');
INSERT INTO `userslogin` VALUES ('222', '沈振兴', 'szx', '普通用户');
INSERT INTO `userslogin` VALUES ('301', 'Looper', 'looper', '普通用户');
INSERT INTO `userslogin` VALUES ('401', 'deft', '401', '普通用户');
INSERT INTO `userslogin` VALUES ('555', '555', 'admin', '管理员');
INSERT INTO `userslogin` VALUES ('556', '000', '000', '普通用户');
INSERT INTO `userslogin` VALUES ('557', '000', '000', '普通用户');
INSERT INTO `userslogin` VALUES ('558', '000', '0000', '普通用户');
