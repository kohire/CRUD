CREATE DATABASE tech;
USE tech;

CREATE TABLE dispositivos(
    idDisp tinyint not null primary key auto_increment,
    nombre varchar(40),
    descripcion varchar(80), 
    modelo varchar(30),
    marca varchar(30),
    precio int,
    color varchar(30)
);

SELECT * FROM dispositivos;

CREATE PROCEDURE getNextID()
 SELECT AUTO_INCREMENT
 FROM information_schema.TABLES
 WHERE TABLE_SCHEMA = "tech"
 AND TABLE_NAME = "dispositivos";

 call getNextId();