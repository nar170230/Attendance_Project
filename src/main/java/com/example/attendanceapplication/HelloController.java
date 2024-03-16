package com.example.attendanceapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label outputLabel;

    @FXML
    protected void onSubmitButtonClicked() {
        outputLabel.setText("Output message will be generated later!");
    }
}