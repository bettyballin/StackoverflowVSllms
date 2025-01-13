import javax.swing.JOptionPane;

public class YourActivity_1 {
    public void showDialog() {
        String message = formatLevel() + formatMission();

        int dialogResult = JOptionPane.showConfirmDialog(null, message, "Success", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            startANewGame();
        } else {
            System.exit(0);
        }
    }

    private void updateGameSettings() {
        // implement your update game settings logic here
    }

    private String formatLevel() {
        // implement your format level logic here
        return "";
    }

    private String formatMission() {
        // implement your format mission logic here
        return "";
    }

    private void startANewGame() {
        // implement your start a new game logic here
    }

    public static void main(String[] args) {
        YourActivity activity = new YourActivity();
        activity.showDialog();
    }
}