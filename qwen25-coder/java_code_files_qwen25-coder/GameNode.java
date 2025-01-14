import java.util.ArrayList;
import java.util.List;

public class GameNode {

    public List<GameNode> nextMoves;
    public Effect smallEffect;
    public Effect bigEffect;

    public GameNode() {
        this.nextMoves = new ArrayList<>();
    }

    class Effect {
        // Define the effect properties and methods
    }

    public static void main(String[] args) {
    }
}