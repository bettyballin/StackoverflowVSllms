public class ProprietaryLexer {
    private XPathLexer baseLexer;

    public ProprietaryLexer(java.io.Reader reader) {
        baseLexer = new XPathLexer(reader);
    }

    // Example method to get the next token, with custom handling
    public Token getNextToken() throws java.io.IOException {
        Token token = baseLexer.getNextToken();

        if (token.getType() == TokenType.XPATH_FUNCTION) {
            // Custom logic for proprietary extensions
            return handleProprietaryFunction(token);
        }

        return token;
    }

    private Token handleProprietaryFunction(Token token) {
        // Implement your custom handling here
        // Return a new Token if you need to modify the output
        return token;
    }

    public static void main(String[] args) {
    }
}

// Dummy implementations to make the code compile
class XPathLexer {
    public XPathLexer(java.io.Reader reader) {
        // Constructor implementation
    }

    public Token getNextToken() {
        // Return a dummy token
        return new Token();
    }
}

class Token {
    public TokenType getType() {
        // Return a dummy token type
        return TokenType.DEFAULT;
    }
}

enum TokenType {
    XPATH_FUNCTION,
    DEFAULT
}