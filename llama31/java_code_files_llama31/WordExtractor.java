/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordExtractor {
    public static void main(String[] stringArray) {
        String string = "path_to_your_text_file.txt";
        try {
            Scanner scanner = new Scanner(new File(string));
            scanner.useDelimiter("\\Z");
            String string2 = scanner.next();
            scanner.close();
            Pattern pattern = Pattern.compile("\\b\\w[\\w']*$");
            Matcher matcher = pattern.matcher(string2.toLowerCase());
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found: " + fileNotFoundException.getMessage());
        }
    }
}
