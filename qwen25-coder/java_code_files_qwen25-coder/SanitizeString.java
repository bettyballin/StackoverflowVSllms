public class SanitizeString {
    public static void main(String[] args) {
        String input = """
        i like cats
        
        
        my cat is happy
        i love my cat
        
        
        
        hope you have a nice day
        """;
        String sanitizedOutput = input.replaceAll("\\n{2,}", "\n");
        System.out.println(sanitizedOutput);
    }
}