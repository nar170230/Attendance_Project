package com.example.attendanceapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Stage stage = new Stage();


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");


        /*
        Image icon = new Image("file:yelanPFP.jpg");
        stage.getIcons().add(icon);
        Group root = new Group();
        Scene scene = new Scene(root, 600,600,Color.LIGHTCYAN);

        Text text = new Text();
        text.setText("WHOAAAAA");
        text.setX(200);
        text.setY(300);
        text.setFont(Font.font("Verdana",50));
        text.setFill(Color.GREEN);

        Line line = new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(500);
        line.setStrokeWidth(5);
        line.setStroke(Color.RED);
        line.setOpacity(0.5);
        line.setRotate(45);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(100);
        rectangle.setY(100);
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setFill(Color.BLUE);
        rectangle.setStrokeWidth(5);
        rectangle.setStroke(Color.BLACK);

        Image image = new Image("yelanPFP.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setX(400);
        imageView.setY(400);

        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(200.0,200.0,
                                    300.0,300.0,
                                    200.0,300.0
                                    );
        triangle.setFill(Color.YELLOW);

        Circle circle = new Circle();
        circle.setCenterX(350);
        circle.setCenterY(350);
        circle.setRadius(50);
        circle.setFill(Color.ORANGE);

        root.getChildren().add(text);
        root.getChildren().add(line);
        root.getChildren().add(rectangle);
        root.getChildren().add(triangle);
        root.getChildren().add(circle);
        root.getChildren().add(imageView);
        stage.setTitle("Stage Demo");
        //stage.setWidth(420);
        //stage.setHeight(460);
        //stage.setResizable(false);
        //stage.setX(50);
        //stage.setY(50);
        //stage.setFullScreen(true);
        //stage.setFullScreenExitHint("YOU Can't ESCAPE");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("DELETE"));
        */


        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}