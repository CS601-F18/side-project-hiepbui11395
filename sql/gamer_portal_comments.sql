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
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` text NOT NULL,
  `score` int(11) NOT NULL,
  `commentTime` timestamp NOT NULL,
  `fromUserId` int(11) NOT NULL,
  `toUserId` int(11) NOT NULL,
  `parentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FromUser_idx` (`fromUserId`),
  KEY `ToUser_idx` (`toUserId`),
  KEY `ParentComment_idx` (`parentId`),
  CONSTRAINT `FromUser` FOREIGN KEY (`fromUserId`) REFERENCES `accounts` (`id`),
  CONSTRAINT `ParentComment` FOREIGN KEY (`parentId`) REFERENCES `comments` (`id`),
  CONSTRAINT `ToUser` FOREIGN KEY (`toUserId`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (12,'Great',5,'2018-11-22 19:58:41',8,9,NULL),(13,'Hello',4,'2018-11-22 20:54:07',1,2,NULL),(14,'',0,'2018-11-22 23:37:51',1,5,NULL),(15,'',6,'2018-11-22 23:42:55',1,5,NULL),(16,'Tesst',5,'2018-11-22 23:43:01',1,5,NULL),(17,'Test',5,'2018-11-23 00:18:52',1,5,NULL),(18,'Test ',2,'2018-11-23 00:19:06',1,5,NULL),(19,'Testtttt',2,'2018-11-23 00:20:33',1,5,NULL),(20,'Testtttt',325,'2018-11-23 00:20:44',1,5,NULL),(21,'Test sort',1,'2018-11-23 02:20:23',1,2,NULL),(22,'Good player',3,'2018-11-25 23:00:50',101,7,NULL),(23,'Nice',5,'2018-11-25 23:01:10',101,7,NULL),(24,'Well play',2,'2018-11-25 23:02:19',101,7,NULL);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-04 23:36:05
