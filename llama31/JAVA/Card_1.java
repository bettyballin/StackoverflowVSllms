// Define the Daddy class
class Daddy {
    private static Daddy instance;

    private Daddy() {}

    public static Daddy getInstance() {
        if (instance == null) {
            instance = new Daddy();
        }
        return instance;
    }

    public void draw() {
        System.out.println("Drawing...");
    }
}

// The original code with some modifications
public class Card_1_1 {
    public void play() {
        Daddy.getInstance().draw();
    }

    public static void main(String[] args) {
        Card_1 card = new Card_1();
        card.play();
    }
}