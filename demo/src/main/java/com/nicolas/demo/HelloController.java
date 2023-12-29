package com.nicolas.demo;

import com.nicolas.demo.classes.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

import static com.nicolas.demo.classes.FlashHelper.Configuration.*;

public class HelloController implements Initializable {

    @FXML
    private ScrollPane scrollPaneLog;

    @FXML
    private Label labelProgramFilePath, labelProgramPartitionPath;

    @FXML
    public Label labelLog;

    @FXML
    private ChoiceBox<Integer> choiceBoxUploadSpeed;

    @FXML
    private ChoiceBox<String> choiceBoxComPort;


    private static final int DEFAULT_UPLOAD_SPEED = 0;


    private void setupLabelUpdater() {
        // Create a Timeline with a KeyFrame that triggers every second
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            // Update the label text every second
            labelLog.setText(Cmd.logString);
            scrollPaneLog.setVvalue(1.0);
        }));

        // Set the cycle count to indefinite so it runs continuously
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Start the timeline
        timeline.play();
    }

    @FXML
    protected void onProgramClicked() {
        FlashHelper.Configuration.setProgramFilePath(Util.convertToUsablePath(labelProgramFilePath.getText()));
        FlashHelper.Configuration.setPartitionFilePath(Util.convertToUsablePath(labelProgramPartitionPath.getText()));
        FlashHelper.Configuration.setPort(choiceBoxComPort.getValue());
        FlashHelper.Configuration.setUploadSpeed(choiceBoxUploadSpeed.getValue());

        int status = getStatusConfiguration();

        if (status == STATUS_OK) {
            Cmd.programCommand();
        } else {
            invalidConfigurationMessage(status);
        }

    }

    private int getStatusConfiguration() {
        if (!labelProgramFilePath.getText().toString().contains(".bin")) {
            return STATUS_INVALID_FILE_PATH;
        } else if(!labelProgramPartitionPath.getText().toString().contains(".bin")){
            return STATUS_INVALID_PARTITION_PATH;
        } else if(choiceBoxUploadSpeed.getValue() == null){
            return STATUS_INVALID_UPLOAD_SPEED;
        } else if(choiceBoxComPort.getValue() == null){
            return STATUS_INVALID_PORT;
        } else {
            return STATUS_OK;
        }
    }

    private void invalidConfigurationMessage(int status) {
        if (status == STATUS_INVALID_FILE_PATH) {
            labelLog.setText("Invalid Program File Path");
        } else if (status == STATUS_INVALID_PARTITION_PATH) {
            labelLog.setText("Invalid Program Partition Path");
        } else if (status == STATUS_INVALID_UPLOAD_SPEED) {
            labelLog.setText("Upload speed parameter is empty");
        } else if (status == STATUS_INVALID_PORT) {
            labelLog.setText("Port parameter is empty");
        }
    }

    private void logFlashOptions() {
        System.out.println("Program button clicked!" +
                "\nCOM Port: " + FlashHelper.Configuration.getPort() +
                "\nUpload speed: " + FlashHelper.Configuration.getUploadSpeed() +
                "\nProgram file path: " + FlashHelper.Configuration.getProgramFilePath() +
                "\nPartition file path: " + FlashHelper.Configuration.getPartitionFilePath()
        );
    }

    @FXML
    private void updateLogLabel() {
        labelLog.setText(Cmd.logString);
    }

    @FXML
    protected void onFileButtonClicked() {
        FlashHelper.Configuration.setProgramFilePath(FileChooser.start(HelloApplication.getStage()));
        labelProgramFilePath.setText(FlashHelper.Configuration.getProgramFilePath());
    }

    @FXML
    protected void onPartitionButtonClicked() {
        FlashHelper.Configuration.setPartitionFilePath(FileChooser.start(HelloApplication.getStage()));
        labelProgramPartitionPath.setText(FlashHelper.Configuration.getPartitionFilePath());
    }

    @FXML
    protected void onPortSelected() {
        System.out.println("COM Port: " + choiceBoxComPort.getValue());
        choiceBoxComPort.getItems().clear();
        choiceBoxComPort.getItems().addAll(SerialPortHelper.getCommPorts());
    }

    @FXML
    protected void onUploadSpeedSelected() {
        System.out.println("Upload Speed: " + choiceBoxUploadSpeed.getValue());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxComPort.getItems().addAll(SerialPortHelper.getCommPorts());
        choiceBoxComPort.setValue(SerialPortHelper.getCommPorts().get(0));

        choiceBoxUploadSpeed.getItems().addAll(FlashHelper.Configuration.uploadSpeedOptions);
        choiceBoxUploadSpeed.setValue(FlashHelper.Configuration.uploadSpeedOptions[DEFAULT_UPLOAD_SPEED]);

        setupLabelUpdater();
    }
}