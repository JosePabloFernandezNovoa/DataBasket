CREATE DATABASE  IF NOT EXISTS `nba` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `nba`;
create user nba@localhost identified by 'nba';
grant all on nba.* to nba@localhost;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: nba
-- ------------------------------------------------------
-- Server version	5.7.32-log

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
-- Table structure for table `equipos`
--

DROP TABLE IF EXISTS `equipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipos` (
  `idEquipo` smallint(6) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `Ciudad` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `Conferencia` varchar(4) COLLATE utf8_spanish_ci NOT NULL,
  `Division` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `Entrenador` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Mascota` varchar(20) COLLATE utf8_spanish_ci NULL,
  `Logotipo` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idEquipo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipos`
--

LOCK TABLES `equipos` WRITE;
/*!40000 ALTER TABLE `equipos` DISABLE KEYS */;
INSERT INTO `equipos` VALUES (1,'Celtics','Boston','East','Atlantic','Brad Stevens','Lucky the Leprechaun','celtics.png'),(2,'Raptors','Toronto','East','Atlantic','Nick Nurse','Raptor','raptors.png'),(3,'Bulls','Chicago','East','Central','Billy Donovan','Benny the Bull','bulls.png'),(4,'Bucks','Milwaukee','East','Central','Mike Budenholzer','Bango','bucks.png'),(5,'Lakers','Los Angeles','West','Pacific','Frank Vogel','NULL','lakers.png'),(6,'Warriors','Golden State','West','Pacific','Steve Kerr','Thunder','warriors.png'),(7,'Mavericks','Dallas','West','SouthWest','Rick Carlisle','Cowboy','dallas.png');
/*!40000 ALTER TABLE `equipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadisticas`
--

DROP TABLE IF EXISTS `estadisticas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadisticas` (
  `idEstadistica` smallint(6) NOT NULL,
  `idJugador` smallint(6) NOT NULL,
  `idPartido` smallint(6) NOT NULL,
  `temporada` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `puntosPartido` smallint(6) NOT NULL,
  `asistenciasPartido` smallint(6) NOT NULL,
  `taponesPartido` smallint(6) NOT NULL,
  `rebotesPartido` smallint(6) NOT NULL,
  PRIMARY KEY (`idEstadistica`),
  KEY `FK_estadisticas_jugadores` (`idJugador`),
  KEY `FK_estadisticas_partido` (`idPartido`),
  CONSTRAINT `FK_estadisticas_jugadores` FOREIGN KEY (`idJugador`) REFERENCES `jugadores` (`idJugador`),
  CONSTRAINT `FK_estadisticas_partido` FOREIGN KEY (`idPartido`) REFERENCES `partidos` (`idPartido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadisticas`
--

LOCK TABLES `estadisticas` WRITE;
/*!40000 ALTER TABLE `estadisticas` DISABLE KEYS */;
INSERT INTO `estadisticas` VALUES (1,6,4,'20/21',25,5,6,9),(5,6,28,'20/21',25,5,11,6),(6,6,1,'20/21',25,5,6,9),(7,6,2,'20/21',28,10,11,6),(8,6,3,'20/21',19,4,9,8),(9,6,5,'20/21',21,7,8,16),(10,2,25,'20/21',10,7,6,9),(11,2,6,'20/21',17,10,17,5),(12,2,27,'20/21',22,4,6,5),(13,2,28,'20/21',30,9,8,13),(14,2,29,'20/21',20,5,6,7),(15,2,30,'20/21',21,5,11,10),(16,5,6,'20/21',1,10,6,15),(17,5,27,'20/21',2,4,6,9),(18,5,28,'20/21',1,8,8,13),(19,5,29,'20/21',9,9,10,12),(20,5,30,'20/21',1,5,11,10),(21,10,1,'20/21',20,5,6,3),(22,10,2,'20/21',8,10,2,4),(23,10,3,'20/21',10,4,6,7),(24,10,4,'20/21',9,7,3,6),(25,10,5,'20/21',18,7,1,6),(26,10,28,'20/21',7,7,2,5),(27,5,25,'20/21',6,7,10,12);
/*!40000 ALTER TABLE `estadisticas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugadores` (
  `idJugador` smallint(6) NOT NULL AUTO_INCREMENT,
  `idEquipo` smallint(6) NOT NULL,
  `Nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `Procedencia` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `Altura` varchar(4) COLLATE utf8_spanish_ci NOT NULL,
  `Peso` tinyint(3) NOT NULL,
  `Edad` tinyint(2) NOT NULL,
  `Posicion` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `Nacionalidad` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Foto` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idJugador`),
  KEY `FK_jugadores_equipos` (`idEquipo`),
  CONSTRAINT `FK_jugadores_equipos` FOREIGN KEY (`idEquipo`) REFERENCES `equipos` (`idEquipo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES (2,5,'Kobe Bryant','Lower Merion HS (PA)','205',95,24,'Base','EEUU','kobe.png'),(3,5,'Andrew Bynum','St. Joseph HS (NJ)','185',95,24,'Pivot','EEUU','avatar.png'),(5,5,'Derek Fisher','Arkansas-Little Rock','210',95,21,'Escolta','EEUU','avatar.png'),(6,1,'Ray Allen','Connecticut','205',97,28,'Alero','EEUU','rayAllen.png'),(9,1,'Sam Cassell','Florida State','180',91,30,'Ala-Pivot','EEUU','avatar.png'),(10,1,'Glen Davis','Louisiana State','195',90,20,'Escolta','EEUU','avatar.png');
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partidos`
--

DROP TABLE IF EXISTS `partidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partidos` (
  `idPartido` smallint(6) NOT NULL AUTO_INCREMENT,
  `equipoLocal` smallint(6) NOT NULL,
  `equipoVisitante` smallint(6) NOT NULL,
  `puntosLocal` tinyint(3) NOT NULL,
  `puntosVisitante` tinyint(3) NOT NULL,
  `temporada` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idPartido`),
  KEY `FK_partido_equiposL` (`equipoLocal`),
  KEY `FK_partido_equiposV` (`equipoVisitante`),
  CONSTRAINT `FK_partido_equiposL` FOREIGN KEY (`equipoLocal`) REFERENCES `equipos` (`idEquipo`),
  CONSTRAINT `FK_partido_equiposV` FOREIGN KEY (`equipoVisitante`) REFERENCES `equipos` (`idEquipo`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partidos`
--

LOCK TABLES `partidos` WRITE;
/*!40000 ALTER TABLE `partidos` DISABLE KEYS */;
INSERT INTO `partidos` VALUES (1,1,2,74,117,'20/21'),(2,1,3,105,100,'20/21'),(3,1,4,98,99,'20/21'),(4,1,5,78,127,'20/21'),(5,1,6,122,123,'20/21'),(6,1,7,94,88,'20/21'),(7,2,1,99,108,'20/21'),(8,2,3,111,100,'20/21'),(9,2,4,92,95,'20/21'),(10,2,5,78,101,'20/21'),(11,2,6,106,93,'20/21'),(12,2,7,98,121,'20/21'),(13,3,1,84,91,'20/21'),(14,3,2,111,100,'20/21'),(15,3,4,92,95,'20/21'),(16,3,5,96,123,'20/21'),(17,3,6,106,93,'20/21'),(18,3,7,102,121,'20/21'),(19,4,1,84,91,'20/21'),(20,4,2,111,100,'20/21'),(21,4,3,92,95,'20/21'),(22,4,5,96,123,'20/21'),(23,4,6,106,93,'20/21'),(24,4,7,102,121,'20/21'),(25,5,2,74,117,'20/21'),(26,5,3,105,100,'20/21'),(27,5,4,98,99,'20/21'),(28,5,1,78,127,'20/21'),(29,5,6,122,123,'20/21'),(30,5,7,94,88,'20/21'),(31,6,1,99,108,'20/21'),(32,6,3,111,100,'20/21'),(33,6,4,92,95,'20/21'),(34,6,5,78,101,'20/21'),(35,6,2,106,93,'20/21'),(36,6,7,98,121,'20/21'),(37,7,1,99,108,'20/21'),(38,7,3,111,100,'20/21'),(39,7,4,92,95,'20/21'),(40,7,5,78,101,'20/21'),(41,7,6,106,93,'20/21'),(42,7,2,98,121,'20/21');
/*!40000 ALTER TABLE `partidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idUsuario` smallint(6) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(128) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(9) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `rol` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `avatar` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin@gmail.com','202cb962ac59075b964b07152d234b70','Administrador',NULL,NULL,'2021-05-25','ADMIN','avatar.png'),(2,'usuario1@gmail.com','202cb962ac59075b964b07152d234b70','Usuario1','Prueba1','638528932','2021-05-05','USER','avatar.png');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-07 13:22:30
