/*
 * Decompiled with CFR 0.152.
 */
public class InputEscaper {
    String userInput = "user-input data";
    String escapedInput = this.userInput.replace("\"", "&quot;").replace("'", "&#x27;");

    public static void main(String[] stringArray) {
        InputEscaper inputEscaper = new InputEscaper();
        System.out.println(inputEscaper.escapedInput);
    }
}
