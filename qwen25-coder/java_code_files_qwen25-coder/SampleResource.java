import java.lang.String;
public class SampleResource {
    private int id;

    public SampleResource(int id) {
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            // Log that the object is being garbage collected
            System.out.println("Finalizing resource with ID: " + id);
        } finally {
            super.finalize();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SampleResource(i);
        }

        // Suggest garbage collection to demonstrate finalize being called
        System.gc();
    }
}