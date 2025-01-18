public class Main {
    public static void main(String[] args) {
        String input = """
                i like cats

                m...
                y love my cat

                ..."""; // Your original input
        input = input.replaceAll("\\n{2,}", "\n"); // Replaces >= 2 newline characters with a single one
        System.out.println(input); // Prints the corrected string
    }
}