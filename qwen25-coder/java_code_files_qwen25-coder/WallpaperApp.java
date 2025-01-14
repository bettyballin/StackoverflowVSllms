import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class WallpaperApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Load images
        Image oldImage = new Image("file:path/to/old/image.jpg");
        Image newImage = new Image("file:path/to/new/image.jpg");

        // Create image views
        ImageView imageViewOld = new ImageView(oldImage);
        ImageView imageViewNew = new ImageView(newImage);

        // Ensure the new image is initially transparent
        imageViewNew.setOpacity(0);

        // Stack images on top of each other
        StackPane root = new StackPane(imageViewOld, imageViewNew);

        // Create a fade transition from old to new image
        FadeTransition ft = new FadeTransition(Duration.seconds(2), imageViewOld);
        ft.setToValue(0.0);  // Fade out the old image

        FadeTransition ftReverse = new FadeTransition(Duration.seconds(2), imageViewNew);
        ftReverse.setFromValue(0.0);  // Start with zero opacity
        ftReverse.setToValue(1.0);    // Fade in the new image

        // Play transitions in sequence
        ft.setOnFinished(e -> ftReverse.play());
        ft.play();

        Scene scene = new Scene(root, oldImage.getWidth(), oldImage.getHeight());

        primaryStage.setTitle("Wallpaper Transition Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}