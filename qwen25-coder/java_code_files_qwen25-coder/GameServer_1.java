import java.lang.String;
import java.util.concurrent.CountDownLatch;

public class GameServer {
    private final int numberOfPlayers;
    private CountDownLatch startSignal;
    
    public GameServer(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        startSignal = new CountDownLatch(numberOfPlayers);
    }
    
    public void playerReady() {
        // Player is ready, countdown
        startSignal.countDown();
    }

    public boolean allPlayersReady() throws InterruptedException {
        // Wait for all players to be ready
        startSignal.await(); 
        System.out.println("All players are ready. Starting the game...");
        return true;
    }
    
    // Assume this method is called somewhere in your networking logic when a player sends readiness message
    private void onPlayerReadinessMessage() {
        playerReady();
    }

    public static void main(String[] args) throws InterruptedException {
        GameServer server = new GameServer(3); // Example for 3 players

        Thread player1 = new Thread(() -> {
            System.out.println("Player 1 is ready");
            server.onPlayerReadinessMessage();
        });

        Thread player2 = new Thread(() -> {
            System.out.println("Player 2 is ready");
            server.onPlayerReadinessMessage();
        });
        
        Thread player3 = new Thread(() -> {
            System.out.println("Player 3 is ready");
            server.onPlayerReadinessMessage();
        });

        // Start all players
        player1.start();
        player2.start();
        player3.start();

        // Wait for all players to be ready
        boolean canStartGame = server.allPlayersReady(); 
        if (canStartGame) {
            System.out.println("Starting the game now...");
        } else {
            System.out.println("Not all players are ready yet.");
        }
    }
}