import org.apache.commons.lang3.StringUtils;

public class Main_67 {
    public static void main(String[] args) {
        String line = "abc,bcc,";
        String[] tokens = StringUtils.split(line, ",");
        for (String token : tokens) {
            System.out.println(token);
        }
    }
}