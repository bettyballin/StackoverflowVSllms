import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class representation {
    Gson gson = new GsonBuilder().create();
    Type listOfMyClassObject = new TypeToken<List<YourModel>>() {}.getType(); // YourModel should be replaced by actual class representation.
    List<YourModel> parsedJsonArray;

    public representation() {
        String responseString = ""; // Initialize appropriately
        parsedJsonArray = gson.fromJson(responseString, listOfMyClassObject);
    }

    public static void main(String[] args) {
    }
}

class YourModel {
    // Fields and methods of YourModel
}