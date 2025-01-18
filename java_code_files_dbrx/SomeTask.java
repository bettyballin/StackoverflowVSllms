import java.lang.String;

public class SomeTask {
    class Task implements Runnable {
        private SemaphoredResource resource;

        public void run() {
            resource.useResource();  // Each task will try to use the resource here, but only up to ten tasks will be allowed due to semaphores value.
        }
    }

    public static void main(String[] args) {
    }
}

class SemaphoredResource {
    void useResource() {
        // Placeholder method
    }
}