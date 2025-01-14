import java.lang.String;
public class BirthdayProblemCalculator {
    double pCollisionPair = 1.0 / 50000;
    int n = 100;
    
    // Calculate probability of no collision
    double noCollisionProb = 1 - (n * (n - 1) * pCollisionPair / 2);
    
    // Calculate probability of at least one collision
    double collisionProb = 1 - noCollisionProb;
    
    public BirthdayProblemCalculator() {
        System.out.println("Probability of at least one collision: " + collisionProb);
    }
    
    public static void main(String[] args) {
        new BirthdayProblemCalculator();
    }
}