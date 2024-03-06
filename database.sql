CREATE DATABASE IF NOT EXISTS Project_Attendance;

USE Project_Attendance;

CREATE TABLE IF NOT EXISTS User_Login (
	UserID INT PRIMARY KEY,
    Username VARCHAR(255) NOT NULL,
    PasswordHash VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Professors ( 
	ProfessorID INT PRIMARY KEY,
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    Email VARCHAR(255),
    Phone VARCHAR(20),
    Department VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Students (
    StudentID INT PRIMARY KEY,
    FirstName VARCHAR(255) NOT NULL,
    MiddleName VARCHAR(255),
    LastName VARCHAR(255) NOT NULL,
    Email VARCHAR(255),
    Major VARCHAR(255),
    Credits INT
);

CREATE TABLE IF NOT EXISTS Course_Information (
	ClassID INT PRIMARY KEY,
	ProfessorID INT NOT NULL,
    ClassName VARCHAR(255) NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL,
    QuizAvailability BOOLEAN NOT NULL,
    CONSTRAINT fk_professor
        FOREIGN KEY (ProfessorID)
        REFERENCES Professors(ProfessorID)
);

CREATE TABLE IF NOT EXISTS Quiz_Questions (
	QuestionID INT PRIMARY KEY,
    QuestionText TEXT,
    Choices JSON,
    CorrectAnswer VARCHAR(255)
);

CREATE TABLE  IF NOT EXISTS Attendance_Records (
	AttendanceID INT PRIMARY KEY,
    ClassID INT,
    StudentID INT,
    AttendanceStatus VARCHAR(255),
        Timestamp DATETIME,
    CONSTRAINT fk_class
        FOREIGN KEY (ClassID)
        REFERENCES Course_Information(ClassID),
    CONSTRAINT fk_student
        FOREIGN KEY (StudentID)
        REFERENCES Students(StudentID)
);
