import java.lang.String;
public class CollisionProbabilityCalculator {
    static double n = Math.pow(10, 9); // one billion IDs
    static double m = Math.pow(2, 64); // size of the space with 64 bits

    static double collisionProbability = 1 - Math.exp(-Math.pow(n, 2) / (2 * m));

    static {
        System.out.println("Collision Probability: " + collisionProbability);
    }
    public static void main(String[] args) {
    }
}