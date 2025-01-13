/*
 * Decompiled with CFR 0.152.
 */
public class InputEncoder {
    String userInput = "user-input data";
    String encodedInput = this.userInput.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");

    public static void main(String[] stringArray) {
        InputEncoder inputEncoder = new InputEncoder();
        System.out.println(inputEncoder.encodedInput);
    }
}
