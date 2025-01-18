import java.util.ArrayList;
import java.util.List;

public class CarQueryExecutor {
    List<Car> cars = new ArrayList<>(); // assume this list is populated...

    public static void main(String[] args) {
        CarQueryExecutor executor = new CarQueryExecutor();
        JOSQLQuery query = new JOSQLQuery();
        String sql = "SELECT * FROM car WHERE manufactureDate BETWEEN 1960 AND 1969 AND licensePlate LIKE 'AZ%' ORDER BY modelName";
        query.parse(sql);
        List<Car> results = (List<Car>) query.execute(executor.cars).getResultList();
    }
}