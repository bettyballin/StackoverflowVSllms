import java.lang.String;
import java.text.DecimalFormat;
public class FileSizeFormatter {

    private static final String[] UNITS = {"B", "K", "M", "G", "T"};
    
    public static String format(long size) {
        if (size < 1024) return size + " B";
        
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + UNITS[digitGroups];
    }

    public static void main(String[] args) {
    }
}