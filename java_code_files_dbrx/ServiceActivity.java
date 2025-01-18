import java.lang.String;

public class ServiceActivity extends BaseClass {
    private boolean shouldRun;
    
    @Override
    public void onDestroy() {
        Measurements.clear();
        super.onDestroy();
        shouldRun = false; // Add this line
    }
    
    public static void main(String[] args) {
    }
}

class BaseClass {
    public void onDestroy() {
        // Base onDestroy method
    }
}

class Measurements {
    public static void clear() {
        // Clear measurements
    }
}