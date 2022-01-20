CREATE DATABASE  IF NOT EXISTS `flyawaydb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `flyawaydb`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: flyawaydb
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `email` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  `firstname` varchar(60) NOT NULL,
  `lastname` varchar(60) NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('mishrapriyanka14@gmail.com','123','Priyanka','Mishra');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `traveldate` date NOT NULL,
  `flight_no` int DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `no_of_passengers` int NOT NULL,
  PRIMARY KEY (`booking_id`),
  UNIQUE KEY `booking_id` (`booking_id`),
  KEY `flight_no` (`flight_no`),
  KEY `email` (`email`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`flight_no`) REFERENCES `flights` (`flight_no`),
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`email`) REFERENCES `users` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (4,'2022-02-10',1,'anay@gmail.com',3),(5,'2022-02-14',1,'anay@gmail.com',5),(6,'2022-02-14',1,'saanvi@gmail.com',30),(7,'2022-02-14',1,'ram@gmail.com',60),(8,'2022-02-14',1,'anay@gmail.com',3),(9,'2022-02-14',1,'anay@gmail.com',1),(10,'2022-02-14',2,'saanvi@gmail.com',4),(11,'2022-02-14',2,'saanvi@gmail.com',10),(12,'2022-02-14',11,'saanvi@gmail.com',3),(13,'2022-02-14',2,'priyanka@gmail.com',4),(14,'2022-01-21',2,'priyanka@gmail.com',3),(15,'2022-01-21',2,'priyanka@gmail.com',3),(16,'2022-02-13',1,'saanvi@gmail.com',2),(17,'2022-02-13',1,'saanvi@gmail.com',3),(18,'2022-02-13',1,'anay@gmail.com',4),(19,'2022-02-13',1,'priyanka@gmail.com',4),(20,'2022-02-12',1,'saanvi@gmail.com',3);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flights`
--

DROP TABLE IF EXISTS `flights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flights` (
  `flight_no` int NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL,
  `available_seat` int NOT NULL,
  `departure_time` time NOT NULL,
  `arrival_time` time NOT NULL,
  `route_id` int DEFAULT NULL,
  PRIMARY KEY (`flight_no`),
  UNIQUE KEY `flight_no` (`flight_no`),
  KEY `route_id` (`route_id`),
  CONSTRAINT `flights_ibfk_1` FOREIGN KEY (`route_id`) REFERENCES `routes` (`route_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flights`
--

LOCK TABLES `flights` WRITE;
/*!40000 ALTER TABLE `flights` DISABLE KEYS */;
INSERT INTO `flights` VALUES (1,2000,100,'07:10:00','08:30:00',1),(2,3000,100,'09:10:00','11:00:00',1),(3,4000,120,'08:45:00','10:00:00',4),(4,2000,120,'08:45:00','10:00:00',2),(5,2000,120,'10:45:00','11:40:00',2),(6,7000,100,'04:00:00','05:10:00',2),(7,1500,120,'03:00:00','04:30:00',1),(8,3000,120,'10:00:00','11:00:00',5),(9,6000,120,'10:00:00','11:00:00',6),(10,6000,120,'10:00:00','11:00:00',7),(11,7000,120,'10:00:00','11:00:00',8),(12,4000,120,'10:00:00','11:00:00',9),(13,4000,120,'12:00:00','13:00:00',4),(14,9000,120,'12:00:00','13:00:00',4),(15,3000,120,'14:00:00','15:40:00',7),(16,3000,120,'14:00:00','15:40:00',5),(17,3000,120,'14:00:00','15:40:00',9),(18,4000,120,'16:00:00','17:40:00',6),(19,1000,100,'02:00:00','03:00:00',6);
/*!40000 ALTER TABLE `flights` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routes`
--

DROP TABLE IF EXISTS `routes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routes` (
  `route_id` int NOT NULL AUTO_INCREMENT,
  `source` varchar(20) NOT NULL,
  `destination` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`route_id`),
  UNIQUE KEY `route_id` (`route_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routes`
--

LOCK TABLES `routes` WRITE;
/*!40000 ALTER TABLE `routes` DISABLE KEYS */;
INSERT INTO `routes` VALUES (1,'Indore','Pune'),(2,'Pune','Indore'),(4,'Hyderabad','Pune'),(5,'Surat','Delhi'),(6,'Mumbai','Delhi'),(7,'Lucknow','Delhi'),(8,'Pune','Goa'),(9,'Goa','Mumbai');
/*!40000 ALTER TABLE `routes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `email` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  `firstname` varchar(60) NOT NULL,
  `lastname` varchar(60) NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('anay@gmail.com','123','Anay','Pandit'),('priyanka@gmail.com','Priya#123','Priyanka','Pandit'),('ram@gmail.com','123','Ram','Chandra'),('saanvi@gmail.com','123','Saanvi','Mishra');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-17 22:33:40
