//Attendance System part 2
//CS4485 - Senior Design
//Team 58 - Nabeel Rizvi

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) {
        //Students UTD ID, and quiz answers will be obtained from html page in part 1
        String utdId = "0123456789";
        String[] quizAnswers = new String[3];
        long timeOfSubmission = System.currentTimeMillis();
        //TODO get users IP address

        //Check if Id is valid
        if (utdId.length() != 10){
            System.out.println("Error: Given UTD ID is not 10 characters");
            System.exit(1);
        }
        for (int i = 0; i < utdId.length(); i++){
            if (!Character.isDigit(utdId.charAt(i))){
                System.out.println("Error: Given UTD ID contains non-digit");
                System.exit(1);
            }
        }

        //Connect to database and obtain matching entry
        Connection studentDatabase = null;
        try {
            //TODO once test database is given, make the connection here
            studentDatabase = DriverManager.getConnection("");
            ResultSet matchingStudent = studentDatabase.createStatement().executeQuery("SELECT * FROM STUDENTS WHERE id LIKE '%"+utdId+"%'");
            //TODO send the resultSets data along with quiz answers, IP address, and System time to part 4 as well as display to screen using AJAX
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}