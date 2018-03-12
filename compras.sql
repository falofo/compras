/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.1.10-MariaDB : Database - compras
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`compras` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;

USE `compras`;

/*Table structure for table `available_product` */

CREATE TABLE `available_product` (
  `available_id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_id` int(10) NOT NULL,
  `product_id` int(10) NOT NULL,
  PRIMARY KEY (`available_id`),
  KEY `available_id` (`available_id`),
  KEY `fk_available_product_customer_id` (`customer_id`),
  KEY `fk_available_product_product_id` (`product_id`),
  CONSTRAINT `fk_available_product_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `fk_available_product_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `available_product` */

insert  into `available_product`(`available_id`,`customer_id`,`product_id`) values (1,1,1);
insert  into `available_product`(`available_id`,`customer_id`,`product_id`) values (2,1,2);
insert  into `available_product`(`available_id`,`customer_id`,`product_id`) values (3,1,3);
insert  into `available_product`(`available_id`,`customer_id`,`product_id`) values (4,2,2);
insert  into `available_product`(`available_id`,`customer_id`,`product_id`) values (5,3,1);
insert  into `available_product`(`available_id`,`customer_id`,`product_id`) values (6,3,3);

/*Table structure for table `customer` */

CREATE TABLE `customer` (
  `customer_id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `customer` */

insert  into `customer`(`customer_id`,`name`,`email`) values (1,'Manny​ ​Bharma','mbharma@correo.com');
insert  into `customer`(`customer_id`,`name`,`email`) values (2,'Alan​ ​Briggs','abrigss@correo.com');
insert  into `customer`(`customer_id`,`name`,`email`) values (3,'Mike​ ​Simm','msimm@correo.com');

/*Table structure for table `order` */

CREATE TABLE `order` (
  `order_id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_id` int(10) DEFAULT NULL,
  `delivery_address` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`),
  KEY `fk_order_customer_id` (`customer_id`),
  CONSTRAINT `fk_order_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `order` */

/*Table structure for table `order_detail` */

CREATE TABLE `order_detail` (
  `detail_id` int(10) NOT NULL AUTO_INCREMENT,
  `product_id` int(10) NOT NULL,
  `order_id` int(10) NOT NULL,
  `quantity` int(10) NOT NULL,
  PRIMARY KEY (`detail_id`),
  KEY `fk_order_detail_product_id` (`product_id`),
  KEY `fk_order_detail_order_id` (`order_id`),
  CONSTRAINT `fk_order_detail_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`),
  CONSTRAINT `fk_order_detail_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `order_detail` */

/*Table structure for table `product` */

CREATE TABLE `product` (
  `product_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `price` decimal(10,0) NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `product` */

insert  into `product`(`product_id`,`name`,`price`) values (1,'Product A','9');
insert  into `product`(`product_id`,`name`,`price`) values (2,'Product B','11');
insert  into `product`(`product_id`,`name`,`price`) values (3,'Product C','13');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
