import java.sql.*;
public class IndustryCompanyFinder {
    int parent_id = 7;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    {
        try {
            ps = conn.prepareStatement("select C.company, C.shname, C.fullname, count(d_to_c.designer) from companies C left join ind_to_c IC on C.company = IC.company left join d_to_c on C.company= d_to_c.company where IC.industry = ? group by C.company, C.shname, C.fullname order by C.shname");
            ps.setInt(1, parent_id);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}