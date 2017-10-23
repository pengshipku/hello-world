/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-22 18:58:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '1', 'iUOoOdMAl7FsB1Kig37hmg==');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `cover` varchar(255) DEFAULT NULL COMMENT '封面',
  `price` float DEFAULT NULL COMMENT '价格',
  `intro` varchar(1024) DEFAULT NULL COMMENT '介绍',
  `auther` varchar(255) DEFAULT NULL COMMENT '作者',
  `press` varchar(255) DEFAULT NULL COMMENT '出版社',
  `pubdate` date DEFAULT NULL COMMENT '出版日期',
  `special` int(1) DEFAULT '0' COMMENT '特卖',
  `news` int(1) DEFAULT '0' COMMENT '新书',
  `sale` int(1) DEFAULT '0' COMMENT '打折',
  `category_id` int(11) DEFAULT NULL COMMENT '分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('41', 'Aptamil', 'picture/17062222963.png', '50', 'Danone\'s milk powder quality is guaranteed, although the formula is equal, but the alpine milk and plentiful DHA are the biggest selling points.', 'Germay', 'DaNeng', '2017-06-22', '1', '0', '1', '1');
INSERT INTO `book` VALUES ('42', 'Babybio', 'picture/17062203909.png', '40', 'The formula is more refined and more refined than other organic milk powder. It is rich in milk and bifidobacteria, which regulates the stomach and intestines.', 'France', 'Babybio', '2017-06-22', '0', '1', '0', '1');
INSERT INTO `book` VALUES ('43', 'HiPP', 'picture/17062210748.png', '100', 'Not only the milk powder, but also the use of the milk powder, so far, the baby face cream and so on. Affordable and safe, it belongs to the affordable brand of the organic world.', 'Germary', 'Germary', '2017-06-22', '0', '1', '0', '1');
INSERT INTO `book` VALUES ('44', 'Karivare', 'picture/17062205128.png', '80', 'The New Zealand version of the Toatl Omega 3 component is 108mg, which is a necessary component of baby brain development. It is a polyunsaturated fatty acid, and its high quality New Zealand milk source is also a highlight.', 'Xinxilan', 'Xinxilan', '2017-06-22', '1', '0', '1', '1');
INSERT INTO `book` VALUES ('45', 'Apple', 'picture/17062238942.png', '2', 'Apple is a low-calorie food that produces 60 kilocalories per 100 grams. The nutrition composition of apple is soluble, easy to be absorbed by the body, so there is called \"fresh water\", which is beneficial to dissolve sulfur element and lubricate the skin.', 'China', 'China', '2017-06-22', '1', '1', '0', '2');
INSERT INTO `book` VALUES ('46', 'Pear', 'picture/17062230390.png', '4', 'The fruit of the pear is usually used to eat, not only the flavor of the sweet, sweet, but also nutritious, contains a variety of vitamins and fiber, different kinds of pear taste and texture are completely different. Pears are either raw or cooked. In terms of medical efficacy, pears can be constipated, digested and beneficial to cardiovascular.', 'China', 'China', '2017-06-22', '1', '0', '0', '2');
INSERT INTO `book` VALUES ('47', 'Orange', 'picture/17062259530.png', '5', 'Vitamin A in oranges can also enhance the body\'s vision and treatment of night blindness in dark environments. Orange should not eat too much, eat too much can suffer from beta-carotenemia, the skin is deep yellow, like jaundice.', 'China', 'China', '2017-06-22', '0', '0', '0', '2');
INSERT INTO `book` VALUES ('48', 'Watermellon juice', 'picture/17062247864.png', '10', 'It is used to extract the juice from the physical methods such as pressing, centrifugation and extraction.', 'China', 'China', '2017-06-22', '0', '1', '0', '14');
INSERT INTO `book` VALUES ('49', 'Lemon juice', 'picture/17062201767.png', '14', 'The effect of mango juice and function is very wide, mango juice had good antioxidant functions, so can have the benefit of delay aging, mango juice can improve our immune ability, protect our body, mango juice can clean our liver, kidney and blood.', 'China', 'China', '2017-06-22', '1', '0', '0', '14');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'Milk');
INSERT INTO `category` VALUES ('2', 'Fruit');
INSERT INTO `category` VALUES ('14', 'Healthy Juice');

-- ----------------------------
-- Table structure for `indent`
-- ----------------------------
DROP TABLE IF EXISTS `indent`;
CREATE TABLE `indent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total` float DEFAULT NULL COMMENT '总价',
  `amount` int(11) DEFAULT NULL COMMENT '商品总数',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态(1未处理/2已处理)',
  `name` varchar(20) DEFAULT NULL COMMENT '收货人姓名',
  `phone` varchar(20) DEFAULT NULL COMMENT '收货人电话',
  `address` varchar(255) DEFAULT NULL COMMENT '收货地址',
  `systime` datetime DEFAULT NULL COMMENT '下单时间',
  `user_id` int(11) DEFAULT NULL COMMENT '下单用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of indent
-- ----------------------------

-- ----------------------------
-- Table structure for `items`
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` float DEFAULT NULL COMMENT '购买时价格',
  `amount` int(11) DEFAULT NULL COMMENT '数量',
  `book_id` int(11) DEFAULT NULL,
  `indent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Host` char(60) COLLATE utf8_bin NOT NULL DEFAULT '',
  `User` char(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `Select_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Insert_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Update_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Delete_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Create_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Drop_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Reload_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Shutdown_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Process_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `File_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Grant_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `References_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Index_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Alter_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Show_db_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Super_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Create_tmp_table_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Lock_tables_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Execute_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Repl_slave_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Repl_client_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Create_view_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Show_view_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Create_routine_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Alter_routine_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Create_user_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Event_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Trigger_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `Create_tablespace_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `ssl_type` enum('','ANY','X509','SPECIFIED') CHARACTER SET utf8 NOT NULL DEFAULT '',
  `ssl_cipher` blob NOT NULL,
  `x509_issuer` blob NOT NULL,
  `x509_subject` blob NOT NULL,
  `max_questions` int(11) unsigned NOT NULL DEFAULT '0',
  `max_updates` int(11) unsigned NOT NULL DEFAULT '0',
  `max_connections` int(11) unsigned NOT NULL DEFAULT '0',
  `max_user_connections` int(11) unsigned NOT NULL DEFAULT '0',
  `plugin` char(64) COLLATE utf8_bin NOT NULL DEFAULT 'mysql_native_password',
  `authentication_string` text COLLATE utf8_bin,
  `password_expired` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  `password_last_changed` timestamp NULL DEFAULT NULL,
  `password_lifetime` smallint(5) unsigned DEFAULT NULL,
  `account_locked` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',
  PRIMARY KEY (`Host`,`User`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and global privileges';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('localhost', 'root', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', '', '', '', '', '0', '0', '0', '0', 'mysql_native_password', 0x2A38314635453231453335343037443838344136434434413733314145424642364146323039453142, 'N', '2017-06-11 10:25:40', null, 'N');
INSERT INTO `user` VALUES ('localhost', 'mysql.sys', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', '', '', '', '', '0', '0', '0', '0', 'mysql_native_password', 0x2A5448495349534E4F544156414C494450415353574F52445448415443414E42455553454448455245, 'N', '2017-05-19 12:52:34', null, 'Y');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '1', 'iUOoOdMAl7FsB1Kig37hmg==', '12312341234');
INSERT INTO `users` VALUES ('2', '哈哈', 'yJOXpxCuYkm+zIQrRHPdpQ==', '123');
