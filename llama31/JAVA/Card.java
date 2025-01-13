import java.lang.String;

class Daddy {
    public static void draw() {
        System.out.println("Daddy drew a card.");
    }
}

public class Card {
    public void play() {
        Daddy.draw();
    }

    public static void main(String[] args) {
        Card card = new Card();
        card.play();
    }
}