-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema BankingApp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema BankingApp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BankingApp` DEFAULT CHARACTER SET latin1 ;
USE `BankingApp` ;

-- -----------------------------------------------------
-- Table `BankingApp`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BankingApp`.`User` (
  `userId` INT(11) NOT NULL AUTO_INCREMENT,
  `fName` VARCHAR(45) NOT NULL,
  `lName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 72
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `BankingApp`.`Account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BankingApp`.`Account` (
  `accId` INT(11) NOT NULL AUTO_INCREMENT,
  `availBalance` VARCHAR(45) NULL DEFAULT NULL,
  `User_userId` INT(11) NOT NULL,
  `accType` VARCHAR(45) CHARACTER SET 'dec8' NULL DEFAULT NULL,
  PRIMARY KEY (`accId`, `User_userId`),
  INDEX `fk_Account_User1_idx` (`User_userId` ASC),
  CONSTRAINT `fk_Account_User1`
    FOREIGN KEY (`User_userId`)
    REFERENCES `BankingApp`.`User` (`userId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `BankingApp`.`Transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BankingApp`.`Transaction` (
  `tranId` INT(11) NOT NULL AUTO_INCREMENT,
  `amount` DOUBLE NULL DEFAULT NULL,
  `tranType` VARCHAR(45) NULL DEFAULT NULL,
  `Account_accId` INT(11) NOT NULL,
  `Account_User_userId` INT(11) NOT NULL,
  PRIMARY KEY (`tranId`, `Account_accId`, `Account_User_userId`),
  UNIQUE INDEX `tranId_UNIQUE` (`tranId` ASC),
  INDEX `fk_Transaction_Account1_idx` (`Account_accId` ASC, `Account_User_userId` ASC),
  CONSTRAINT `fk_Transaction_Account1`
    FOREIGN KEY (`Account_accId` , `Account_User_userId`)
    REFERENCES `BankingApp`.`Account` (`accId` , `User_userId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 29
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
