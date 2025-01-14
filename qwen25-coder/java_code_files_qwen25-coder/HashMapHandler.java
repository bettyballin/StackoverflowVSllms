import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Handler handler = new Handler();
        HashMap<String, String> myHashMap = new HashMap<String, String>();
        handler.myMethod(myHashMap);
    }
}

class Handler {
    public void myMethod(HashMap<String, String> myHashMap) {
        // Original functionality remains unchanged
    }
}