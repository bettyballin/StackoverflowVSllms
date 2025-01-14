// Daddy class
class Game {
    Deck deck;

    public Game() {
        this.deck = new Deck(this); // Pass 'this' to the deck so it has a reference to Game
    }

    public void draw(String player, int numberOfCards) {
        System.out.println(player + " draws " + numberOfCards + " card(s).");
        // Logic to actually draw cards...
    }

    public void dealDamage(String targetPlayer, int amount) {
        System.out.println(targetPlayer + " takes " + amount + " damage.");
        // Logic to apply damage...
    }
}

// Deck class
class Deck {
    private final Game game;

    public Deck(Game game) {
        this.game = game; // Reference to the Game instance
    }

    public void play(Card card) {
        card.play(game);
    }
}

// Card class
abstract class Card {
    public abstract void play(Game game); // All cards must implement their own play method
}

// Example implementation of a Card
class DrawOneDealDamageCard extends Card {
    private String targetPlayer;

    public DrawOneDealDamageCard(String targetPlayer) {
        this.targetPlayer = targetPlayer;
    }

    @Override
    public void play(Game game) {
        game.draw("Player", 1); // Call draw method of the Game class
        game.dealDamage(targetPlayer, 1); // Call dealDamage method of the Game class
    }
}

// Main method to test the structure
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Deck deck = game.deck;

        Card card = new DrawOneDealDamageCard("Player2");
        deck.play(card);
    }
}