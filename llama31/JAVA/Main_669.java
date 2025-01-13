import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class Main_669 {
    public static void main(String[] args) {
        List<String> columns = new ArrayList<>();
        // Add some sample data to the list
        columns.add("Column1");
        columns.add("Column2");
        columns.add("Column3");

        Gson gson = new Gson();
        String json = gson.toJson(columns);

        System.out.println(json);
    }
}