-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Sep 10, 2018 at 07:22 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+07:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `simple-ecommerce`
--
CREATE Database simple_ecommerce_db;
USE simple_ecommerce_db;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

--
-- Table structure for table `product_temp`
--



CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `category_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `parent_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `category_name`, `parent_id`) VALUES
(1, 'Fashion', NULL),
(2, 'Electronics', NULL),
(3, 'Clothing for Women', 1),
(4, 'Clothing for Men', 1),
(5, 'Mobiles & Tablets', 2),
(6, 'Computers & Laptops', 2),
(7, 'Apple', 5),
(8, 'Samsung', 5),
(9, 'Supuer Dry', 4),
(10, 'Quilla', 3),
(11, 'Dell', 6);


--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);


--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `product_name` varchar(200) NOT NULL,
  `category_id` int(11) NOT NULL,
  `created_date` date NOT NULL,
  `price` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--







INSERT INTO `product` (`id`, `product_name`, `category_id`, `created_date`, `price`) VALUES
(1, 'Orange Label Cotton Crew Jumper', 9, '2017-11-09', '1500.00'),
(2, 'Orange Label Cotton Crew Jumper', 9, '2017-10-03', '1500.00'),
(3, 'Air Corps Bomber Jacket', 9, '2017-09-03', '8000.00'),
(4, 'Orange Label Cotton Crew Jumper', 9, '2017-04-08', '1500.00'),
(5, 'Arctic Pop Zip Hooded SD-Windcheater', 9, '2017-07-16', '7000.00'),
(6, 'Classic Pique Polo Shirt', 9, '2017-11-25', '3000.00'),
(7, 'Orange Label Cotton Crew Jumper', 9, '2017-09-04', '1500.00'),
(8, 'Rotor Leather 4 Pocket Jacket', 9, '2017-07-16', '12000.00'),
(9, 'Classic Pique Polo Shirt', 9, '2017-11-24', '3000.00'),
(10, 'Vintage Logo Hoodie', 9, '2017-05-08', '3200.00'),
(11, 'Watch 4', 7, '2017-10-21', '15000.00'),
(12, 'iPhone 8', 7, '2017-04-15', '17000.00'),
(13, 'iPhone 7', 7, '2017-11-13', '15000.00'),
(14, 'iPhone SE', 7, '2017-07-15', '12000.00'),
(15, 'iPhone Xs', 7, '2017-03-31', '49999.00'),
(16, 'iPhone 7', 7, '2017-02-07', '15000.00'),
(17, 'Watch 4', 7, '2017-02-09', '15000.00'),
(18, 'iPhone 7', 7, '2017-09-17', '15000.00'),
(19, 'iPad Pro', 7, '2017-01-17', '22000.00'),
(20, 'iPhone SE', 7, '2017-09-08', '12000.00'),
(21, 'Galaxy On5 8GB', 8, '2017-04-07', '12000.00'),
(22, 'Galaxy On5 8GB', 8, '2017-06-14', '12000.00'),
(23, 'Galaxy Note9', 8, '2017-01-10', '25000.00'),
(24, 'Galaxy Tab A', 8, '2017-05-20', '12000.00'),
(25, 'Galaxy J3 Emerge', 8, '2017-01-05', '12000.00'),
(26, 'Galaxy Tab A', 8, '2017-01-08', '12000.00'),
(27, 'Galaxy J7 Prime', 8, '2017-03-10', '12000.00'),
(28, 'Galaxy J3 16GB', 8, '2017-08-31', '12000.00'),
(29, 'Galaxy S9', 8, '2017-08-26', '22000.00'),
(30, 'Galaxy J3 16GB', 8, '2017-02-13', '12000.00'),
(31, 'QUILLA ชุดเดรสสไตล์เกาหลี Tri-Tone Long Pleated Dress', 10, '2017-02-23', '799.00'),
(32, 'QUILLA European Wrap-around | Asymmetrical | Classic Maxi Dresses 2017', 10, '2017-11-05', '900.00'),
(33, 'QUILLA เสื้อกันหนาว European NYC Printed Striped Sleeves ', 10, '2017-02-09', '350.00'),
(34, 'QUILLA เสื้อกันหนาว Classic Monochrome European Sweater', 10, '2017-01-03', '380.00'),
(35, 'QUILLA เสื้อกันหนาว European NYC Printed Striped Sleeves ', 10, '2017-06-05', '350.00'),
(36, 'QUILLA แจ็คเก็ตฤดูหนาว Standing Hooded Collar Invisible Zipper Snap Button Down Coat with Chic Patch Designs', 10, '2017-03-12', '850.00'),
(37, 'QUILLA เสื้อกันหนาว Classic Monochrome European Sweater', 10, '2017-02-22', '380.00'),
(38, 'QUILLA Bestselling Winter Jacket Korean Free Winter Leggings', 10, '2017-09-07', '599.00'),
(39, 'QUILLA แจ็คเก็ตกันหนาว เสื้อโค้ท Classic Slim Fit Single Button Coat', 10, '2017-05-07', '1200.00'),
(40, 'QUILLA เสื้อกันหนาว Classic Monochrome European Sweater', 10, '2017-01-02', '380.00'),
(41, 'G7 17\"', 11, '2017-06-11', '15000.00'),
(42, '7000 Gaming Series', 11, '2017-07-03', '47000.00'),
(43, 'G7 17\"', 11, '2017-09-12', '15000.00'),
(44, 'G7 17\"', 11, '2017-10-21', '15000.00'),
(45, '7000 Gaming Series', 11, '2017-04-14', '47000.00'),
(46, 'XPS 13', 11, '2017-09-12', '65000.00'),
(47, 'XPS 15', 11, '2017-10-07', '68000.00'),
(48, '7000 Gaming Series', 11, '2017-07-12', '47000.00'),
(49, 'XPS 13', 11, '2017-05-23', '65000.00'),
(50, 'G7 17\"', 11, '2017-01-12', '15000.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
COMMIT;
