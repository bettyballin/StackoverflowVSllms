import java.lang.String;
public class Deck {
    private Card[] cards; // Array or list to hold cards
    private IGameActions gameRules;  // Game rules refrence for using shared methods like drawCard() etc.

    public Deck(IGameActions gameRules) {
        this.gameRules = gameRules;
    }

    void playCard(int index){
         cards[index].play(); // Call the card's play method.
    }

    public static void main(String[] args) {
    }
}

class Card {
    void play() {
        // Implement play method
    }
}

interface IGameActions {
    // Interface methods
}