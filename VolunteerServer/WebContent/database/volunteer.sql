/*
Navicat MySQL Data Transfer

Source Server         : danding
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : volunteer

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2015-02-01 00:02:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `activityID` varchar(255) NOT NULL,
  `title` varchar(255) default NULL,
  `activityType` varchar(255) default NULL,
  `recruitPeopleNum` int(11) default NULL,
  `startTime` datetime default NULL,
  `endTime` datetime default NULL,
  `deadline` datetime default NULL,
  `uploadTime` datetime default NULL,
  `activityAddress` varchar(255) default NULL,
  `activityContactName` varchar(255) default NULL,
  `activityTelPhone` varchar(255) default NULL,
  `activityEmail` varchar(255) default NULL,
  `perks` varchar(255) default NULL,
  `activityIntroduce` varchar(255) default NULL,
  PRIMARY KEY  (`activityID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminID` varchar(255) NOT NULL,
  `account` varchar(255) default NULL,
  `adminName` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`adminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `announce`
-- ----------------------------
DROP TABLE IF EXISTS `announce`;
CREATE TABLE `announce` (
  `announceID` varchar(255) NOT NULL,
  `title` varchar(255) default NULL,
  `content` varchar(255) default NULL,
  PRIMARY KEY  (`announceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of announce
-- ----------------------------

-- ----------------------------
-- Table structure for `checkactivity`
-- ----------------------------
DROP TABLE IF EXISTS `checkactivity`;
CREATE TABLE `checkactivity` (
  `checkActivityID` varchar(255) NOT NULL,
  `orgID` varchar(255) default NULL,
  `activityID` varchar(255) default NULL,
  `state` varchar(255) default NULL,
  `failedReason` varchar(255) default NULL,
  `checkTime` datetime default NULL,
  `uploadTime` datetime default NULL,
  PRIMARY KEY  (`checkActivityID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkactivity
-- ----------------------------

-- ----------------------------
-- Table structure for `checkorg`
-- ----------------------------
DROP TABLE IF EXISTS `checkorg`;
CREATE TABLE `checkorg` (
  `checkOrgID` varchar(255) NOT NULL,
  `orgID` varchar(255) default NULL,
  `state` varchar(255) default NULL,
  `failedReason` varchar(255) default NULL,
  `checkTime` datetime default NULL,
  `uploadTime` datetime default NULL,
  PRIMARY KEY  (`checkOrgID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkorg
-- ----------------------------

-- ----------------------------
-- Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `cityID` varchar(255) NOT NULL,
  `provinceID` varchar(255) default NULL,
  `cityName` varchar(255) default NULL,
  PRIMARY KEY  (`cityID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------

-- ----------------------------
-- Table structure for `information`
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `informationID` varchar(255) NOT NULL,
  `title` varchar(255) default NULL,
  `digest` varchar(255) default NULL,
  `imgPath` varchar(255) default NULL,
  PRIMARY KEY  (`informationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of information
-- ----------------------------

-- ----------------------------
-- Table structure for `org`
-- ----------------------------
DROP TABLE IF EXISTS `org`;
CREATE TABLE `org` (
  `orgID` varchar(255) NOT NULL,
  `orgName` varchar(255) default NULL,
  `practiceNumber` varchar(255) default NULL,
  `orgScale` varchar(255) default NULL,
  `orgAddress` varchar(255) default NULL,
  `orgContactName` varchar(255) default NULL,
  `orgTelPhone` varchar(255) default NULL,
  `orgEmail` varchar(255) default NULL,
  `orgIntroduce` varchar(255) default NULL,
  `orgType` varchar(255) default NULL,
  `registerTime` varchar(255) default NULL,
  `recruitNum` varchar(255) default NULL,
  PRIMARY KEY  (`orgID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of org
-- ----------------------------

-- ----------------------------
-- Table structure for `province`
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `provinceID` varchar(255) NOT NULL,
  `provinceName` varchar(255) default NULL,
  PRIMARY KEY  (`provinceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province
-- ----------------------------

-- ----------------------------
-- Table structure for `systemddl`
-- ----------------------------
DROP TABLE IF EXISTS `systemddl`;
CREATE TABLE `systemddl` (
  `seqID` varchar(255) NOT NULL,
  `keyword` varchar(255) default NULL,
  `ddlCode` varchar(255) default NULL,
  `ddlName` varchar(255) default NULL,
  PRIMARY KEY  (`seqID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemddl
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` varchar(255) NOT NULL,
  `account` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `userName` varchar(255) default NULL,
  `nickName` varchar(255) default NULL,
  `sex` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  `portrait` varchar(255) default NULL,
  `telPhone` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `introduce` varchar(255) default NULL,
  `volunteerTypet` varchar(255) default NULL,
  `experience` varchar(255) default NULL,
  `applyCount` int(11) default NULL,
  `isCantonese` varchar(255) default NULL,
  `registerTime` varchar(255) default NULL,
  `volunteerLastTime` bigint(20) default NULL,
  PRIMARY KEY  (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `custBonus` varchar(255) NOT NULL,
  `custLevel` varchar(255) default NULL,
  `custName` varchar(255) default NULL,
  `userId` varchar(255) default NULL,
  `usersession` varchar(255) default NULL,
  `custPwd` varchar(255) default NULL,
  PRIMARY KEY  (`custBonus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('22222', '1', 'sss', '1', '1111111', 'ddd');
