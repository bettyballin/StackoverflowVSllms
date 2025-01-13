import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FlickeringSquares extends Application {
    private static final int NUM_SQUARES = 9;
    private static final int SQUARE_SIZE = 50;
    private static final Color[] COLORS = {Color.RED, Color.BLUE};

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);

        Rectangle[] squares = new Rectangle[NUM_SQUARES];
        for (int i = 0; i < NUM_SQUARES; i++) {
            squares[i] = new Rectangle(100 + i * (SQUARE_SIZE + 10), 100, SQUARE_SIZE, SQUARE_SIZE);
            root.getChildren().add(squares[i]);
        }

        AnimationTimer timer = new AnimationTimer() {
            private long lastNano = System.nanoTime();
            private int frame = 0;

            @Override
            public void handle(long now) {
                if (now - lastNano < 11_000_000) { // 11ms @ 85Hz
                    return;
                }
                lastNano = now;

                for (Rectangle square : squares) {
                    square.setFill(COLORS[frame % 2]);
                }
                frame++;
            }
        };
        timer.start();

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}