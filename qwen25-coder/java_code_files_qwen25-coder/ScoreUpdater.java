import java.util.Set;

public class ScoreUpdater {
    // Assuming 'score' is an integer representing the player's score

    // Declare variables
    float yourCharacterWidth;
    LabelAtlas labelAtlas;
    float upperRightCornerX;
    float upperRightCornerY;

    void updateScoreLabel(int score) {
        // Convert the score to a string to easily get its length
        String scoreString = String.valueOf(score);

        // Calculate how much the label should be shifted to the left
        float shiftX = -(scoreString.length() - 1) * (yourCharacterWidth / 2.0f);

        // Set the position of your LabelAtlas, adjusting for the new score length
        labelAtlas.setPosition(upperRightCornerX + shiftX, upperRightCornerY);
    }

    // Call this method whenever the score changes
    public static void main(String[] args) {
    }
}

class LabelAtlas {
    void setPosition(float x, float y) {
        // Dummy method
    }
}