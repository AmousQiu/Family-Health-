-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: db.cs.dal.ca
-- Generation Time: Dec 02, 2018 at 06:45 PM
-- Server version: 5.7.10
-- PHP Version: 7.1.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `zqiu`
--

-- --------------------------------------------------------

--
-- Table structure for table `Children-User`
--

CREATE TABLE `Children-User` (
  `UserID` int(11) NOT NULL,
  `FamilyID` int(11) NOT NULL,
  `Email` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Children-User`
--

INSERT INTO `Children-User` (`UserID`, `FamilyID`, `Email`) VALUES
(1, 1, '1@dal.ca'),
(2, 2, '2@dal.ca'),
(3, 3, '3@dal.ca'),
(4, 4, '4@dal.ca'),
(5, 5, '5@dal.ca'),
(6, 6, '6@dal.ca'),
(7, 7, '7@dal.ca'),
(8, 8, '8@dal.ca'),
(9, 9, '9@dal.ca'),
(10, 10, '10@dal.ca');

-- --------------------------------------------------------

--
-- Table structure for table `Doctor`
--

CREATE TABLE `Doctor` (
  `DoctorID` int(11) NOT NULL,
  `Name` varchar(11) NOT NULL,
  `DoctorPhone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Doctor`
--

INSERT INTO `Doctor` (`DoctorID`, `Name`, `DoctorPhone`) VALUES
(1, '1', 9029999),
(2, '2', 9029989),
(3, '3', 9039999),
(4, '4', 9029299),
(5, '5', 9029929),
(6, '6', 9029499),
(7, '7', 9029959),
(8, '8', 902567),
(9, '9', 90223499),
(10, '10', 9032444);

-- --------------------------------------------------------

--
-- Table structure for table `Parent-User`
--

CREATE TABLE `Parent-User` (
  `UserID` int(11) NOT NULL,
  `FamilyID` int(11) NOT NULL,
  `Height` int(11) NOT NULL,
  `Weight` int(11) NOT NULL,
  `BloodPressure` int(11) NOT NULL,
  `HeartRate` int(11) NOT NULL,
  `DoctorID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Parent-User`
--

INSERT INTO `Parent-User` (`UserID`, `FamilyID`, `Height`, `Weight`, `BloodPressure`, `HeartRate`, `DoctorID`) VALUES
(11, 1, 170, 120, 130, 75, 1),
(12, 2, 170, 120, 130, 75, 2),
(13, 3, 170, 120, 130, 75, 3),
(14, 4, 170, 120, 130, 75, 5),
(15, 5, 170, 120, 130, 75, 6),
(16, 6, 170, 120, 130, 75, 7),
(17, 7, 170, 120, 130, 75, 9),
(18, 8, 170, 120, 130, 75, 10),
(19, 9, 170, 120, 130, 75, 8),
(20, 10, 170, 120, 130, 75, 4);

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `UserID` int(11) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `Status` varchar(45) NOT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Telephone#` int(11) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `FamilyID` varchar(45) NOT NULL,
  `DoctorID` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`UserID`, `Name`, `Gender`, `Age`, `Status`, `Password`, `Telephone#`, `Address`, `FamilyID`, `DoctorID`) VALUES
(1, 'Shivam', 'Male', 23, 'Children', '123465', 123124, 'DJscsd', '1', '1'),
(2, 'Sam', 'Male', 21, 'Children', 'Something', 342332, '123132', '2', '1'),
(3, 'David', 'Male', 21, 'Children', '12432566', 342332, '123132', '3', '2'),
(4, 'Ellen', 'Female', 21, 'Children', 'Something', 342332, '123132', '4', '4'),
(5, 'Ben', 'Male', 21, 'Children', '1345123', 342332, '123132', '5', '4'),
(6, 'Samatha', 'Female', 21, 'Children', '125232', 342332, '123132', '6', '4'),
(7, 'Ana', 'Female', 21, 'Children', 'Something', 342332, '123132', '7', '5'),
(8, 'Jenny', 'Female', 25, 'Children', 'qweg2', 12870135, '1030af1', '8', '10'),
(9, 'Elysha', 'Female', 21, 'Children', 'Something', 342332, '123132', '9', '6'),
(10, 'Peter', 'Male', 21, 'Children', '2345324', 342232, '123dfs', '10', '7'),
(11, 'Simon', 'Male', 56, 'Parent', '15g1rfsd23', 19875990, 'qduqqq', '1', '1'),
(12, 'Robert', 'Male', 58, 'Parent', '15g345', 19875990, 'qduqqq', '2', '1'),
(13, 'Danniel', 'Male', 63, 'Parent', 'sdg231', 19875990, 'qduqqq', '3', '2'),
(14, 'Melissa', 'Female', 55, 'Parent', '1354622', 1469203, 'qduqqq', '4', '4'),
(15, 'Rosa', 'Female', 57, 'Parent', 'adh124', 19875990, 'qduqqq', '5', ''),
(16, 'Taylor', 'Female', 65, 'Parent', '356f32r1', 23546464, 'srshth', '6', '4'),
(17, 'Asher', 'Male', 67, 'Parent', 'sdg235', 125643, 'qetgrqwerg', '7', '5'),
(18, 'Kam', 'Male', 67, 'Parent', '2344365', 19875990, 'qduqqq', '8', '10'),
(19, 'Luke', 'Male', 76, 'Parent', '15g1rfsd23', 19875990, 'qduqqq', '9', '6'),
(20, 'Blue', 'Male', 67, 'Parent', '15g1rfsd23', 19875990, 'qduqqq', '10', '7');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Children-User`
--
ALTER TABLE `Children-User`
  ADD PRIMARY KEY (`UserID`);

--
-- Indexes for table `Doctor`
--
ALTER TABLE `Doctor`
  ADD PRIMARY KEY (`DoctorID`);

--
-- Indexes for table `Parent-User`
--
ALTER TABLE `Parent-User`
  ADD PRIMARY KEY (`UserID`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`UserID`) USING BTREE,
  ADD KEY `DoctorID` (`DoctorID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
