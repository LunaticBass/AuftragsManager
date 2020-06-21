-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: kmanager
-- ------------------------------------------------------
-- Server version	8.0.19


--
-- Table structure for table `artikel`
--

DROP TABLE IF EXISTS `artikel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `artikel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bestellung_ID` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `groesse` varchar(45) DEFAULT NULL,
  `anmerkung` varchar(45) DEFAULT NULL,
  `DTYPE` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `bestellung`
--

DROP TABLE IF EXISTS `bestellung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `bestellung` (
  `id` int NOT NULL AUTO_INCREMENT,
  `kunden_ID` int DEFAULT NULL,
  `datum` datetime DEFAULT NULL,
  `rabatt` double DEFAULT NULL,
  `versandkosten` double DEFAULT NULL,
  `endsumme` double DEFAULT NULL,
  `waehrung` varchar(45) DEFAULT NULL,
  `bezahlt` bit(1) DEFAULT NULL,
  `versendet` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `kunde`
--

DROP TABLE IF EXISTS `kunde`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `kunde` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `adresse` varchar(100) DEFAULT NULL,
  `telefon` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

