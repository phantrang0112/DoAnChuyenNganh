-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: qlyt
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
  `id` int NOT NULL AUTO_INCREMENT,
  `fullName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `img` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Phan Thị Trang','TrangPhan','phantrang011220@gmail.com','0327248445','https://bloganh.net/wp-content/uploads/2021/03/chup-anh-dep-anh-sang-min.jpg'),(2,'phan Thị  Hải Yến','phanyen','phanyen@gmail.com','0356265127','https://bloganh.net/wp-content/uploads/2021/03/chup-anh-dep-anh-sang-min.jpg');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bacsi`
--

DROP TABLE IF EXISTS `bacsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bacsi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `makhoa` int DEFAULT NULL,
  `img` varchar(1000) DEFAULT NULL,
  `username` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `khoa11_idx` (`makhoa`),
  KEY `khoa465_idx` (`makhoa`),
  CONSTRAINT `khoa11` FOREIGN KEY (`makhoa`) REFERENCES `khoa` (`ma`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bacsi`
--

LOCK TABLES `bacsi` WRITE;
/*!40000 ALTER TABLE `bacsi` DISABLE KEYS */;
INSERT INTO `bacsi` VALUES (1,'Bac si y','bacsi@gmail.com','0327248445',3,'https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2020/09/hinh-nen-dien-thoai-dep-moi-nhat-132.jpg?fit=564%2C20000&quality=95&ssl=1','Bacsi2'),(2,'Bacsi a','bacsia@gmail.com','0356265127',3,'https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2020/09/hinh-nen-dien-thoai-dep-moi-nhat-132.jpg?fit=564%2C20000&quality=95&ssl=1','Bacsi1'),(3,'Bác sĩ c','bacsic@gmail.com','0273789988',2,'https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2020/09/hinh-nen-dien-thoai-dep-moi-nhat-132.jpg?fit=564%2C20000&quality=95&ssl=1','bacsic'),(4,'Bac si d','bacsid@gmail.com','0356579887',2,'https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2020/09/hinh-nen-dien-thoai-dep-moi-nhat-132.jpg?fit=564%2C20000&quality=95&ssl=1','bacsid'),(5,'Bác sĩ an','bacsian@gmail.com','0327248445',3,'https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2020/09/hinh-nen-dien-thoai-dep-moi-nhat-132.jpg?fit=564%2C20000&quality=95&ssl=1','Bacsian'),(6,'Bác sĩ anh','bacsianh@gmail.com','0327248445',1,'https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2020/09/hinh-nen-dien-thoai-dep-moi-nhat-132.jpg?fit=564%2C20000&quality=95&ssl=1','Bacsianh');
/*!40000 ALTER TABLE `bacsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `benh`
--

DROP TABLE IF EXISTS `benh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benh` (
  `ma` int NOT NULL AUTO_INCREMENT,
  `tenbenh` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `maloaibenh` int DEFAULT NULL,
  PRIMARY KEY (`ma`),
  KEY `khoa10_idx` (`maloaibenh`),
  CONSTRAINT `khoa10` FOREIGN KEY (`maloaibenh`) REFERENCES `loaibenh` (`ma`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benh`
--

LOCK TABLES `benh` WRITE;
/*!40000 ALTER TABLE `benh` DISABLE KEYS */;
INSERT INTO `benh` VALUES (1,'corona',1),(2,'corona2',2),(3,'corona3',2),(4,'lao',2);
/*!40000 ALTER TABLE `benh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietsokhambenh`
--

DROP TABLE IF EXISTS `chitietsokhambenh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietsokhambenh` (
  `masokhambenh` int NOT NULL,
  `mabenh` int NOT NULL,
  PRIMARY KEY (`masokhambenh`,`mabenh`),
  KEY `khoa7_idx` (`mabenh`),
  CONSTRAINT `khoa5` FOREIGN KEY (`masokhambenh`) REFERENCES `sokhambenh` (`masokhambenh`),
  CONSTRAINT `khoa7` FOREIGN KEY (`mabenh`) REFERENCES `benh` (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietsokhambenh`
--

LOCK TABLES `chitietsokhambenh` WRITE;
/*!40000 ALTER TABLE `chitietsokhambenh` DISABLE KEYS */;
INSERT INTO `chitietsokhambenh` VALUES (11,1),(12,1),(14,1),(15,1),(18,1),(3,2),(11,2),(12,2),(13,2),(14,2),(15,2),(17,2),(18,2),(17,4);
/*!40000 ALTER TABLE `chitietsokhambenh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietsotiemchung`
--

DROP TABLE IF EXISTS `chitietsotiemchung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietsotiemchung` (
  `masotiemchung` int NOT NULL,
  `mavaccine` int NOT NULL,
  `solieu` int DEFAULT NULL,
  `trieuchungsautiem` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `trangthai` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`masotiemchung`,`mavaccine`),
  KEY `khoa4_idx` (`mavaccine`),
  CONSTRAINT `khoa3` FOREIGN KEY (`masotiemchung`) REFERENCES `sotiemchung` (`ma`),
  CONSTRAINT `khoa4` FOREIGN KEY (`mavaccine`) REFERENCES `vaccine` (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietsotiemchung`
--

LOCK TABLES `chitietsotiemchung` WRITE;
/*!40000 ALTER TABLE `chitietsotiemchung` DISABLE KEYS */;
INSERT INTO `chitietsotiemchung` VALUES (1,1,1,'khong','dã tiêm'),(1,2,1,'không','đã tiêm'),(1,3,1,NULL,'chua tiem');
/*!40000 ALTER TABLE `chitietsotiemchung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitiettoathuoc`
--

DROP TABLE IF EXISTS `chitiettoathuoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitiettoathuoc` (
  `matoathuoc` int NOT NULL,
  `mathuoc` int NOT NULL,
  `soluongdung` int DEFAULT NULL,
  `cachdung` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`matoathuoc`,`mathuoc`),
  KEY `khoa13_idx` (`mathuoc`),
  CONSTRAINT `khoa12` FOREIGN KEY (`matoathuoc`) REFERENCES `toathuoc` (`ma`),
  CONSTRAINT `khoa13` FOREIGN KEY (`mathuoc`) REFERENCES `thuoc` (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiettoathuoc`
--

LOCK TABLES `chitiettoathuoc` WRITE;
/*!40000 ALTER TABLE `chitiettoathuoc` DISABLE KEYS */;
INSERT INTO `chitiettoathuoc` VALUES (1,1,3,'Sáng 1, chiều 1'),(2,1,2,'Sáng 1,chiều 1'),(2,2,1,'sáng 0.5, chiều 0.5'),(3,1,5,'ngay 1 lan'),(5,1,2,'ngay 1 lan'),(6,1,1,'ngay 1 lan'),(6,2,4,'ngay 1 lan'),(7,1,3,'ngay 1 lan'),(7,2,2,'ngay 1 lan'),(8,1,1,'ngay 1 lan'),(9,1,1,'ngay 1 lan'),(9,2,3,'ngay 1 lan'),(10,1,3,'ngay 1 lan'),(11,2,2,'ngay 1 lan'),(12,1,1,'ngay 1 lan'),(12,2,2,'ngay 1 lan'),(13,2,2,'ngày uống 1 lần'),(13,4,4,'ngày uống 2 lần'),(14,2,2,'ngày uống 1 lần'),(14,4,1,'ngày uống 2 lần');
/*!40000 ALTER TABLE `chitiettoathuoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoa`
--

DROP TABLE IF EXISTS `khoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoa` (
  `ma` int NOT NULL AUTO_INCREMENT,
  `tenkhoa` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ma`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoa`
--

LOCK TABLES `khoa` WRITE;
/*!40000 ALTER TABLE `khoa` DISABLE KEYS */;
INSERT INTO `khoa` VALUES (1,'Ngoai'),(2,'Noi'),(3,'Chan Thuong'),(4,'Tai - Mui - Hong'),(5,'Nhi'),(6,'Truyen nhiem');
/*!40000 ALTER TABLE `khoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lichkham`
--

DROP TABLE IF EXISTS `lichkham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lichkham` (
  `idlichkham` int NOT NULL AUTO_INCREMENT,
  `mabacsi` int DEFAULT NULL,
  `userId` int DEFAULT NULL,
  `ngayhenkham` date DEFAULT NULL,
  `trangthai` varchar(205) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`idlichkham`),
  KEY `khoa50_idx` (`mabacsi`),
  KEY `khoa51_idx` (`userId`),
  CONSTRAINT `khoa50` FOREIGN KEY (`mabacsi`) REFERENCES `bacsi` (`id`),
  CONSTRAINT `khoa51` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lichkham`
--

LOCK TABLES `lichkham` WRITE;
/*!40000 ALTER TABLE `lichkham` DISABLE KEYS */;
INSERT INTO `lichkham` VALUES (2,2,1,'2021-12-22','Đã hủy'),(3,1,1,'2021-02-13','Đã khám'),(6,1,18,'2021-03-12','Đã khám'),(7,1,1,'2021-12-04','Đã khám'),(8,1,1,'2021-12-04','Đã khám'),(9,1,1,'2021-12-06','Đã khám'),(11,1,4,'2021-12-06','Đã khám'),(12,1,4,'2021-12-14','Đã khám'),(13,1,4,'2021-12-13','Đã khám'),(14,1,4,'2021-12-14','Đã khám'),(16,1,1,'2021-12-15','Đã khám'),(17,1,1,'2021-12-21','Chờ xác nhận'),(18,1,18,'2021-12-19','Đã khám'),(19,1,18,'2021-12-23','Chờ xác nhận'),(21,1,18,'2021-12-24','Đã đăng kí'),(23,1,1,'2021-12-23','Đã hủy'),(24,1,1,'2021-12-19','Đã khám'),(25,1,1,'2021-12-22','Chờ xác nhận'),(26,1,1,'2021-12-23','Chờ xác nhận'),(27,1,1,'2021-12-22','Chờ xác nhận');
/*!40000 ALTER TABLE `lichkham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lichtruc`
--

DROP TABLE IF EXISTS `lichtruc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lichtruc` (
  `ma` int NOT NULL AUTO_INCREMENT,
  `mabacsi` int DEFAULT NULL,
  `ngaytruc` datetime DEFAULT NULL,
  `Tuan` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ma`),
  KEY `khoa20_idx` (`mabacsi`),
  CONSTRAINT `khoa20` FOREIGN KEY (`mabacsi`) REFERENCES `bacsi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lichtruc`
--

LOCK TABLES `lichtruc` WRITE;
/*!40000 ALTER TABLE `lichtruc` DISABLE KEYS */;
INSERT INTO `lichtruc` VALUES (9,1,'2021-12-14 00:00:00','51'),(10,1,'2021-12-15 00:00:00','51'),(11,1,'2021-12-16 00:00:00','51'),(12,1,'2021-12-20 00:00:00','52'),(13,1,'2021-12-21 00:00:00','52'),(14,1,'2021-12-22 00:00:00','52'),(15,1,'2021-12-23 00:00:00','52'),(16,1,'2021-12-24 00:00:00','52'),(17,1,'2021-12-25 00:00:00','52');
/*!40000 ALTER TABLE `lichtruc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaibenh`
--

DROP TABLE IF EXISTS `loaibenh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaibenh` (
  `ma` int NOT NULL AUTO_INCREMENT,
  `tenloai` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ma`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaibenh`
--

LOCK TABLES `loaibenh` WRITE;
/*!40000 ALTER TABLE `loaibenh` DISABLE KEYS */;
INSERT INTO `loaibenh` VALUES (1,'loai1'),(2,'loai2');
/*!40000 ALTER TABLE `loaibenh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news` (
  `idNews` int NOT NULL AUTO_INCREMENT,
  `tieude` varchar(1000) DEFAULT NULL,
  `noidung` varchar(10000) DEFAULT NULL,
  `noidungthugon` varchar(1000) DEFAULT NULL,
  `img` varchar(1000) DEFAULT NULL,
  `ngaytao` date DEFAULT NULL,
  `idadmin` int DEFAULT NULL,
  PRIMARY KEY (`idNews`),
  KEY `khoangoaivoiadmin_idx` (`idadmin`),
  CONSTRAINT `khoangoaivoiadmin` FOREIGN KEY (`idadmin`) REFERENCES `admin` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'Bộ Y tế tiếp nhận 50.000 liều vaccine phòng COVID-19 AstraZeneca của Chính phủ Áo trao tặng','Chiều ngày 16/11, Thứ trưởng Bộ Y tế Đỗ Xuân Tuyên đã đại diện Bộ Y tế tiếp nhận 50.000 liều vaccine phòng COVID-19 AstraZeneca của Cộng hòa Áo tặng Việt Nam để  phục vụ công tác phòng chống dịch từ Ngài Hans-Peter Glanzer, Đại sứ Áo tại Việt Nam thay mặt Chính phủ Cộng hoà Áo trao tặng.','Thứ trưởng Bộ Y tế Đỗ Xuân Tuyên cho biết, Bộ Y tế sẽ phân bổ số vaccine phòng COVID-19 do Cộng hoà Áo trao tặng tới các đơn vị và địa phương căn cứ theo tình hình thực tế để đáp ứng yêu cầu phòng, chống dịch khẩn cấp, đảm bảo phù hợp, hiệu quả.','https://covid19.qltns.mediacdn.vn/354844073405468672/2021/11/16/dscf1067-1-16370455800251162382023-1637050116940-163705011861449746608.jpg','2021-11-11',1),(2,'Bảo đảm người dân được tiếp cận y tế từ sớm, từ cơ sở và thần tốc thực hiện chiến dịch tiêm chủng','Dự họp tại đầu cầu Trụ sở Chính phủ có Phó Thủ tướng, Phó Trưởng ban Ban Chỉ đạo Vũ Đức Đam, Bộ trưởng Bộ Y tế Nguyễn Thanh Long và lãnh đạo các bộ, ngành, cơ quan liên quan. ','Thủ tướng Phạm Minh Chính nhấn mạnh, để giảm ca mắc cộng đồng, ca chuyển nặng và giảm tối đa ca tử vong, phải thực hiện thật nghiêm túc, hiệu quả, quyết liệt các giải pháp đã đề ra, đặc biệt là bảo đảm người dân được tiếp cận y tế từ sớm, từ cơ sở và thần tốc thực hiện chiến dịch tiêm chủng','https://covid19.qltns.mediacdn.vn/354844073405468672/2021/12/17/img1712-1639666607143-1639666609091146290455-1639701723086-16397017235351326813086.jpg','2021-12-17',1),(3,'Ngày 18/12: Có 15.895 ca mắc COVID-19 tại 60 tỉnh, thành phố, riêng Hà Nội 1.244 ca','- Tính từ 16h ngày 17/12 đến 16h ngày 18/12, trên Hệ thống Quốc gia quản lý ca bệnh COVID-19 ghi nhận 15.895 ca nhiễm mới, trong đó 12 ca nhập cảnh và 15.883 ca ghi nhận trong nước (tăng 668 ca so với ngày trước đó) tại 60 tỉnh, thành phố (có 10.493 ca trong cộng đồng).','SKĐS - Bản tin dịch COVID-19 ngày 18/12 của Bộ Y tế cho biết có 15.895 ca mắc COVID-19 tại 60 tỉnh, thành phố, riêng Hà Nội 1.244 ca; trong ngày có 1.645 bệnh nhân khỏi; 248 trường hợp tử vong.','https://suckhoedoisong.qltns.mediacdn.vn/324455921873985536/2021/12/18/ca-moi-18-1639825181278164676440.jpeg','2021-12-18',1);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tenquyen` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'USER'),(3,'BACSI');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sokhambenh`
--

DROP TABLE IF EXISTS `sokhambenh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sokhambenh` (
  `masokhambenh` int NOT NULL AUTO_INCREMENT,
  `ngaykham` date NOT NULL,
  `malichkham` int NOT NULL,
  `matoathuoc` int DEFAULT NULL,
  PRIMARY KEY (`masokhambenh`),
  KEY `khoa52_idx` (`malichkham`),
  KEY `khoa90_idx` (`matoathuoc`),
  CONSTRAINT `khoa52` FOREIGN KEY (`malichkham`) REFERENCES `lichkham` (`idlichkham`),
  CONSTRAINT `khoa90` FOREIGN KEY (`matoathuoc`) REFERENCES `toathuoc` (`ma`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sokhambenh`
--

LOCK TABLES `sokhambenh` WRITE;
/*!40000 ALTER TABLE `sokhambenh` DISABLE KEYS */;
INSERT INTO `sokhambenh` VALUES (3,'2021-07-01',3,5),(7,'2021-12-01',7,1),(8,'2021-12-01',6,6),(10,'2021-12-05',8,7),(11,'2021-12-06',9,8),(12,'2021-12-06',11,9),(13,'2021-12-06',12,10),(14,'2021-12-06',13,11),(15,'2021-12-08',14,12),(16,'2021-12-17',16,NULL),(17,'2021-12-19',24,13),(18,'2021-12-19',18,14);
/*!40000 ALTER TABLE `sokhambenh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sotiemchung`
--

DROP TABLE IF EXISTS `sotiemchung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sotiemchung` (
  `ma` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `ngaytiem` date DEFAULT NULL,
  PRIMARY KEY (`ma`),
  KEY `khoa14_idx` (`userId`),
  CONSTRAINT `khoa14` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sotiemchung`
--

LOCK TABLES `sotiemchung` WRITE;
/*!40000 ALTER TABLE `sotiemchung` DISABLE KEYS */;
INSERT INTO `sotiemchung` VALUES (1,1,'2021-11-11');
/*!40000 ALTER TABLE `sotiemchung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `username` varchar(200) NOT NULL,
  `password` varchar(500) DEFAULT NULL,
  `idrole` int DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `khoangoai_idx` (`idrole`),
  CONSTRAINT `khoangoai` FOREIGN KEY (`idrole`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES ('Bacsi1','1234',2),('Bacsi2','$2a$10$fg/C8S8kZBUFqnWYBQu5I.bFWfjwtVS.y/G0IFQGrIOb5wYdmaL3S',3),('Bacsian','$2a$10$J7Scuk/p3sb.0/fxJv7br.V8ssn0.fJ7vK.8Jvn1fjbObF8VPNhQa',2),('Bacsianh','$2a$10$g03v66u5rNrS4PalWsJoOOB/VNB0B4ihEJZB8beHGZUImUma1DyGe',2),('bacsic','$2a$10$L7/FPGpBfCg5mIjHXZi89.0RfOgJNtNwptiG4tOkieFwD5FW88Xq2',3),('bacsid','$2a$10$L7/FPGpBfCg5mIjHXZi89.0RfOgJNtNwptiG4tOkieFwD5FW88Xq2',3),('phanyen','$2a$10$7T4CLy0NYRnObmP.gP5dAOEVuWNCJBSywG2RjL.uhW1W7V4WcAm/6',1),('tomsmith','$2a$10$ROrkfOFcIuJKujFLOkbr4OfqLyafTDJiLr9h2O8pJzSv4IrHtEczO',2),('Trang','1234',2),('trang1','$2a$10$vA6BKdH0IGy852ip3EJlvuI9D8VV71cpYgS.agxwQ7FsDUub8/kV.',2),('trang10','$2a$10$hg7nJHFODlwX8rL7RXlS1eRagb2sXicDL/aydPgS28/dwCmStweA2',2),('trang2','$2a$10$wVWQjNhzgo7gWLe28kFxH.QsDNJTxwgcmwPblGJyIq3tC2pbVBK2q',2),('trang5','$2a$10$XywCZAp0L61jU.Ez3Grg8eG/opSunAJ/PADTPP4Vgt1LcQhQQ5V82',2),('trang7','$2a$10$NzsuBQG.FIs1GWBeb.pVIuhTyiRKBBSbxDPPOKzaHlvEhoJ1Ex6FO',2),('trang9','$2a$10$E3XAnGCGYWJEazncxBQnSeU1dHlAR2EOgpCldqBiaKdXSUJT2QPX6',2),('TrangPhan','$2a$10$5VyDBvg9e9pEVGwsEmLaZ.xutIaVpyWDjlb4JBB.2L2oobDlZtyaa',2),('trangphan1','$2a$10$L7/FPGpBfCg5mIjHXZi89.0RfOgJNtNwptiG4tOkieFwD5FW88Xq2',2),('yennhi','$2a$10$qbPC1UjaXebpWa0qHMOvuuvnAThrFIIachDEt7Jm5zusPoWnUw1Wm',2);
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thuoc`
--

DROP TABLE IF EXISTS `thuoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thuoc` (
  `ma` int NOT NULL AUTO_INCREMENT,
  `tenthuoc` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `soluong` int DEFAULT NULL,
  `ngaynhap` date DEFAULT NULL,
  `hansudung` date DEFAULT NULL,
  `trangthai` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `donggoi` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ma`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thuoc`
--

LOCK TABLES `thuoc` WRITE;
/*!40000 ALTER TABLE `thuoc` DISABLE KEYS */;
INSERT INTO `thuoc` VALUES (1,'verocell',2,'2021-01-01','2022-01-01','tốt','vỉ'),(2,'thuốc 2',1,'2021-02-02','2022-03-03','tốt','vỉ'),(3,'panadol',2,'2021-03-03','2022-03-03','tot','vi'),(4,'paracetamol',5,'2021-05-05','2022-05-05','tot','vi'),(5,'siro ho',10,'2021-04-04','2022-04-04','tot','chai');
/*!40000 ALTER TABLE `thuoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toathuoc`
--

DROP TABLE IF EXISTS `toathuoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `toathuoc` (
  `ma` int NOT NULL AUTO_INCREMENT,
  `ngaytao` date DEFAULT NULL,
  PRIMARY KEY (`ma`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toathuoc`
--

LOCK TABLES `toathuoc` WRITE;
/*!40000 ALTER TABLE `toathuoc` DISABLE KEYS */;
INSERT INTO `toathuoc` VALUES (1,'2021-01-01'),(2,'2021-02-02'),(3,'2021-12-04'),(4,'2021-12-04'),(5,'2021-12-04'),(6,'2021-12-05'),(7,'2021-12-05'),(8,'2021-12-06'),(9,'2021-12-06'),(10,'2021-12-06'),(11,'2021-12-06'),(12,'2021-12-08'),(13,'2021-12-19'),(14,'2021-12-19');
/*!40000 ALTER TABLE `toathuoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(200) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `img` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'trangphan','TrangPhan','trang1234@gmail.com','0327764465','https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2020/09/hinh-nen-dien-thoai-dep-moi-nhat-132.jpg?fit=564%2C20000&quality=95&ssl=1'),(4,'phan thi trang','Trang đẹp gái','phantrang151220@gmail.com','0327248445','https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2020/09/hinh-nen-dien-thoai-dep-moi-nhat-132.jpg?fit=564%2C20000&quality=95&ssl=1'),(18,'phan yến nhi','yennhi','abc@gmail.com','0356265127','https://elead.com.vn/wp-content/uploads/2020/04/tai-anh-thien-nhien-20-1400x788-3.jpg'),(19,'phan thi trang','trangphan1','phantrang011220@gmail.com','0327248445',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaccine`
--

DROP TABLE IF EXISTS `vaccine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaccine` (
  `ma` int NOT NULL AUTO_INCREMENT,
  `tenvaccine` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `trangthaivaccine` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ngaynhap` date DEFAULT NULL,
  `hansudung` date DEFAULT NULL,
  `soluong` int DEFAULT NULL,
  PRIMARY KEY (`ma`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaccine`
--

LOCK TABLES `vaccine` WRITE;
/*!40000 ALTER TABLE `vaccine` DISABLE KEYS */;
INSERT INTO `vaccine` VALUES (1,'Vaccine bạch hầu','tốt','2021-10-12','2023-10-12',5),(2,'Vaccine bại liệt','tổt','2021-10-12','2023-10-12',13),(3,'Vacine covid','tốt','2021-10-12','2032-10-12',12),(4,'Vaccine lao','tot','2021-10-12','2023-10-12',20),(5,'Vaccine viem nao Nhat Ban','tot','2021-10-12','2023-10-12',15);
/*!40000 ALTER TABLE `vaccine` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-23  9:49:29
