/*
Navicat MySQL Data Transfer

Source Server         : user
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : blogdb

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2021-12-22 17:51:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `Id` int(4) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL COMMENT '博文标题',
  `Context` text COMMENT '博文内容',
  `CreatedTime` datetime DEFAULT NULL COMMENT '发布时间',
  `ClassId` int(4) NOT NULL COMMENT '所属分类编号',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '计算机', 'Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点，还摒弃了C++里难以理解的多继承、指针等概念，因此Java语言具有功能强大和简单易用两个特征。Java语言作为静态面向对象编程语言的代表，极好地实现了面向对象理论，允许程序员以优雅的思维方式进行复杂的编程 [1]  。', '2021-12-03 00:00:00', '2');
INSERT INTO `blog` VALUES ('4', '毛泽东', '毛泽东（1893年12月26日-1976年9月9日），字润之（原作咏芝，后改润芝），笔名子任。湖南湘潭人。中国人民的领袖，伟大的马克思主义者，伟大的无产阶级革命家 [23]  、战略家、理论家，中国共产党、中国人民解放军和中华人民共和国的主要缔造者和领导人，马克思主义中国化的伟大开拓者，近代以来中国伟大的爱国者和民族英雄，中国共产党第一代中央领导集体的核心，领导中国人民彻底改变自己命运和国家面貌的一代伟人 [16]  [23]  。', '2021-12-05 00:00:00', '3');
INSERT INTO `blog` VALUES ('6', '邓小平', '邓小平（1904年8月22日-1997年2月19日），原名邓先圣，学名邓希贤，四川广安人。早年赴欧洲勤工俭学，归国后，他全身心地投入党领导的争取民族独立和人民解放的革命斗争。从土地革命、抗日战争到解放战争，先后担任党和军队的许多重要领导职务，为党中央一系列重大战略决策的实施，为新民主主义革命的胜利和新中国的诞生，建立了赫赫功勋，成为中华人民共和国的开国元勋。 [1] ', '2021-12-05 00:00:00', '3');
INSERT INTO `blog` VALUES ('17', '博客管理系统', '我很牛逼', '2021-12-04 18:11:57', '1');
INSERT INTO `blog` VALUES ('22', '张三', '张', '2021-12-05 19:34:18', '5');
INSERT INTO `blog` VALUES ('23', 'test', 'test', '2021-12-05 19:43:27', '1');
INSERT INTO `blog` VALUES ('25', 'springbioot', 'Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，Spring Boot致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者。', '2021-12-05 22:35:41', '9');
INSERT INTO `blog` VALUES ('26', 'SSM', 'spring springmvc mybatis', '2021-12-06 11:04:57', '10');
INSERT INTO `blog` VALUES ('28', '12321421', '21421421', '2021-12-06 19:39:33', '10');
INSERT INTO `blog` VALUES ('29', '12321321421', '321421421', '2021-12-06 19:41:07', '10');
INSERT INTO `blog` VALUES ('31', '1312', '321321', '2021-12-07 08:54:24', '12');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `Id` int(4) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL COMMENT '分类名称',
  `Sort` int(4) NOT NULL COMMENT '排序',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '娱乐', '1');
INSERT INTO `class` VALUES ('2', '科技', '2');
INSERT INTO `class` VALUES ('3', '政治', '3');
INSERT INTO `class` VALUES ('5', '汽车', '4');
INSERT INTO `class` VALUES ('8', '科学', '6');
INSERT INTO `class` VALUES ('9', '博客', '5');
INSERT INTO `class` VALUES ('10', 'SSM框架', '7');
INSERT INTO `class` VALUES ('12', '测试', '19');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `Id` int(4) NOT NULL AUTO_INCREMENT,
  `Context` text COMMENT '评论内容',
  `CreatedTime` datetime NOT NULL COMMENT '评论时间',
  `UserName` varchar(50) NOT NULL COMMENT '评论人',
  `BlogId` int(4) NOT NULL COMMENT '评论的博文编号',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('2', '厉害了', '2021-12-05 00:00:00', '2', '1');
INSERT INTO `comment` VALUES ('5', '厉害', '2021-12-04 16:17:44', '2', '6');
INSERT INTO `comment` VALUES ('6', '强', '2021-12-04 13:00:00', '2', '6');
INSERT INTO `comment` VALUES ('8', '66', '2021-12-04 00:00:00', '2', '1');
INSERT INTO `comment` VALUES ('11', '2333', '2021-12-03 00:00:00', '2', '4');
INSERT INTO `comment` VALUES ('13', '7', '2021-12-04 00:00:00', '2', '6');
INSERT INTO `comment` VALUES ('18', '123', '2021-12-05 22:12:41', 'zhangsan', '1');
INSERT INTO `comment` VALUES ('19', '123', '2021-12-05 22:12:41', 'zhangsan', '1');
INSERT INTO `comment` VALUES ('20', '123', '2021-12-05 22:12:41', 'zhangsan', '1');
INSERT INTO `comment` VALUES ('21', '法外狂徒', '2021-12-05 22:14:40', 'zhangsan', '17');
INSERT INTO `comment` VALUES ('22', 'test', '2021-12-05 22:14:59', 'zhangsan', '23');
INSERT INTO `comment` VALUES ('23', 'test', '2021-12-05 22:15:09', 'zhangsan', '23');
INSERT INTO `comment` VALUES ('24', 'test', '2021-12-05 22:15:09', 'zhangsan', '23');
INSERT INTO `comment` VALUES ('25', 'test', '2021-12-05 22:15:09', 'zhangsan', '23');
INSERT INTO `comment` VALUES ('26', 'test', '2021-12-05 22:15:09', 'zhangsan', '23');
INSERT INTO `comment` VALUES ('27', 'test', '2021-12-05 22:15:09', 'zhangsan', '23');
INSERT INTO `comment` VALUES ('28', '123', '2021-12-05 22:15:20', 'zhangsan', '23');
INSERT INTO `comment` VALUES ('37', 'zhangsan', '2021-12-05 22:28:20', 'zhangsan', '1');
INSERT INTO `comment` VALUES ('38', 'zhangsan', '2021-12-05 22:28:21', 'zhangsan', '1');
INSERT INTO `comment` VALUES ('39', 'zhangsan', '2021-12-05 22:28:21', 'zhangsan', '1');
INSERT INTO `comment` VALUES ('40', 'zhangsan', '2021-12-05 22:28:21', 'zhangsan', '1');
INSERT INTO `comment` VALUES ('41', 'zhaosi', '2021-12-05 22:30:44', 'zhangsan', '1');
INSERT INTO `comment` VALUES ('42', 'eqweqw', '2021-12-06 17:07:10', 'zhangsan', '6');
INSERT INTO `comment` VALUES ('43', 'zhangsan', '2021-12-06 20:09:50', '', '28');
INSERT INTO `comment` VALUES ('68', '123', '2021-12-06 20:31:14', '', '4');
INSERT INTO `comment` VALUES ('69', '312312', '2021-12-06 20:31:34', '', '1');
INSERT INTO `comment` VALUES ('70', '12312', '2021-12-06 20:35:06', '', '1');
INSERT INTO `comment` VALUES ('71', '测试', '2021-12-06 20:38:30', '1', '1');
INSERT INTO `comment` VALUES ('79', '1', '2021-12-06 20:53:25', '1', '4');
INSERT INTO `comment` VALUES ('80', '1', '2021-12-06 20:53:27', '1', '4');
INSERT INTO `comment` VALUES ('81', '1123', '2021-12-06 20:53:30', '1', '4');
INSERT INTO `comment` VALUES ('82', '1312312', '2021-12-06 20:53:42', '', '4');
INSERT INTO `comment` VALUES ('83', '21312312', '2021-12-06 21:01:52', '1', '6');
INSERT INTO `comment` VALUES ('84', '321321312321421412', '2021-12-06 21:01:55', '1', '6');
INSERT INTO `comment` VALUES ('85', '3', '2021-12-06 21:02:19', '1', '6');
INSERT INTO `comment` VALUES ('86', '132q32', '2021-12-07 08:55:59', '1', '4');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `UserName` varchar(16) NOT NULL COMMENT '用户名',
  `Password` varchar(255) NOT NULL COMMENT '密码',
  `Email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `Power` varchar(50) NOT NULL COMMENT 'admin-管理员;user-一般用户1',
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '356a192b7913b04c54574d18c28d46e6395428ab', '1', 'user');
INSERT INTO `users` VALUES ('2', 'da4b9237bacccdf19c0760cab7aec4a8359010b0', '2', 'admin');
