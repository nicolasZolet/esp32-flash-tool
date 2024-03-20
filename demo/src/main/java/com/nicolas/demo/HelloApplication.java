package com.nicolas.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage stage;
    private static final double WINDOW_WIDTH = 650;
    private static final double WINDOW_HEIGHT = 700;
    public static boolean windowIsOpen = true;

    @Override
    public void start(Stage stage) throws IOException {

        HelloApplication.stage = stage;
//
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), WINDOW_WIDTH, WINDOW_HEIGHT);
//
        stage.setMinWidth(WINDOW_WIDTH);
        stage.setMinHeight(WINDOW_HEIGHT);

        stage.setTitle("ESP32 Flash Tool");
        stage.setScene(scene);
        stage.show();
//
//        stage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, e->{
//            System.out.println("Close program");
//            windowIsOpen = false;
//        });

    }

    public static Stage getStage() {
        return HelloApplication.stage;
    }

    public static void main(String[] args) {
        launch();
    }

}