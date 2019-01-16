CREATE DATABASE  IF NOT EXISTS `dgt` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dgt`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: dgt
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agente`
--

DROP TABLE IF EXISTS `agente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `agente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `placa` int(11) NOT NULL,
  `id_departamento` int(11) DEFAULT NULL,
  `password` varchar(145) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_departamento_idx` (`id_departamento`),
  CONSTRAINT `fk_departamento_has_agente` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agente`
--

LOCK TABLES `agente` WRITE;
/*!40000 ALTER TABLE `agente` DISABLE KEYS */;
INSERT INTO `agente` VALUES (1,'majonei',111,37,'123456'),(2,'jony walker',222,36,'123456'),(3,'monk',333,38,'123456'),(4,'takelberri',444,39,'123456'),(5,'tontini',555,39,'123456');
/*!40000 ALTER TABLE `agente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coche`
--

DROP TABLE IF EXISTS `coche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `coche` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(10) NOT NULL,
  `modelo` varchar(45) NOT NULL DEFAULT 'cuatro latas',
  `km` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coche`
--

LOCK TABLES `coche` WRITE;
/*!40000 ALTER TABLE `coche` DISABLE KEYS */;
INSERT INTO `coche` VALUES (1,'3548MKZ','toyota yaris',500),(2,'9605EFH','fiat multipla',800),(3,'5674MBD','GTR',1800),(4,'BI0020AZ','flagoneta',47500);
/*!40000 ALTER TABLE `coche` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `departamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (36,'Alcoholemia'),(38,'Fealdad'),(33,'Ingeniería'),(35,'Mercadeo'),(39,'Oficinistas'),(34,'Producción'),(37,'Velocidad'),(31,'Ventas');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `multa`
--

DROP TABLE IF EXISTS `multa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `multa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_coche` int(11) NOT NULL,
  `id_agente` int(11) DEFAULT NULL,
  `importe` float DEFAULT '50',
  `concepto` varchar(255) NOT NULL,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `fecha_modificacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `fecha_baja` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_multas_coches_idx` (`id_coche`),
  KEY `fk_agente_idx` (`id_agente`),
  CONSTRAINT `fk_agente_has_multa` FOREIGN KEY (`id_agente`) REFERENCES `agente` (`id`),
  CONSTRAINT `fk_coche_has_multa` FOREIGN KEY (`id_coche`) REFERENCES `coche` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `multa`
--

LOCK TABLES `multa` WRITE;
/*!40000 ALTER TABLE `multa` DISABLE KEYS */;
INSERT INTO `multa` VALUES (1,2,3,200,'por feo','2019-01-07 10:38:42','2019-01-11 09:30:15',NULL),(2,4,1,500,'exceso velocidad 240km/h','2019-01-07 10:39:23','2019-01-11 09:30:15',NULL),(3,1,2,700,'empinar codo 8.0','2018-01-07 10:39:42','2019-01-11 09:30:15',NULL),(4,1,4,700,'empinar codo 8.0','2019-01-07 10:39:42','2019-01-11 09:30:15',NULL),(5,1,1,500,'conduccion temeraria','2019-01-05 10:39:42','2019-01-11 09:30:15',NULL),(6,4,4,400,'por correr','2019-01-02 10:39:42','2019-01-11 09:30:15',NULL),(7,1,4,2134,'minimo 10 caracterdsgdsfges','2019-01-10 12:14:24','2019-01-11 09:30:15',NULL),(8,1,4,950,'Conducción temeraria','2019-01-11 10:03:09','2019-01-11 10:03:09','2019-01-16 10:39:29'),(9,1,4,222,'sdfsafsdafasfdsd','2019-01-15 08:41:15','2019-01-15 08:41:15','2019-01-15 08:41:55'),(10,1,4,20.2312,'Concepto largo para prueba porque esto se corta en version movil TODO','2019-01-16 09:01:40','2019-01-16 09:01:40',NULL),(11,1,4,25.25,'concepto','2019-01-16 09:58:55','2019-01-16 09:58:55',NULL),(12,4,4,222,'asdfsadfasdfasdasdfsadfsadf','2019-01-16 10:26:27','2019-01-16 10:26:27','2019-01-16 10:40:42'),(13,4,4,33,'decvcvcvcvcvcbvnvbnvbnvbn','2019-01-16 11:50:56','2019-01-16 11:50:56',NULL);
/*!40000 ALTER TABLE `multa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'dgt'
--
/*!50003 DROP PROCEDURE IF EXISTS `agente_getById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `agente_getById`( 
IN p_id LONG )
BEGIN    
SELECT id, nombre, placa, id_departamento FROM agente WHERE id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `agente_getMultas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `agente_getMultas`( 
IN  p_id LONG)
BEGIN
SELECT m.id AS 'id_multa', c.id AS 'id_coche',fecha, importe, concepto, matricula, modelo,km FROM agente AS a, multa AS m, coche AS c WHERE a.id=m.id_agente AND m.id_coche=c.id AND a.id=p_id AND m.fecha_baja IS NULL ORDER BY m.fecha DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `agente_getMultasAnuladas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `agente_getMultasAnuladas`( 
IN  p_id LONG)
BEGIN
SELECT m.id AS 'id_multa', c.id AS 'id_coche',fecha, importe, concepto, matricula, modelo,km FROM agente AS a, multa AS m, coche AS c WHERE a.id=m.id_agente AND m.id_coche=c.id AND a.id=p_id AND m.fecha_baja IS NOT NULL ORDER BY m.fecha DESC ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `agente_login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `agente_login`(
	
    IN p_placa VARCHAR(150) , 
    IN p_password VARCHAR(45) )
BEGIN
SELECT `id`, `nombre`, `placa`, `id_departamento`, `password` FROM agente WHERE placa = p_placa AND password = p_password;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `coche_get_matricula` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `coche_get_matricula`(IN matricula VARCHAR(10))
BEGIN
SELECT id, matricula, modelo, km FROM coche WHERE matricula =matricula;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `multa_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `multa_insert`(

	IN p_importe FLOAT,
    IN p_concepto VARCHAR(255),
	IN id_coche LONG,
	IN id_agente LONG,
	OUT o_id LONG

)
BEGIN
INSERT INTO multa (importe, concepto, id_coche, id_agente) VALUES (p_importe, p_concepto, id_coche, id_agente);

SET o_id = LAST_INSERT_ID();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `multa_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `multa_update`(

	IN p_id LONG,
	OUT o_id LONG

)
BEGIN
UPDATE multa SET fecha_baja = CURRENT_TIMESTAMP WHERE (`id` = p_id);
SET o_id = LAST_INSERT_ID();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-16 14:06:06
