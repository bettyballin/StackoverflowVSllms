import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class PlayMovie extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Path to your movie file
        String filePath = "path_to_your_movie_file.mov";

        // Create a media
        Media media = new Media(new java.io.File(filePath).toURI().toString());
        // Create a media player
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        // Create a media view
        MediaView mediaView = new MediaView(mediaPlayer);

        // Create and set the scene
        BorderPane root = new BorderPane();
        root.setCenter(mediaView);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Play Movie");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Start playing the media
        mediaPlayer.play();
    }
}