use zqiu;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `zqiu`
--

-- --------------------------------------------------------

--
-- Table structure for table `HealthRecord`
--

CREATE TABLE `HealthRecord` (
  `Username` varchar(45) NOT NULL,
  `Height` int(11) NOT NULL,
  `Weight` int(11) NOT NULL,
  `BloodPressure` int(11) NOT NULL,
  `HeartRate` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `HealthRecord`
--

INSERT INTO `HealthRecord` (`Username`, `Height`, `Weight`, `BloodPressure`, `HeartRate`) VALUES
('123', 165, 110, 90, 60),
('amous', 167, 105, 95, 56),
('AmousQiu', 170, 120, 120, 70),
('ares', 168, 120, 98, 78),
('Hebe', 172, 110, 116, 87),
('Iris', 175, 130, 120, 85),
('Joshua', 180, 140, 130, 92),
('KevinChou', 176, 120, 130, 70),
('rubio', 192, 150, 120, 56),
('Tom', 177, 120, 110, 55);

-- --------------------------------------------------------

--
-- Table structure for table `Relationship`
--

CREATE TABLE `Relationship` (
  `f_User` varchar(45) NOT NULL,
  `s_User` varchar(45) NOT NULL,
  `r_no` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Relationship`
--

INSERT INTO `Relationship` (`f_User`, `s_User`, `r_no`) VALUES
('123', 'ares', 1),
('amous', 'Hebe', 2),
('AmousQiu', 'Iris', 3),
('ares', '123', 1),
('Hebe', 'Amous', 2),
('Iris', 'AmousQiu', 3),
('Joshua', 'KevinChou', 4),
('KevinChou', 'Joshua', 4),
('rubio', 'Tom', 5),
('Tom', 'rubio', 5);

-- --------------------------------------------------------

--
-- Table structure for table `Userfix`
--

CREATE TABLE `Userfix` (
  `UserName` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `Password` varchar(45) NOT NULL,
  `Telephone` varchar(11) NOT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Userfix`
--

INSERT INTO `Userfix` (`UserName`, `Name`, `Gender`, `Age`, `Password`, `Telephone`, `Address`, `Email`, `category`) VALUES
('123', '123', 'Male', 18, '123', '123', '123 Mountain Street', '1234@dal.ca', 'Children'),
('amous', 'qiu ziyu', 'Female', 20, '1111', '1897007', '1234 Hill Street', '1234@dal.ca', 'Children'),
('AmousQiu', 'Amous', 'Female', 20, '19980420', '9029895420', '178 South Street', '1749@dal.ca', 'Children'),
('ares', 'qiu shaojie', 'Male', 48, '123456', '1887007', '1000 Hill Street', '123@dal.ca', 'Parent'),
('Hebe', 'Hebe', 'Female', 60, '12345', '16437', '1000 Mountain Street', '1000@dal.ca', 'Parent'),
('Iris', 'Iris', 'Male', 60, '123456', '19402752', '1000 South Park Street', '1029@dal.ca', 'Parent'),
('Joshua', 'joshuakushner', 'Male', 60, '123634', '19802471', '100 Tower Road', '1094@dal.ca', 'Parent'),
('KevinChou', 'KevinChou', 'Male', 21, '123456', '1982034', '100 North Street', '23@dal.ca', 'Children'),
('rubio', 'rickyrubio', 'Male', 25, '1984021', '1998203', '400 Victoria Street', '123@dal.ca', 'Children'),
('Tom', 'Tomdaley', 'Male', 50, '123456', '1975023', '1040 Spring Garden Street', '1004@dal.ca', 'Parent');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `HealthRecord`
--
ALTER TABLE `HealthRecord`
  ADD PRIMARY KEY (`Username`),
  ADD UNIQUE KEY `UserName` (`Username`),
  ADD UNIQUE KEY `Username_2` (`Username`);

--
-- Indexes for table `Relationship`
--
ALTER TABLE `Relationship`
  ADD PRIMARY KEY (`f_User`),
  ADD UNIQUE KEY `s_User` (`s_User`);

--
-- Indexes for table `Userfix`
--
ALTER TABLE `Userfix`
  ADD PRIMARY KEY (`UserName`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `HealthRecord`
--
ALTER TABLE `HealthRecord`
  ADD CONSTRAINT `HealthRecord_ibfk_1` FOREIGN KEY (`Username`) REFERENCES `Userfix` (`UserName`);

--
-- Constraints for table `Relationship`
--
ALTER TABLE `Relationship`
  ADD CONSTRAINT `Relationship_ibfk_1` FOREIGN KEY (`f_User`) REFERENCES `Userfix` (`UserName`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

#Sign up a new user
INSERT INTO `Userfix`(
    `UserName`,
    `Name`,
    `Gender`,
    `Age`,
    `Password`,
    `Telephone`,
    `Address`,
    `Email`,
    `category`
)
VALUES(
    'Haley',
    'Haley',
    'Female',
    '21',
    '123456',
    '198402',
    '1000 Hill Street',
    'asd@dal.ca',
    'Children'
);

#Insert this user's health record
INSERT INTO `HealthRecord`(
    `Username`,
    `Height`,
    `Weight`,
    `BloodPressure`,
    `HeartRate`
)
VALUES('Haley', '180', '120', '90', '70');

#remove this user's health record
DELETE 
FROM 
  'HealthRecord' 
WHERE
   Username='Hayley';

#remove this user's information 
DELETE
FROM 
  `Userfix` 
 WHERE 
   UserName='Hayley';

#update name to Anna
UPDATE 
  Userfix 
SET 
  Name='Anna' 
WHERE
  UserName='123';

#Show all the user's information
SELECT
    *
FROM
    `Userfix`

#Show Hebe's health record
SELECT
    *
FROM
    HealthRecord
WHERE
    UserName = 'Hebe';

#show Hebe's parent's health record
SELECT
    *
FROM
    HealthRecord
WHERE
    UserName =(
    SELECT
        s_User
    FROM
        Relationship
    WHERE
        f_User = 'Hebe'
);

#Show all the users information about name gender and weight
SELECT
    Userfix.Name,
    Userfix.Gender,
    HealthRecord.Weight
FROM
    Userfix
INNER JOIN HealthRecord ON HealthRecord.Username = Userfix.UserName;

#Show the amount of female and male users
SELECT
    COUNT(UserName),
    Gender
FROM
    Userfix
GROUP BY
    Gender;

#Create a view of all the children user's username
CREATE VIEW ChildrenUser AS
SELECT 
  UserName,category
FROM 
  Userfix
WHERE 
  category='Children';

#show the view
SELECT * FROM  ChildrenUser;

#Trigger
#check if the age the user input is more than 0,if not set the age to 0 for future default
DELIMITER $$
CREATE TRIGGER Before_checkage_Insert BEFORE INSERT ON Userfix FOR EACH ROW
BEGIN
IF NEW.Age<0 THEN SET NEW.Age=0;
END IF;
END $$
DELIMITER ;

#Stored Procedure show the user table
CREATE DEFINER=`zqiu`@`129.173.0.0/255.255.0.0` PROCEDURE `Test`()
BEGIN
  SELECT * FROM Userfix;
END
Call Test;