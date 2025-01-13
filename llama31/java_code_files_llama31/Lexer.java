/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.InputStream;

public class Lexer {
    private InputStream input;

    public Lexer(InputStream inputStream) {
        this.input = inputStream;
    }

    public Token nextToken() throws IOException {
        return new Token(TokenType.IDENTIFIER, "hello");
    }

    public static void main(String[] stringArray) throws IOException {
        Lexer lexer = new Lexer(System.in);
        Token token = lexer.nextToken();
        if (token.getType() == TokenType.IDENTIFIER) {
            System.out.println("Identifier: " + token.getValue());
        }
    }
}
