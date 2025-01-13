import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class UserDAO_4_4 {
    public static void insert(UserBean daoUb, int cityId) throws Exception {
        Connection daoConn = null;
        CityBean cb = new CityBean();
        cb = daoUb.getCity();
        System.out.println("cb = " + cb);
        daoConn = connectionUtil.getConnection();

        Statement daoSt = daoConn.createStatement();
        String str = "INSERT into user (name,age,sex,city) VALUES('" + daoUb.getName() + "'," + daoUb.getAge() + ",'" + daoUb.getSex() + "'," + cityId + ")";
        daoSt.executeUpdate(str);
        //daoConn.close();
    }

    public static void main(String[] args) {
    }
}

class UserBean {
    private String name;
    private int age;
    private String sex;
    private CityBean city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public CityBean getCity() {
        return city;
    }

    public void setCity(CityBean city) {
        this.city = city;
    }
}

class CityBean {
    // Add properties and methods as needed
}

class connectionUtil {
    public static Connection getConnection() throws SQLException {
        // Implement connection logic here
        return null;
    }
}