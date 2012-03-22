/*
SQLyog Community Edition- MySQL GUI v8.2 
MySQL - 5.1.40-community : Database - sukyky
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `holding` */

CREATE TABLE `holding` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` int(11) NOT NULL,
  `owner_id` bigint(20) DEFAULT NULL,
  `stock_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA44B8EA3C3AFCB32` (`stock_id`),
  KEY `FKA44B8EA3CB63477D` (`owner_id`),
  CONSTRAINT `FKA44B8EA3CB63477D` FOREIGN KEY (`owner_id`) REFERENCES `trader` (`id`),
  CONSTRAINT `FKA44B8EA3C3AFCB32` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=latin1;

/*Data for the table `holding` */

insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (1,0,1,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (2,50,1,2);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (3,1000,2,3);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (4,20,2,4);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (5,40,3,5);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (6,1000,3,6);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (7,20,3,2);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (8,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (9,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (10,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (11,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (12,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (13,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (14,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (15,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (16,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (17,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (18,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (19,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (20,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (21,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (22,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (23,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (24,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (25,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (26,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (27,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (28,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (29,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (30,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (31,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (32,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (33,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (34,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (35,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (36,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (37,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (38,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (39,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (40,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (41,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (42,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (43,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (44,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (45,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (46,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (47,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (48,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (49,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (50,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (51,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (52,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (53,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (54,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (55,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (56,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (57,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (58,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (59,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (60,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (61,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (62,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (63,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (64,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (65,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (66,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (67,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (68,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (69,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (70,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (71,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (72,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (73,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (74,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (75,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (76,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (77,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (78,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (79,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (80,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (81,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (82,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (83,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (84,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (85,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (86,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (87,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (88,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (89,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (90,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (91,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (92,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (93,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (94,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (95,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (96,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (97,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (98,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (99,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (100,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (101,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (102,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (103,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (104,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (105,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (106,1,2,1);
insert  into `holding`(`id`,`amount`,`owner_id`,`stock_id`) values (107,1,2,1);

/*Table structure for table `stock` */

CREATE TABLE `stock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `stock` */

insert  into `stock`(`id`,`name`) values (1,'Apple');
insert  into `stock`(`id`,`name`) values (6,'Cisco');
insert  into `stock`(`id`,`name`) values (5,'Dell');
insert  into `stock`(`id`,`name`) values (2,'Google');
insert  into `stock`(`id`,`name`) values (3,'Nokia');
insert  into `stock`(`id`,`name`) values (4,'Sampo');

/*Table structure for table `tradeorder` */

CREATE TABLE `tradeorder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `priceA` int(11) NOT NULL,
  `time` datetime DEFAULT NULL,
  `buyer_id` bigint(20) DEFAULT NULL,
  `seller_id` bigint(20) DEFAULT NULL,
  `stock_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE5BBC06A2DECD87D` (`buyer_id`),
  KEY `FKE5BBC06AE072731` (`seller_id`),
  KEY `FKE5BBC06AC3AFCB32` (`stock_id`),
  CONSTRAINT `FKE5BBC06AC3AFCB32` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`),
  CONSTRAINT `FKE5BBC06A2DECD87D` FOREIGN KEY (`buyer_id`) REFERENCES `trader` (`id`),
  CONSTRAINT `FKE5BBC06AE072731` FOREIGN KEY (`seller_id`) REFERENCES `trader` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=latin1;

/*Data for the table `tradeorder` */

insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (1,60000,'2012-03-22 07:41:53',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (2,60000,'2012-03-22 07:41:53',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (3,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (4,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (5,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (6,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (7,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (8,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (9,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (10,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (11,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (12,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (13,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (14,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (15,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (16,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (17,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (18,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (19,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (20,60000,'2012-03-22 07:41:54',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (21,60000,'2012-03-22 07:41:55',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (22,60000,'2012-03-22 07:41:55',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (23,60000,'2012-03-22 07:41:55',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (24,60000,'2012-03-22 07:41:55',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (25,60000,'2012-03-22 07:41:55',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (26,60000,'2012-03-22 07:41:55',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (27,60000,'2012-03-22 07:41:55',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (28,60000,'2012-03-22 07:41:55',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (29,60000,'2012-03-22 07:41:55',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (30,60000,'2012-03-22 07:41:55',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (31,60000,'2012-03-22 07:41:55',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (32,60000,'2012-03-22 07:41:55',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (33,60000,'2012-03-22 07:41:55',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (34,60000,'2012-03-22 07:41:55',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (35,60000,'2012-03-22 07:41:55',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (36,60000,'2012-03-22 07:41:55',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (37,60000,'2012-03-22 07:41:56',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (38,60000,'2012-03-22 07:41:56',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (39,60000,'2012-03-22 07:41:56',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (40,60000,'2012-03-22 07:41:56',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (41,60000,'2012-03-22 07:41:56',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (42,60000,'2012-03-22 07:41:56',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (43,60000,'2012-03-22 07:41:56',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (44,60000,'2012-03-22 07:41:56',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (45,60000,'2012-03-22 07:41:56',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (46,60000,'2012-03-22 07:41:56',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (47,60000,'2012-03-22 07:41:56',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (48,60000,'2012-03-22 07:41:56',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (49,60000,'2012-03-22 07:41:56',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (50,60000,'2012-03-22 07:41:56',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (51,60000,'2012-03-22 07:41:56',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (52,60000,'2012-03-22 07:41:57',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (53,60000,'2012-03-22 07:41:57',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (54,60000,'2012-03-22 07:41:57',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (55,60000,'2012-03-22 07:41:57',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (56,60000,'2012-03-22 07:41:57',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (57,60000,'2012-03-22 07:41:57',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (58,60000,'2012-03-22 07:41:57',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (59,60000,'2012-03-22 07:41:57',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (60,60000,'2012-03-22 07:41:57',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (61,60000,'2012-03-22 07:41:57',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (62,60000,'2012-03-22 07:41:57',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (63,60000,'2012-03-22 07:41:57',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (64,60000,'2012-03-22 07:41:57',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (65,60000,'2012-03-22 07:41:57',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (66,60000,'2012-03-22 07:41:57',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (67,60000,'2012-03-22 07:41:58',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (68,60000,'2012-03-22 07:41:58',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (69,60000,'2012-03-22 07:41:58',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (70,60000,'2012-03-22 07:41:58',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (71,60000,'2012-03-22 07:41:58',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (72,60000,'2012-03-22 07:41:58',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (73,60000,'2012-03-22 07:41:58',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (74,60000,'2012-03-22 07:41:58',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (75,60000,'2012-03-22 07:41:58',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (76,60000,'2012-03-22 07:41:58',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (77,60000,'2012-03-22 07:41:58',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (78,60000,'2012-03-22 07:41:58',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (79,60000,'2012-03-22 07:41:58',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (80,60000,'2012-03-22 07:41:58',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (81,60000,'2012-03-22 07:41:59',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (82,60000,'2012-03-22 07:41:59',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (83,60000,'2012-03-22 07:41:59',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (84,60000,'2012-03-22 07:41:59',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (85,60000,'2012-03-22 07:41:59',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (86,60000,'2012-03-22 07:41:59',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (87,60000,'2012-03-22 07:41:59',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (88,60000,'2012-03-22 07:41:59',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (89,60000,'2012-03-22 07:41:59',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (90,60000,'2012-03-22 07:41:59',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (91,60000,'2012-03-22 07:41:59',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (92,60000,'2012-03-22 07:41:59',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (93,60000,'2012-03-22 07:41:59',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (94,60000,'2012-03-22 07:41:59',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (95,60000,'2012-03-22 07:42:00',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (96,60000,'2012-03-22 07:42:00',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (97,60000,'2012-03-22 07:42:00',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (98,60000,'2012-03-22 07:42:00',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (99,60000,'2012-03-22 07:42:00',2,1,1);
insert  into `tradeorder`(`id`,`priceA`,`time`,`buyer_id`,`seller_id`,`stock_id`) values (100,60000,'2012-03-22 07:42:00',2,1,1);

/*Table structure for table `trader` */

CREATE TABLE `trader` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `trader` */

insert  into `trader`(`id`,`name`) values (2,'Bill');
insert  into `trader`(`id`,`name`) values (1,'Bob');
insert  into `trader`(`id`,`name`) values (3,'George');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
