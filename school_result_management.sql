CREATE TABLE `results` (
   `roll_no` int NOT NULL AUTO_INCREMENT,
   `student_name` varchar(100) DEFAULT NULL,
   `subject1` double DEFAULT NULL,
   `subject2` double DEFAULT NULL,
   `subject3` double DEFAULT NULL,
   `total` double DEFAULT NULL,
   `percentage` double DEFAULT NULL,
   `grade` varchar(5) DEFAULT NULL,
   PRIMARY KEY (`roll_no`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci