/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlertRetriever {
    public static void main(String[] stringArray) {
        AlertRetriever alertRetriever = new AlertRetriever();
        alertRetriever.run();
    }

    public void run() {
        String string = "SELECT a.id AS alertId, a.location_id, a.alert_type_id, a.event_id, a.user_id, a.site_id, a.accepted_by FROM alerts AS a JOIN alert_types AS ats ON a.alert_type_id = ats.id JOIN events AS tr ON a.event_id = tr.event_id WHERE tr.end_Time IS null AND tr.status_id = 0 AND ats.code = 'E' AND a.site_id IN (SELECT * FROM dbo.udf_get_event_sitelist(?))";
        try (Connection connection = this.getConnection();){
            PreparedStatement preparedStatement = connection.prepareStatement(string);
            int n = 1;
            preparedStatement.setInt(1, n);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            }
        }
        catch (SQLException sQLException) {
            // empty catch block
        }
    }

    private Connection getConnection() throws SQLException {
        return null;
    }
}
