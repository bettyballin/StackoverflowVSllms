import java.lang.String;

public class GameController {
    private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    // Handling user input
    public void handleUserInput(String userInput) {
        switch (userInput) {
            case "jump":
                model.getPlayer().jump();
                break;
            case "shoot":
                model.getPlayer().shoot();
                break;
            default:
                System.out.println("Unknown command");
        }
        view.update(model);
    }

    // Handling a system timeout event
    public void handleTimeoutEvent() {
        model.saveState();
        System.out.println("Game state saved due to inactivity.");
    }

    // Managing external API response
    public void handleApiResponse(String responseData) {
        if (responseData.equals("update_available")) {
            model.update();
            view.displayUpdateNotification();
        }
    }

    public static void main(String[] args) {
        // Create instances of GameModel and GameView
        GameModel model = new GameModel();
        GameView view = new GameView();

        // Create the controller
        GameController controller = new GameController(model, view);

        // Example usage
        controller.handleUserInput("jump");
        controller.handleTimeoutEvent();
        controller.handleApiResponse("update_available");
    }
}

// Supporting classes to make the code executable
class GameModel {
    private Player player = new Player();

    public Player getPlayer() {
        return player;
    }

    public void saveState() {
        // Implementation for saving the game state
    }

    public void update() {
        // Implementation for updating the game model
    }
}

class GameView {
    public void update(GameModel model) {
        // Implementation for updating the game view
    }

    public void displayUpdateNotification() {
        // Implementation for displaying an update notification
    }
}

class Player {
    public void jump() {
        System.out.println("Player jumps.");
    }

    public void shoot() {
        System.out.println("Player shoots.");
    }
}