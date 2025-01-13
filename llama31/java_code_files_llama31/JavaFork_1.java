/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class JavaFork_1 {
    public static void main(String[] stringArray) throws IOException {
        Runtime.getRuntime().exec("java -cp " + System.getProperty("java.class.path") + " IndependentProcess");
    }
}
