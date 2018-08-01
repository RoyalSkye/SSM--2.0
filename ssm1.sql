/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : ssm1

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-08-01 19:20:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for branch
-- ----------------------------
DROP TABLE IF EXISTS `branch`;
CREATE TABLE `branch` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `qid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `valid` int(11) DEFAULT '1',
  PRIMARY KEY (`bid`),
  KEY `fk_qid` (`qid`),
  CONSTRAINT `fk_qid` FOREIGN KEY (`qid`) REFERENCES `enterprise` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of branch
-- ----------------------------
INSERT INTO `branch` VALUES ('1', '1', '实训中心', '东软实训中心', '15940471397', '123.43949', '41.70588', '1');
INSERT INTO `branch` VALUES ('2', '1', '艺术中心', '多才艺术中心', '15940471393', '123.40297', '41.73612', '1');
INSERT INTO `branch` VALUES ('3', '1', '恒大名都', '恒大名都', '15940471397', '116.413387', '39.910924', '1');
INSERT INTO `branch` VALUES ('6', '1', '北京分部', '北京', '010', '116.413387', '39.910924', '1');
INSERT INTO `branch` VALUES ('7', '1', 'test', 'neu', '111', '123.420822', '41.77491', '1');
INSERT INTO `branch` VALUES ('8', '1', 'test', '1', '111', '123.420822', '41.77491', '1');
INSERT INTO `branch` VALUES ('9', '1', 'test', 'neu', '111', '123.420822', '41.77491', '1');
INSERT INTO `branch` VALUES ('10', '1', 'test', 'neu', '111', '123.420822', '41.77491', '1');
INSERT INTO `branch` VALUES ('11', '1', 'test', 'neu', '111', '123.420822', '41.77491', '1');
INSERT INTO `branch` VALUES ('12', '1', 'neu', 'neu', '11', '123.420822', '41.77491', '1');
INSERT INTO `branch` VALUES ('13', '2', '东北育才', '东北育才', '024', '123.44269', '41.716313', '1');
INSERT INTO `branch` VALUES ('14', '1', '非洲分部', '非洲分部', '11', '1', '1', '1');
INSERT INTO `branch` VALUES ('15', '1', '上海分部', '上海', '001', '121.48054', '31.235929', '1');
INSERT INTO `branch` VALUES ('16', '1', '上海分部', '上海', '010', '121.48054', '31.235929', '1');
INSERT INTO `branch` VALUES ('17', '1', '测试', '中软国际（大连）', '000', '121.523239', '38.866982', '0');
INSERT INTO `branch` VALUES ('18', '1', '730', '东北大学', '730', '123.425144', '41.771072', '1');

-- ----------------------------
-- Table structure for checkin
-- ----------------------------
DROP TABLE IF EXISTS `checkin`;
CREATE TABLE `checkin` (
  `checkinid` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`checkinid`),
  KEY `fk_checkincid` (`cid`),
  CONSTRAINT `fk_checkincid` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkin
-- ----------------------------
INSERT INTO `checkin` VALUES ('1', '2018-07-29 22:00:00', '8');
INSERT INTO `checkin` VALUES ('2', '2018-07-28 00:00:15', '8');

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `couponid` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`couponid`),
  KEY `fk_couponid` (`cid`),
  CONSTRAINT `fk_couponid` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coupon
-- ----------------------------
INSERT INTO `coupon` VALUES ('1', 'C++', '8', '2018-07-26 00:00:00', '2018-08-10 00:00:00', '0.9', '优惠券');
INSERT INTO `coupon` VALUES ('2', 'JAVA', '8', '2018-07-26 00:00:00', '2018-08-10 00:00:00', '0.9', '优惠券');

-- ----------------------------
-- Table structure for creditproduct
-- ----------------------------
DROP TABLE IF EXISTS `creditproduct`;
CREATE TABLE `creditproduct` (
  `cpid` int(11) NOT NULL AUTO_INCREMENT,
  `credit` int(11) DEFAULT '0',
  `discount` double DEFAULT NULL,
  `duration` int(11) DEFAULT '0',
  `category` varchar(255) DEFAULT NULL,
  `cpname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cpid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of creditproduct
-- ----------------------------
INSERT INTO `creditproduct` VALUES ('1', '10', '0.9', '2', 'C++,Java', '优惠券');
INSERT INTO `creditproduct` VALUES ('2', '10', '0.9', '2', 'C++,PythonC++,Python', '更新优惠券');
INSERT INTO `creditproduct` VALUES ('3', '10', '0.9', '2', 'HTML5', '优惠券');
INSERT INTO `creditproduct` VALUES ('4', '10', '0.9', '2', 'Python', '优惠券');
INSERT INTO `creditproduct` VALUES ('5', '20', '0.8', '3', 'C++', '优惠券');
INSERT INTO `creditproduct` VALUES ('6', '20', '0.8', '3', 'Java', '优惠券');
INSERT INTO `creditproduct` VALUES ('7', '20', '0.8', '3', 'HTML5', '优惠券');
INSERT INTO `creditproduct` VALUES ('8', '20', '0.8', '3', 'Python', '优惠券');
INSERT INTO `creditproduct` VALUES ('11', '50', '0.85', '1', 'Java,HTML5,C++,Python', '通用优惠券');
INSERT INTO `creditproduct` VALUES ('12', '10', '0.9', '2', 'Java,C++', '优惠券');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`,`phone`),
  KEY `phone` (`phone`),
  KEY `cid` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '135', '1', 'test0', '99', '100');
INSERT INTO `customer` VALUES ('2', '137', '1', 'test1', '100', '100');
INSERT INTO `customer` VALUES ('3', '136', '1', 'test2', '100', '100');
INSERT INTO `customer` VALUES ('4', '138', '1', 'test3', '100', '100');
INSERT INTO `customer` VALUES ('5', '139', '1', 'test4', '101', '100');
INSERT INTO `customer` VALUES ('7', '150', 'test', 'test5', '100', '100');
INSERT INTO `customer` VALUES ('8', '13504019086', '8000', 'skye', '100.99', '100');
INSERT INTO `customer` VALUES ('9', '18604010547', '1', 'hyf', '99', '100');

-- ----------------------------
-- Table structure for enterprise
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `qid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `videopath` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `uetext` text,
  PRIMARY KEY (`qid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise
-- ----------------------------
INSERT INTO `enterprise` VALUES ('1', '东软睿道', 'http://101.201.70.204:9998/group1/M00/00/00/rBAFzFthlp2AaYSPAFmTZruco8A027.mp4', '沈阳东软睿道教育服务有限公司（简称东软睿道）由东软创办，基于东软的产业发展与人才培养实践，提供更加符合IT行业发展需求的人才培养体系和方法学，精准提升大学生和大学后的就业、创业技能，为新经济时代的转型发展提供高质量规模化的人才供给。', '<p><img src=\"/upload/1.jpg\" width=\"300\" height=\"300\"/></p><p><br/></p>');
INSERT INTO `enterprise` VALUES ('2', '实训中心', '1.mp4', '实训中心 Test', 'test');

-- ----------------------------
-- Table structure for freelisten
-- ----------------------------
DROP TABLE IF EXISTS `freelisten`;
CREATE TABLE `freelisten` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `fdesc` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  `bid` int(11) DEFAULT NULL,
  `pubtime` datetime DEFAULT NULL,
  PRIMARY KEY (`fid`),
  KEY `fk_bid` (`bid`),
  KEY `fk_qid1` (`qid`),
  CONSTRAINT `fk_bid` FOREIGN KEY (`bid`) REFERENCES `branch` (`bid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_qid1` FOREIGN KEY (`qid`) REFERENCES `enterprise` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of freelisten
-- ----------------------------
INSERT INTO `freelisten` VALUES ('1', 'JAVA免费试听课', '/upload/1531209359661timg.jpg', '<p><img src=\"/upload/1.jpg\" width=\"300\" height=\"300\"/>haha</p>', '进行中', '1', '1', '2018-06-11 10:53:43');
INSERT INTO `freelisten` VALUES ('2', '大数据免费试听课', '/upload/1531718242586show1.jpg', '<p><img src=\"/upload/1.jpg\" width=\"300\" height=\"300\"/></p>', '进行中', '1', '2', '2018-06-12 10:53:46');
INSERT INTO `freelisten` VALUES ('3', 'PHP免费试听课', '/upload/1531718258328show3.jpg', '<p><img src=\"/upload/1.jpg\" width=\"300\" height=\"300\"/></p>', '进行中', '1', '1', '2018-06-13 10:53:50');
INSERT INTO `freelisten` VALUES ('4', 'Python免费试听课', '/upload/1.jpg', 'test', '进行中', '2', '13', '2018-07-10 10:22:51');
INSERT INTO `freelisten` VALUES ('9', '算法免费试听课', '/upload/15312202409304.jpg', '<p>test</p>', '进行中', '1', '3', '2018-07-10 06:57:32');
INSERT INTO `freelisten` VALUES ('10', 'test', '/upload/15317261674521.png', '<p>y</p>', '进行中', '1', '3', '2018-07-16 15:29:36');

-- ----------------------------
-- Table structure for freelistenbook
-- ----------------------------
DROP TABLE IF EXISTS `freelistenbook`;
CREATE TABLE `freelistenbook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fid` int(11) DEFAULT NULL,
  `cname` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `booktime` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `comment` varchar(3000) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_fid` (`fid`),
  CONSTRAINT `fk_fid` FOREIGN KEY (`fid`) REFERENCES `freelisten` (`fid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of freelistenbook
-- ----------------------------
INSERT INTO `freelistenbook` VALUES ('7', '2', '费园园', '15940471397', '2018-05-26 17:54:50', '已处理', '嘻嘻嘻', '13504019086');
INSERT INTO `freelistenbook` VALUES ('8', '1', '哈哈', '123456789', '2018-05-26 17:55:33', '已处理', '弟弟', '13504019086');
INSERT INTO `freelistenbook` VALUES ('9', '1', '哈哈', '123456789', '2018-05-26 17:55:35', '已处理', '弟弟', '13504019086');
INSERT INTO `freelistenbook` VALUES ('10', '1', '信息', '111', '2018-05-26 17:58:17', '待处理', '玩儿玩儿', null);
INSERT INTO `freelistenbook` VALUES ('11', '3', 'skye', '', '2018-06-15 09:53:39', '待处理', '', 'null');
INSERT INTO `freelistenbook` VALUES ('12', '3', '费园园', '1940471397', '2018-06-15 11:39:18', '待处理', '上午课', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk');
INSERT INTO `freelistenbook` VALUES ('13', '3', '谢谢', '123', '2018-06-15 12:00:02', '待处理', '谁是', 'null');
INSERT INTO `freelistenbook` VALUES ('14', '3', '谢谢', '123', '2018-06-15 12:00:28', '待处理', '谁是', 'null');
INSERT INTO `freelistenbook` VALUES ('15', '3', '谢谢', '123', '2018-06-15 12:00:30', '待处理', '谁是', 'null');
INSERT INTO `freelistenbook` VALUES ('16', '3', 'hyf', '18604010547', '2018-06-15 14:05:03', '待处理', '', '18604010547');
INSERT INTO `freelistenbook` VALUES ('17', '3', 'skye', '', '2018-06-15 14:12:20', '待处理', '', '135');
INSERT INTO `freelistenbook` VALUES ('18', '3', 'skye', '', '2018-06-15 14:31:52', '待处理', '', '135');
INSERT INTO `freelistenbook` VALUES ('19', '3', 'skye', '', '2018-06-15 14:31:53', '待处理', '', '135');
INSERT INTO `freelistenbook` VALUES ('20', '3', 'skye', '', '2018-06-15 15:14:09', '待处理', '', '135');
INSERT INTO `freelistenbook` VALUES ('21', '3', 'hyf', '18604010547', '2018-06-19 12:59:15', '已处理', 'test', '18604010547');
INSERT INTO `freelistenbook` VALUES ('22', '3', '费园园', '15940471397', '2018-06-21 18:54:26', '已处理', '明天上午', '135');
INSERT INTO `freelistenbook` VALUES ('23', '3', 'skye', '', '2018-06-22 13:29:45', '待处理', '', '135');
INSERT INTO `freelistenbook` VALUES ('24', '4', 'test', '1350', '2018-07-11 13:29:45', '待处理', 'test', '138');
INSERT INTO `freelistenbook` VALUES ('25', '4', 'test', '1350', '2018-07-11 13:29:45', '已处理', 'test', '138');
INSERT INTO `freelistenbook` VALUES ('26', '4', 'test', '1350', '2018-07-11 13:29:45', '已处理', 'test', '138');
INSERT INTO `freelistenbook` VALUES ('27', '4', 'test', '1350', '2018-07-11 13:29:45', '已处理', 'test', '138');
INSERT INTO `freelistenbook` VALUES ('28', '4', 'test', '1350', '2018-07-11 13:29:45', '已处理', 'test', '138');
INSERT INTO `freelistenbook` VALUES ('29', '4', 'test', '1350', '2018-07-11 13:29:45', '已处理', 'test', '138');
INSERT INTO `freelistenbook` VALUES ('30', '4', 'test', '1350', '2018-07-11 13:29:45', '已处理', 'test', '138');
INSERT INTO `freelistenbook` VALUES ('31', '4', 'test', '1350', '2018-07-11 13:29:45', '已处理', 'test', '138');
INSERT INTO `freelistenbook` VALUES ('32', '4', 'test', '1350', '2018-07-11 13:29:45', '已处理', 'test', '138');
INSERT INTO `freelistenbook` VALUES ('34', '2', '123', '11111111111', '2018-07-13 10:43:15', '待处理', '', '138');
INSERT INTO `freelistenbook` VALUES ('35', '9', 'skye', '13504011141', '2018-07-13 10:46:08', '待处理', 'test', '138');
INSERT INTO `freelistenbook` VALUES ('36', '2', '123', '11111111111', '2018-07-13 10:47:09', '待处理', '1111111111111', '138');
INSERT INTO `freelistenbook` VALUES ('37', '1', '111', '11111111111', '2018-07-16 15:42:59', '待处理', '111', '18604010547');

-- ----------------------------
-- Table structure for lesson
-- ----------------------------
DROP TABLE IF EXISTS `lesson`;
CREATE TABLE `lesson` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `lname` varchar(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `lprice` double DEFAULT NULL,
  `ldesc` text,
  `category` varchar(255) DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  `pubtime` datetime DEFAULT NULL,
  `credit` int(11) DEFAULT '0',
  PRIMARY KEY (`lid`),
  KEY `fk_qid2` (`qid`),
  CONSTRAINT `fk_qid2` FOREIGN KEY (`qid`) REFERENCES `enterprise` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lesson
-- ----------------------------
INSERT INTO `lesson` VALUES ('1', 'java', '/upload/course1.jpg', '1', '<p><strong><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong><br/></p><p>test</p><p>neusoft</p><p><strong style=\"white-space: normal;\"><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong></p>', 'Java', '1', '2018-07-30 12:58:46', '9');
INSERT INTO `lesson` VALUES ('2', 'C++', '/upload/course2.jpg', '1', '<p><strong><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong><br/></p><p>test</p><p>neusoft</p><p><strong style=\"white-space: normal;\"><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong></p>', 'HTML5', '1', '2018-06-04 10:39:29', '10');
INSERT INTO `lesson` VALUES ('3', 'ACM', '/upload/course3.jpg', '1', '<p><strong><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong><br/></p><p>test</p><p>neusoft</p><p><strong style=\"white-space: normal;\"><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong></p>', 'Java', '1', '2018-06-11 10:39:33', '10');
INSERT INTO `lesson` VALUES ('4', 'C', '/upload/course4.jpg', '1', '<p><strong><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong><br/></p><p>test</p><p>neusoft</p><p><strong style=\"white-space: normal;\"><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong></p>', 'HTML5', '1', '2018-06-07 10:39:37', '10');
INSERT INTO `lesson` VALUES ('5', '大数据课程', '/upload/course1.jpg', '1', '<p><strong><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong><br/></p><p>test</p><p>neusoft</p><p><strong style=\"white-space: normal;\"><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong></p>', 'C++', '1', '2018-06-08 10:39:40', '10');
INSERT INTO `lesson` VALUES ('6', '计算机网络', '/upload/course2.jpg', '1', '<p><strong><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong><br/></p><p>test</p><p>neusoft</p><p><strong style=\"white-space: normal;\"><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong></p>', 'C++', '1', '2018-06-13 10:39:44', '10');
INSERT INTO `lesson` VALUES ('7', '计算机组成原理', '/upload/course3.jpg', '1', '<p><strong><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong><br/></p><p>test</p><p>neusoft</p><p><strong style=\"white-space: normal;\"><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong></p>', 'HTML5', '1', '2018-06-11 10:39:47', '10');
INSERT INTO `lesson` VALUES ('8', '软件工程', '/upload/course4.jpg', '1', '<p><strong><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong><br/></p><p>test</p><p>neusoft</p><p><strong style=\"white-space: normal;\"><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong></p>', 'Python', '1', '2018-06-02 10:39:52', '10');
INSERT INTO `lesson` VALUES ('9', '软件测试', '/upload/course1.jpg', '1', '<p><strong><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong><br/></p><p>test</p><p>neusoft</p><p><strong style=\"white-space: normal;\"><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong></p>', 'HTML5', '1', '2018-06-11 10:39:56', '10');
INSERT INTO `lesson` VALUES ('10', 'Python', '/upload/course2.jpg', '1', '<p><strong><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong><br/></p><p>test</p><p>neusoft</p><p><strong style=\"white-space: normal;\"><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong></p>', 'Python', '1', '2018-06-15 10:39:59', '10');
INSERT INTO `lesson` VALUES ('11', 'HTML5', '/upload/course3.jpg', '1', '<p><strong><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong><br/></p><p>test</p><p>neusoft</p><p><strong style=\"white-space: normal;\"><img src=\"http://localhost:8080/upload/20180716/1531721413369003436.jpg\" title=\"1531721413369003436.jpg\" alt=\"4.jpg\" width=\"286\" height=\"166\"/></strong></p>', 'C++', '2', '2018-07-12 09:21:07', '10');
INSERT INTO `lesson` VALUES ('26', 'test', '/upload/15329213790206.jpg', '1', '<p>1</p>', 'C++', '1', '2018-07-30 11:29:39', '10');
INSERT INTO `lesson` VALUES ('27', 'test', '/upload/1532923035177cat.jpg', '1', '<p>test</p>', 'C++', '1', '2018-07-30 11:57:33', '10');

-- ----------------------------
-- Table structure for lessonbranch
-- ----------------------------
DROP TABLE IF EXISTS `lessonbranch`;
CREATE TABLE `lessonbranch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lid` int(11) DEFAULT NULL,
  `bid` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bid1` (`bid`),
  KEY `fk_lid` (`lid`),
  CONSTRAINT `fk_bid1` FOREIGN KEY (`bid`) REFERENCES `branch` (`bid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_lid` FOREIGN KEY (`lid`) REFERENCES `lesson` (`lid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lessonbranch
-- ----------------------------
INSERT INTO `lessonbranch` VALUES ('2', '2', '1');
INSERT INTO `lessonbranch` VALUES ('4', '4', '2');
INSERT INTO `lessonbranch` VALUES ('5', '5', '2');
INSERT INTO `lessonbranch` VALUES ('6', '6', '2');
INSERT INTO `lessonbranch` VALUES ('7', '7', '3');
INSERT INTO `lessonbranch` VALUES ('8', '8', '3');
INSERT INTO `lessonbranch` VALUES ('9', '9', '3');
INSERT INTO `lessonbranch` VALUES ('10', '10', '3');
INSERT INTO `lessonbranch` VALUES ('11', '3', '1');
INSERT INTO `lessonbranch` VALUES ('13', '11', '13');
INSERT INTO `lessonbranch` VALUES ('82', '26', '1');
INSERT INTO `lessonbranch` VALUES ('83', '26', '2');
INSERT INTO `lessonbranch` VALUES ('84', '26', '6');
INSERT INTO `lessonbranch` VALUES ('85', '26', '15');
INSERT INTO `lessonbranch` VALUES ('86', '26', '16');
INSERT INTO `lessonbranch` VALUES ('87', '27', '15');
INSERT INTO `lessonbranch` VALUES ('88', '27', '16');
INSERT INTO `lessonbranch` VALUES ('89', '1', '1');
INSERT INTO `lessonbranch` VALUES ('90', '1', '2');
INSERT INTO `lessonbranch` VALUES ('91', '1', '3');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mtitle` varchar(255) DEFAULT NULL,
  `mtime` datetime DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  PRIMARY KEY (`mid`),
  KEY `fk_qid3` (`qid`),
  CONSTRAINT `fk_qid3` FOREIGN KEY (`qid`) REFERENCES `enterprise` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', 'test', '2018-07-13 14:28:40', '2');
INSERT INTO `message` VALUES ('2', '无阅读不生活test', '2018-07-14 05:45:18', '1');
INSERT INTO `message` VALUES ('3', 'li', '2018-07-15 14:51:18', '1');
INSERT INTO `message` VALUES ('4', 'test2', '2018-07-03 15:01:58', '1');
INSERT INTO `message` VALUES ('5', 'test', '2018-07-13 14:42:09', '1');
INSERT INTO `message` VALUES ('7', 'test', '2018-07-13 14:42:10', '1');
INSERT INTO `message` VALUES ('8', 'test', '2018-07-13 14:42:11', '1');
INSERT INTO `message` VALUES ('9', 'test', '2018-07-13 14:42:11', '1');
INSERT INTO `message` VALUES ('10', 'test', '2018-07-13 14:42:12', '1');
INSERT INTO `message` VALUES ('11', 'test', '2018-07-13 14:42:12', '1');
INSERT INTO `message` VALUES ('12', 'test', '2018-07-13 14:42:12', '1');
INSERT INTO `message` VALUES ('13', 'test', '2018-07-13 14:42:12', '1');
INSERT INTO `message` VALUES ('14', 'test', '2018-07-13 14:42:12', '1');
INSERT INTO `message` VALUES ('15', 'test', '2018-07-13 14:42:13', '1');
INSERT INTO `message` VALUES ('16', 'test', '2018-07-13 14:42:13', '1');
INSERT INTO `message` VALUES ('17', 'test', '2018-07-13 14:42:13', '1');
INSERT INTO `message` VALUES ('18', 'test', '2018-07-13 14:42:13', '1');
INSERT INTO `message` VALUES ('19', 'test', '2018-07-13 14:42:14', '1');
INSERT INTO `message` VALUES ('20', 'test20', '2018-07-13 14:42:14', '1');
INSERT INTO `message` VALUES ('21', 'test21', '2018-07-13 14:42:14', '1');
INSERT INTO `message` VALUES ('22', 'test22', '2018-07-13 14:42:14', '1');
INSERT INTO `message` VALUES ('28', '发布朋友圈', '2018-07-14 07:16:23', '1');
INSERT INTO `message` VALUES ('29', '20180714', '2018-07-14 07:17:34', '1');
INSERT INTO `message` VALUES ('30', 'treet', '2018-08-01 19:13:50', '1');

-- ----------------------------
-- Table structure for messageimg
-- ----------------------------
DROP TABLE IF EXISTS `messageimg`;
CREATE TABLE `messageimg` (
  `miid` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`miid`),
  KEY `fk_mid` (`mid`),
  CONSTRAINT `fk_mid` FOREIGN KEY (`mid`) REFERENCES `message` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of messageimg
-- ----------------------------
INSERT INTO `messageimg` VALUES ('20', '2', '15315615177666.jpg');
INSERT INTO `messageimg` VALUES ('22', '28', '1531566807887cat.jpg');
INSERT INTO `messageimg` VALUES ('23', '28', '15315668078874.jpg');
INSERT INTO `messageimg` VALUES ('24', '28', '15315668136037.jpg');
INSERT INTO `messageimg` VALUES ('25', '29', '1531567051788timg.jpg');
INSERT INTO `messageimg` VALUES ('26', '3', '1.jpg');
INSERT INTO `messageimg` VALUES ('29', '30', 'http://101.201.70.204:9998/group1/M00/00/00/rBAFzFthleaAY70OAAAltvWxY8Y222.jpg');
INSERT INTO `messageimg` VALUES ('30', '30', 'http://101.201.70.204:9998/group1/M00/00/00/rBAFzFthleaAeukZAADps5aemcY263.jpg');

-- ----------------------------
-- Table structure for messagelike
-- ----------------------------
DROP TABLE IF EXISTS `messagelike`;
CREATE TABLE `messagelike` (
  `mlid` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `mlnickname` varchar(255) DEFAULT NULL,
  `mltime` datetime DEFAULT NULL,
  PRIMARY KEY (`mlid`),
  KEY `fk_mid1` (`mid`),
  CONSTRAINT `fk_mid1` FOREIGN KEY (`mid`) REFERENCES `message` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of messagelike
-- ----------------------------
INSERT INTO `messagelike` VALUES ('1', '2', '13504019086', '2018-07-13 14:25:27');
INSERT INTO `messagelike` VALUES ('2', '1', '13504019086', '2018-07-15 23:24:32');
INSERT INTO `messagelike` VALUES ('3', '3', '13504019086', '2018-07-15 23:24:43');
INSERT INTO `messagelike` VALUES ('4', '1', '18604010547', '2018-07-16 14:00:18');
INSERT INTO `messagelike` VALUES ('5', '2', '18604010547', '2018-07-16 14:00:26');
INSERT INTO `messagelike` VALUES ('6', '3', '18604010547', '2018-07-16 14:00:32');

-- ----------------------------
-- Table structure for messagereply
-- ----------------------------
DROP TABLE IF EXISTS `messagereply`;
CREATE TABLE `messagereply` (
  `mrid` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `mrnickname` varchar(255) DEFAULT NULL,
  `mrtime` datetime DEFAULT NULL,
  PRIMARY KEY (`mrid`),
  KEY `fk_mid2` (`mid`),
  CONSTRAINT `fk_mid2` FOREIGN KEY (`mid`) REFERENCES `message` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of messagereply
-- ----------------------------
INSERT INTO `messagereply` VALUES ('1', '2', '哈哈', '136', '2018-06-21 18:27:26');
INSERT INTO `messagereply` VALUES ('2', '2', 'test', '138', '2018-07-03 20:16:25');
INSERT INTO `messagereply` VALUES ('3', '3', 'skye', '13504019086', '2018-07-13 14:25:48');
INSERT INTO `messagereply` VALUES ('10', '3', 'test', '18604010547', '2018-07-16 14:17:17');
INSERT INTO `messagereply` VALUES ('11', '3', 'test', '18604010547', '2018-07-16 14:18:14');
INSERT INTO `messagereply` VALUES ('12', '30', '1111', '18604010547', '2018-07-16 15:43:26');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `lid` int(11) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `actual` double DEFAULT NULL,
  `status` char(255) DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  `transactionid` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `fk_lid1` (`lid`),
  KEY `fk_qid4` (`qid`),
  KEY `fk_cid` (`openid`),
  CONSTRAINT `fk_cid` FOREIGN KEY (`openid`) REFERENCES `customer` (`phone`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_lid1` FOREIGN KEY (`lid`) REFERENCES `lesson` (`lid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_qid4` FOREIGN KEY (`qid`) REFERENCES `enterprise` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('43', '1', '150', '1', '1', '已退款', '2018-05-26 12:27:24', '1', '4200000116201805263247934519', 'skye', '138');
INSERT INTO `order` VALUES ('44', '1', '150', '1', '1', '已退款', '2018-05-26 12:27:43', '1', '4200000110201805261060715976', 'skye', '138');
INSERT INTO `order` VALUES ('45', '1', '150', '1', '1', '已退款', '2018-05-26 12:31:02', '1', '4200000130201805260683103431', 'skye', '138');
INSERT INTO `order` VALUES ('46', '1', '18604010547', '1', '1', '已付款', '2018-05-26 12:39:42', '1', '4200000109201805266997780435', 'hyf', '18604010547');
INSERT INTO `order` VALUES ('47', '1', '18604010547', '1', '1', '待付款', '2018-05-26 13:57:41', '1', '111111', 'hyf', '18604010547');
INSERT INTO `order` VALUES ('48', '1', '18604010547', '1', '1', '已退款', '2018-05-26 14:03:30', '1', '1111111111', 'hyf', '18604010547');
INSERT INTO `order` VALUES ('49', '1', '18604010547', '1', '1', '已付款', '2018-05-26 14:04:54', '1', '4200000110201805264729572488', 'hyf', '18604010547');
INSERT INTO `order` VALUES ('50', '2', '136', '1', '1', '已退款', '2018-05-26 14:05:22', '1', '4200000130201805266329195070', 'daisy', '136');
INSERT INTO `order` VALUES ('51', '1', '136', '1', '1', '待付款', '2018-05-26 14:10:43', '1', null, 'daisy', '139');
INSERT INTO `order` VALUES ('52', '2', '139', '1', '1', '待付款', '2018-05-26 14:10:50', '1', null, 'skye', '139');
INSERT INTO `order` VALUES ('53', '4', '139', '1', '1', '待付款', '2018-05-26 14:11:35', '1', null, 'skye', '139');
INSERT INTO `order` VALUES ('54', '2', '139', '1', '1', '已退款', '2018-05-26 14:19:35', '1', '4200000110201805263169394125', 'skye', '139');
INSERT INTO `order` VALUES ('55', '4', '139', '1', '1', '已付款', '2018-05-26 14:20:15', '1', '4200000138201805262717162733', 'skye', '139');
INSERT INTO `order` VALUES ('56', '1', '139', '1', '1', '已付款', '2018-06-07 16:46:55', '1', '4200000124201806070328955434', '费园园', '15940471397');
INSERT INTO `order` VALUES ('57', '1', '139', '1', '1', '已付款', '2018-06-07 17:36:42', '1', '4200000126201806078388299831', '哈哈', '123');
INSERT INTO `order` VALUES ('58', '1', '139', '1', '1', '待付款', '2018-06-07 18:38:05', '1', null, '', '');
INSERT INTO `order` VALUES ('59', '2', '139', '1', '1', '待付款', '2018-06-07 18:39:49', '1', null, '', '');
INSERT INTO `order` VALUES ('63', '1', '139', '1', '1', '退款中', '2018-06-15 11:31:05', '1', '4200000117201806150052450136', '费园园', '15940471397');
INSERT INTO `order` VALUES ('64', '1', '135', '1', '1', '已付款', '2018-06-15 11:31:18', '1', '4200000137201806155057560390', '费园园', '');
INSERT INTO `order` VALUES ('65', '1', '139', '1', '1', '待付款', '2018-06-15 14:03:47', '1', null, '', '');
INSERT INTO `order` VALUES ('66', '1', '139', '1', '1', '待付款', '2018-06-15 14:51:50', '1', null, '', '');
INSERT INTO `order` VALUES ('67', '1', '139', '1', '1', '已使用', '2018-06-19 13:02:37', '1', null, 'aa', '123');
INSERT INTO `order` VALUES ('68', '1', '139', '1', '1', '待付款', '2018-06-19 13:03:49', '1', null, 'www', '123');
INSERT INTO `order` VALUES ('69', '10', '18604010547', '1', '1', '退款中', '2018-06-19 14:27:56', '1', '4200000112201806197932997460', '费元', '');
INSERT INTO `order` VALUES ('70', '6', '139', '1', '1', '已退款', '2018-06-19 14:36:52', '1', '4200000136201806193206770784', '给', '');
INSERT INTO `order` VALUES ('71', '6', '139', '1', '1', '已退款', '2018-06-19 16:53:29', '1', '4200000118201806199959334942', '费园', '');
INSERT INTO `order` VALUES ('72', '10', '139', '1', '1', '退款中', '2018-06-21 18:55:55', '1', '4200000133201806213004102392', '费园园', '');
INSERT INTO `order` VALUES ('73', '10', '139', '1', '1', '待付款', '2018-06-22 09:10:34', '1', null, '费园园', '15940471397');
INSERT INTO `order` VALUES ('74', '11', '150', '1', '1', '待付款', '2018-07-14 20:07:50', '2', '12121212', 'test', '138');
INSERT INTO `order` VALUES ('75', '1', '18604010547', '0', '0', '待付款', '2018-07-16 15:41:34', '1', '1531726894824', '111', '11111111111');
INSERT INTO `order` VALUES ('76', '1', '139', '1', '1', '已驳回', '2018-07-30 09:51:54', '1', '12121', '111', '111');

-- ----------------------------
-- Table structure for refund
-- ----------------------------
DROP TABLE IF EXISTS `refund`;
CREATE TABLE `refund` (
  `oid` int(11) NOT NULL,
  `refundreason` varchar(3000) DEFAULT NULL,
  `refundtime` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  CONSTRAINT `fk_oid` FOREIGN KEY (`oid`) REFERENCES `order` (`oid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of refund
-- ----------------------------
INSERT INTO `refund` VALUES ('43', '', '2018-05-26 12:28:10', null);
INSERT INTO `refund` VALUES ('44', '', '2018-05-26 12:29:26', null);
INSERT INTO `refund` VALUES ('45', '', '2018-05-26 12:32:20', null);
INSERT INTO `refund` VALUES ('46', '做', '2018-05-26 12:40:15', '已处理');
INSERT INTO `refund` VALUES ('50', '111', '2018-05-26 14:22:38', '已处理');
INSERT INTO `refund` VALUES ('54', '', '2018-05-26 14:21:51', '已处理');
INSERT INTO `refund` VALUES ('55', '', '2018-05-26 14:20:43', '已处理');
INSERT INTO `refund` VALUES ('63', '', '2018-06-15 11:33:18', '待处理');
INSERT INTO `refund` VALUES ('69', '', '2018-06-19 14:38:27', '待处理');
INSERT INTO `refund` VALUES ('70', '', '2018-06-19 14:37:24', '已处理');
INSERT INTO `refund` VALUES ('71', '', '2018-06-19 16:53:55', '已处理');
INSERT INTO `refund` VALUES ('72', '', '2018-06-21 18:56:55', '待处理');

-- ----------------------------
-- Table structure for swiper
-- ----------------------------
DROP TABLE IF EXISTS `swiper`;
CREATE TABLE `swiper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qid` int(11) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `category` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_qid5` (`qid`),
  CONSTRAINT `fk_qid5` FOREIGN KEY (`qid`) REFERENCES `enterprise` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of swiper
-- ----------------------------
INSERT INTO `swiper` VALUES ('1', '1', 'http://101.201.70.204:9998/group1/M00/00/00/rBAFzFthlq6AXp3HAAAltvWxY8Y773.jpg', 'A');
INSERT INTO `swiper` VALUES ('2', '1', '1531718145086show2.jpg', 'B');
INSERT INTO `swiper` VALUES ('3', '1', '1.jpg', 'C');
INSERT INTO `swiper` VALUES ('4', '1', 'http://101.201.70.204:9998/group1/M00/00/00/rBAFzFthkTGAAUHsAAKnZXaSxqs950.jpg', 'D');
INSERT INTO `swiper` VALUES ('5', '2', '1.jpg', 'A');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(255) DEFAULT NULL,
  `tphoto_url` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  PRIMARY KEY (`tid`),
  KEY `fk_qid6` (`qid`),
  CONSTRAINT `fk_qid6` FOREIGN KEY (`qid`) REFERENCES `enterprise` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '费园园', '/upload/feiyy.jpg', '主要从事HTML5、Java开源领域及Android移动开发，在东软集团担任过6年的软件工程师，2年半的HTML5、JAVA培训讲师，承担过东北大学，北交大等重点高校培训项目。', '1');
INSERT INTO `teacher` VALUES ('2', '陈伟', '/upload/chenw.jpg', '有30多年的软件项目开发经验，有10多年的教学经验，熟悉.NET、C#、F#、C语言、Java等编程语言等，擅长C#、Java语言课程。为Microsoft、Intel、AutoDisk、南京大学、东北大学等学校和企业授过课。', '1');
INSERT INTO `teacher` VALUES ('3', '宋波', '/upload/1531717870631teacher.jpg', ' 12年开发经验，2年教学经验,精通JAVA、C、C++、C#、PHP等多种编程语言，熟悉ios，android移动平台APP开发，语言功底扎实浑厚，精通数据结构和算法，积累多套软件开发框架。', '1');
INSERT INTO `teacher` VALUES ('4', '居老师', '/upload/153170448921010.JPG', '镇生者之魂，安亡者之心，赎未亡之罪，轮未竟之回', '1');
INSERT INTO `teacher` VALUES ('6', 'test', '/upload/1531717882102teacher.jpg', 'Neusoft Neusoft Neusoft Neusoft', '1');
INSERT INTO `teacher` VALUES ('13', '面面', '/upload/1531741520586timg.jpg', '镇魂澜孩最爱的面面', '1');
INSERT INTO `teacher` VALUES ('14', '12343', '/upload/1531741598821timg.jpg', '。。。。', '1');
INSERT INTO `teacher` VALUES ('18', '中文处理', '/upload/1532659988556ZHZHZHZHtest.jpg', '中文处理', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `userpassword` varchar(255) NOT NULL,
  `qid` int(11) DEFAULT NULL,
  `jurisdiction` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_qid7` (`qid`),
  CONSTRAINT `fk_qid7` FOREIGN KEY (`qid`) REFERENCES `enterprise` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('adminadmin', 'admin', '1', '超级管理员', '1');
INSERT INTO `user` VALUES ('feiyy', '123456', '1', '管理员', '5');
INSERT INTO `user` VALUES ('skye', '123456', '1', '管理员', '6');
INSERT INTO `user` VALUES ('test', '123456', '2', '管理员', '7');

-- ----------------------------
-- Function structure for func_currval
-- ----------------------------
DROP FUNCTION IF EXISTS `func_currval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `func_currval`(seq_name varchar(50)) RETURNS int(11)
begin
 declare value integer;
 set value = 0;
 select current_value into value
 from seq
 where name = seq_name;
 return value;
end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for func_nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `func_nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `func_nextval`(seq_name varchar(50)) RETURNS int(11)
begin
 update seq
 set current_value = current_value + increment_value
 where name = seq_name;
 return func_currval(seq_name);
end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for func_setval
-- ----------------------------
DROP FUNCTION IF EXISTS `func_setval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `func_setval`(seq_name varchar(50),value integer) RETURNS int(11)
begin
 update seq
 set current_value = value
 where name = seq_name;
 return func_currval(seq_name);
end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `nextval`(str varchar(50)) RETURNS int(11)
begin  
    declare i int;  
    set i=(select start_value from emp_seq where name=str);  
    update emp_seq  
        set start_value=i+increment_value  
    where name=str;  
return i;  
end
;;
DELIMITER ;
