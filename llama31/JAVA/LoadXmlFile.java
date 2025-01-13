import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.xdb.XMLType;

public class LoadXmlFile {
  public static void main(String[] args) throws Exception {
    // Load Oracle JDBC driver
    Class.forName("oracle.jdbc.driver.OracleDriver");

    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");
    File xmlFile = new File("badges.xml");
    FileInputStream xmlStream = new FileInputStream(xmlFile);
    XMLType xmlData = new XMLType(conn, xmlStream);
    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO badges_table (userid, name, date) VALUES (?, ?, ?)");
    pstmt.setLong(1, xmlData.getLong("/badges/row/@UserId"));
    pstmt.setString(2, xmlData.getString("/badges/row/@Name"));
    pstmt.setDate(3, xmlData.getDate("/badges/row/@Date"));
    pstmt.executeUpdate();
    conn.commit();
    conn.close();
  }
}