/*
 * Decompiled with CFR 0.152.
 */
class Content {
    private String title;
    private String body;

    public Content(String string, String string2) {
        this.title = string;
        this.body = string2;
    }

    public String toString() {
        return "Title: " + this.title + ", Body: " + this.body;
    }
}
