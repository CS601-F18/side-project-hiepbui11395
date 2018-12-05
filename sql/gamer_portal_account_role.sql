-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: gamer_portal
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `account_role`
--

DROP TABLE IF EXISTS `account_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `account_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idAccount` int(11) NOT NULL,
  `idRole` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `role_idx` (`idRole`),
  KEY `account_idx` (`idAccount`),
  KEY `accountRole_idx` (`idAccount`),
  CONSTRAINT `accountRole` FOREIGN KEY (`idAccount`) REFERENCES `accounts` (`id`),
  CONSTRAINT `role` FOREIGN KEY (`idRole`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_role`
--

LOCK TABLES `account_role` WRITE;
/*!40000 ALTER TABLE `account_role` DISABLE KEYS */;
INSERT INTO `account_role` VALUES (1,1,1),(2,2,1),(3,3,1),(5,4,1),(7,5,1),(8,6,1),(9,7,1),(10,8,1),(11,9,1),(12,10,1),(13,11,1),(14,12,1),(15,13,1),(16,14,1),(17,15,1),(18,16,1),(19,17,1),(20,18,1),(21,19,1),(22,20,1),(23,21,1),(24,22,1),(25,23,1),(26,24,1),(27,25,1),(28,26,1),(29,27,1),(30,28,1),(31,29,1),(32,30,1),(33,31,1),(34,32,1),(35,33,1),(36,34,1),(37,35,1),(38,36,1),(39,37,1),(40,38,1),(41,39,1),(42,40,1),(43,41,1),(44,42,1),(45,43,1),(46,44,1),(47,45,1),(48,46,1),(49,47,1),(50,48,1),(51,49,1),(52,50,1),(53,51,1),(54,52,1),(55,53,1),(56,54,1),(57,55,1),(58,56,1),(59,57,1),(60,58,1),(61,59,1),(62,60,1),(63,61,1),(64,62,1),(65,63,1),(66,64,1),(67,65,1),(68,66,1),(69,67,1),(70,68,1),(71,69,1),(72,70,1),(73,71,1),(74,72,1),(75,73,1),(76,74,1),(77,75,1),(78,76,1),(79,77,1),(80,78,1),(81,79,1),(82,80,1),(83,81,1),(84,82,1),(85,83,1),(86,84,1),(87,85,1),(88,86,1),(89,87,1),(90,88,1),(91,89,1),(92,90,1),(93,91,1),(94,92,1),(95,93,1),(96,94,1),(97,95,1),(98,96,1),(99,97,1),(100,98,1),(101,99,1),(102,100,1),(103,101,1);
/*!40000 ALTER TABLE `account_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-04 23:36:04
