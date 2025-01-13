/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyObjectDAO {
    public void create(MyObject myObject) throws SQLException {
        Connection connection = DatabaseConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO myobjects (name, myenum) VALUES (?, ?)");
        preparedStatement.setString(1, myObject.getName());
        preparedStatement.setString(2, myObject.getMyEnum().toString());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public MyObject read(int n) throws SQLException {
        Connection connection = DatabaseConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM myobjects WHERE id = ?");
        preparedStatement.setInt(1, n);
        ResultSet resultSet = preparedStatement.executeQuery();
        MyObject myObject = null;
        if (resultSet.next()) {
            myObject = new MyObject();
            myObject.setId(resultSet.getInt("id"));
            myObject.setName(resultSet.getString("name"));
            myObject.setMyEnum(EnumMyEnum.valueOf(resultSet.getString("myenum")));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return myObject;
    }

    public void update(MyObject myObject) throws SQLException {
        Connection connection = DatabaseConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE myobjects SET name = ?, myenum = ? WHERE id = ?");
        preparedStatement.setString(1, myObject.getName());
        preparedStatement.setString(2, myObject.getMyEnum().toString());
        preparedStatement.setInt(3, myObject.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public void delete(int n) throws SQLException {
        Connection connection = DatabaseConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM myobjects WHERE id = ?");
        preparedStatement.setInt(1, n);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public static void main(String[] stringArray) {
    }
}
