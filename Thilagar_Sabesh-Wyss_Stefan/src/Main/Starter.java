
package Main;

import View.ViewUI;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

/**
 * the application starter
 */
public class Starter   extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent rootPanel = new ViewUI();
        Scene scene = new Scene(rootPanel, 400, 250);
        primaryStage.setTitle("test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * starts the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("prism.lcdtext", "false");
        launch(args);
    }
}

