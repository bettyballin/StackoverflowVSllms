import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IndustryCompanyDAO {
    int parent_id = 7;
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public IndustryCompanyDAO() throws Exception {
        // Initialize the connection (placeholder)
        conn = null; // Replace with actual connection initialization

        ps = conn.prepareStatement(
            "select C.company, C.shname, C.fullname, count(d_to_c.designer) " +
            "from companies C " +
            "left join ind_to_c IC on C.company = IC.company " +
            "left join d_to_c on C.company = d_to_c.company " +
            "where IC.industry = ? " +
            "group by C.company, C.shname, C.fullname " +
            "order by C.shname"
        );
        ps.setInt(1, parent_id);
        rs = ps.executeQuery();
    }

    public static void main(String[] args) {
        try {
            new IndustryCompanyDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}