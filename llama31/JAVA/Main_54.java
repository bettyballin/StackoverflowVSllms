import java.sql.SQLException;

public class Main_54_54 {
    public static void main(String[] args) throws SQLException {
        DatabaseConfig.init();
        MyObjectDAO dao = new MyObjectDAO();

        MyObject obj = new MyObject();
        obj.setName("John");
        obj.setMyEnum(EnumMyEnum.VALUE1);
        dao.create(obj);

        MyObject readObj = dao.read(1);
        System.out.println(readObj.getName());

        obj.setName("Jane");
        dao.update(obj);

        dao.delete(1);
    }
}