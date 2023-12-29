import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class FileExplorerButton extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button openExplorerButton = new Button("Open File Explorer");
        openExplorerButton.setOnAction(e -> openFileExplorer());

        StackPane root = new StackPane();
        root.getChildren().add(openExplorerButton);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("File Explorer Button");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openFileExplorer() {
        // Specify the directory or file path you want to open in the file explorer
        String filePath = "C:/";  // Replace with your desired path

        try {
            Desktop.getDesktop().browse(new URI("file://" + filePath));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
