/*
 * Decompiled with CFR 0.152.
 */
public class FileReceiver_1 {
    public static void main(String[] stringArray) {
        if (stringArray.length != 1) {
            System.out.println("Usage: java FileReceiver <filename>");
            System.exit(1);
        }
        String string = stringArray[0];
        System.out.println("Received file: " + string);
    }
}
