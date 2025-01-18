public class Main {
    public static void main(String[] args) {
        double numOfUUIDs = Math.pow(2, 64); // UUID bits length
        double collisionsProbability = 1 - Math.exp(-Math.pow(numOfUUIDs, 2) / (2 * Math.pow(2, 97)));
        // formula for the exact probability of collisions. For more information: https://en.wikipedia.org/wiki/Birthday_problem#Probability_table .
        System.out.println(collisionsProbability); // print out the output
    }
}