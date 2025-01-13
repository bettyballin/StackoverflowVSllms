public class PersonQueryOptimizer {
    // Development and testing
    String query1 = "SELECT * FROM Person WHERE PersonName LIKE '%frank%'";

    // Optimized query
    String query2 = "SELECT Id, Forename, Surname FROM Person WHERE PersonName LIKE '%frank%'";

    public static void main(String[] args) {
        PersonQueryOptimizer optimizer = new PersonQueryOptimizer();
        System.out.println("Original Query: " + optimizer.query1);
        System.out.println("Optimized Query: " + optimizer.query2);
    }
}