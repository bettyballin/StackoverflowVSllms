import java.lang.String;
// Example: Mock a simple component interaction

interface SystemComponent {
    void performOperation();
}

class LegacySystem implements SystemComponent {
    @Override
    public void performOperation() {
        // Simulate legacy system operation
    }
}

class MainWebsiteApplication implements SystemComponent {
    @Override
    public void performOperation() {
        // Simulate website application operation
    }
}

class Facade implements SystemComponent {
    private final LegacySystem legacySystem;
    private final MainWebsiteApplication mainWebsiteApp;

    public Facade(LegacySystem legacySystem, MainWebsiteApplication mainWebsiteApp) {
        this.legacySystem = legacySystem;
        this.mainWebsiteApp = mainWebsiteApp;
    }

    @Override
    public void performOperation() {
        legacySystem.performOperation();
        mainWebsiteApp.performOperation();
    }
}

public class Main {
    public static void main(String[] args) {
    }
}