/*
 * Decompiled with CFR 0.152.
 */
class KanaValidator {
    KanaValidator() {
    }

    public boolean isHiragana(String string) {
        for (char c : string.toCharArray()) {
            if (this.isHiraganaChar(c)) continue;
            return false;
        }
        return true;
    }

    private boolean isHiraganaChar(char c) {
        return c >= '\u3040' && c <= '\u309f';
    }
}
