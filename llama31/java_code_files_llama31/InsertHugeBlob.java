/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertHugeBlob {
    public static void main(String[] stringArray) throws SQLException, Exception {
        Connection connection = DriverManager.getConnection("url", "username", "password");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO table (bindata) VALUES (?)");
        File file = new File("c:/tmp/hugefile");
        FileInputStream fileInputStream = new FileInputStream(file);
        preparedStatement.setBinaryStream(1, (InputStream)fileInputStream, file.length());
        preparedStatement.executeUpdate();
        fileInputStream.close();
        preparedStatement.close();
        connection.close();
    }
}
