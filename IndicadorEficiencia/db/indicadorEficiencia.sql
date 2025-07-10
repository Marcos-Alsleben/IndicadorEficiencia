-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema indicadorEficiencia
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema indicadorEficiencia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `indicadorEficiencia` DEFAULT CHARACTER SET utf8 ;
USE `indicadorEficiencia` ;

-- -----------------------------------------------------
-- Table `indicadorEficiencia`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `indicadorEficiencia`.`cliente` (
  `id_cliente` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `criado` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modificado` TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_cliente`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `indicadorEficiencia`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `indicadorEficiencia`.`funcionario` (
  `id_funcionario` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `criado` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modificado` TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_funcionario`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `indicadorEficiencia`.`indicador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `indicadorEficiencia`.`indicador` (
  `id_indicador` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_funcionario` INT UNSIGNED NOT NULL,
  `pedido` VARCHAR(45) NOT NULL,
  `qtd_artes` INT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `id_cliente` INT UNSIGNED NOT NULL,
  `data` DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `criado` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modificado` TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_indicador`),
  INDEX `fk_indicadores_clientes_idx` (`id_cliente` ASC) VISIBLE,
  INDEX `fk_indicadores_funcionarios_idx` (`id_funcionario` ASC) VISIBLE,
  CONSTRAINT `fk_indicadores_clientes`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `indicadorEficiencia`.`cliente` (`id_cliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_indicadores_funcionarios`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `indicadorEficiencia`.`funcionario` (`id_funcionario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


CREATE USER IF NOT EXISTS 'carton'@'%' IDENTIFIED BY '2574';

GRANT ALL ON *.* TO 'carton'@'%' WITH GRANT OPTION;


flush privileges;


-- Inserções com data atual
INSERT INTO cliente (nome, criado, modificado) VALUES 
('3RHO', NOW(), NOW()),
('ACHE', NOW(), NOW()),
('AMGEN', NOW(), NOW()),
('APSEN', NOW(), NOW()),
('AVON', NOW(), NOW()),
('CARTONDRUCK', NOW(), NOW()),
('CARTONARTE', NOW(), NOW()),
('DELLY', NOW(), NOW()),
('DENGO', NOW(), NOW()),
('EMBELLEZE', NOW(), NOW()),
('EUROFARMA', NOW(), NOW()),
('GSK', NOW(), NOW()),
('HINODE', NOW(), NOW()),
('JBS', NOW(), NOW()),
('MARTIN-BROWER', NOW(), NOW()),
('MOMENTA', NOW(), NOW()),
('MONDELEZ', NOW(), NOW()),
('MEGA VITAL', NOW(), NOW()),
('NATURA', NOW(), NOW()),
('NIVEA', NOW(), NOW()),
('PERFETTI', NOW(), NOW()),
('PROCOSA', NOW(), NOW()),
('PLATLOG', NOW(), NOW()),
('PROCTER', NOW(), NOW()),
('PHITOTERAPHIA', NOW(), NOW()),
('RAZZO', NOW(), NOW()),
('SAVOY', NOW(), NOW()),
('SOUZA CRUZ', NOW(), NOW()),
('LIBBS', NOW(), NOW()),
('LIPSON', NOW(), NOW()),
('FAST FOOD', NOW(), NOW()),
('WECKERLE', NOW(), NOW()),
('ZODIAC', NOW(), NOW()),
('BERGAMO', NOW(), NOW()),
('UNILEVER', NOW(), NOW()),
('PHILIP MORRIS', NOW(), NOW()),
('J T I', NOW(), NOW()),
('BOBS', NOW(), NOW()),
('PEOPLE', NOW(), NOW()),
('VAN CLEVE', NOW(), NOW()),
('SANPHAR', NOW(), NOW()),
('BRASIL ESPRESSO', NOW(), NOW()),
('LECLAIR', NOW(), NOW()),
('R F G', NOW(), NOW()),
('COLGATE', NOW(), NOW()),
('DAHUER', NOW(), NOW()),
('NACIONAL', NOW(), NOW()),
('SINTER', NOW(), NOW()),
('CRISTÁLIA', NOW(), NOW()),
('NORDISK', NOW(), NOW()),
('ALTHAIA', NOW(), NOW()),
('BRASCUBA', NOW(), NOW()),
('CHROMAVIS', NOW(), NOW()),
('VOSSKO', NOW(), NOW()),
('COSMO', NOW(), NOW());