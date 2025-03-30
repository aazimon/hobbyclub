# Create the database.
CREATE DATABASE `HobbyClub`

# Create application user
CREATE USER 'HobbyClubApp'@'%' IDENTIFIED BY '##########';

# setup permissions
GRANT SELECT, DELETE, INSERT, UPDATE ON hobbyclub.* TO 'HobbyClubApp'@'%';
FLUSH PRIVILEGES;

SHOW GRANTS FOR 'HobbyClubApp'@'%';

# create location tables.
CREATE TABLE `state` (
	`stateId` INT(11) NOT NULL,
	`name` VARCHAR(100) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`createDatetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`stateId`) USING BTREE,
	UNIQUE INDEX `Unique_Name` (`name`) USING BTREE
)
COMMENT='States of the US'
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `city` (
	`cityId` INT(11) NOT NULL,
	`name` VARCHAR(120) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`stateId` INT(11) NOT NULL,
	`createDatetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`cityId`) USING BTREE,
	UNIQUE INDEX `Unique_Name_State` (`name`, `stateId`) USING BTREE,
	INDEX `FK_City_State` (`stateId`) USING BTREE,
	CONSTRAINT `FK_City_State` FOREIGN KEY (`stateId`) REFERENCES `state` (`stateId`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
# Create categories (domain data)
CREATE TABLE `categories` (
	`categoryId` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`createDatetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`categoryId`) USING BTREE
)
COMMENT='Categories of Interest, allows grouping clubs together and ease searching.'
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
# Create account table
CREATE TABLE `accounts` (
	`accountId` INT(11) NOT NULL AUTO_INCREMENT,
	`firstName` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`lastName` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`nickName` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_general_ci',
	`stateId` INT(11) NOT NULL,
	`cityId` INT(11) NOT NULL DEFAULT '0',
	`createDatetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	`active` CHAR(1) NOT NULL DEFAULT 'A' COLLATE 'latin1_general_ci',
	PRIMARY KEY (`accountId`) USING BTREE,
	UNIQUE INDEX `Unique_NickName` (`nickName`) USING BTREE,
	INDEX `FK_Account_State` (`stateId`) USING BTREE,
	INDEX `FK_Account_City` (`cityId`) USING BTREE,
	CONSTRAINT `FK_Account_City` FOREIGN KEY (`cityId`) REFERENCES `city` (`cityId`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Account_State` FOREIGN KEY (`stateId`) REFERENCES `state` (`stateId`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COMMENT='Accounts for each registered user of Hobby Club'
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
# Create user interest
CREATE TABLE `userinterest` (
	`accountId` INT(11) NOT NULL,
	`categoryId` INT(11) NOT NULL,
	`create_datetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	UNIQUE INDEX `ComboKey_User_Category` (`accountId`, `categoryId`) USING BTREE,
	INDEX `FK_UserInterest_Category` (`categoryId`) USING BTREE,
	CONSTRAINT `FK_UserInterest_Account` FOREIGN KEY (`accountId`) REFERENCES `accounts` (`accountId`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_UserInterest_Category` FOREIGN KEY (`categoryId`) REFERENCES `categories` (`categoryId`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COMMENT='Linking Users to their category interest.'
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
# Create the main clubs table.
CREATE TABLE `clubs` (
	`clubId` INT(11) NOT NULL,
	`name` VARCHAR(100) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`description` VARCHAR(1000) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`cityId` INT(11) NOT NULL,
	`stateId` INT(11) NOT NULL,
	`categoryId` INT(11) NOT NULL,
	`creatorId` INT(11) NOT NULL,
	`createDatetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	`active` CHAR(1) NOT NULL DEFAULT 'A' COLLATE 'latin1_general_ci',
	PRIMARY KEY (`clubId`) USING BTREE,
	UNIQUE INDEX `Unique_Name_State` (`name`, `stateId`) USING BTREE,
	INDEX `FK_Club_State` (`stateId`) USING BTREE,
	INDEX `FK_Club_City` (`cityId`) USING BTREE,
	INDEX `FK_Club_Category` (`categoryId`) USING BTREE,
	INDEX `FK_Club_Account` (`creatorId`) USING BTREE,
	CONSTRAINT `FK_Club_Account` FOREIGN KEY (`creatorId`) REFERENCES `accounts` (`accountId`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Club_Category` FOREIGN KEY (`categoryId`) REFERENCES `categories` (`categoryId`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Club_City` FOREIGN KEY (`cityId`) REFERENCES `city` (`cityId`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Club_State` FOREIGN KEY (`stateId`) REFERENCES `state` (`stateId`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COMMENT='Hobby Clubs that users are allowed to join, post to and schedule events.'
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `userclubs` (
	`accountId` INT(11) NOT NULL,
	`clubId` INT(11) NOT NULL,
	`createDatetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	`active` CHAR(1) NOT NULL DEFAULT 'A' COLLATE 'latin1_general_ci',
	UNIQUE INDEX `ComboKey_Account_Club` (`accountId`, `clubId`) USING BTREE,
	INDEX `FK_userClub_Club` (`clubId`) USING BTREE,
	CONSTRAINT `FK_userClub_Account` FOREIGN KEY (`accountId`) REFERENCES `accounts` (`accountId`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_userClub_Club` FOREIGN KEY (`clubId`) REFERENCES `clubs` (`clubId`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
# Events
CREATE TABLE `events` (
	`eventId` INT(11) NOT NULL,
	`title` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`details` VARCHAR(500) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`datetime` DATETIME NOT NULL DEFAULT current_timestamp(),
	`accountId` INT(11) NOT NULL DEFAULT '0',
	`cityId` INT(11) NULL DEFAULT NULL,
	`stateId` INT(11) NULL DEFAULT NULL,
	`createDatetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`eventId`) USING BTREE,
	INDEX `FK_Event_Account` (`accountId`) USING BTREE,
	INDEX `FK_Event_City` (`cityId`) USING BTREE,
	INDEX `FK_Event_State` (`stateId`) USING BTREE,
	CONSTRAINT `FK_Event_Account` FOREIGN KEY (`accountId`) REFERENCES `accounts` (`accountId`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Event_City` FOREIGN KEY (`cityId`) REFERENCES `city` (`cityId`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Event_State` FOREIGN KEY (`stateId`) REFERENCES `state` (`stateId`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COMMENT='Events for a Club.'
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `eventattendance` (
	`eventId` INT(11) NOT NULL,
	`accountId` INT(11) NOT NULL,
	`attending` CHAR(2) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`createDatetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	UNIQUE INDEX `ComboKey_Account_Event` (`eventId`, `accountId`) USING BTREE,
	INDEX `FK_Attend_Account` (`accountId`) USING BTREE,
	INDEX `FK_Attend_Event` (`eventId`) USING BTREE,
	CONSTRAINT `FK_Attend_Account` FOREIGN KEY (`accountId`) REFERENCES `accounts` (`accountId`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Attend_Event` FOREIGN KEY (`eventId`) REFERENCES `events` (`eventId`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COMMENT='This table list user that are attending an event.'
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
# Topics
CREATE TABLE `topics` (
	`topicId` INT(11) NOT NULL,
	`clubId` INT(11) NOT NULL,
	`accountId` INT(11) NOT NULL,
	`title` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`message` VARCHAR(300) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`createDatetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`topicId`) USING BTREE,
	INDEX `FK_Topic_Account` (`accountId`) USING BTREE,
	INDEX `FK_Topic_Club` (`clubId`) USING BTREE,
	CONSTRAINT `FK_Topic_Account` FOREIGN KEY (`accountId`) REFERENCES `accounts` (`accountId`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Topic_Club` FOREIGN KEY (`clubId`) REFERENCES `clubs` (`clubId`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COMMENT='Topics by members of a club.'
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `replies` (
	`replyId` INT(11) NOT NULL,
	`topicId` INT(11) NOT NULL,
	`accountId` INT(11) NOT NULL,
	`message` VARCHAR(300) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`createDatetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`replyId`) USING BTREE,
	INDEX `FK_Reply_Account` (`accountId`) USING BTREE,
	INDEX `FK_Reply_Topic` (`topicId`) USING BTREE,
	CONSTRAINT `FK_Reply_Account` FOREIGN KEY (`accountId`) REFERENCES `accounts` (`accountId`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Reply_Topic` FOREIGN KEY (`topicId`) REFERENCES `topics` (`topicId`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COMMENT='The replies to Topics on a given club\'s home page.'
COLLATE='latin1_general_ci' 
ENGINE=InnoDB
;
