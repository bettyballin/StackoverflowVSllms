import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SqlParser {
    String sql = "SELECT FieldDescription,FieldValue FROM codes WHERE FieldName='ContactMethod' and IsNull(Deactived,'') != 'T' order by fielddescription";
    Pattern pattern = Pattern.compile("from\\s+.+?(?=order)", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(sql);

    public static void main(String[] args) {
        SqlParser parser = new SqlParser();
        if (parser.matcher.find()) {
            System.out.println(parser.matcher.group());
        }
    }
}