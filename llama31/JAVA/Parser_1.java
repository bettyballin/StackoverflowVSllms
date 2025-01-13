import java.util.Scanner;

public class Parser_1 {
    private Scanner scanner;
    private String[] tokens;
    private int tokenIndex;

    public Parser(String input) {
        scanner = new Scanner(input);
        scanner.useDelimiter("\\s+");
        tokens = scanner.nextLine().split("\\s+");
        tokenIndex = 0;
    }

    public void expression() {
        term();
        while (tokenIndex < tokens.length && tokens[tokenIndex].equals("+")) {
            tokenIndex++;
            term();
        }
    }

    public void term() {
        factor();
        while (tokenIndex < tokens.length && tokens[tokenIndex].equals("*")) {
            tokenIndex++;
            factor();
        }
    }

    public void factor() {
        if (tokenIndex >= tokens.length) return;
        if (tokens[tokenIndex].matches("[a-zA-Z]+")) { // VAR
            tokenIndex++;
        } else if (tokens[tokenIndex].matches("[0-9]+")) { // NUM
            tokenIndex++;
        } else if (tokens[tokenIndex].equals("(")) { // call()
            // Implement call() logic, for simplicity, it's assumed as consuming the token
            tokenIndex++;
        }
    }

    public static void main(String[] args) {
        Parser parser = new Parser("1 + 2 * 3");
        parser.expression();
    }
}