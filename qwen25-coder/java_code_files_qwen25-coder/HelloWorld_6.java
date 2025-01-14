import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloWorld_6 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello, JavaFX!");
        Scene scene = new Scene(label);
        
        primaryStage.setTitle("JavaFX Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}