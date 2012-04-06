-- Trade table
CREATE TABLE trade (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  price int(11) NOT NULL,
  time datetime DEFAULT NULL,
  stock_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  KEY FK_ORDER_STOCK (stock_id),
  CONSTRAINT FK_ORDER_STOCK FOREIGN KEY (stock_id) REFERENCES stock (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
