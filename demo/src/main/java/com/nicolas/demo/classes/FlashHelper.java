package com.nicolas.demo.classes;

public class FlashHelper {

    //String command = "program\\bin\\esptool.exe --chip esp32 --port COM3 --baud 921600 --before default_reset --after hard_reset write_flash -z --flash_mode dio --flash_freq 80m --flash_size detect 0xe000 program\\bin\\boot_app0.bin 0x1000 program\\bin\\bootloader_dio_80m.bin 0x10000 program\\program.bin 0x8000 program\\partitions.bin";

    public static String getBuildCommand() {
        String command = esptoolFileLocation + " " +
                Commands.chipModel + " " + Configuration.chipModel + " " +
                Commands.port + " " + Configuration.port + " " +
                Commands.uploadSpeed + " " + Configuration.uploadSpeed + " " +
                Commands.beforeFlash + " " + Configuration.beforeFlash + " " +
                Commands.afterFlash + " " + Configuration.afterFlash + " " +
                Commands.writeFlash + " " + Configuration.writeFlash + " " +
                Commands.flashMode + " " + Configuration.flashMode + " " +
                Commands.flashFrequency + " " + Configuration.flashFrequency + " " +
                Commands.flashSize + " " + Configuration.flashSize + " " +
                Commands.bootloaderApplicationMemoryAddress + " " + Configuration.bootloaderApplicationFileAddress + " " +
                Commands.bootloaderMemoryAddress + " " + Configuration.bootloaderFileAddress + " " +
                Commands.programMemoryAddress + " " + Configuration.programFilePath + " " +
                Commands.partitionMemoryAddress + " " + Configuration.partitionFilePath;

        System.out.println("Command: " + command);

        return command;
    }

    public static final String esptoolFileLocation = "src\\main\\resources\\system\\esptool.exe";

    public static class Commands {
        public static final String
                chipModel = "--chip",
                port = "--port",
                uploadSpeed = "--baud",
                beforeFlash = "--before",
                afterFlash = "--after",
                writeFlash = "write_flash",
                flashMode = "--flash_mode",
                flashFrequency = "--flash_freq",
                flashSize = "--flash_size",
                bootloaderApplicationMemoryAddress = "0xe000",
                bootloaderMemoryAddress = "0x1000",
                programMemoryAddress = "0x10000",
                partitionMemoryAddress = "0x8000";
    }

    public static class Configuration {

        public static int STATUS_OK = 0,
                STATUS_INVALID_FILE_PATH = 1,
                STATUS_INVALID_PARTITION_PATH = 2,
                STATUS_INVALID_UPLOAD_SPEED = 3,
                STATUS_INVALID_PORT = 4;

        public enum STATUS {
            OK,

        }

        public static final Integer[] uploadSpeedOptions = new Integer[]{
                921600, 115200, 256000, 230400, 512000
        };

        public static final String
                chipModel = "esp32",
                beforeFlash = "default_reset",
                afterFlash = "hard_reset",
                writeFlash = "-z",
                flashMode = "dio",
                flashFrequency = "80m",
                flashSize = "detect",
                bootloaderApplicationFileAddress = "src\\main\\resources\\system\\boot_app0.bin",
//                bootloaderApplicationFileAddress = "program\\bin\\boot_app0.bin",
                bootloaderFileAddress = "src\\main\\resources\\system\\bootloader_dio_80m.bin";
//                bootloaderFileAddress = "program\\bin\\bootloader_dio_80m.bin";


        //editable:
        public static String
                port,
                programFilePath,
                partitionFilePath;
        public static int uploadSpeed;

        public static String getPort() {
            return port;
        }

        public static void setPort(String port) {
            Configuration.port = port;
        }

        public static String getProgramFilePath() {
            return programFilePath;
        }

        public static void setProgramFilePath(String programFilePath) {
            Configuration.programFilePath = programFilePath;
        }

        public static String getPartitionFilePath() {
            return partitionFilePath;
        }

        public static void setPartitionFilePath(String partitionFilePath) {
            Configuration.partitionFilePath = partitionFilePath;
        }

        public static int getUploadSpeed() {
            return uploadSpeed;
        }

        public static void setUploadSpeed(int uploadSpeed) {
            Configuration.uploadSpeed = uploadSpeed;
        }
    }

}
