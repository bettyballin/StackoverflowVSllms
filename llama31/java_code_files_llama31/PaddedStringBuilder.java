/*
 * Decompiled with CFR 0.152.
 */
class PaddedStringBuilder {
    private StringBuilder sb = new StringBuilder();

    public PaddedStringBuilder append(String string) {
        if (this.sb.length() > 0) {
            this.sb.append(" ");
        }
        this.sb.append(string);
        return this;
    }

    public String toString() {
        return this.sb.toString();
    }
}
