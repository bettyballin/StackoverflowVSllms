public class BirthdayProblemCalculator_1 {

    public static void main(String[] args) {
        double threshold = 0.5;
        double targetN = 1; // Start from 1 and increment
        double pCollisionPair = 0.0001; // Example value

        while (true) {
            double noCollisionProb = 1 - (targetN * (targetN - 1) * pCollisionPair / 2);
            double collisionProb = 1 - noCollisionProb;

            if (collisionProb >= threshold) {
                break;
            }

            targetN++;
        }

        System.out.println("Number of hashes before collision probability exceeds " + threshold + ": " + (targetN - 1));
    }
}