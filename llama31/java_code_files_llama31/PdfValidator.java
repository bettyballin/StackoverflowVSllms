/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PdfValidator {
    public static boolean isPdf(File file) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file);){
            byte[] byArray = new byte[8];
            fileInputStream.read(byArray);
            boolean bl = byArray[0] == 37 && byArray[1] == 80 && byArray[2] == 68 && byArray[3] == 70;
            return bl;
        }
    }

    public static void main(String[] stringArray) throws IOException {
        File file = new File("path/to/your/file.pdf");
        if (PdfValidator.isPdf(file)) {
            System.out.println("File is a PDF");
        } else {
            System.out.println("File is not a PDF");
        }
    }
}
