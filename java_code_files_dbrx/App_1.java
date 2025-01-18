import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App_1 extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        SimpleStringProperty prop = new SimpleStringProperty("Hello World");
        Label label1 = new Label();
        label1.textProperty().bind(prop);  // Bind the label's text property to the string property.
        Button button = new Button("Change Text");
        button.setOnAction((event) -> { prop.setValue("Bindings are cool!"); });  // Update the property when the button is clicked.
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1, button);
        layout.setAlignment(Pos.CENTER_LEFT);
        Scene scene = new Scene(layout, 325, 80);
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.show();
    }
}