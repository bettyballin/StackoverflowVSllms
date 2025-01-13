/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SQLQueryLoader {
    String sqlQuery = Files.readString(Paths.get("path/to/query.sql", new String[0]));

    public static void main(String[] stringArray) throws IOException {
        new SQLQueryLoader();
    }
}
