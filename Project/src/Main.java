import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {

    public static final String NAME_FRAME = "Program start!";
    public static final int FRAME_SIZE_WIDTH = 300, FRAME_SIZE_HEIGHT = 500;

    public static void main(String[] args){
        System.out.println(NAME_FRAME);

        JFrame frame = new JFrame(NAME_FRAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_SIZE_WIDTH,FRAME_SIZE_HEIGHT);

        JPanel panel = new JPanel();
        panel.setSize(FRAME_SIZE_WIDTH, FRAME_SIZE_HEIGHT);

        JButton button1 = new JButton("Press 1");
        JButton button2 = new JButton("Press 2");

        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);
//        frame.getContentPane().add(panel);


        frame.setVisible(true);

        openFileChooser();

//        openExplorerAndSelectFile();

//        openFileExplorer();
    }

    private static void openFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String absolutePath = selectedFile.getAbsolutePath();
            System.out.println("Selected file: " + absolutePath);
        } else {
            System.out.println("No file selected");
        }
    }

    private static void openExplorerAndSelectFile() {
        try {
            // Specify the file path you want to select
            File fileToSelect = new File("C:\\Path\\To\\Your\\Desired\\File.txt");

            // Check if Desktop is supported
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();

                // Check if the file exists
                if (fileToSelect.exists()) {
                    // Open Windows Explorer and select the file
                    desktop.open(fileToSelect.getParentFile());
                    desktop.open(fileToSelect);
                } else {
                    System.out.println("File does not exist: " + fileToSelect.getAbsolutePath());
                }
            } else {
                System.out.println("Desktop is not supported");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void openFileExplorer() {
        String filePath = "C:/";

        try {
            Desktop.getDesktop().browse(new URI("file://" + filePath));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}


