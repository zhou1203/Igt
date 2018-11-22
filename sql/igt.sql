CREATE DATABASE igt;
USE igt;

CREATE TABLE igt_scheme(
	test_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	user_id CHAR(10) NOT NULL,
	count INT NOT NULL,
	card_type CHAR(10) NOT NULL,
	isWin CHAR(10) NOT NULL,
	bo_or_pe INT NOT NULL,
	money INT NOT NULL,
	decition_time INT NOT NULL,
	test_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)

CREATE TABLE user_scheme(
	user_id CHAR(10) NOT NULL PRIMARY KEY,
	gender CHAR(10) NOT NULL,
)

CREATE TABLE borrow_scheme(
	test_id INT NOT NULL PRIMARY KEY,
	user_id CHAR(10) NOT NULL,
	money CHAR(10) NOT NULL,
	total CHAR(1O) NOT NULL,
	borrow_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)