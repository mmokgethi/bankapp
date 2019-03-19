CREATE DATABASE bankingApp;
USE bankingApp;

DROP TABLE IF EXISTS `AccType`;
CREATE TABLE `AccType` (
  `accTypeCode` int(11) NOT NULL,
  `accTypeDesc` varchar(45) NOT NULL,
  PRIMARY KEY (`accTypeCode`),
  UNIQUE KEY `accTypeCode_UNIQUE` (`accTypeCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
LOCK TABLES `AccType` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account` (
  `accId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `accTypeCode` int(11) NOT NULL,
  `availBalance` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`accId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
LOCK TABLES `Account` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `TranType`;
CREATE TABLE `TranType` (
  `tranTypeCode` int(11) NOT NULL,
  `TranTypecol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tranTypeCode`),
  UNIQUE KEY `tranTypeCode_UNIQUE` (`tranTypeCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
LOCK TABLES `TranType` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `Transaction`;
CREATE TABLE `Transaction` (
  `tranId` int(11) NOT NULL,
  `accId` int(11) NOT NULL,
  `tranTypeCode` int(11) NOT NULL,
  `amount` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  PRIMARY KEY (`tranId`),
  UNIQUE KEY `tranId_UNIQUE` (`tranId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
LOCK TABLES `Transaction` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `userId` int(11) NOT NULL,
  `fName` varchar(45) NOT NULL,
  `lName` varchar(45) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userId_UNIQUE` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
LOCK TABLES `User` WRITE;
UNLOCK TABLES;