-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: sd4
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device` (
  `device_id` bigint NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (2,'New York','John'),(15,'San Francisco','Mary'),(39,'Chicago','Val'),(63,'Austin','Jack');
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (86);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor`
--

DROP TABLE IF EXISTS `sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sensor` (
  `sensor_id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `device_device_id` bigint DEFAULT NULL,
  PRIMARY KEY (`sensor_id`),
  KEY `FKnkunvpco79k25u8e3tky58ue7` (`device_device_id`),
  CONSTRAINT `FKnkunvpco79k25u8e3tky58ue7` FOREIGN KEY (`device_device_id`) REFERENCES `device` (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor`
--

LOCK TABLES `sensor` WRITE;
/*!40000 ALTER TABLE `sensor` DISABLE KEYS */;
INSERT INTO `sensor` VALUES (3,'Ground Floor','John1',2),(16,'Ground floor','Mary1',15),(27,'Second floor','Mary 2',15),(40,'Garage','Val1',39),(52,'House','Val2',39),(64,'Balcony','Jack1',63),(75,'Third floor','Mary3',15);
/*!40000 ALTER TABLE `sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor_reading`
--

DROP TABLE IF EXISTS `sensor_reading`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sensor_reading` (
  `sensor_reading_id` bigint NOT NULL,
  `reading` bigint DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL,
  `sensor_sensor_id` bigint DEFAULT NULL,
  PRIMARY KEY (`sensor_reading_id`),
  KEY `FKljsmhhq9o0o38yn8whdg2s63` (`sensor_sensor_id`),
  CONSTRAINT `FKljsmhhq9o0o38yn8whdg2s63` FOREIGN KEY (`sensor_sensor_id`) REFERENCES `sensor` (`sensor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor_reading`
--

LOCK TABLES `sensor_reading` WRITE;
/*!40000 ALTER TABLE `sensor_reading` DISABLE KEYS */;
INSERT INTO `sensor_reading` VALUES (4,17,'2022-05-18 11:41:57.000000',3),(5,36,'2022-05-18 14:28:37.000000',3),(6,3,'2022-05-18 17:15:17.000000',3),(7,29,'2022-05-18 20:01:57.000000',3),(8,3,'2022-05-18 22:48:37.000000',3),(9,19,'2022-05-19 01:35:17.000000',3),(10,36,'2022-05-19 04:21:57.000000',3),(11,36,'2022-05-19 07:08:37.000000',3),(12,40,'2022-05-19 09:55:17.000000',3),(13,38,'2022-05-19 12:41:57.000000',3),(17,49,'2022-05-18 11:41:57.000000',16),(18,32,'2022-05-18 14:28:37.000000',16),(19,17,'2022-05-18 17:15:17.000000',16),(20,28,'2022-05-18 20:01:57.000000',16),(21,8,'2022-05-18 22:48:37.000000',16),(22,1,'2022-05-19 01:35:17.000000',16),(23,0,'2022-05-19 04:21:57.000000',16),(24,8,'2022-05-19 07:08:37.000000',16),(25,27,'2022-05-19 09:55:17.000000',16),(26,17,'2022-05-19 12:41:57.000000',16),(28,5,'2022-05-18 11:41:57.000000',27),(29,39,'2022-05-18 14:28:37.000000',27),(30,16,'2022-05-18 17:15:17.000000',27),(31,34,'2022-05-18 20:01:57.000000',27),(32,15,'2022-05-18 22:48:37.000000',27),(33,19,'2022-05-19 01:35:17.000000',27),(34,20,'2022-05-19 04:21:57.000000',27),(35,1,'2022-05-19 07:08:37.000000',27),(36,10,'2022-05-19 09:55:17.000000',27),(37,28,'2022-05-19 12:41:57.000000',27),(41,18,'2022-05-18 11:41:57.000000',40),(42,7,'2022-05-18 14:28:37.000000',40),(43,30,'2022-05-18 17:15:17.000000',40),(44,8,'2022-05-18 20:01:57.000000',40),(45,38,'2022-05-18 22:48:37.000000',40),(46,12,'2022-05-19 01:35:17.000000',40),(47,23,'2022-05-19 04:21:57.000000',40),(48,1,'2022-05-19 07:08:37.000000',40),(49,2,'2022-05-19 09:55:17.000000',40),(50,45,'2022-05-19 12:41:57.000000',40),(53,16,'2022-05-18 11:41:57.000000',52),(54,28,'2022-05-18 14:28:37.000000',52),(55,23,'2022-05-18 17:15:17.000000',52),(56,39,'2022-05-18 20:01:57.000000',52),(57,10,'2022-05-18 22:48:37.000000',52),(58,31,'2022-05-19 01:35:17.000000',52),(59,17,'2022-05-19 04:21:57.000000',52),(60,45,'2022-05-19 07:08:37.000000',52),(61,5,'2022-05-19 09:55:17.000000',52),(62,48,'2022-05-19 12:41:57.000000',52),(65,31,'2022-05-18 11:41:57.000000',64),(66,25,'2022-05-18 14:28:37.000000',64),(67,46,'2022-05-18 17:15:17.000000',64),(68,32,'2022-05-18 20:01:57.000000',64),(69,7,'2022-05-18 22:48:37.000000',64),(70,45,'2022-05-19 01:35:17.000000',64),(71,26,'2022-05-19 04:21:57.000000',64),(72,5,'2022-05-19 07:08:37.000000',64),(73,9,'2022-05-19 09:55:17.000000',64),(74,27,'2022-05-19 12:41:57.000000',64),(76,29,'2022-05-18 11:41:57.000000',75),(77,18,'2022-05-18 14:28:37.000000',75),(78,47,'2022-05-18 17:15:17.000000',75),(79,3,'2022-05-18 20:01:57.000000',75),(80,17,'2022-05-18 22:48:37.000000',75),(81,22,'2022-05-19 01:35:17.000000',75),(82,34,'2022-05-19 04:21:57.000000',75),(83,46,'2022-05-19 07:08:37.000000',75),(84,24,'2022-05-19 09:55:17.000000',75),(85,8,'2022-05-19 12:41:57.000000',75);
/*!40000 ALTER TABLE `sensor_reading` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL,
  `is_admin` bit(1) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,_binary '','$2a$10$SSdbjhpLq1Jqga0xyUTxsONAdPevYWW4V6gdJOX4xZZIsbgzUvzdK','admin'),(14,_binary '\0','$2a$10$VcIRt0vOUbzeS9MCrQp93OcsUMH66xcZUdZNuSMLh4agO3/FNCape','John'),(38,_binary '\0','$2a$10$cPKdW9OLSP/uVwxhGEu07u6KdJ.b5gSf3oR/TAoSB/n5S.9PrgFG6','Mary'),(51,_binary '\0','$2a$10$CIs514rI/xEbWPJobyrqreLWDoBgZtAoEEOpnPYnLsF8ma9X7wZeC','Val');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-23 17:33:50
