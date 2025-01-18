import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyApp1 extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();  // setup scene graph node hierarchy
        Scene scn = new Scene(root, 600, 350); // instantiates the scene with given dimensions
        primaryStage.setScene(scn);  // apply stage's scene to main window
        primaryStage.show(); // display the main window
    }
}