public interface IGameActions {
    void drawCard();
}

public abstract class Card implements IGameActions {
    private IGameActions gameRules;  // Game rules reference for using shared methods like drawCard() etc.

    public Card(IGameActions gameRules){
        this.gameRules = gameRules;
    }

    void play(){
         // Some other code here...
         gameRules.drawCard();  // Call the draw method from GameRules reference
     }

    public static void main(String[] args) {
    }
}