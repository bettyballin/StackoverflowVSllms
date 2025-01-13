/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main_251 {
    public static void main(String[] stringArray) throws IOException {
        File file = new File("path_to_your_file");
        Document document = new Document();
        byte[] byArray = Files.readAllBytes(file.toPath());
        document.setFileContents(byArray);
        System.out.println("File contents read and set to Document object.");
    }

    static class Document {
        private byte[] fileContents;

        Document() {
        }

        public void setFileContents(byte[] byArray) {
            this.fileContents = byArray;
        }
    }
}
