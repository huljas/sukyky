-- Stock table
CREATE TABLE stock (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY INDEX_NAME (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

