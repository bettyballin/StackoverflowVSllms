public class Main {
    String runLengthEncode(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 0; i < s.length() - 1; i++) { // check all characters except last character
            if (s.charAt(i) == s.charAt(i + 1)) { // If current and next chars are same then increase counter
                count++;
            } else {
                sb.append("" + count);
                sb.append(s.charAt(i)); // Add char to final stream after appending its count. Reset count.
                count = 1;
            }
        }
        return sb.toString(); // Return output string
    }
}