import java.lang.String;

public class class_5_5 {
    // Define the grammar
    // E -> T ((ADD | SUB) T)*
    // T -> F ((MUL | DIV) F)*
    // F -> NUMBER | VARIABLE

    // Token types
    enum TokenType {
        ADD, SUB, MUL, DIV, NUMBER, VARIABLE, EOF
    }

    // Token class
    static class Token {
        TokenType type;
        String value;

        public Token(TokenType type, String value) {
            this.type = type;
            this.value = value;
        }
    }

    // TokenStream class
    static class TokenStream {
        Token[] tokens;
        int pos;

        public TokenStream(Token[] tokens) {
            this.tokens = tokens;
            this.pos = 0;
        }

        public Token peek() {
            return tokens[pos];
        }

        public Token next() {
            return tokens[pos++];
        }
    }

    // Parser class
    static class Parser {
        private TokenStream tokens;

        public Parser(TokenStream tokens) {
            this.tokens = tokens;
        }

        // Parse the input
        public Node parse() {
            return expression();
        }

        // E -> T ((ADD | SUB) T)*
        private Node expression() {
            Node left = term();
            while (tokens.peek().type == TokenType.ADD || tokens.peek().type == TokenType.SUB) {
                Token op = tokens.next();
                Node right = term();
                left = new BinaryNode(op, left, right);
            }
            return left;
        }

        // T -> F ((MUL | DIV) F)*
        private Node term() {
            Node left = factor();
            while (tokens.peek().type == TokenType.MUL || tokens.peek().type == TokenType.DIV) {
                Token op = tokens.next();
                Node right = factor();
                left = new BinaryNode(op, left, right);
            }
            return left;
        }

        // F -> NUMBER | VARIABLE
        private Node factor() {
            Token token = tokens.next();
            if (token.type == TokenType.NUMBER) {
                return new NumberNode(token.value);
            } else if (token.type == TokenType.VARIABLE) {
                return new VariableNode(token.value);
            }
            // Handle errors
            return null;
        }
    }

    // Node classes
    static abstract class Node {
        public abstract String toString();
    }

    static class BinaryNode extends Node {
        Token op;
        Node left;
        Node right;

        public BinaryNode(Token op, Node left, Node right) {
            this.op = op;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "(" + left + " " + op.value + " " + right + ")";
        }
    }

    static class NumberNode extends Node {
        String value;

        public NumberNode(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    static class VariableNode extends Node {
        String value;

        public VariableNode(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public static void main(String[] args) {
        Token[] tokens = new Token[] {
            new Token(TokenType.NUMBER, "2"),
            new Token(TokenType.ADD, "+"),
            new Token(TokenType.NUMBER, "3"),
            new Token(TokenType.MUL, "*"),
            new Token(TokenType.NUMBER, "4")
        };

        TokenStream tokenStream = new TokenStream(tokens);
        Parser parser = new Parser(tokenStream);
        Node node = parser.parse();

        System.out.println(node.toString());
    }
}