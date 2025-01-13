/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class ReadWithScanner {
    private final File fFile;

    public static void main(String ... stringArray) throws FileNotFoundException {
        ReadWithScanner readWithScanner = new ReadWithScanner("C:\\Temp\\test.txt");
        readWithScanner.processLineByLine();
        ReadWithScanner.log("Done.");
    }

    public ReadWithScanner(String string) {
        this.fFile = new File(string);
    }

    public final void processLineByLine() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(this.fFile);){
            while (scanner.hasNextLine()) {
                this.processLine(scanner.nextLine());
            }
        }
    }

    protected void processLine(String string) {
        Scanner scanner = new Scanner(string);
        scanner.useDelimiter("=");
        if (scanner.hasNext()) {
            String string2 = scanner.next();
            String string3 = scanner.next();
            ReadWithScanner.log("Name is : " + this.quote(string2.trim()) + ", and Value is : " + this.quote(string3.trim()));
        } else {
            ReadWithScanner.log("Empty or invalid line. Unable to process.");
        }
        scanner.close();
    }

    private static void log(Object object) {
        System.out.println(String.valueOf(object));
    }

    private String quote(String string) {
        String string2 = "'";
        return string2 + string + string2;
    }
}
