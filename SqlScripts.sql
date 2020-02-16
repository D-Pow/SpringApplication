/**
 * If using MySQL Shell, connect to MySQL Server as user defined in appication.properties:
 *     `\connect --mysql devuser@localhost`
 * To access data:
 *     `USE [database_name];`
 *     `DESCRIBE [table_name];`
 */

-- MySQL
CREATE TABLE IF NOT EXISTS employee(
    id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(36),
    role VARCHAR(20)
);
INSERT INTO employee VALUES (572396, 'Bob Loblaw', 'Engineer');

-- SQLite doesn't have BIGINT nor UNSIGNED, so map to INTEGER. Remove _ from AUTO_INCREMENT.
CREATE TABLE IF NOT EXISTS employee(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(36),
    role VARCHAR(20)
);
