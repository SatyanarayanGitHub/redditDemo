CREATE DATABASE IF NOT EXISTS `redditdb`;
USE `redditdb`;


--
-- Table structure for table `link`
-- 
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link` (
	`id` BIGINT(20) NOT NULL,	
	`title` VARCHAR(255) NULL DEFAULT NULL,
	`url` VARCHAR(255) NULL DEFAULT NULL,
	`create_by` VARCHAR(255) NULL DEFAULT NULL,
	`created_date` DATETIME NULL DEFAULT NULL,
	`last_modified_by` VARCHAR(255) NULL DEFAULT NULL,
	`last_modified_date` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=MyISAM
;


--
-- Table structure for table `comment`
-- 
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
	`id` BIGINT(20) NOT NULL,	
	`body` VARCHAR(255) NULL DEFAULT NULL,
	`create_by` VARCHAR(255) NULL DEFAULT NULL,
	`created_date` DATETIME NULL DEFAULT NULL,
	`last_modified_by` VARCHAR(255) NULL DEFAULT NULL,
	`last_modified_date` DATETIME NULL DEFAULT NULL,
	`link_id` BIGINT(20) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FKoutxw6g1ndh1t6282y0fwvami` (`link_id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=MyISAM


