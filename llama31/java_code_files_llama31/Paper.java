/*
 * Decompiled with CFR 0.152.
 */
public class Paper {
    private String content;

    public Paper(String string) {
        this.content = string;
    }

    public Paper clone() {
        return new Paper(this.content);
    }

    public static void main(String[] stringArray) {
        Paper paper = new Paper("Hello World!");
        Paper paper2 = paper.clone();
    }
}
