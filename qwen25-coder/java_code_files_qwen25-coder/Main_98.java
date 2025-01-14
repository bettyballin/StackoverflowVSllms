public class Main {
    public static void main(String[] args) {
        String userInput = args[0];
        String safeOutput = escapeHtml4(userInput);
        java.io.PrintStream out = System.out;
        out.println(safeOutput);
    }

    // Method to escape HTML special characters
    public static String escapeHtml4(String input) {
        if (input == null) return null;
        StringBuilder builder = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '&': builder.append("&amp;"); break;
                case '<': builder.append("&lt;"); break;
                case '>': builder.append("&gt;"); break;
                case '"': builder.append("&quot;"); break;
                case '\'': builder.append("&#x27;"); break;
                case '/': builder.append("&#x2F;"); break;
                default: builder.append(c);
            }
        }
        return builder.toString();
    }
}