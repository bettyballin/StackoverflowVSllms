public class Main {
    public static void main(String[] args) {
        // Using String.format
        int age = 25;
        String name = "Alice";
        String formattedMessage = String.format("Name: %s, Age: %d", name, age);

        // Using simple concatenation
        String concatenatedMessage = "Name: " + name + ", Age: " + age;

        System.out.println(formattedMessage); // Output: Name: Alice, Age: 25
        System.out.println(concatenatedMessage); // Output: Name: Alice, Age: 25
    }
}