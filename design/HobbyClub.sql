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
	`state_id` INT(11) NOT NULL,
	`name` VARCHAR(100) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`create_datetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`state_id`) USING BTREE,
	UNIQUE INDEX `Unique_Name` (`name`) USING BTREE
)
COMMENT='States of the US'
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `city` (
	`city_id` INT(11) NOT NULL,
	`name` VARCHAR(120) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`state_id` INT(11) NOT NULL,
	`create_datetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`city_id`) USING BTREE,
	UNIQUE INDEX `Unique_Name_State` (`name`, `state_id`) USING BTREE,
	INDEX `FK_City_State` (`state_id`) USING BTREE,
	CONSTRAINT `FK_City_State` FOREIGN KEY (`state_id`) REFERENCES `state` (`state_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
commit;
# Create categories (domain data)
CREATE TABLE `categories` (
	`category_id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`create_datetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`category_id`) USING BTREE
)
COMMENT='Categories of Interest, allows grouping clubs together and ease searching.'
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
commit;
# Create account table
CREATE TABLE `accounts` (
	`account_id` INT(11) NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`last_name` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`nick_name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_general_ci',
	`state_id` INT(11) NOT NULL,
	`city_id` INT(11) NOT NULL DEFAULT '0',
	`create_datetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	`active` CHAR(1) NOT NULL DEFAULT 'A' COLLATE 'latin1_general_ci',
	PRIMARY KEY (`account_id`) USING BTREE,
	UNIQUE INDEX `Unique_NickName` (`nick_name`) USING BTREE,
	INDEX `FK_Account_State` (`state_id`) USING BTREE,
	INDEX `FK_Account_City` (`city_id`) USING BTREE,
	CONSTRAINT `FK_Account_City` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Account_State` FOREIGN KEY (`state_id`) REFERENCES `state` (`state_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COMMENT='Accounts for each registered user of Hobby Club'
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
commit;
# Create user interest
CREATE TABLE `userinterest` (
	`account_id` INT(11) NOT NULL,
	`category_id` INT(11) NOT NULL,
	`create_datetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	UNIQUE INDEX `ComboKey_User_Category` (`account_id`, `category_id`) USING BTREE,
	INDEX `FK_UserInterest_Category` (`category_id`) USING BTREE,
	CONSTRAINT `FK_UserInterest_Account` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`account_id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_UserInterest_Category` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COMMENT='Linking Users to their category interest.'
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
commit;
# Create the main clubs table.
CREATE TABLE `clubs` (
	`club_id` INT(11) NOT NULL,
	`name` VARCHAR(100) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`description` VARCHAR(1000) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`city_id` INT(11) NOT NULL,
	`state_id` INT(11) NOT NULL,
	`category_id` INT(11) NOT NULL,
	`creator_id` INT(11) NOT NULL,
	`create_datetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	`active` CHAR(1) NOT NULL DEFAULT 'A' COLLATE 'latin1_general_ci',
	PRIMARY KEY (`club_id`) USING BTREE,
	UNIQUE INDEX `Unique_Name_State` (`name`, `state_id`) USING BTREE,
	INDEX `FK_Club_State` (`state_id`) USING BTREE,
	INDEX `FK_Club_City` (`city_id`) USING BTREE,
	INDEX `FK_Club_Category` (`category_id`) USING BTREE,
	INDEX `FK_Club_Account` (`creator_id`) USING BTREE,
	CONSTRAINT `FK_Club_Account` FOREIGN KEY (`creator_id`) REFERENCES `accounts` (`account_id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Club_Category` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Club_City` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Club_State` FOREIGN KEY (`state_id`) REFERENCES `state` (`state_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COMMENT='Hobby Clubs that users are allowed to join, post to and schedule events.'
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `userclubs` (
	`account_id` INT(11) NOT NULL,
	`club_id` INT(11) NOT NULL,
	`create_datetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	`active` CHAR(1) NOT NULL DEFAULT 'A' COLLATE 'latin1_general_ci',
	UNIQUE INDEX `ComboKey_Account_Club` (`account_id`, `club_id`) USING BTREE,
	INDEX `FK_userClub_Club` (`club_id`) USING BTREE,
	CONSTRAINT `FK_userClub_Account` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`account_id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_userClub_Club` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`club_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
commit;
# Events
CREATE TABLE `events` (
	`event_id` INT(11) NOT NULL,
	`title` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`details` VARCHAR(500) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`datetime` DATETIME NOT NULL DEFAULT current_timestamp(),
	`account_id` INT(11) NOT NULL DEFAULT '0',
	`city_id` INT(11) NULL DEFAULT NULL,
	`state_id` INT(11) NULL DEFAULT NULL,
	`create_datetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`event_id`) USING BTREE,
	INDEX `FK_Event_Account` (`account_id`) USING BTREE,
	INDEX `FK_Event_City` (`city_id`) USING BTREE,
	INDEX `FK_Event_State` (`state_id`) USING BTREE,
	CONSTRAINT `FK_Event_Account` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`account_id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Event_City` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Event_State` FOREIGN KEY (`state_id`) REFERENCES `state` (`state_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COMMENT='Events for a Club.'
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `eventattendance` (
	`event_id` INT(11) NOT NULL,
	`account_id` INT(11) NOT NULL,
	`attending` CHAR(2) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`create_datetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	UNIQUE INDEX `ComboKey_Account_Event` (`event_id`, `account_id`) USING BTREE,
	INDEX `FK_Attend_Account` (`account_id`) USING BTREE,
	INDEX `FK_Attend_Event` (`event_id`) USING BTREE,
	CONSTRAINT `FK_Attend_Account` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`account_id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Attend_Event` FOREIGN KEY (`event_id`) REFERENCES `events` (`event_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COMMENT='This table list user that are attending an event.'
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
commit;
# Topics
CREATE TABLE `topics` (
	`topic_id` INT(11) NOT NULL,
	`club_id` INT(11) NOT NULL,
	`account_id` INT(11) NOT NULL,
	`title` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`message` VARCHAR(300) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`create_datetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`topic_id`) USING BTREE,
	INDEX `FK_Topic_Account` (`account_id`) USING BTREE,
	INDEX `FK_Topic_Club` (`club_id`) USING BTREE,
	CONSTRAINT `FK_Topic_Account` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`account_id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Topic_Club` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`club_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COMMENT='Topics by members of a club.'
COLLATE='latin1_general_ci'
ENGINE=InnoDB
;
CREATE TABLE `replies` (
	`reply_id` INT(11) NOT NULL,
	`topic_id` INT(11) NOT NULL,
	`account_id` INT(11) NOT NULL,
	`message` VARCHAR(300) NOT NULL DEFAULT '' COLLATE 'latin1_general_ci',
	`create_datetime` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`reply_id`) USING BTREE,
	INDEX `FK_Reply_Account` (`account_id`) USING BTREE,
	INDEX `FK_Reply_Topic` (`topic_id`) USING BTREE,
	CONSTRAINT `FK_Reply_Account` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`account_id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_Reply_Topic` FOREIGN KEY (`topic_id`) REFERENCES `topics` (`topic_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COMMENT='The replies to Topics on a given club\'s home page.'
COLLATE='latin1_general_ci' 
ENGINE=InnoDB
;
commit;

# Add all states
INSERT INTO state (state_id, name) VALUES
(1, 'Alabama'),
(2, 'Alaska'),
(3, 'Arizona'),
(4, 'Arkansas'),
(5, 'California'),
(6, 'Colorado'),
(7, 'Connecticut'),
(8, 'Delaware'),
(9, 'Florida'),
(10, 'Georgia'),
(11, 'Hawaii'),
(12, 'Idaho'),
(13, 'Illinois'),
(14, 'Indiana'),
(15, 'Iowa'),
(16, 'Kansas'),
(17, 'Kentucky'),
(18, 'Louisiana'),
(19, 'Maine'),
(20, 'Maryland'),
(21, 'Massachusetts'),
(22, 'Michigan'),
(23, 'Minnesota'),
(24, 'Mississippi'),
(25, 'Missouri'),
(26, 'Montana'),
(27, 'Nebraska'),
(28, 'Nevada'),
(29, 'New Hampshire'),
(30, 'New Jersey'),
(31, 'New Mexico'),
(32, 'New York'),
(33, 'North Carolina'),
(34, 'North Dakota'),
(35, 'Ohio'),
(36, 'Oklahoma'),
(37, 'Oregon'),
(38, 'Pennsylvania'),
(39, 'Rhode Island'),
(40, 'South Carolina'),
(41, 'South Dakota'),
(42, 'Tennessee'),
(43, 'Texas'),
(44, 'Utah'),
(45, 'Vermont'),
(46, 'Virginia'),
(47, 'Washington'),
(48, 'West Virginia'),
(49, 'Wisconsin'),
(50, 'Wyoming');
commit;

# insert major cities for each state
INSERT INTO city (city_id, name, state_id) VALUES
-- Alabama (state_id = 1)
(1, 'Birmingham', 1),
(2, 'Montgomery', 1),
(3, 'Mobile', 1),
-- Alaska (state_id = 2)
(4, 'Anchorage', 2),
(5, 'Fairbanks', 2),
(6, 'Juneau', 2),
-- Arizona (state_id = 3)
(7, 'Phoenix', 3),
(8, 'Tucson', 3),
(9, 'Mesa', 3),
-- Arkansas (state_id = 4)
(10, 'Little Rock', 4),
(11, 'Fort Smith', 4),
(12, 'Fayetteville', 4),
-- California (state_id = 5)
(13, 'Los Angeles', 5),
(14, 'San Francisco', 5),
(15, 'San Diego', 5),
-- Colorado (state_id = 6)
(16, 'Denver', 6),
(17, 'Colorado Springs', 6),
(18, 'Aurora', 6),
-- Connecticut (state_id = 7)
(19, 'Hartford', 7),
(20, 'New Haven', 7),
(21, 'Bridgeport', 7),
-- Delaware (state_id = 8)
(22, 'Wilmington', 8),
(23, 'Dover', 8),
(24, 'Newark', 8),
-- Florida (state_id = 9)
(25, 'Miami', 9),
(26, 'Orlando', 9),
(27, 'Tampa', 9),
-- Georgia (state_id = 10)
(28, 'Atlanta', 10),
(29, 'Savannah', 10),
(30, 'Augusta', 10),
-- Hawaii (state_id = 11)
(31, 'Honolulu', 11),
(32, 'Hilo', 11),
(33, 'Kailua', 11),
-- Idaho (state_id = 12)
(34, 'Boise', 12),
(35, 'Meridian', 12),
(36, 'Nampa', 12),
-- Illinois (state_id = 13)
(37, 'Chicago', 13),
(38, 'Springfield', 13),
(39, 'Peoria', 13),
-- Indiana (state_id = 14)
(40, 'Indianapolis', 14),
(41, 'Fort Wayne', 14),
(42, 'Evansville', 14),
-- Iowa (state_id = 15)
(43, 'Des Moines', 15),
(44, 'Cedar Rapids', 15),
(45, 'Davenport', 15),
-- Kansas (state_id = 16)
(46, 'Wichita', 16),
(47, 'Overland Park', 16),
(48, 'Kansas City', 16),
-- Kentucky (state_id = 17)
(49, 'Louisville', 17),
(50, 'Lexington', 17),
(51, 'Bowling Green', 17),
-- Louisiana (state_id = 18)
(52, 'New Orleans', 18),
(53, 'Baton Rouge', 18),
(54, 'Shreveport', 18),
-- Maine (state_id = 19)
(55, 'Portland', 19),
(56, 'Lewiston', 19),
(57, 'Bangor', 19),
-- Maryland (state_id = 20)
(58, 'Baltimore', 20),
(59, 'Annapolis', 20),
(60, 'Frederick', 20),
-- Massachusetts (state_id = 21)
(61, 'Boston', 21),
(62, 'Worcester', 21),
(63, 'Springfield', 21),
-- Michigan (state_id = 22)
(64, 'Detroit', 22),
(65, 'Grand Rapids', 22),
(66, 'Lansing', 22),
-- Minnesota (state_id = 23)
(67, 'Minneapolis', 23),
(68, 'Saint Paul', 23),
(69, 'Duluth', 23),
-- Mississippi (state_id = 24)
(70, 'Jackson', 24),
(71, 'Gulfport', 24),
(72, 'Biloxi', 24),
-- Missouri (state_id = 25)
(73, 'Kansas City', 25),
(74, 'Saint Louis', 25),
(75, 'Springfield', 25),
-- Montana (state_id = 26)
(76, 'Billings', 26),
(77, 'Missoula', 26),
(78, 'Great Falls', 26),
-- Nebraska (state_id = 27)
(79, 'Omaha', 27),
(80, 'Lincoln', 27),
(81, 'Grand Island', 27),
-- Nevada (state_id = 28)
(82, 'Las Vegas', 28),
(83, 'Reno', 28),
(84, 'Henderson', 28),
-- New Hampshire (state_id = 29)
(85, 'Manchester', 29),
(86, 'Nashua', 29),
(87, 'Concord', 29),
-- New Jersey (state_id = 30)
(88, 'Newark', 30),
(89, 'Jersey City', 30),
(90, 'Trenton', 30),
-- New Mexico (state_id = 31)
(91, 'Albuquerque', 31),
(92, 'Santa Fe', 31),
(93, 'Las Cruces', 31),
-- New York (state_id = 32)
(94, 'New York City', 32),
(95, 'Buffalo', 32),
(96, 'Rochester', 32),
-- North Carolina (state_id = 33)
(97, 'Charlotte', 33),
(98, 'Raleigh', 33),
(99, 'Greensboro', 33),
-- North Dakota (state_id = 34)
(100, 'Fargo', 34),
(101, 'Bismarck', 34),
(102, 'Grand Forks', 34),
-- Ohio (state_id = 35)
(103, 'Columbus', 35),
(104, 'Cleveland', 35),
(105, 'Cincinnati', 35),
-- Oklahoma (state_id = 36)
(106, 'Oklahoma City', 36),
(107, 'Tulsa', 36),
(108, 'Norman', 36),
-- Oregon (state_id = 37)
(109, 'Portland', 37),
(110, 'Salem', 37),
(111, 'Eugene', 37),
-- Pennsylvania (state_id = 38)
(112, 'Philadelphia', 38),
(113, 'Pittsburgh', 38),
(114, 'Harrisburg', 38),
-- Rhode Island (state_id = 39)
(115, 'Providence', 39),
(116, 'Warwick', 39),
(117, 'Cranston', 39),
-- South Carolina (state_id = 40)
(118, 'Charleston', 40),
(119, 'Columbia', 40),
(120, 'Greenville', 40),
-- South Dakota (state_id = 41)
(121, 'Sioux Falls', 41),
(122, 'Rapid City', 41),
(123, 'Aberdeen', 41),
-- Tennessee (state_id = 42)
(124, 'Nashville', 42),
(125, 'Memphis', 42),
(126, 'Knoxville', 42),
-- Texas (state_id = 43)
(127, 'Houston', 43),
(128, 'Austin', 43),
(129, 'Dallas', 43),
-- Utah (state_id = 44)
(130, 'Salt Lake City', 44),
(131, 'Provo', 44),
(132, 'Ogden', 44),
-- Vermont (state_id = 45)
(133, 'Burlington', 45),
(134, 'Montpelier', 45),
(135, 'Rutland', 45),
-- Virginia (state_id = 46)
(136, 'Virginia Beach', 46),
(137, 'Richmond', 46),
(138, 'Norfolk', 46),
-- Washington (state_id = 47)
(139, 'Seattle', 47),
(140, 'Spokane', 47),
(141, 'Tacoma', 47),
-- West Virginia (state_id = 48)
(142, 'Charleston', 48),
(143, 'Huntington', 48),
(144, 'Morgantown', 48),
-- Wisconsin (state_id = 49)
(145, 'Milwaukee', 49),
(146, 'Madison', 49),
(147, 'Green Bay', 49),
-- Wyoming (state_id = 50)
(148, 'Cheyenne', 50),
(149, 'Casper', 50),
(150, 'Laramie', 50);
commit;

# add categories
INSERT INTO categories (category_id, name) VALUES
    (1, 'Anime Club'),
    (2, 'Art Club'),
    (3, 'Astronomy Club'),
    (4, 'Board Game Club'),
    (5, 'Book Club'),
    (6, 'Car Enthusiast Club'),
    (7, 'Chess Club'),
    (8, 'Cooking Club'),
    (9, 'Crafting Club'),
    (10, 'Dance Club'),
    (11, 'Debate Club'),
    (12, 'Film Club'),
    (13, 'Fitness Club'),
    (14, 'Gaming Club'),
    (15, 'Gardening Club'),
    (16, 'Hiking Club'),
    (17, 'Language Club'),
    (18, 'Martial Arts Club'),
    (19, 'Music Club'),
    (20, 'Photography Club'),
    (21, 'Robotics Club'),
    (22, 'Science Club'),
    (23, 'Sustainability Club'),
    (24, 'Tech Club'),
    (25, 'Writing Club');
commit;
