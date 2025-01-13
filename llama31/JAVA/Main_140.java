public class Main_140 {
    public static void main(String[] args) {
        String userInput = "Hello ' World";
        String filteredInput = userInput.replace("'", "''");
        System.out.println(filteredInput); // Outputs: Hello '' World
    }
}