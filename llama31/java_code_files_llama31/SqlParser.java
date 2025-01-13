/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlParser {
    String sql = "SELECT FieldDescription,FieldValue FROM codes WHERE FieldName='ContactMethod' and IsNull(Deactived,'') != 'T' order by fielddescription";
    Pattern pattern = Pattern.compile("from\\s+.+?(?=order)", 2);
    Matcher matcher = this.pattern.matcher(this.sql);

    public static void main(String[] stringArray) {
        SqlParser sqlParser = new SqlParser();
        if (sqlParser.matcher.find()) {
            System.out.println(sqlParser.matcher.group());
        }
    }
}
