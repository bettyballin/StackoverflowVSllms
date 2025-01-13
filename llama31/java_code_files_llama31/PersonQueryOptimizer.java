/*
 * Decompiled with CFR 0.152.
 */
public class PersonQueryOptimizer {
    String query1 = "SELECT * FROM Person WHERE PersonName LIKE '%frank%'";
    String query2 = "SELECT Id, Forename, Surname FROM Person WHERE PersonName LIKE '%frank%'";

    public static void main(String[] stringArray) {
        PersonQueryOptimizer personQueryOptimizer = new PersonQueryOptimizer();
        System.out.println("Original Query: " + personQueryOptimizer.query1);
        System.out.println("Optimized Query: " + personQueryOptimizer.query2);
    }
}
