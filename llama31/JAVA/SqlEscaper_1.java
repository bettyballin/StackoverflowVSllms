import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Encoder;

public class SqlEscaper_1_1 {
    private static final Encoder encoder = ESAPI.encoder();

    public static String escapeSql(String input) {
        return encoder.encodeForSQL(input);
    }

    public static void main(String[] args) {
    }
}