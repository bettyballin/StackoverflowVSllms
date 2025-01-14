import java.lang.String;
public class VehiclesDAO {
    String query = "SELECT * FROM Vehicles WHERE DKID IN (69954) ORDER BY CASE WHEN ImageName1 = 'na' THEN 0 ELSE 1 END, Make, Model, Year DESC";
    public static void main(String[] args) {
    }
}