import java.util.regex.Pattern;

public class FileNameCheckerUtil {
    public boolean checkFileName(String fileName, String extension){
        return Pattern.matches(".*\\." + extension + "$", fileName);
    }
    public static void main(String[] args) {
    }
}