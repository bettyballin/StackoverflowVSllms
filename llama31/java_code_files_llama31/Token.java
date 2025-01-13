/*
 * Decompiled with CFR 0.152.
 */
class Token {
    private TokenType type;
    private String value;

    public Token(TokenType tokenType, String string) {
        this.type = tokenType;
        this.value = string;
    }

    public TokenType getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }
}
