/*
 * Decompiled with CFR 0.152.
 */
public class BorderRestorer {
    public static void main(String[] stringArray) {
        BorderRestorer borderRestorer = new BorderRestorer();
        InputElement inputElement = new InputElement();
        borderRestorer.restoreBorder(inputElement);
    }

    public void restoreBorder(InputElement inputElement) {
        Border border = inputElement.getBorder();
        inputElement.setBorder(border);
    }
}
