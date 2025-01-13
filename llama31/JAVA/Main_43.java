import java.util.ArrayList;
import java.util.HashMap;

public class Main_43 {
    public static void main(String[] args) {
        ArrayList<HashMap<String, String>> aka = new ArrayList<>();

        // Assuming aka is populated with data...

        String sptitle = null;
        if (!aka.isEmpty()) {
            for (HashMap<String, String> ak : aka) {
                if (ak.containsKey("lang") && ak.get("lang").equals("es")) {
                    sptitle = ak.get("title");
                }
            }
        }
        System.out.println(sptitle); // Added a print statement to make the code executable
    }
}