CREATE DATABASE IF NOT EXISTS student_db;
USE student_db;

CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    department VARCHAR(100) NOT NULL,
    email VARCHAR(120) UNIQUE NOT NULL
);

INSERT INTO students (name, age, department, email)
VALUES
('Rahul Kumar', 20, 'Computer Science', 'rahul20@gmail.com'),
('Priya Sharma', 21, 'Information Technology', 'priya21@gmail.com');
