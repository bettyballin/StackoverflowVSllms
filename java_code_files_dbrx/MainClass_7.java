class AxFlash {
    public void Dispose() {
        // Dispose logic here
    }
}

class AxShockwaveFlashObjects {
    public AxFlash CreateInstance() {
        return new AxFlash();
    }
}

public class MainClass {
    private static AxFlash axFlash;

    public static void main(String[] args) {
        if (axFlash != null) { 
            axFlash.Dispose(); 
        }
        axFlash = new AxShockwaveFlashObjects().CreateInstance(); // Recreate a new instance after disposing the old one
    }
}