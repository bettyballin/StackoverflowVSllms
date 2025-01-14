import java.lang.String;
public class ReverseWords_1 {
    public static String reverseLettersInEachWord(String input) {
        // Split the input string by spaces to get individual words
        String[] words = input.split(" ");
        
        // StringBuilder to store the result
        StringBuilder reversedString = new StringBuilder();
        
        // Iterate over each word
        for (int i = 0; i < words.length; i++) {
            // Reverse the current word
            String reversedWord = new StringBuilder(words[i]).reverse().toString();
            
            // Append the reversed word to the result
            reversedString.append(reversedWord);
            
            // Add a space between words, but not after the last word
            if (i < words.length - 1) {
                reversedString.append(" ");
            }
        }
        
        // Return the final reversed string
        return reversedString.toString();
    }

    public static void main(String[] args) {
        String input = "my string";
        String output = reverseLettersInEachWord(input);
        System.out.println(output);  // Output: ym gnirts
    }
}