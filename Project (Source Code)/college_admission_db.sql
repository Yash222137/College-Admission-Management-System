-- Database Creation
CREATE DATABASE IF NOT EXISTS college_admission_db;
USE college_admission_db;

-- 1. COURSE TABLE
CREATE TABLE IF NOT EXISTS COURSE (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(100) NOT NULL,
    duration INT NOT NULL, -- in years
    fees INT NOT NULL
    UNIQUE (course_name, duration, fees)   -- ✅ IMPORTANT FIX     
    );

-- 2. ADMISSION TABLE (Student)
CREATE TABLE IF NOT EXISTS ADMISSION (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    father_name VARCHAR(100),
    dob DATE,
    gender VARCHAR(10),
    course_id INT,
    mobile VARCHAR(15),
    FOREIGN KEY (course_id) REFERENCES COURSE(course_id)
);

-- 3. ADDRESS TABLE
CREATE TABLE IF NOT EXISTS ADDRESS (
    address_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT UNIQUE, -- Assuming 1:1 for simplicity based on description
    house_no VARCHAR(50),
    street VARCHAR(100),
    city VARCHAR(50),
    state VARCHAR(50),
    pincode VARCHAR(10),
    FOREIGN KEY (student_id) REFERENCES ADMISSION(student_id) ON DELETE CASCADE
);

-- 4. QUALIFICATION TABLE
CREATE TABLE IF NOT EXISTS QUALIFICATION (
    q_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    exam_name VARCHAR(50), -- e.g., '10th', '12th'
    board VARCHAR(100),
    passing_year INT,
    percentage FLOAT,
    FOREIGN KEY (student_id) REFERENCES ADMISSION(student_id) ON DELETE CASCADE
);

-- 5. FEES TABLE
CREATE TABLE IF NOT EXISTS FEES (
    fee_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT UNIQUE,
    total_fees INT,
    paid INT,
    balance INT,
    FOREIGN KEY (student_id) REFERENCES ADMISSION(student_id) ON DELETE CASCADE
);

-- 6. DOCUMENTS TABLE
CREATE TABLE IF NOT EXISTS DOCUMENTS (
    doc_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT UNIQUE,
    aadhar_no VARCHAR(20),
    tenth_marksheet VARCHAR(200),
    twelfth_marksheet VARCHAR(200),
    photo VARCHAR(200),
    FOREIGN KEY (student_id) REFERENCES ADMISSION(student_id) ON DELETE CASCADE
);

-- Insert Sample Courses
   INSERT INTO COURSE (course_name, duration, fees) VALUES ('B.Tech (CS)', 4, 400000);
   INSERT INTO COURSE (course_name, duration, fees) VALUES ('BBA', 3, 150000);
   INSERT INTO COURSE (course_name, duration, fees) VALUES ('BCA', 3, 180000);

 


