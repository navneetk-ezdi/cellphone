create database cellphone;

CREATE TABLE `CELLPHONE_BRAND` (
	`CELLPHONE_ID` int(3) NOT NULL AUTO_INCREMENT,
	`CELLPHONE_BRAND` varchar(45) NOT NULL,
	PRIMARY KEY (`CELLPHONE_ID`)
);
 
CREATE TABLE `CELLPHONE_MODEL` (
	`MODEL_ID` int(11) NOT NULL AUTO_INCREMENT,
	`MODEL_NAME` varchar(128) NOT NULL,
	`MODEL_COLOR` varchar(10) NOT NULL,
	`MODEL_SCREEN_SIZE` float(3,1) NOT NULL,
	`MODEL_TYPE` varchar(10) NOT NULL,
	`MODEL_OS` varchar(20) NOT NULL,
	`MODEL_PROCESSOR` varchar(50) NOT NULL,
	`MODEL_RAM` int(6) NOT NULL,
	`MODEL_INTERNAL_MEMORY` int(6) NOT NULL,
	`MODEL_LENGTH` float(3,1) NOT NULL,
	`MODEL_BREADTH` float(3,1) NOT NULL,
	`MODEL_THICKNESS` float(3,1) NOT NULL,
	`MODEL_RELEASE_DATE` date NOT NULL,
    `CELLPHONE_ID` int(3) NOT NULL,
	PRIMARY KEY (`MODEL_ID`),
	KEY `CELLPHONE_FK` (`CELLPHONE_ID`),
	CONSTRAINT `CELLPHONE_FK` FOREIGN KEY (`CELLPHONE_ID`) REFERENCES `CELLPHONE_BRAND` (`CELLPHONE_ID`)
);

CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));
   
CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
  
INSERT INTO users(username,password,enabled)
VALUES ('navneet','nvnt8891', true);
INSERT INTO users(username,password,enabled)
VALUES ('kunal','nvnt8891', true);
 
INSERT INTO user_roles (username, role)
VALUES ('navneet', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('kunal', 'ROLE_ADMIN');