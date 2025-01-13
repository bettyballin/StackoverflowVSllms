/*
 * Decompiled with CFR 0.152.
 */
import java.sql.SQLException;

public class Main_797 {
    public static void main(String[] stringArray) throws SQLException {
        Object var1_1 = null;
        boolean bl = false;
        XmlHandler xmlHandler = new XmlHandler();
        String string = "Example String with <XML> tags";
        String string2 = Main_797.escapeXml(string);
        xmlHandler.characters(string2.toCharArray(), 0, string2.length());
    }

    public static String escapeXml(String string) {
        return string.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#039;");
    }
}
