CREATE DATABASE  IF NOT EXISTS monarca;
USE monarca;


DROP TABLE IF EXISTS build;
CREATE TABLE build (
  id int(11) NOT NULL AUTO_INCREMENT,
  description varchar(45) DEFAULT NULL,
  version VARCHAR(15) DEFAULT NULL,
  branch int (11) DEFAULT NULL,
  CONSTRAINT  PkBuild PRIMARY KEY (id)
);

DROP TABLE IF EXISTS branch;
CREATE TABLE branch (
  id int(11) NOT NULL AUTO_INCREMENT,
  description varchar(45) DEFAULT NULL,
  createdOn date DEFAULT NULL,
  project int (11) DEFAULT NULL,
  CONSTRAINT  PkBuild PRIMARY KEY (id)
);

DROP TABLE IF EXISTS project;
CREATE TABLE project (
  id int(11) NOT NULL AUTO_INCREMENT,
  description varchar(45) DEFAULT NULL,
  createdOn date DEFAULT NULL,
  CONSTRAINT  PkProject PRIMARY KEY (id)
); 

DROP TABLE IF EXISTS role;
CREATE TABLE role (
	id int(11) NOT NULL AUTO_INCREMENT,
	roleName VARCHAR(45) DEFAULT NULL,
	CONSTRAINT  PkRole PRIMARY KEY (id)
);

DROP TABLE IF EXISTS user;
CREATE TABLE user (
	id int(11) NOT NULL AUTO_INCREMENT,
	userName VARCHAR(45) DEFAULT NULL,
    password VARCHAR(45) DEFAULT NULL,
	CONSTRAINT  PkUser PRIMARY KEY (id)
);

DROP TABLE IF EXISTS userRole;
CREATE TABLE userRole (
	user int(11) NOT NULL,
	role int(11) NOT NULL,
	PRIMARY KEY (user,role)
);


DROP TABLE IF EXISTS topic;
CREATE TABLE topic (
	id int(11) NOT NULL AUTO_INCREMENT,
	topicName VARCHAR(45) DEFAULT NULL,
	topicKey varchar(45),
	CONSTRAINT  PkTopic PRIMARY KEY (id)
);

DROP TABLE IF EXISTS activity;
CREATE TABLE activity (
	id int(11) NOT NULL AUTO_INCREMENT,
	activityName VARCHAR(45) DEFAULT NULL,
	topic int(11) not null,
	role int(11) not null,
	CONSTRAINT PkActivityb PRIMARY KEY (id)
);