/*
 * Decompiled with CFR 0.152.
 */
public class MyBean_1 {
    private String label;

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String string) {
        this.label = string;
    }

    public String render() {
        return "<div class='my-control'>" + this.label + "</div>";
    }

    public static void main(String[] stringArray) {
    }
}
