//Attendance System part 2
//CS4485 - Senior Design
//Team 58 - Nabeel Rizvi

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*public class LogAttendance {
    public static void main(String[] args){

    }
}*/

class attendanceServer extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        //Students UTD ID, and quiz answers will be obtained from html page in part 1
        String utdId = request.getParameter("id");
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
        String studentName = "";
        Connection studentDatabase = null;
        try {
            //For this to work, the database needs to exist on the local machine. Needs to be replaced later if a database address is given
            studentDatabase = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendancedb","student","password");
            ResultSet matchingStudent = studentDatabase.createStatement().executeQuery("SELECT * FROM STUDENTS WHERE id LIKE '%"+utdId+"%'");
            if (matchingStudent.next())
                studentName = matchingStudent.getString("name");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("text/html");
        try {
            response.getWriter().write(studentName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}