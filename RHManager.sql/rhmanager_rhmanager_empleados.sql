-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: rhmanager
-- ------------------------------------------------------
-- Server version	8.0.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `rhmanager_empleados`
--

DROP TABLE IF EXISTS `rhmanager_empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rhmanager_empleados` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Documento` varchar(20) NOT NULL,
  `Salario` decimal(10,2) NOT NULL,
  `IdArea` int NOT NULL,
  `IdCargo` int NOT NULL,
  `Estado` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Documento` (`Documento`),
  KEY `FK_Area` (`IdArea`),
  KEY `FK_Cargo` (`IdCargo`),
  CONSTRAINT `FK_Area` FOREIGN KEY (`IdArea`) REFERENCES `rhmanager_areas` (`Id`),
  CONSTRAINT `FK_Cargo` FOREIGN KEY (`IdCargo`) REFERENCES `rhmanager_cargos` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rhmanager_empleados`
--

LOCK TABLES `rhmanager_empleados` WRITE;
/*!40000 ALTER TABLE `rhmanager_empleados` DISABLE KEYS */;
INSERT INTO `rhmanager_empleados` VALUES (1,'Juan Esteban Ortiz','1016035301',5000000.00,1,1,1),(2,'Laura Martinez','1020304050',3200000.00,2,2,1),(3,'Carlos Ramirez','1098765432',2800000.00,3,4,1),(4,'Andres Gomez','1045789632',4500000.00,4,3,1),(5,'Sofia Herrera','1078945612',6000000.00,5,5,1);
/*!40000 ALTER TABLE `rhmanager_empleados` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-14 14:11:02
