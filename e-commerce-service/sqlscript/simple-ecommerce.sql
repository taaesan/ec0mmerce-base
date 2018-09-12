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
(3, 'Home & Living', NULL),
(4, 'Leisure & Sports', NULL),
(5, 'Health & Beauty', NULL),
(6, 'Kids & Babies', NULL),
(7, 'Grocery', NULL),
(8, 'E-voucher & Books', NULL),
(9, 'Clothing for Women', 1),
(10, 'Clothing for Men', 1),
(11, 'Bags & Shoes', 1),
(12, 'Watches, Sunglasses & Jewellery', 1),
(13, 'Mobiles & Tablets', 2),
(14, 'Computers & Laptops', 2),
(15, 'Home Appliances', 2),
(16, 'Home Entertainment', 2),
(17, 'Cameras & Camcoders', 2),
(18, 'sub_cat', 2),
(19, 'Only Camera', 18);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `category_id` int(11) NOT NULL,
  `created_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `product_name`, `category_id`, `created_date`) VALUES
(1, 'Apple iPhone X', 13, '2018-09-10'),
(2, 'Apple iPhone 0', 13, '2018-09-12'),
(3, 'Apple iPhone 1', 13, '2018-09-12'),
(4, 'Apple iPhone 2', 13, '2018-09-12'),
(5, 'Apple iPhone 3', 13, '2018-09-12'),
(6, 'Apple iPhone 4', 13, '2018-09-12'),
(7, 'Apple iPhone 5', 13, '2018-09-12'),
(8, 'Apple iPhone 6', 13, '2018-09-12'),
(9, 'Apple iPhone 7', 13, '2018-09-12'),
(10, 'Apple iPhone 8', 13, '2018-09-12'),
(11, 'Apple iPhone 9', 13, '2018-09-12'),
(12, 'Apple iPhone 10', 13, '2018-09-12'),
(13, 'Apple iPhone 11', 13, '2018-09-12'),
(14, 'Apple iPhone 12', 13, '2018-09-12'),
(15, 'Apple iPhone 13', 13, '2018-09-12'),
(16, 'Apple iPhone 14', 13, '2018-09-12'),
(17, 'Apple iPhone 15', 13, '2018-09-12'),
(18, 'Apple iPhone 16', 13, '2018-09-12'),
(19, 'Apple iPhone 17', 13, '2018-09-12'),
(20, 'Apple iPhone 18', 13, '2018-09-12'),
(21, 'Apple iPhone 19', 13, '2018-09-12'),
(22, 'Apple iPhone 20', 13, '2018-09-12'),
(23, 'Apple iPhone 21', 13, '2018-09-12'),
(24, 'Apple iPhone 22', 13, '2018-09-12'),
(25, 'Apple iPhone 23', 13, '2018-09-12'),
(26, 'Apple iPhone 24', 13, '2018-09-12'),
(27, 'Apple iPhone 25', 13, '2018-09-12'),
(28, 'Apple iPhone 26', 13, '2018-09-12'),
(29, 'Apple iPhone 27', 13, '2018-09-12'),
(30, 'Apple iPhone 28', 13, '2018-09-12'),
(31, 'Apple iPhone 29', 13, '2018-09-12'),
(32, 'Apple iPhone 30', 13, '2018-09-12'),
(33, 'Apple iPhone 31', 13, '2018-09-12'),
(34, 'Apple iPhone 32', 13, '2018-09-12'),
(35, 'Apple iPhone 33', 13, '2018-09-12'),
(36, 'Apple iPhone 34', 13, '2018-09-12'),
(37, 'Apple iPhone 35', 13, '2018-09-12'),
(38, 'Apple iPhone 36', 13, '2018-09-12'),
(39, 'Apple iPhone 37', 13, '2018-09-12'),
(40, 'Apple iPhone 38', 13, '2018-09-12'),
(41, 'Apple iPhone 39', 13, '2018-09-12'),
(42, 'Apple iPhone 40', 13, '2018-09-12'),
(43, 'Apple iPhone 41', 13, '2018-09-12'),
(44, 'Apple iPhone 42', 13, '2018-09-12'),
(45, 'Apple iPhone 43', 13, '2018-09-12'),
(46, 'Apple iPhone 44', 13, '2018-09-12'),
(47, 'Apple iPhone 45', 13, '2018-09-12'),
(48, 'Apple iPhone 46', 13, '2018-09-12'),
(49, 'Apple iPhone 47', 13, '2018-09-12'),
(50, 'Apple iPhone 48', 13, '2018-09-12'),
(51, 'Apple iPhone 49', 13, '2018-09-12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
