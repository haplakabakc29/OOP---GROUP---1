-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 09, 2026 at 12:47 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gadgetdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `listtransactions`
--

CREATE TABLE `listtransactions` (
  `transaction_id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `itemnames` text NOT NULL,
  `itemprices` int(11) NOT NULL,
  `cardnumber` varchar(100) NOT NULL,
  `cardexpiry` varchar(50) NOT NULL,
  `cardcvv` varchar(20) NOT NULL,
  `order_timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `listtransactions`
--

INSERT INTO `listtransactions` (`transaction_id`, `username`, `itemnames`, `itemprices`, `cardnumber`, `cardexpiry`, `cardcvv`, `order_timestamp`) VALUES
(1, 'paul', 'Wireless Earbuds, Bluetooth Speaker, Digital Camera', 5797, 'COD', 'N/A', 'N/A', '2026-06-09 10:36:56'),
(2, 'paul', 'Smart Watch, Phone Stand', 2848, '09565588166', 'GCash', 'N/A', '2026-06-09 10:40:15');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `street` varchar(255) NOT NULL,
  `city` varchar(100) NOT NULL,
  `province` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `street`, `city`, `province`) VALUES
(1, 'paul', '123456', 'Almeda Street', 'Binan', 'Laguna');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `listtransactions`
--
ALTER TABLE `listtransactions`
  ADD PRIMARY KEY (`transaction_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `listtransactions`
--
ALTER TABLE `listtransactions`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
