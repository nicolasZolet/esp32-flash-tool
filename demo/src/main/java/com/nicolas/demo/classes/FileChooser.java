package com.nicolas.demo.classes;

import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class FileChooser {

    private static final String WINDOW_NAME = "Select a File";
    private static final String DEFAULT_VALUE = "C:\\";

    public static String start (Stage stage) {
        String absolutePath = DEFAULT_VALUE;

        javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
        fileChooser.setTitle(WINDOW_NAME);

        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(stage);

        if(selectedFiles==null) {
            logNoFiles();
            return DEFAULT_VALUE;
        } else if(selectedFiles.size() > 1) {
            logToManyFiles();
            return DEFAULT_VALUE;
        } else {
            for (File selectedFile : selectedFiles) {
                absolutePath = selectedFile.getAbsolutePath();
                System.out.println("Selected file: " + absolutePath);
            }
        }

        return absolutePath;
    }

    private static void logToManyFiles(){
        System.out.println("To many Files");
    }

    private static void logNoFiles(){
        System.out.println("No file selected");
    }
}
