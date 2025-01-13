import java.lang.String;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UniqueFileNameGenerator_2 {
    private static long counter = 0;
    private static final Object lock = new Object();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public static String generateFileName(String prefix, String suffix) {
        synchronized (lock) {
            String timestamp = dateFormat.format(new Date());
            return prefix + timestamp + "_" + (counter++) + suffix;
        }
    }

    public static void main(String[] args) {
        String fileName = generateFileName("file_", ".txt");
        System.out.println(fileName);
    }
}