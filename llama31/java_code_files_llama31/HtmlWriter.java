/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HtmlWriter {
    public static void main(String[] stringArray) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("output.html"));){
            printWriter.write("<div class=\"bar\">");
            printWriter.write("</div>");
        }
        catch (IOException iOException) {
            System.err.println("Error writing to file: " + iOException.getMessage());
        }
    }
}
