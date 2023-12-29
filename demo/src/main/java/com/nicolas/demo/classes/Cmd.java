package com.nicolas.demo.classes;

import com.nicolas.demo.HelloApplication;

import java.io.IOException;
import java.io.InputStream;

public class Cmd {

    public static void programCommand() {

        Thread threadRunCmd = new Thread(() -> Cmd.executeCommand_2(FlashHelper.getBuildCommand()));

        threadRunCmd.start();
    }

    public static String logString = "";

    public static void executeCommand_2(String command) {
        logString = "";
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
        processBuilder.redirectErrorStream(true);
        Process process;

        try {
            process = processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Read character by character
        try (InputStream inputStream = process.getInputStream()) {
            int nextByte;
            while (HelloApplication.windowIsOpen && (nextByte = inputStream.read()) != -1) {
                char nextChar = (char) nextByte;

                logString += nextChar;
                System.out.print(nextChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            int exitCode = process.waitFor();
            System.out.println("Command exited with code " + exitCode);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
