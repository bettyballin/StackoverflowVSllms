import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MultiMonitorExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Sample UI
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 400, 300);

        // Get the primary screen bounds
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        // Create and show a stage on each additional monitor
        for (Screen s : Screen.getScreens()) {
            if (!s.equals(Screen.getPrimary())) {
                Stage secondStage = new Stage();
                secondStage.setTitle("Secondary Monitor");
                secondStage.setScene(scene);

                Rectangle2D bounds = s.getVisualBounds();

                // Set position and size of secondary stage to be on the additional screen
                secondStage.setX(bounds.getMinX() + 10);
                secondStage.setY(bounds.getMinY() + 10);

                secondStage.show();
            }
        }

        primaryStage.setScene(scene);
        primaryStage.setTitle("Primary Monitor");
        primaryStage.setX(primaryScreenBounds.getMinX() + 10);
        primaryStage.setY(primaryScreenBounds.getMinY() + 10);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}