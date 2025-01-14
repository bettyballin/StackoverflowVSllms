import java.lang.String;
import java.lang.HashMap;
import java.lang.Map;

public class SparseArrayCube {
    // Example of a simple sparse array in Java
    Map<String, Map<String, Double>> cubeData = new HashMap<>();

    {
        cubeData.put("2021Q1", new HashMap<>());
        cubeData.get("2021Q1").put("Laptop_X", 1500.0);
    }

    public static void main(String[] args) {
    }
}