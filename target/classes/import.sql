create database test;
use database test;
CREATE TABLE product (
  id int(11) NOT NULL auto_increment,
  name varchar(255),
  description varchar (255)
  price int(11) ,
url varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO product (`name`, `description`, `price`) VALUES ('GrowBox', 'Our main product', 30000);
INSERT INTO product (`name`, `description`, `price`) VALUES ('Fertilizer', 'liquid syntetic fertilizer', 400);
INSERT INTO product (`name`, `description`, `price`) VALUES ('seeds', 'beet seeds', 100);