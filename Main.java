import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        // ====================
        // Stanley - Save button funcetionality
        // ====================
        // Save button
        Button btnSave = new Button("Save");
        // Save button event handler
        btnSave.setOnAction(e -> {SaveUtility.saveHotels(hotels); 
            System.out.println("Save button clicked");
        });
        // ====================
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}