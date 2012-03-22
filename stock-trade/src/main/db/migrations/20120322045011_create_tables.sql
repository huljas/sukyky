-- Create tables
CREATE TABLE `stock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `trader` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `trade_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `priceA` int(11) NOT NULL,
  `time` datetime DEFAULT NULL,
  `buyer_id` bigint(20) DEFAULT NULL,
  `seller_id` bigint(20) DEFAULT NULL,
  `stock_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ORDER_BUYER` (`buyer_id`),
  KEY `FK_ORDER_SELLER` (`seller_id`),
  KEY `FK_ORDER_STOCK` (`stock_id`),
  CONSTRAINT `FK_ORDER_STOCK` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`),
  CONSTRAINT `FK_ORDER_BUYER` FOREIGN KEY (`buyer_id`) REFERENCES `trader` (`id`),
  CONSTRAINT `FK_ORDER_SELLER` FOREIGN KEY (`seller_id`) REFERENCES `trader` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `holding` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` int(11) NOT NULL,
  `owner_id` bigint(20) DEFAULT NULL,
  `stock_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_HOLDING_STOCK` (`stock_id`),
  KEY `FK_HOLDING_OWNER` (`owner_id`),
  CONSTRAINT `FK_HOLDING_OWNER` FOREIGN KEY (`owner_id`) REFERENCES `trader` (`id`),
  CONSTRAINT `FK_HOLDING_STOCK` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

