-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: pet_directory
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `adoption`
--

DROP TABLE IF EXISTS `adoption`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adoption` (
  `adoption_id` int NOT NULL AUTO_INCREMENT,
  `adoption_date` datetime DEFAULT NULL,
  `adoption_result` varchar(20) DEFAULT NULL,
  `record_date` datetime DEFAULT NULL,
  `enabled` int DEFAULT 1,
  `pet_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`adoption_id`),
  UNIQUE KEY `adoption_idx_1` (`user_id`,`pet_id`,`adoption_id`),
  KEY `adoption_ibfk_1` (`pet_id`),
  CONSTRAINT `adoption_ibfk_1` FOREIGN KEY (`pet_id`) REFERENCES `pet` (`pet_id`),
  CONSTRAINT `adoption_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adoption`
--

LOCK TABLES `adoption` WRITE;
/*!40000 ALTER TABLE `adoption` DISABLE KEYS */;
/*!40000 ALTER TABLE `adoption` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(60) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `enabled` int DEFAULT 1,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES 
(1,'admincat','$2a$10$zVE/XTTbGleVFha9a7EmTOkQlcYrM3wDEMhishUYLGxzf25MqXjQy','Leo','0988555444','1998-08-08','silentcat5360@gmail.com','男','貓貓市貓貓區貓貓路11號',1),
(2,'cat22222','$2a$10$KrJPMQ8cooME09yHnHQRi.c3/d9B1sezINczme/khxd2z08FV84d6','Henry','0912555666','1990-02-02','cat2@cat.com','男','貓貓市貓貓區貓貓路12號',1),
(3,'cat33333','$2a$10$6Aaa9dilSyAVctiIDIKk6.77wcZm8ZcB31kyV2Wu5yt7/FVjCG2w.','Krostan','0912777888','1999-03-03','cat3@cat.com','男','貓貓市貓貓區貓貓路13號',1),
(4,'cat44444','$2a$10$KxrjHuCKyYZHHQTS9vIy3e7OmeugnmyJY/n6Ieep8d9zSAcTocdZm','Alvin','0912999000','1990-04-05','cat4@cat.com','男','貓貓市貓貓區貓貓路14號',1),
(5,'cat55555','$2a$10$botcOISXuKXD/BCRqqm.JOWX5jsz7aOyQnds2bSnYFEbs.TgRG2gO','Jack','0912111222','1999-05-05','cat5@cat.com','女','貓貓市貓貓區貓貓路15號',1),
(6,'cat66666','$2a$10$wsFbMKGDMThdfAnDsrztv./YccXmK/.gtYuzyr7c3/N/9SYCgEWPe','Kit','0922555113','1999-06-06','cat6@gamil.com','女','貓貓市貓貓區貓貓路16號',1),
(7,'cat77777','$2a$10$g.jsJYiQrlfvw3QhJccWw.9gU8/eyAqBAz2oV6/MTLdgJHtpoMoW.','Ken','0988554441','1999-07-07','cat7@gamil.com','女','貓貓市貓貓區貓貓路17號',1),
(8,'cat88888','$2a$10$om/9ONd3AWqmT153rtMD4eZJ4U4ei.WvNKvkFkPdcTBUM5Vzx4Qym','Joe','0955888999','1999-08-08','cat8@gmail.com','女','貓貓市貓貓區貓貓路18號',1),
(9,'cat99999','$2a$10$zwtaqG41mMfWuBAFhLRNsu6KgXD5O/0Vo9kTYV0G6RWq0AWDbg1/i','阿布','0955444111','1999-09-09','cat9@gmail.com','女','貓貓市貓貓區貓貓路19號',1);

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissions` (
  `user_id` int NOT NULL,
  `role` enum('系統管理者','管理者','使用者') NOT NULL,
  UNIQUE KEY `permissions_idx_1` (`user_id`),
  CONSTRAINT `permissions_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
INSERT INTO `permissions` VALUES (1,'系統管理者');
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pet`
--

DROP TABLE IF EXISTS `pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pet` (
  `pet_id` int NOT NULL AUTO_INCREMENT,
  `pet_name` varchar(45) DEFAULT NULL,
  `breed` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `coat_color` varchar(45) DEFAULT NULL,
  `age` varchar(20) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `species` varchar(50) DEFAULT NULL,
  `size` varchar(50) DEFAULT NULL,
  `quest` varchar(500) DEFAULT NULL,
  `photos` varchar(255) DEFAULT NULL,
  `enabled` int DEFAULT 1,
  `user_id` int NOT NULL,
  PRIMARY KEY (`pet_id`),
  KEY `pet_ibfk_1` (`user_id`),
  FULLTEXT KEY `fulltext_keywordSearch_idx` (`pet_name`,`breed`,`gender`,`coat_color`,`age`,`location`,`species`,`size`,`quest`),
  CONSTRAINT `pet_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet`
--

LOCK TABLES `pet` WRITE;
/*!40000 ALTER TABLE `pet` DISABLE KEYS */;
INSERT INTO `pet` VALUES 
(2,'拉拉','金吉拉','公','黃色','2','桃園','貓','中型','家要大','images\\1\\202306280156金吉拉.jpeg','N',1),
(3,'拉布','拉不拉多','公','藍色','1','台北','狗','大型','家要小','images\\1\\202306280156拉不拉多.jpg','N',1),
(4,'魯夫','哈士奇','公','灰色','2','屏東','狗','小型','小窩要有船','images\\1\\202306280156哈士奇.jpg','N',1),
(5,'炭炭郎','布偶貓','公','白色','1','高雄','貓','小型','家庭美滿','images\\1\\202306280156布偶貓.jpg','N',1),
(6,'布魯托','愛斯基摩犬','公','黃色','10','台東','狗','中大型','要有山','images\\1\\202306280157愛斯基摩犬.jpg','N',1),
(7,'香吉士','泰迪犬','公','咖啡色','1','桃園','狗','小型','喜歡美女','images\\1\\202306280203泰迪犬.jpg','N',1),
(8,'安納','柏曼貓','母','黑白色','2','台北','貓','中型','毛偏多,需要常開冷氣','images\\1\\202306280159柏曼貓.jpg','N',1),
(9,'凱凱','短毛貓','公','白色','1','宜蘭','貓','中型','毛偏多,需要常開冷氣','images\\1\\202306280203短毛貓.jpeg','N',1),
(10,'嗚嗚','長毛貓','母','灰色','2','桃園','貓','中型','毛很多,自己保重','images\\2\\202306280200金吉拉2.jpeg','N',2),
(11,'禮李','米克斯','公','黑白色','3','新竹','狗','大型','希望不是狗溜你','images\\2\\202306280200米克斯.jpg','N',2),
(12,'四月','垂耳兔','公','蛋黃奶油色','1','苗栗','兔','小型','耳朵常需要注意,需要養在室內','images\\2\\202306280200垂耳兔.jpg','N',2),
(13,'洛洛','米克斯','母','黑色','1','嘉義','貓','中型','請保重','images\\2\\202306280201米克斯貓2.jpg','N',2),
(14,'推進','鬆獅犬','母','橘黃色','3','桃園','狗','大型','非常需要冷氣房','images\\2\\202306280201鬆獅犬.jpg','N',2),
(15,'德克','波斯貓','母','黑色','1','台南','貓','中型','高冷,要有貓奴才的心理準備','images\\2\\202306280201波斯貓.jpg','N',2),
(16,'八月','曼赤肯貓','母','橘白色','1','台北','貓','中型','小短腿,值得你擁有','images\\2\\202306280201曼赤肯.jpg','N',2),
(19,'號角','米克斯','母','黃色','6個月','桃園','貓','中型','喜歡捕獵','images\\2\\202306280201米克斯貓.jpg','N',2);
/*!40000 ALTER TABLE `pet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publish`
--

DROP TABLE IF EXISTS `publish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publish` (
  `publish_id` int NOT NULL AUTO_INCREMENT,
  `publish_date` datetime DEFAULT NULL,
  `enabled` int DEFAULT 1,
  `pet_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`publish_id`),
  UNIQUE KEY `publish_idx_1` (`user_id`,`pet_id`),
  KEY `publish_ibfk_1` (`pet_id`),
  CONSTRAINT `publish_ibfk_1` FOREIGN KEY (`pet_id`) REFERENCES `pet` (`pet_id`) ON DELETE CASCADE,
  CONSTRAINT `publish_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publish`
--

LOCK TABLES `publish` WRITE;
/*!40000 ALTER TABLE `publish` DISABLE KEYS */;
/*!40000 ALTER TABLE `publish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reset_tokens`
--

DROP TABLE IF EXISTS `reset_tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reset_tokens` (
  `user_id` int NOT NULL,
  `token` varchar(36) DEFAULT NULL,
  `expiration_date` datetime DEFAULT NULL,
  `is_used` varchar(10) DEFAULT 'N',
  UNIQUE KEY `reset_tokens_idx_1` (`user_id`,`token`),
  CONSTRAINT `reset_tokens_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reset_tokens`
--

LOCK TABLES `reset_tokens` WRITE;
/*!40000 ALTER TABLE `reset_tokens` DISABLE KEYS */;
/*!40000 ALTER TABLE `reset_tokens` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-28 14:04:25
