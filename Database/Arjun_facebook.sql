-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Oct 18, 2016 at 11:16 AM
-- Server version: 5.5.52-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `Arjun_facebook`
--

-- --------------------------------------------------------

--
-- Table structure for table `Fb_registration`
--

CREATE TABLE IF NOT EXISTS `Fb_registration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(25) NOT NULL,
  `sname` varchar(25) NOT NULL,
  `email` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dod` int(11) NOT NULL,
  `dom` int(11) NOT NULL,
  `doy` int(11) NOT NULL,
  `password` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `Fb_registration`
--

INSERT INTO `Fb_registration` (`id`, `fname`, `sname`, `email`, `gender`, `dod`, `dom`, `doy`, `password`) VALUES
(4, 'Arjun', 'Prakash', 'arjun@gmail.com', 'male', 10, 11, 1993, '1'),
(9, 'Fgsgshv', 'Vhdvdv', 'Hsvdvdv', 'Male', 11, 333, 33, 'Vvgdggd'),
(11, 'nihal', 'jbn', 'nihal@gmail.com', 'male', 10, 10, 2016, '112233'),
(12, 'nihal', 'jabeen', 'nihal@gmail.com', 'male', 23, 4, 1995, 'nihal'),
(13, 'nihal', 'jbn', 'nihal@gmail.com', 'male', 10, 10, 2016, '112233'),
(14, 'nihal', 'jbn', 'nihal@gmail.com', 'male', 10, 10, 2016, '112233');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE IF NOT EXISTS `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`id`, `status`) VALUES
(4, 'Pantheeramkavu, Kerala\n');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
