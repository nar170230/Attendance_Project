module com.example.attendanceapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.attendanceapplication to javafx.fxml;
    exports com.example.attendanceapplication;
}