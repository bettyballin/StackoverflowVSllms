/*
 * Decompiled with CFR 0.152.
 */
import java.io.PrintStream;

public class MultipartResponseGenerator {
    public static void main(String[] stringArray) {
        PrintStream printStream = System.out;
        System.out.println("Content-Type: multipart/mixed; boundary=END_OF_FILE");
        printStream.println("<?xml version='1.0' encoding='UTF-8'?>");
        printStream.println("<graph_data>");
        printStream.println("</graph_data>");
        printStream.println("--END_OF_FILE");
        printStream.println("Content-Type: image/png");
        printStream.println("Content-Disposition: inline; filename=graph.png");
        printStream.println("--END_OF_FILE--");
    }
}
