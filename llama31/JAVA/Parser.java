import java.lang.String;

// Tokenizer class is assumed to be defined elsewhere
class Tokenizer {
    public boolean hasNext() { /* implementation */ }
    public Token peek() { /* implementation */ }
    public Token next() { /* implementation */ }
}

// Token class is assumed to be defined elsewhere
class Token {
    public static final Token SYMBOL = new Token("SYMBOL");
    public static final Token TEXT = new Token("TEXT");

    private String value;

    public Token(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

// ParseError class is assumed to be defined elsewhere
class ParseError extends RuntimeException {
    public ParseError(String message) {
        super(message);
    }
}

public abstract class AstNode {
    // ...
}

public class AstTextNode extends AstNode {
    private String text;

    public AstTextNode(Token text) {
        this.text = text.getValue();
    }

    // ...
}

public class AstSymbolNode extends AstNode {
    private AstNode child;
    private Token symbol;

    public AstSymbolNode(AstNode child, Token symbol) {
        this.child = child;
        this.symbol = symbol;
    }

    // ...
}

public class Parser {
    private Tokenizer tokenizer;

    public Parser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public AstNode parse() {
        return parseExpr();
    }

    private AstNode parseExpr() {
        AstNode node = parseTerm();
        while (tokenizer.hasNext() && tokenizer.peek() == Token.SYMBOL) {
            Token symbol = tokenizer.next();
            node = new AstSymbolNode(node, symbol);
            node = parseTerm();
        }
        return node;
    }

    private AstNode parseTerm() {
        if (tokenizer.peek() == Token.TEXT) {
            return new AstTextNode(tokenizer.next());
        } else if (tokenizer.peek() == Token.SYMBOL) {
            Token symbol = tokenizer.next();
            return new AstSymbolNode(parseTerm(), symbol);
        } else {
            throw new ParseError("Unexpected token");
        }
    }

    public static void main(String[] args) {
        // Example usage:
        Tokenizer tokenizer = new Tokenizer(); // assume Tokenizer implementation
        Parser parser = new Parser(tokenizer);
        AstNode ast = parser.parse();
        // ...
    }
}