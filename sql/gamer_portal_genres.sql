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
-- Table structure for table `genres`
--

DROP TABLE IF EXISTS `genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `genres` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `active` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genres`
--

LOCK TABLES `genres` WRITE;
/*!40000 ALTER TABLE `genres` DISABLE KEYS */;
INSERT INTO `genres` VALUES (10,'Action',_binary ''),(11,'Strategy',_binary ''),(12,'Sports',_binary ''),(13,'Adventure',_binary ''),(14,'Role-Playing',_binary ''),(15,'Driving/Racing',_binary ''),(16,'Simulation',_binary ''),(17,'Educational',_binary ''),(18,'Fighting',_binary ''),(19,'Wrestling',_binary ''),(20,'Shooter',_binary ''),(21,'Real-Time Strategy',_binary ''),(22,'Card Game',_binary ''),(23,'Trivia/Board Game',_binary ''),(24,'Compilation',_binary ''),(25,'MMORPG',_binary ''),(26,'Minigame Collection',_binary ''),(27,'Puzzle',_binary ''),(28,'Music/Rhythm',_binary ''),(29,'Boxing',_binary ''),(30,'Football',_binary ''),(31,'Basketball',_binary ''),(32,'Skateboarding',_binary ''),(33,'Flight Simulator',_binary ''),(34,'Tennis',_binary ''),(35,'Billiards',_binary ''),(36,'Fishing',_binary ''),(37,'Golf',_binary ''),(38,'Bowling',_binary ''),(39,'Pinball',_binary ''),(40,'Dual-Joystick Shooter',_binary ''),(41,'First-Person Shooter',_binary ''),(42,'Snowboarding/Skiing',_binary ''),(43,'Baseball',_binary ''),(44,'Light-Gun Shooter',_binary ''),(45,'Text Adventure',_binary ''),(46,'Brawler',_binary ''),(47,'Vehicular Combat',_binary ''),(48,'Hockey',_binary ''),(49,'Soccer',_binary ''),(50,'Platformer',_binary ''),(51,'Track & Field',_binary ''),(52,'Action-Adventure',_binary ''),(53,'Fitness',_binary ''),(54,'Block-Breaking',_binary ''),(55,'Cricket',_binary ''),(56,'Surfing',_binary ''),(57,'Shoot \'Em Up',_binary ''),(58,'Gambling',_binary ''),(59,'MOBA',_binary '');
/*!40000 ALTER TABLE `genres` ENABLE KEYS */;
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
