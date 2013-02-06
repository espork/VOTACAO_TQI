CREATE DATABASE  votacao_tqi;

USE votacao_tqi;

CREATE TABLE  votacao_tqi.poll (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE  votacao_tqi.Item (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  poll_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  KEY poll_fk (poll_id),
  CONSTRAINT poll_fk FOREIGN KEY (poll_id) REFERENCES poll (id)
);


CREATE TABLE  votacao_tqi.Opinion (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  ip varchar(255) DEFAULT NULL,
  item_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY ITEM_FK (item_id),
  CONSTRAINT ITEM_FK FOREIGN KEY (item_id) REFERENCES item (id)
);