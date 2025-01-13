import java.util.HashMap;

public class Handler {
    public void myMethod(HashMap<String, String> map) {
        // method implementation
    }

    public static void main(String[] args) {
        Handler handler = new Handler();
        HashMap<String, String> myHashMap = new HashMap<>();
        handler.myMethod(myHashMap);
    }
}