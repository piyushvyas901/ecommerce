DROP TABLE IF EXISTS billionaires;
 
CREATE TABLE billionaires (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);

DROP TABLE IF EXISTS UserDetailsAndInfo ;

CREATE TABLE UserDetailsAndInfo (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL UNIQUE,
  last_name VARCHAR(250) NOT NULL,
  password VARCHAR(250) DEFAULT NULL
);
 

DROP TABLE IF EXISTS UserDB;
 
CREATE TABLE UserDB (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  password VARCHAR(250) DEFAULT NULL
);
 
DROP TABLE IF EXISTS CATEGORY;

CREATE TABLE CATEGORY( 
  category_id INT PRIMARY KEY, 
  product_category VARCHAR(255) NOT NULL
);
 
 
DROP TABLE IF EXISTS PRODUCTS;

CREATE TABLE PRODUCTS( 
  PRODUCT_ID INT AUTO_INCREMENT  PRIMARY KEY,
  CATEGORY_ID INT,
  PRODUCT_NAME VARCHAR(255) NOT NULL,
  PRICE INT,
  foreign key (CATEGORY_ID) REFERENCES CATEGORY(CATEGORY_ID)
);



 DROP TABLE IF EXISTS ORDERCART;
 
 CREATE TABLE ORDERCART( 
  ORDER_ID INT AUTO_INCREMENT  PRIMARY KEY,
  PRODUCT_ID INT,
  DATE_OF_ORDER VARCHAR(255) NOT NULL,
 foreign key (PRODUCT_ID) REFERENCES PRODUCTS(PRODUCT_ID));

 