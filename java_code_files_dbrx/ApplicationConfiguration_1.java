import java.lang.String;

interface AppStarter {
    void startSystem(Resource... resources);
}

class Resource {
    // Define Resource as an empty class
}

public class ApplicationConfiguration_1 implements AppStarter {
    private Resource[] resources;

    public void startSystem(Resource... resources) {
        this.resources = resources;
        // initialize system based on given resources
    }

    public static void main(String[] args) {
    }
}