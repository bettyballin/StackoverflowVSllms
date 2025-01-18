import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class HelloFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Text text = new Text("Hello, JavaFX!");
        StackPane stackpane = new StackPane();
        stackpane.getChildren().addAll(text);
        Scene scene = new Scene(stackpane, 300, 250);
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}