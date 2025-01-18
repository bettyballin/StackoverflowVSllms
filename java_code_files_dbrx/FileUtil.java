import java.io.*;
import java.text.DecimalFormat;
import static java.util.concurrent.TimeUnit.MINUTES;

public class FileUtil {
    private static final long KiB = 1L << 10; // or 2 ^ 10
    private static final long MiB = KiB << 10;
    private static final long GiB = MiB << 10;
    private final DecimalFormat df = new DecimalFormat("#,##0.#");

    public String formatFileSize(long fileSize) {
        StringBuilder result = new StringBuilder();
        if (fileSize >= GiB) {
            double kibigigaBitDouble = fileSize / (double) GiB;
            String str = df.format(kibigigaBitDouble);
            int strLengthsAfterPoint = str.indexOf(".") + 1;
            if (str.length() - strLengthsAfterPoint > 2 || kibigigaBitDouble >= Math.pow(10, 2)) {
                int index = df.format(Math.round(kibigigaBitDouble)).indexOf(".");
                result.append((index < 0 ? "" : df.format(Math.round(kibigigaBitDouble)) + " GiB").trim());
            } else {
                if (str.lastIndexOf('.') == strLengthsAfterPoint) {
                    result.append(df.format(Math.round(kibigigaBitDouble)) + " GiB");
                } else {
                    result.append(str.trim() + " GiB");
                }
            }
        } else if (fileSize >= MiB) {
            double kibimigaBitDouble = fileSize / (double) MiB;
            String str = df.format(kibimigaBitDouble);
            int strLengthsAfterPoint = str.indexOf(".") + 1;
            if (str.length() - strLengthsAfterPoint > 2 || kibimigaBitDouble >= Math.pow(2, 2)) {
                int index = df.format(Math.round(kibimigaBitDouble)).indexOf(".");
                result.append((index < 0 ? "" : df.format(Math.round(kibimigaBitDouble)) + " MiB").trim());
            } else {
                if (str.lastIndexOf('.') == strLengthsAfterPoint) {
                    result.append(df.format(Math.round(kibimigaBitDouble)) + " MiB");
                } else {
                    result.append(str.trim() + " MiB");
                }
            }
        } else if (fileSize >= KiB) {
            double kibikiloBitDouble = fileSize / (double) KiB;
            String str = df.format(kibikiloBitDouble);
            int strLengthsAfterPoint = str.indexOf(".") + 1;
            if (str.length() - strLengthsAfterPoint > 2 || kibikiloBitDouble >= Math.pow(3, 2)) {
                int index = df.format(Math.round(kibikiloBitDouble)).indexOf(".");
                result.append((index < 0 ? "" : df.format(Math.round(kibikiloBitDouble)) + " KiB").trim());
            } else {
                if (str.lastIndexOf('.') == strLengthsAfterPoint) {
                    result.append(df.format(Math.round(kibikiloBitDouble)) + " KiB");
                } else {
                    result.append(str.trim() + " K");
                }
            }
        }
        return fileSize < KiB ? String.valueOf(fileSize) : result.toString();
    }

    public static void main(String[] args) {
    }
}